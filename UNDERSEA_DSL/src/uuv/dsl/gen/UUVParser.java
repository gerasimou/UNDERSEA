// Generated from grammar/UUV.g4 by ANTLR 4.5

  package uuv.dsl.gen;
  import java.util.*; 

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class UUVParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, ASSIGN=7, SERVER_HOST=8, 
		SERVER_PORT=9, SIMULATION_TIME=10, TIME_WINDOW=11, SIMULATION_SPEED=12, 
		SPEED=13, NAME=14, RATE=15, CHANGE=16, RELIABILITY=17, SLCOMMENT=18, ID=19, 
		INT=20, DOUBLE=21, IP=22, OCTET=23, STRING=24, WS=25;
	public static final int
		RULE_model = 0, RULE_simulation = 1, RULE_invocation = 2, RULE_host = 3, 
		RULE_port = 4, RULE_speed = 5, RULE_uuv = 6, RULE_sensor = 7, RULE_change = 8;
	public static final String[] ruleNames = {
		"model", "simulation", "invocation", "host", "port", "speed", "uuv", "sensor", 
		"change"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'localhost'", "'UUV'", "'{'", "':'", "'}'", "'SENSOR'", "'='", 
		"'host'", "'port'", "'simulation time'", "'time window'", "'simulation speed'", 
		"'speed'", "'name'", "'rate'", "'change'", "'reliability'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "ASSIGN", "SERVER_HOST", "SERVER_PORT", 
		"SIMULATION_TIME", "TIME_WINDOW", "SIMULATION_SPEED", "SPEED", "NAME", 
		"RATE", "CHANGE", "RELIABILITY", "SLCOMMENT", "ID", "INT", "DOUBLE", "IP", 
		"OCTET", "STRING", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "UUV.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		Set<String> types = new HashSet<String>() {{add("T");}};
		boolean istype() { return types.contains(getCurrentToken().getText()); }

	public UUVParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ModelContext extends ParserRuleContext {
		public List<SimulationContext> simulation() {
			return getRuleContexts(SimulationContext.class);
		}
		public SimulationContext simulation(int i) {
			return getRuleContext(SimulationContext.class,i);
		}
		public List<InvocationContext> invocation() {
			return getRuleContexts(InvocationContext.class);
		}
		public InvocationContext invocation(int i) {
			return getRuleContext(InvocationContext.class,i);
		}
		public List<HostContext> host() {
			return getRuleContexts(HostContext.class);
		}
		public HostContext host(int i) {
			return getRuleContext(HostContext.class,i);
		}
		public List<PortContext> port() {
			return getRuleContexts(PortContext.class);
		}
		public PortContext port(int i) {
			return getRuleContext(PortContext.class,i);
		}
		public List<UuvContext> uuv() {
			return getRuleContexts(UuvContext.class);
		}
		public UuvContext uuv(int i) {
			return getRuleContext(UuvContext.class,i);
		}
		public List<SpeedContext> speed() {
			return getRuleContexts(SpeedContext.class);
		}
		public SpeedContext speed(int i) {
			return getRuleContext(SpeedContext.class,i);
		}
		public List<SensorContext> sensor() {
			return getRuleContexts(SensorContext.class);
		}
		public SensorContext sensor(int i) {
			return getRuleContext(SensorContext.class,i);
		}
		public ModelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_model; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UUVListener ) ((UUVListener)listener).enterModel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UUVListener ) ((UUVListener)listener).exitModel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UUVVisitor ) return ((UUVVisitor<? extends T>)visitor).visitModel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModelContext model() throws RecognitionException {
		ModelContext _localctx = new ModelContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_model);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(25);
				switch (_input.LA(1)) {
				case SIMULATION_TIME:
					{
					setState(18);
					simulation();
					}
					break;
				case TIME_WINDOW:
					{
					setState(19);
					invocation();
					}
					break;
				case SERVER_HOST:
					{
					setState(20);
					host();
					}
					break;
				case SERVER_PORT:
					{
					setState(21);
					port();
					}
					break;
				case T__1:
					{
					setState(22);
					uuv();
					}
					break;
				case SIMULATION_SPEED:
					{
					setState(23);
					speed();
					}
					break;
				case T__5:
					{
					setState(24);
					sensor();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(27); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__5) | (1L << SERVER_HOST) | (1L << SERVER_PORT) | (1L << SIMULATION_TIME) | (1L << TIME_WINDOW) | (1L << SIMULATION_SPEED))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SimulationContext extends ParserRuleContext {
		public Token value;
		public TerminalNode SIMULATION_TIME() { return getToken(UUVParser.SIMULATION_TIME, 0); }
		public TerminalNode ASSIGN() { return getToken(UUVParser.ASSIGN, 0); }
		public TerminalNode INT() { return getToken(UUVParser.INT, 0); }
		public SimulationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simulation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UUVListener ) ((UUVListener)listener).enterSimulation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UUVListener ) ((UUVListener)listener).exitSimulation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UUVVisitor ) return ((UUVVisitor<? extends T>)visitor).visitSimulation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimulationContext simulation() throws RecognitionException {
		SimulationContext _localctx = new SimulationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_simulation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(SIMULATION_TIME);
			setState(30);
			match(ASSIGN);
			setState(31);
			((SimulationContext)_localctx).value = match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InvocationContext extends ParserRuleContext {
		public Token value;
		public TerminalNode TIME_WINDOW() { return getToken(UUVParser.TIME_WINDOW, 0); }
		public TerminalNode ASSIGN() { return getToken(UUVParser.ASSIGN, 0); }
		public TerminalNode INT() { return getToken(UUVParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(UUVParser.DOUBLE, 0); }
		public InvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UUVListener ) ((UUVListener)listener).enterInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UUVListener ) ((UUVListener)listener).exitInvocation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UUVVisitor ) return ((UUVVisitor<? extends T>)visitor).visitInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InvocationContext invocation() throws RecognitionException {
		InvocationContext _localctx = new InvocationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_invocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(TIME_WINDOW);
			setState(34);
			match(ASSIGN);
			setState(35);
			((InvocationContext)_localctx).value = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==DOUBLE) ) {
				((InvocationContext)_localctx).value = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HostContext extends ParserRuleContext {
		public Token value;
		public TerminalNode SERVER_HOST() { return getToken(UUVParser.SERVER_HOST, 0); }
		public TerminalNode ASSIGN() { return getToken(UUVParser.ASSIGN, 0); }
		public TerminalNode IP() { return getToken(UUVParser.IP, 0); }
		public HostContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_host; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UUVListener ) ((UUVListener)listener).enterHost(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UUVListener ) ((UUVListener)listener).exitHost(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UUVVisitor ) return ((UUVVisitor<? extends T>)visitor).visitHost(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HostContext host() throws RecognitionException {
		HostContext _localctx = new HostContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_host);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(SERVER_HOST);
			setState(38);
			match(ASSIGN);
			setState(39);
			((HostContext)_localctx).value = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==IP) ) {
				((HostContext)_localctx).value = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PortContext extends ParserRuleContext {
		public Token value;
		public TerminalNode SERVER_PORT() { return getToken(UUVParser.SERVER_PORT, 0); }
		public TerminalNode ASSIGN() { return getToken(UUVParser.ASSIGN, 0); }
		public TerminalNode INT() { return getToken(UUVParser.INT, 0); }
		public PortContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_port; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UUVListener ) ((UUVListener)listener).enterPort(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UUVListener ) ((UUVListener)listener).exitPort(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UUVVisitor ) return ((UUVVisitor<? extends T>)visitor).visitPort(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PortContext port() throws RecognitionException {
		PortContext _localctx = new PortContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_port);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(SERVER_PORT);
			setState(42);
			match(ASSIGN);
			setState(43);
			((PortContext)_localctx).value = match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SpeedContext extends ParserRuleContext {
		public Token value;
		public TerminalNode SIMULATION_SPEED() { return getToken(UUVParser.SIMULATION_SPEED, 0); }
		public TerminalNode ASSIGN() { return getToken(UUVParser.ASSIGN, 0); }
		public TerminalNode INT() { return getToken(UUVParser.INT, 0); }
		public SpeedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_speed; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UUVListener ) ((UUVListener)listener).enterSpeed(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UUVListener ) ((UUVListener)listener).exitSpeed(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UUVVisitor ) return ((UUVVisitor<? extends T>)visitor).visitSpeed(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpeedContext speed() throws RecognitionException {
		SpeedContext _localctx = new SpeedContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_speed);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(SIMULATION_SPEED);
			setState(46);
			match(ASSIGN);
			setState(47);
			((SpeedContext)_localctx).value = match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UuvContext extends ParserRuleContext {
		public Token name;
		public Token min;
		public Token max;
		public Token steps;
		public Token value;
		public List<TerminalNode> NAME() { return getTokens(UUVParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(UUVParser.NAME, i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(UUVParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(UUVParser.ASSIGN, i);
		}
		public List<TerminalNode> SPEED() { return getTokens(UUVParser.SPEED); }
		public TerminalNode SPEED(int i) {
			return getToken(UUVParser.SPEED, i);
		}
		public List<TerminalNode> SERVER_PORT() { return getTokens(UUVParser.SERVER_PORT); }
		public TerminalNode SERVER_PORT(int i) {
			return getToken(UUVParser.SERVER_PORT, i);
		}
		public List<TerminalNode> ID() { return getTokens(UUVParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(UUVParser.ID, i);
		}
		public List<TerminalNode> INT() { return getTokens(UUVParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(UUVParser.INT, i);
		}
		public List<TerminalNode> DOUBLE() { return getTokens(UUVParser.DOUBLE); }
		public TerminalNode DOUBLE(int i) {
			return getToken(UUVParser.DOUBLE, i);
		}
		public UuvContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uuv; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UUVListener ) ((UUVListener)listener).enterUuv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UUVListener ) ((UUVListener)listener).exitUuv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UUVVisitor ) return ((UUVVisitor<? extends T>)visitor).visitUuv(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UuvContext uuv() throws RecognitionException {
		UuvContext _localctx = new UuvContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_uuv);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(T__1);
			setState(50);
			match(T__2);
			setState(64); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(64);
				switch (_input.LA(1)) {
				case NAME:
					{
					setState(51);
					match(NAME);
					setState(52);
					match(ASSIGN);
					setState(53);
					((UuvContext)_localctx).name = match(ID);
					}
					break;
				case SPEED:
					{
					setState(54);
					match(SPEED);
					setState(55);
					match(ASSIGN);
					setState(56);
					((UuvContext)_localctx).min = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==INT || _la==DOUBLE) ) {
						((UuvContext)_localctx).min = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(57);
					match(T__3);
					setState(58);
					((UuvContext)_localctx).max = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==INT || _la==DOUBLE) ) {
						((UuvContext)_localctx).max = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(59);
					match(T__3);
					setState(60);
					((UuvContext)_localctx).steps = match(INT);
					}
					break;
				case SERVER_PORT:
					{
					setState(61);
					match(SERVER_PORT);
					setState(62);
					match(ASSIGN);
					setState(63);
					((UuvContext)_localctx).value = match(INT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(66); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SERVER_PORT) | (1L << SPEED) | (1L << NAME))) != 0) );
			setState(68);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SensorContext extends ParserRuleContext {
		public Token name;
		public Token rate;
		public Token reliability;
		public List<TerminalNode> NAME() { return getTokens(UUVParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(UUVParser.NAME, i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(UUVParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(UUVParser.ASSIGN, i);
		}
		public List<TerminalNode> RATE() { return getTokens(UUVParser.RATE); }
		public TerminalNode RATE(int i) {
			return getToken(UUVParser.RATE, i);
		}
		public List<TerminalNode> RELIABILITY() { return getTokens(UUVParser.RELIABILITY); }
		public TerminalNode RELIABILITY(int i) {
			return getToken(UUVParser.RELIABILITY, i);
		}
		public List<TerminalNode> ID() { return getTokens(UUVParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(UUVParser.ID, i);
		}
		public List<TerminalNode> INT() { return getTokens(UUVParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(UUVParser.INT, i);
		}
		public List<TerminalNode> DOUBLE() { return getTokens(UUVParser.DOUBLE); }
		public TerminalNode DOUBLE(int i) {
			return getToken(UUVParser.DOUBLE, i);
		}
		public List<ChangeContext> change() {
			return getRuleContexts(ChangeContext.class);
		}
		public ChangeContext change(int i) {
			return getRuleContext(ChangeContext.class,i);
		}
		public SensorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sensor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UUVListener ) ((UUVListener)listener).enterSensor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UUVListener ) ((UUVListener)listener).exitSensor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UUVVisitor ) return ((UUVVisitor<? extends T>)visitor).visitSensor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SensorContext sensor() throws RecognitionException {
		SensorContext _localctx = new SensorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_sensor);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(T__5);
			setState(71);
			match(T__2);
			setState(86); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(86);
				switch (_input.LA(1)) {
				case NAME:
					{
					setState(72);
					match(NAME);
					setState(73);
					match(ASSIGN);
					setState(74);
					((SensorContext)_localctx).name = match(ID);
					}
					break;
				case RATE:
					{
					setState(75);
					match(RATE);
					setState(76);
					match(ASSIGN);
					setState(77);
					((SensorContext)_localctx).rate = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==INT || _la==DOUBLE) ) {
						((SensorContext)_localctx).rate = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case RELIABILITY:
					{
					setState(78);
					match(RELIABILITY);
					setState(79);
					match(ASSIGN);
					setState(80);
					((SensorContext)_localctx).reliability = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==INT || _la==DOUBLE) ) {
						((SensorContext)_localctx).reliability = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					break;
				case CHANGE:
					{
					setState(82); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(81);
							change();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(84); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(88); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << RATE) | (1L << CHANGE) | (1L << RELIABILITY))) != 0) );
			setState(90);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ChangeContext extends ParserRuleContext {
		public Token begin;
		public Token end;
		public Token value;
		public TerminalNode CHANGE() { return getToken(UUVParser.CHANGE, 0); }
		public TerminalNode ASSIGN() { return getToken(UUVParser.ASSIGN, 0); }
		public List<TerminalNode> INT() { return getTokens(UUVParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(UUVParser.INT, i);
		}
		public List<TerminalNode> DOUBLE() { return getTokens(UUVParser.DOUBLE); }
		public TerminalNode DOUBLE(int i) {
			return getToken(UUVParser.DOUBLE, i);
		}
		public ChangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_change; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UUVListener ) ((UUVListener)listener).enterChange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UUVListener ) ((UUVListener)listener).exitChange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UUVVisitor ) return ((UUVVisitor<? extends T>)visitor).visitChange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChangeContext change() throws RecognitionException {
		ChangeContext _localctx = new ChangeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_change);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(CHANGE);
			setState(93);
			match(ASSIGN);
			setState(94);
			((ChangeContext)_localctx).begin = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==DOUBLE) ) {
				((ChangeContext)_localctx).begin = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(95);
			match(T__3);
			setState(96);
			((ChangeContext)_localctx).end = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==DOUBLE) ) {
				((ChangeContext)_localctx).end = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(97);
			match(T__3);
			setState(98);
			((ChangeContext)_localctx).value = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==DOUBLE) ) {
				((ChangeContext)_localctx).value = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\33g\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\6\2\34\n\2\r\2\16\2\35\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\6\bC\n\b\r\b\16\bD\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\6\tU\n\t\r\t\16\tV\6\t"+
		"Y\n\t\r\t\16\tZ\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\2\2\13\2\4"+
		"\6\b\n\f\16\20\22\2\4\3\2\26\27\4\2\3\3\30\30l\2\33\3\2\2\2\4\37\3\2\2"+
		"\2\6#\3\2\2\2\b\'\3\2\2\2\n+\3\2\2\2\f/\3\2\2\2\16\63\3\2\2\2\20H\3\2"+
		"\2\2\22^\3\2\2\2\24\34\5\4\3\2\25\34\5\6\4\2\26\34\5\b\5\2\27\34\5\n\6"+
		"\2\30\34\5\16\b\2\31\34\5\f\7\2\32\34\5\20\t\2\33\24\3\2\2\2\33\25\3\2"+
		"\2\2\33\26\3\2\2\2\33\27\3\2\2\2\33\30\3\2\2\2\33\31\3\2\2\2\33\32\3\2"+
		"\2\2\34\35\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36\3\3\2\2\2\37 \7\f\2"+
		"\2 !\7\t\2\2!\"\7\26\2\2\"\5\3\2\2\2#$\7\r\2\2$%\7\t\2\2%&\t\2\2\2&\7"+
		"\3\2\2\2\'(\7\n\2\2()\7\t\2\2)*\t\3\2\2*\t\3\2\2\2+,\7\13\2\2,-\7\t\2"+
		"\2-.\7\26\2\2.\13\3\2\2\2/\60\7\16\2\2\60\61\7\t\2\2\61\62\7\26\2\2\62"+
		"\r\3\2\2\2\63\64\7\4\2\2\64B\7\5\2\2\65\66\7\20\2\2\66\67\7\t\2\2\67C"+
		"\7\25\2\289\7\17\2\29:\7\t\2\2:;\t\2\2\2;<\7\6\2\2<=\t\2\2\2=>\7\6\2\2"+
		">C\7\26\2\2?@\7\13\2\2@A\7\t\2\2AC\7\26\2\2B\65\3\2\2\2B8\3\2\2\2B?\3"+
		"\2\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2EF\3\2\2\2FG\7\7\2\2G\17\3\2\2\2H"+
		"I\7\b\2\2IX\7\5\2\2JK\7\20\2\2KL\7\t\2\2LY\7\25\2\2MN\7\21\2\2NO\7\t\2"+
		"\2OY\t\2\2\2PQ\7\23\2\2QR\7\t\2\2RY\t\2\2\2SU\5\22\n\2TS\3\2\2\2UV\3\2"+
		"\2\2VT\3\2\2\2VW\3\2\2\2WY\3\2\2\2XJ\3\2\2\2XM\3\2\2\2XP\3\2\2\2XT\3\2"+
		"\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\7\7\2\2]\21\3\2\2\2^"+
		"_\7\22\2\2_`\7\t\2\2`a\t\2\2\2ab\7\6\2\2bc\t\2\2\2cd\7\6\2\2de\t\2\2\2"+
		"e\23\3\2\2\2\t\33\35BDVXZ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}