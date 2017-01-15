simulation time = 100
time window 	= 5

host 			= localhost
port 			= 8888
speed 			= 2

UUV   { 
	name = simos
}
	        
SENSOR   { 
	name 		= S1
	rate 		= 5
	reliability	= 0.9
	degradation	= 150:200:0.1
}


SENSOR   { 
	name 		= S2
	rate 		= 5
	reliability	= 0.9
}