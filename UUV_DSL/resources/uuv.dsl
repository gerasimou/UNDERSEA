simulation time 	= 100
time window 		= 5
host 				= localhost
port 				= 9999
simulation speed 	= 2

UUV   { 
	name 	= nautilus
	speed 	= 0:4:21
	port	= 888
}
	        
SENSOR   { 
	name 		= SENSOR1
	rate 		= 3
	reliability	= 0.9
	degradation	= 150:200:0.1
}

SENSOR   { 
	name 		= SENSOR2
	rate 		= 3
	reliability	= 0.9
	degradation	= 50:100:0.8
}

SENSOR   { 
	name 		= SENSOR3
	rate 		= 5
	reliability	= 0.5
	degradation	= 50:100:0.1
}

SENSOR   { 
	name 		= SENSOR4
	rate 		= 5
	reliability	= 0.99
}
