/* A simple server in the internet domain using TCP
   The port number is passed as an argument */
#include <cstdio>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>

#include <cstring>
#include <string>
using namespace std;

void error(const char *msg)
{
    perror(msg);
    exit(1);
}


void runServer(int portNo)
{

	 //store the values returned by the socket system call and the accept system call.
     int sockfd, newsockfd;

     //store the size of the address of the client
     socklen_t clientLen;

     //the server reads characters from the socket connection into this buffer.
     char buffer[256];

     //server and client adresses
     struct sockaddr_in serverAddress, clientAddress;

     //contains the number of characters read or written
     int n;

     if (portNo < 2000) {
         fprintf(stderr,"ERROR, no port provided\n");
         exit(1);
     }

     //create a new socket
     sockfd = socket(AF_INET, SOCK_STREAM, 0);
     if (sockfd < 0)
        error("ERROR opening socket");

     //set all values in a buffer to zero
     bzero((char *) &serverAddress, sizeof(serverAddress));

     //populate serverAddress structure
     serverAddress.sin_family = AF_INET;
     serverAddress.sin_addr.s_addr = INADDR_ANY;
     serverAddress.sin_port = htons(portNo);

     //bind a socket to an address
     if (bind(sockfd, (struct sockaddr *) &serverAddress, sizeof(serverAddress)) < 0)
    	 error("ERROR on binding");

     //listen on the socket for connections
     listen(sockfd,5);

     clientLen = sizeof(clientAddress);

     //block the process until a client connects to the server
     newsockfd = accept(sockfd, (struct sockaddr *) &clientAddress, &clientLen);
     if (newsockfd < 0)
    	 error("ERROR on accept");

     do {
		 bzero(buffer,256);
		 printf("Waiting:\n");
		 n = read(newsockfd,buffer,255);
		 if (n < 0)
			 error("ERROR reading from socket");

		 printf("Message: %s\t(%d)\n",buffer, strcmp(buffer,"!!\n"));

		 for (int i = 0; i < strlen(buffer); ++i)
			 printf("%d\t", (int)(buffer[i]));

		 string str = buffer;
		 n = write(newsockfd, str.c_str(), str.length());
		 if (n < 0)
			 error("ERROR writing to socket");
     }
     while (strcmp(buffer,"!!\n") != 0);

     close(newsockfd);
     close(sockfd);
     return;
}
