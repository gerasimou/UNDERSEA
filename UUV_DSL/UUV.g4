grammar UUV;

import UUV_Terminals; // includes all rules from UUV_Terminals.g4 

@parser::header {
  package org.spg.uuv.dsl.gen;
  import java.util.*;
} 

@parser::members {
	Set<String> types = new HashSet<String>() {{add("T");}};
	boolean istype() { return types.contains(getCurrentToken().getText()); }
}

/** The start rule; begin parsing here. 
 * a model is assembled by a model type and a set of abstract elements*/
 
model:
		( simulation
		| invocation
		| host
	 	| port
	 	| uuv
	 	| speed
	 	| sensor)+
;

simulation: 
		SIMULATION_TIME ASSIGN value=INT
; 

invocation: 
		TIME_WINDOW ASSIGN value=(INT | DOUBLE)
;

host: 
		SERVER_HOST ASSIGN value=(IP | 'localhost')
;

port: 
		SERVER_PORT ASSIGN value=INT
;   

speed:
		SPEED ASSIGN value=INT
;

uuv:
		'UUV' 
		'{' 
			NAME ASSIGN name=ID					
		'}'
;

sensor:
		'SENSOR' 
		'{' 
			(
				NAME 		ASSIGN name=ID
			|	RATE 		ASSIGN rate=(INT | DOUBLE)
			|	RELIABILITY	ASSIGN reliability=(INT | DOUBLE)
			|	degradation+
			)+	
		'}' 
;

degradation:
		DEGRADATION	ASSIGN begin=(INT | DOUBLE) ':' end=(INT | DOUBLE) ':' value=(INT | DOUBLE)
;

/* 

model: 
		modelType 
		(module | reward | constant | formula | evolvable)*
		EOF																							//# modelEntry
;


module:
	  'module' name=ID varDeclaration* command+ 'endmodule'										# moduleSimple
	| 'module' newModuleName=ID '=' oldModuleName=ID '[' moduleRenamingVar ']' 'endmodule'		# moduleRenaming
;

moduleRenamingVar:
	  newVar=variable '=' oldVar=variable														# moduleRenamingVarSimple
 	| newVar=variable '=' oldVar=variable ',' moduleRenamingVar									# moduleRenamingVarMulti
;

reward:
	  'rewards' name=STRING  rewardItem* 'endrewards'												//#rewardEntry
;

rewardItem:																								
		('['(transitionID=variable)?']')? rewardPrecondition ':' expression  ';'					//# rewardItemEntry
;

rewardPrecondition:
		expression					 																# rewardPrecExpression
//		variable operator expression 																# rewardPrecExpression
	| 	BOOLEAN																						# rewardPrecBoolean
	|	variable operator BOOLEAN 																	# rewardPrecExpressBoolean
;

function:
	FUNCTIONIDENTIFIER '(' functionParam  ')'
;

functionParam:
		expression																					# functionParamExpr
	| 	expression ',' functionParam																# functionParamMulti
;


formula:
		'formula' name=variable '=' expression ';'															//#formulaEntry
;


constant:
		CONST CONSTANTTYPE? variable (ASSIGN expression)? (';')?									//# constantEntry
;

evolvable:
		EVOLVE CONST CONSTANTTYPE variable bounds[$CONSTANTTYPE.text] ';'							# evolveConst
	|	EVOLVE DISTRIBUTION variable '['cardinality=INT']' bounds["double"]* ';'					# evolveDistribution
	|  	EVOLVE 'module' name=ID (bounds["int"])? varDeclaration* command+ 'endmodule'				# evolveModule
	
;

varDeclaration:		
	 	name = variable':' 'bool' ('init' initValue=BOOLEAN)? ';'									# boolVarDeclaration
	| 	name = variable ':' '[' lowerBound=INT '..' upperBound=intOrVar']' 
			('init' initValue=INT)? ';' 															# intVarDeclaration
;

bounds[String str]:
	{$str.equals("double")}?'[' minValue=DOUBLE '..' maxValue=DOUBLE ']' //{System.err.println($str +"-"+ $minValue.text);}
	|					   '[' minValue=INT    '..' maxValue=INT    ']'	
;

command:
	'['name = ID?']' guard '->' transition ';'														//# commandEntry
 ;

guard:
	 	BOOLEAN 																					# guardBool
	|	ID																							# guardString
	|	variable operator expression																# guardExpression
	| 	guard logicalOp guard																		# guardMulti
	|	'(' guard ')'																				# guardParen
	|	'!' guard																					# guardNot
;

transition:
//		((probability = (DOUBLE | INT) |  probabilityVar = variable) ':')? statement				# transitionEntry
		(expression ':')? statement				# transitionEntry
	| 	transition '+' transition																	# transitionMulti
;

	
statement:
		BOOLEAN																						# statementBool
//	| 	'('variable '\'' ASSIGN INT ')' 															# statementEv
//	| 	'('changingVar=variable '\'' ASSIGN update=variable operator  value=(INT | DOUBLE) ')'		# statementOp
	|	'('variable '\'' ASSIGN expression ')'														# statementMain
	| 	statement '&' statement 																	# statementMulti
;

variable:
		name = ID																		
;

expression:
		expression operator expression																# expressionMulti
	| 	value=(INT | DOUBLE)																		# expressionValue
	| 	variable																					# expressionVariable
	| 	'(' expression ')' 																			# expressionParen
	|	function																					# expressionFunction
;


modelType: 
		value = (DTMC | CTMC | MDP)
;


comparisonOp: 
	 	'>' | '>=' | '<' | '<=' | '!=' | ASSIGN
;


logicalOp: 
		'|' | '&' | '!'
;

numericalOp:
		'*' | '/' | '+' | '-' 
;

intOrVar:
		INT 																						# intOrVarInt
	| 	variable																					# intOrVarVar
;

operator:
		numericalOp
	| 	comparisonOp
	| 	logicalOp
	| 	'<=>' | '=>' | '?' | ':'
;
*/