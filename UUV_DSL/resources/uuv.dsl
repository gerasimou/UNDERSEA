simulation time 	= 100
time window 		= 5
host 				= localhost
port 				= 8888
simulation speed 	= 2

UUV   { 
	name 	= simos
	speed 	= 0:4:21
	port	= 9999 	
}
	        
SENSOR   { 
	name 		= S1
	rate 		= 5
	reliability	= 0.9
	degradation	= 150:200:0.1
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
