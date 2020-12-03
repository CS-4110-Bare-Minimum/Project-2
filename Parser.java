//### This file created by BYACC 1.8(/Java extension  1.15)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";






//#line 2 "Parser.y"
  import java.io.*;
  import java.util.Scanner;
//#line 20 "Parser.java"




public class Parser
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//public class ParserVal is defined in ParserVal.java


String   yytext;//user variable to return contextual strings
ParserVal yyval; //used to return semantic vals from action routines
ParserVal yylval;//the 'lval' (result) I got from yylex()
ParserVal valstk[];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
void val_init()
{
  valstk=new ParserVal[YYSTACKSIZE];
  yyval=new ParserVal();
  yylval=new ParserVal();
  valptr=-1;
}
void val_push(ParserVal val)
{
  if (valptr>=YYSTACKSIZE)
    return;
  valstk[++valptr]=val;
}
ParserVal val_pop()
{
  if (valptr<0)
    return new ParserVal();
  return valstk[valptr--];
}
void val_drop(int cnt)
{
int ptr;
  ptr=valptr-cnt;
  if (ptr<0)
    return;
  valptr = ptr;
}
ParserVal val_peek(int relative)
{
int ptr;
  ptr=valptr-relative;
  if (ptr<0)
    return new ParserVal();
  return valstk[ptr];
}
final ParserVal dup_yyval(ParserVal val)
{
  ParserVal dup = new ParserVal();
  dup.ival = val.ival;
  dup.dval = val.dval;
  dup.sval = val.sval;
  dup.obj = val.obj;
  return dup;
}
//#### end semantic value section ####
public final static short BOOLEAN=257;
public final static short BREAK=258;
public final static short CLASS=259;
public final static short DOUBLE=260;
public final static short ELSE=261;
public final static short EXTENDS=262;
public final static short FALSE=263;
public final static short FOR=264;
public final static short IF=265;
public final static short IMPLEMENTS=266;
public final static short INT=267;
public final static short INTERFACE=268;
public final static short NEW=269;
public final static short NEWARRAY=270;
public final static short NULL=271;
public final static short PRINTLN=272;
public final static short READLN=273;
public final static short RETURN=274;
public final static short STRING=275;
public final static short THIS=276;
public final static short TRUE=277;
public final static short VOID=278;
public final static short WHILE=279;
public final static short INTEGER=280;
public final static short ID=281;
public final static short NEWLINE=282;
public final static short LEFTPAREN=283;
public final static short RIGHTPAREN=284;
public final static short LEFTBRACKET=285;
public final static short RIGHTBRACKET=286;
public final static short LEFTBRACE=287;
public final static short RIGHTBRACE=288;
public final static short SEMICOLON=289;
public final static short COMMA=290;
public final static short INTCONSTANT=291;
public final static short DOUBLECONSTANT=292;
public final static short STRINGCONSTANT=293;
public final static short BOOLEANCONSTANT=294;
public final static short PERIOD=295;
public final static short NOT=296;
public final static short MULTIPLICATION=297;
public final static short DIVISION=298;
public final static short MOD=299;
public final static short PLUS=300;
public final static short MINUS=301;
public final static short LESS=302;
public final static short LESSEQUAL=303;
public final static short GREATER=304;
public final static short GREATEREQUAL=305;
public final static short EQUAL=306;
public final static short NOTEQUAL=307;
public final static short AND=308;
public final static short OR=309;
public final static short ASSIGNOP=310;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    2,    2,    2,    2,    1,    1,    3,    8,    8,
    7,    7,    9,    9,    9,    9,    9,    9,    4,    4,
   13,   13,   11,   11,   14,   14,   15,   15,   16,   16,
    5,   18,   18,   17,   17,    6,   20,   20,   19,   19,
   12,   22,   22,   22,   22,   22,   22,   22,   22,   21,
   21,   23,   24,   25,   26,   27,   28,   10,   10,   10,
   10,   10,   10,   10,   10,   10,   10,   10,   10,   10,
   10,   10,   10,   10,   10,   10,   10,   10,   10,   10,
   10,   29,   29,   30,   30,   30,   32,   32,   33,   33,
   31,   31,   31,   31,   31,
};
final static short yylen[] = {                            2,
    1,    1,    1,    1,    1,    1,    3,    2,    2,    0,
    2,    4,    1,    1,    1,    1,    3,    1,    6,    6,
    1,    3,    1,    0,    1,    3,    2,    0,    2,    0,
    7,    1,    1,    2,    0,    5,    6,    6,    2,    0,
    4,    2,    1,    1,    1,    1,    1,    1,    1,    2,
    0,    7,    5,    9,    2,    3,    6,    3,    1,    1,
    1,    1,    3,    3,    3,    3,    3,    3,    2,    3,
    3,    3,    3,    3,    3,    3,    3,    2,    3,    4,
    6,    1,    3,    1,    4,    3,    4,    6,    2,    0,
    1,    1,    1,    1,    1,
};
final static short yydefred[] = {                         0,
   15,    0,   14,   13,    0,   16,    0,   18,    0,    0,
    6,    2,    3,    4,    5,    0,    0,    0,    0,    0,
    0,    8,    0,    0,    0,    0,   40,    0,    7,    0,
    0,   17,   27,    0,    0,    0,   21,    0,    0,    0,
    0,    0,    0,   95,    0,   61,    0,    0,   91,   92,
   93,   94,    0,    0,    0,    0,   59,   62,   25,    0,
   35,    0,   36,    0,   39,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   10,   20,   22,
   19,    0,    0,   79,    0,    0,    0,    0,   63,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   77,    0,   86,   58,   26,   31,   32,   33,   34,
    0,    0,    0,   80,    0,    0,   87,    0,   85,    0,
    0,    9,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   41,    0,   49,   50,   43,   44,
   45,   46,   47,   48,   81,   88,   38,   37,   55,    0,
    0,    0,    0,    0,   42,    0,    0,    0,   56,    0,
    0,    0,    0,    0,    0,    0,    0,   53,    0,    0,
   57,    0,   52,    0,   54,
};
final static short yydgoto[] = {                          9,
   10,   11,   12,   13,   14,   15,   16,  133,   38,  156,
   39,  157,   40,   60,   26,   35,   95,  130,   36,   65,
  143,  158,  159,  160,  161,  162,  163,  164,  106,   56,
   57,   58,  107,
};
final static short yysindex[] = {                      -144,
    0, -262,    0,    0, -245,    0, -235,    0,    0, -227,
    0,    0,    0,    0,    0, -224, -269, -191, -209, -203,
 -144,    0, -277, -201, -194, -160,    0, -249,    0, -249,
  -13,    0,    0, -171, -157, -247,    0, -260, -151, -154,
 -140, -138, -137,    0, -136,    0, -268,  -13,    0,    0,
    0,    0,  -13,  -13,  516, -281,    0,    0,    0, -141,
    0, -130,    0, -193,    0, -153, -134, -249, -134, -125,
 -126, -117,  -13, -113,   54,  516,   63,  -13,  -13,  -13,
  -13,  -13,  -13,  -13,  -13,  -13,  -13,  -13,  -13,  -13,
  -13, -111,  -13, -109, -146, -108, -107,    0,    0,    0,
    0, -106, -116,    0,  516, -105, -104,  -95,    0,   39,
   39,   39,   63,   63, -181, -181, -181, -181, -208, -208,
 -120,    0,  229,    0,    0,    0,    0,    0,    0,    0,
 -249, -249, -249,    0, -249,  -13,    0,  -13,    0,  -94,
  -92,    0, -197, -165,  516,  -89,  -85,  -83,  -82,  -87,
  -86,  -74,  -13,  -73,    0,  338,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  -13,
  -13,  -13,  359,  -13,    0,  380,   80,  -79,    0,  106,
  -13, -110,  -42, -110,  401,  -48,  -75,    0,  -13, -110,
    0,  132,    0, -110,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  179,
    0,    0,    0,    0,    0,    0,    0, -257,    0,    0,
    0,    0,  -70,    0,    0,  -72,    0,  -66,    0,  -66,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  -60,
    0,    0,    0,    0,    0,    0,    1,    0,    0,    0,
    0,    0,    0,    0, -246,   28,    0,    0,    0,  -61,
    0,    0,    0,    0,    0, -172,    0,    0,    0,    0,
    0,    0,  -52,    0,    0, -220,  427,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  -57,    0,    0,    0,    0,  481,
  497,  513,  445,  463,  255,  277,  299,  321,  183,  207,
  158,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  -66,  -66,  -71,    0,    0,  -49,    0,  -52,    0,    0,
    0,    0,    0,    0,  -54,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
    0,  216,  -93,  143,    0,    0,  -23,    0,    3,  -31,
  -29,  -32,    0,    0,    0,    0,    0,    0,    0,    0,
    0, -101,    0,    0,    0,    0,    0,    0,   68,    0,
    0,    0,  105,
};
final static int YYTABLESIZE=825;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         55,
   41,  128,   17,   91,   37,   30,   37,    1,   28,    1,
    3,   23,    3,   92,   73,   24,   75,    4,   18,    4,
   66,   76,   77,   17,   24,    6,   74,    6,   93,   28,
   62,    8,   31,    8,   99,   19,  101,   12,   64,  142,
   63,  105,   12,   12,  100,   20,  110,  111,  112,  113,
  114,  115,  116,  117,  118,  119,  120,  121,  122,  123,
  149,  125,   21,   78,   22,   78,  150,  151,   78,   78,
   25,   42,   43,   44,  152,   45,  153,   27,   46,   28,
  186,  154,  188,   47,   32,   48,   33,   97,  193,   98,
  155,   24,  195,   49,   50,   51,   52,   17,   53,   89,
   90,  140,  141,   54,  145,   34,  105,   37,   37,   59,
    1,   11,    1,    3,    2,    3,   11,   11,  165,   24,
    4,  173,    4,    5,   87,   88,   89,   90,    6,   61,
    6,    7,   67,    7,    8,   68,    8,  144,  176,  177,
  105,  127,  180,   69,   70,   71,   72,  149,   94,  185,
   96,  145,   98,  150,  151,  102,   31,  192,   42,   43,
   44,  152,   45,  153,  103,   46,  104,  108,  154,  124,
   47,  126,   48,  135,  131,  132,   98,  134,    1,  137,
   49,   50,   51,   52,  136,   53,   51,  138,   90,  147,
   54,  148,   51,   51,  166,  170,  171,   51,   51,   51,
   51,   51,   51,  167,   51,  168,  169,   51,  172,  174,
  183,   51,  190,  191,   30,   51,   51,   24,   11,   51,
   51,   51,   51,   23,   51,   29,   42,   43,   44,   51,
   45,   90,   82,   46,   89,   83,   29,  129,   47,  178,
   48,  187,  146,    0,    0,    0,    0,    0,   49,   50,
   51,   52,    0,   53,    0,   42,   43,   44,   54,   45,
    0,    0,   46,    0,    0,    0,    0,   47,    0,   48,
    0,    0,    0,    0,    0,    0,    0,   49,   50,   51,
   52,    0,   53,    0,   84,   84,   84,   54,    0,   84,
   84,    0,    0,    0,    0,    0,    0,   84,   84,   84,
   84,   84,   84,   84,   84,   84,   84,   84,   84,   84,
   84,   60,    0,   60,    0,    0,   60,   60,    0,    0,
    0,    0,    0,    0,   60,   60,   60,   60,   60,   60,
   60,   60,   60,   60,   60,   60,   60,  109,   81,   82,
   83,   84,   85,   86,   87,   88,   89,   90,    0,    0,
   78,   79,   80,   81,   82,   83,   84,   85,   86,   87,
   88,   89,   90,  182,   83,   84,   85,   86,   87,   88,
   89,   90,    0,    0,    0,    0,   78,   79,   80,   81,
   82,   83,   84,   85,   86,   87,   88,   89,   90,  184,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   78,   79,   80,   81,   82,   83,   84,   85,
   86,   87,   88,   89,   90,  194,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   78,   79,
   80,   81,   82,   83,   84,   85,   86,   87,   88,   89,
   90,   76,    0,   76,    0,    0,   76,   76,    0,    0,
    0,    0,    0,    0,   76,   76,   76,   76,   76,   76,
   76,   76,   76,   76,   76,   76,   74,    0,   74,    0,
    0,   74,   74,    0,    0,    0,    0,    0,    0,   74,
   74,   74,   74,   74,   74,   74,   74,   74,   74,   74,
   75,    0,   75,    0,    0,   75,   75,    0,    0,    0,
    0,    0,    0,   75,   75,   75,   75,   75,   75,   75,
   75,   75,   75,   75,  139,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   78,   79,   80,   81,   82,
   83,   84,   85,   86,   87,   88,   89,   90,   70,    0,
   70,    0,    0,   70,   70,    0,    0,    0,    0,    0,
    0,   70,   70,   70,   70,   70,   70,   70,   70,   70,
   71,    0,   71,    0,    0,   71,   71,    0,    0,    0,
    0,    0,    0,   71,   71,   71,   71,   71,   71,   71,
   71,   71,   72,    0,   72,    0,    0,   72,   72,    0,
    0,    0,    0,    0,    0,   72,   72,   72,   72,   72,
   72,   72,   72,   72,   73,    0,   73,    0,    0,   73,
   73,    0,    0,    0,    0,    0,    0,   73,   73,   73,
   73,   73,   73,   73,   73,   73,  175,    0,    0,    0,
    0,    0,    0,    0,   78,   79,   80,   81,   82,   83,
   84,   85,   86,   87,   88,   89,   90,  179,    0,    0,
    0,    0,    0,    0,    0,   78,   79,   80,   81,   82,
   83,   84,   85,   86,   87,   88,   89,   90,  181,    0,
    0,    0,    0,    0,    0,    0,   78,   79,   80,   81,
   82,   83,   84,   85,   86,   87,   88,   89,   90,  189,
    0,    0,    0,    0,    0,    0,    0,   78,   79,   80,
   81,   82,   83,   84,   85,   86,   87,   88,   89,   90,
   69,    0,   69,    0,    0,   69,   69,    0,    0,    0,
    0,    0,    0,   69,   69,   69,   69,   69,   64,    0,
   64,    0,    0,   64,   64,    0,    0,    0,    0,    0,
    0,   64,   64,   64,   64,   64,   65,    0,   65,    0,
    0,   65,   65,    0,    0,    0,    0,    0,    0,   65,
   65,   65,   65,   65,   66,    0,   66,    0,    0,   66,
   66,    0,    0,    0,    0,    0,    0,   66,   66,   66,
   67,    0,   67,    0,    0,   67,   67,    0,    0,    0,
    0,    0,    0,   67,   67,   67,   68,    0,   68,    0,
    0,   68,   68,    0,    0,    0,    0,    0,    0,   68,
   68,   68,   78,   79,   80,   81,   82,   83,   84,   85,
   86,   87,   88,   89,   90,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         31,
   30,   95,    0,  285,   28,  283,   30,  257,  266,  257,
  260,  281,  260,  295,  283,  285,   48,  267,  281,  267,
  281,   53,   54,   21,  285,  275,  295,  275,  310,  287,
  278,  281,  310,  281,   67,  281,   69,  284,   36,  133,
  288,   73,  289,  290,   68,  281,   78,   79,   80,   81,
   82,   83,   84,   85,   86,   87,   88,   89,   90,   91,
  258,   93,  290,  284,  289,  286,  264,  265,  289,  290,
  262,  269,  270,  271,  272,  273,  274,  287,  276,  283,
  182,  279,  184,  281,  286,  283,  281,  281,  190,  287,
  288,  285,  194,  291,  292,  293,  294,   95,  296,  308,
  309,  131,  132,  301,  136,  266,  138,  131,  132,  281,
  257,  284,  257,  260,  259,  260,  289,  290,  284,  285,
  267,  153,  267,  268,  306,  307,  308,  309,  275,  287,
  275,  278,  284,  278,  281,  290,  281,  135,  170,  171,
  172,  288,  174,  284,  283,  283,  283,  258,  290,  181,
  281,  183,  287,  264,  265,  281,  310,  189,  269,  270,
  271,  272,  273,  274,  291,  276,  284,  281,  279,  281,
  281,  281,  283,  290,  283,  283,  287,  284,    0,  284,
  291,  292,  293,  294,  290,  296,  258,  283,  309,  284,
  301,  284,  264,  265,  284,  283,  283,  269,  270,  271,
  272,  273,  274,  289,  276,  289,  289,  279,  283,  283,
  290,  283,  261,  289,  287,  287,  288,  284,  289,  291,
  292,  293,  294,  284,  296,  287,  269,  270,  271,  301,
  273,  284,  290,  276,  284,  290,   21,   95,  281,  172,
  283,  284,  138,   -1,   -1,   -1,   -1,   -1,  291,  292,
  293,  294,   -1,  296,   -1,  269,  270,  271,  301,  273,
   -1,   -1,  276,   -1,   -1,   -1,   -1,  281,   -1,  283,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  291,  292,  293,
  294,   -1,  296,   -1,  284,  285,  286,  301,   -1,  289,
  290,   -1,   -1,   -1,   -1,   -1,   -1,  297,  298,  299,
  300,  301,  302,  303,  304,  305,  306,  307,  308,  309,
  310,  284,   -1,  286,   -1,   -1,  289,  290,   -1,   -1,
   -1,   -1,   -1,   -1,  297,  298,  299,  300,  301,  302,
  303,  304,  305,  306,  307,  308,  309,  284,  300,  301,
  302,  303,  304,  305,  306,  307,  308,  309,   -1,   -1,
  297,  298,  299,  300,  301,  302,  303,  304,  305,  306,
  307,  308,  309,  284,  302,  303,  304,  305,  306,  307,
  308,  309,   -1,   -1,   -1,   -1,  297,  298,  299,  300,
  301,  302,  303,  304,  305,  306,  307,  308,  309,  284,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  297,  298,  299,  300,  301,  302,  303,  304,
  305,  306,  307,  308,  309,  284,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  297,  298,
  299,  300,  301,  302,  303,  304,  305,  306,  307,  308,
  309,  284,   -1,  286,   -1,   -1,  289,  290,   -1,   -1,
   -1,   -1,   -1,   -1,  297,  298,  299,  300,  301,  302,
  303,  304,  305,  306,  307,  308,  284,   -1,  286,   -1,
   -1,  289,  290,   -1,   -1,   -1,   -1,   -1,   -1,  297,
  298,  299,  300,  301,  302,  303,  304,  305,  306,  307,
  284,   -1,  286,   -1,   -1,  289,  290,   -1,   -1,   -1,
   -1,   -1,   -1,  297,  298,  299,  300,  301,  302,  303,
  304,  305,  306,  307,  286,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  297,  298,  299,  300,  301,
  302,  303,  304,  305,  306,  307,  308,  309,  284,   -1,
  286,   -1,   -1,  289,  290,   -1,   -1,   -1,   -1,   -1,
   -1,  297,  298,  299,  300,  301,  302,  303,  304,  305,
  284,   -1,  286,   -1,   -1,  289,  290,   -1,   -1,   -1,
   -1,   -1,   -1,  297,  298,  299,  300,  301,  302,  303,
  304,  305,  284,   -1,  286,   -1,   -1,  289,  290,   -1,
   -1,   -1,   -1,   -1,   -1,  297,  298,  299,  300,  301,
  302,  303,  304,  305,  284,   -1,  286,   -1,   -1,  289,
  290,   -1,   -1,   -1,   -1,   -1,   -1,  297,  298,  299,
  300,  301,  302,  303,  304,  305,  289,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  297,  298,  299,  300,  301,  302,
  303,  304,  305,  306,  307,  308,  309,  289,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  297,  298,  299,  300,  301,
  302,  303,  304,  305,  306,  307,  308,  309,  289,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  297,  298,  299,  300,
  301,  302,  303,  304,  305,  306,  307,  308,  309,  289,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  297,  298,  299,
  300,  301,  302,  303,  304,  305,  306,  307,  308,  309,
  284,   -1,  286,   -1,   -1,  289,  290,   -1,   -1,   -1,
   -1,   -1,   -1,  297,  298,  299,  300,  301,  284,   -1,
  286,   -1,   -1,  289,  290,   -1,   -1,   -1,   -1,   -1,
   -1,  297,  298,  299,  300,  301,  284,   -1,  286,   -1,
   -1,  289,  290,   -1,   -1,   -1,   -1,   -1,   -1,  297,
  298,  299,  300,  301,  284,   -1,  286,   -1,   -1,  289,
  290,   -1,   -1,   -1,   -1,   -1,   -1,  297,  298,  299,
  284,   -1,  286,   -1,   -1,  289,  290,   -1,   -1,   -1,
   -1,   -1,   -1,  297,  298,  299,  284,   -1,  286,   -1,
   -1,  289,  290,   -1,   -1,   -1,   -1,   -1,   -1,  297,
  298,  299,  297,  298,  299,  300,  301,  302,  303,  304,
  305,  306,  307,  308,  309,
};
}
final static short YYFINAL=9;
final static short YYMAXTOKEN=310;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,"BOOLEAN","BREAK","CLASS","DOUBLE","ELSE","EXTENDS","FALSE",
"FOR","IF","IMPLEMENTS","INT","INTERFACE","NEW","NEWARRAY","NULL","PRINTLN",
"READLN","RETURN","STRING","THIS","TRUE","VOID","WHILE","INTEGER","ID",
"NEWLINE","LEFTPAREN","RIGHTPAREN","LEFTBRACKET","RIGHTBRACKET","LEFTBRACE",
"RIGHTBRACE","SEMICOLON","COMMA","INTCONSTANT","DOUBLECONSTANT",
"STRINGCONSTANT","BOOLEANCONSTANT","PERIOD","NOT","MULTIPLICATION","DIVISION",
"MOD","PLUS","MINUS","LESS","LESSEQUAL","GREATER","GREATEREQUAL","EQUAL",
"NOTEQUAL","AND","OR","ASSIGNOP",
};
final static String yyrule[] = {
"$accept : Program",
"Program : Decl_PLUS",
"Decl : VariableDecl",
"Decl : FunctionDecl",
"Decl : ClassDecl",
"Decl : InterfaceDecl",
"Decl_PLUS : Decl",
"Decl_PLUS : Decl_PLUS COMMA Decl",
"VariableDecl : Variable SEMICOLON",
"VariableDecl_MULT : VariableDecl_MULT VariableDecl",
"VariableDecl_MULT :",
"Variable : Type ID",
"Variable : Type ID ASSIGNOP Expr",
"Type : INT",
"Type : DOUBLE",
"Type : BOOLEAN",
"Type : STRING",
"Type : Type LEFTBRACKET RIGHTBRACKET",
"Type : ID",
"FunctionDecl : Type ID LEFTPAREN Formals RIGHTPAREN StmtBlock",
"FunctionDecl : VOID ID LEFTPAREN Formals RIGHTPAREN StmtBlock",
"Variable_PLUS : Variable",
"Variable_PLUS : Variable_PLUS COMMA Variable",
"Formals : Variable_PLUS",
"Formals :",
"ID_PLUS : ID",
"ID_PLUS : ID_PLUS COMMA ID",
"EXTEND : EXTENDS ID",
"EXTEND :",
"IMPLEMENT : IMPLEMENTS ID_PLUS",
"IMPLEMENT :",
"ClassDecl : CLASS ID EXTEND IMPLEMENT LEFTBRACE Field_MULT RIGHTBRACE",
"Field : VariableDecl",
"Field : FunctionDecl",
"Field_MULT : Field_MULT Field",
"Field_MULT :",
"InterfaceDecl : INTERFACE ID LEFTBRACE Prototype_MULT RIGHTBRACE",
"Prototype : Type ID LEFTPAREN Formals RIGHTPAREN SEMICOLON",
"Prototype : VOID ID LEFTPAREN Formals RIGHTPAREN SEMICOLON",
"Prototype_MULT : Prototype_MULT Prototype",
"Prototype_MULT :",
"StmtBlock : LEFTBRACE VariableDecl_MULT Stmt_MULT RIGHTBRACE",
"Stmt : Expr SEMICOLON",
"Stmt : IfStmt",
"Stmt : WhileStmt",
"Stmt : ForStmt",
"Stmt : BreakStmt",
"Stmt : ReturnStmt",
"Stmt : PrintStmt",
"Stmt : StmtBlock",
"Stmt_MULT : Stmt_MULT Stmt",
"Stmt_MULT :",
"IfStmt : IF LEFTPAREN Expr RIGHTPAREN Stmt ELSE Stmt",
"WhileStmt : WHILE LEFTPAREN Expr RIGHTPAREN Stmt",
"ForStmt : FOR LEFTPAREN Expr SEMICOLON Expr SEMICOLON Expr RIGHTPAREN Stmt",
"BreakStmt : BREAK SEMICOLON",
"ReturnStmt : RETURN Expr SEMICOLON",
"PrintStmt : PRINTLN LEFTPAREN Expr_PLUS COMMA RIGHTPAREN SEMICOLON",
"Expr : Lvalue ASSIGNOP Expr",
"Expr : Constant",
"Expr : Lvalue",
"Expr : THIS",
"Expr : Call",
"Expr : LEFTPAREN Expr RIGHTPAREN",
"Expr : Expr PLUS Expr",
"Expr : Expr MINUS Expr",
"Expr : Expr MULTIPLICATION Expr",
"Expr : Expr DIVISION Expr",
"Expr : Expr MOD Expr",
"Expr : MINUS Expr",
"Expr : Expr LESS Expr",
"Expr : Expr LESSEQUAL Expr",
"Expr : Expr GREATER Expr",
"Expr : Expr GREATEREQUAL Expr",
"Expr : Expr EQUAL Expr",
"Expr : Expr NOTEQUAL Expr",
"Expr : Expr AND Expr",
"Expr : Expr OR Expr",
"Expr : NOT Expr",
"Expr : READLN LEFTPAREN RIGHTPAREN",
"Expr : NEW LEFTPAREN ID RIGHTPAREN",
"Expr : NEWARRAY LEFTPAREN INTCONSTANT COMMA Type RIGHTPAREN",
"Expr_PLUS : Expr",
"Expr_PLUS : Expr_PLUS COMMA Expr",
"Lvalue : ID",
"Lvalue : Lvalue LEFTBRACKET Expr RIGHTBRACKET",
"Lvalue : Lvalue PERIOD ID",
"Call : ID LEFTPAREN Actuals RIGHTPAREN",
"Call : ID PERIOD ID LEFTPAREN Actuals RIGHTPAREN",
"Actuals : Expr_PLUS COMMA",
"Actuals :",
"Constant : INTCONSTANT",
"Constant : DOUBLECONSTANT",
"Constant : STRINGCONSTANT",
"Constant : BOOLEANCONSTANT",
"Constant : NULL",
};

//#line 222 "Parser.y"

private Yylex lexer;

private int yylex () {
	int yyl_return = -1;
	try {
		yylval = new ParserVal(0);
		yyl_return = lexer.yylex();
		System.out.println("-" + yyl_return);
	}
	catch (IOException e) {
		System.err.println("IO error :"+e);
	}
return yyl_return;
}


public void yyerror (String error) {
	//System.err.println ("Error: " + error);
	System.err.println ("[Reject]");

}

public Parser(Reader r) {
	//yydebug=true;
	lexer = new Yylex(r, this);
}

public static void main(String args[]) throws IOException {
	Parser parser;
	System.out.print("Enter File Name: ");
	Scanner scanner = new Scanner(System.in);
	FileReader fr = new FileReader(scanner.nextLine());
	parser = new Parser(fr);
	parser.yyparse();
}
//#line 589 "Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  val_push(yylval);     //save empty value
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        if (yychar < 0)    //it it didn't work/error
          {
          yychar = 0;      //change it to default string (no -1!)
          if (yydebug)
            yylexdebug(yystate,yychar);
          }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        if (yydebug)
          debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0)   //check for under & overflow here
            {
            yyerror("stack underflow. aborting...");  //note lower case 's'
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            if (yydebug)
              debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            if (yydebug)
              debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0)   //check for under & overflow here
              {
              yyerror("Stack underflow. aborting...");  //capital 'S'
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        if (yydebug)
          {
          yys = null;
          if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          if (yys == null) yys = "illegal-symbol";
          debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          }
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    if (yydebug)
      debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    yyval = dup_yyval(yyval); //duplicate yyval if ParserVal is used as semantic value
    switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 1:
//#line 24 "Parser.y"
{System.out.println("");}
break;
case 2:
//#line 28 "Parser.y"
{System.out.println(" ");}
break;
case 3:
//#line 29 "Parser.y"
{System.out.println("");}
break;
case 4:
//#line 30 "Parser.y"
{System.out.println("");}
break;
case 5:
//#line 31 "Parser.y"
{System.out.println("");}
break;
case 6:
//#line 35 "Parser.y"
{System.out.println(" ");}
break;
case 7:
//#line 36 "Parser.y"
{System.out.println("");}
break;
case 8:
//#line 40 "Parser.y"
{System.out.println("");}
break;
case 9:
//#line 44 "Parser.y"
{System.out.println("");}
break;
case 10:
//#line 45 "Parser.y"
{System.out.println("");}
break;
case 11:
//#line 49 "Parser.y"
{System.out.println("");}
break;
case 12:
//#line 50 "Parser.y"
{System.out.println("");}
break;
case 13:
//#line 54 "Parser.y"
{System.out.println(yyval);}
break;
case 14:
//#line 55 "Parser.y"
{System.out.println("");}
break;
case 15:
//#line 56 "Parser.y"
{System.out.println("");}
break;
case 16:
//#line 57 "Parser.y"
{System.out.println("");}
break;
case 17:
//#line 58 "Parser.y"
{System.out.println("");}
break;
case 18:
//#line 59 "Parser.y"
{System.out.println("");}
break;
case 19:
//#line 63 "Parser.y"
{System.out.println("");}
break;
case 20:
//#line 64 "Parser.y"
{System.out.println("");}
break;
case 21:
//#line 68 "Parser.y"
{System.out.println("");}
break;
case 22:
//#line 69 "Parser.y"
{System.out.println("");}
break;
case 23:
//#line 73 "Parser.y"
{System.out.println("");}
break;
case 24:
//#line 74 "Parser.y"
{System.out.println("");}
break;
case 27:
//#line 84 "Parser.y"
{System.out.println("");}
break;
case 28:
//#line 85 "Parser.y"
{System.out.println("");}
break;
case 29:
//#line 89 "Parser.y"
{System.out.println("");}
break;
case 30:
//#line 90 "Parser.y"
{System.out.println("");}
break;
case 31:
//#line 94 "Parser.y"
{System.out.println("");}
break;
case 32:
//#line 98 "Parser.y"
{System.out.println("");}
break;
case 33:
//#line 99 "Parser.y"
{System.out.println("");}
break;
case 34:
//#line 103 "Parser.y"
{System.out.println("");}
break;
case 35:
//#line 104 "Parser.y"
{System.out.println("");}
break;
case 36:
//#line 108 "Parser.y"
{System.out.println("");}
break;
case 37:
//#line 112 "Parser.y"
{System.out.println("");}
break;
case 38:
//#line 113 "Parser.y"
{System.out.println("");}
break;
case 39:
//#line 117 "Parser.y"
{System.out.println("");}
break;
case 40:
//#line 118 "Parser.y"
{System.out.println("");}
break;
case 41:
//#line 122 "Parser.y"
{System.out.println("");}
break;
case 42:
//#line 126 "Parser.y"
{System.out.println("");}
break;
case 43:
//#line 127 "Parser.y"
{System.out.println("");}
break;
case 44:
//#line 128 "Parser.y"
{System.out.println("");}
break;
case 45:
//#line 129 "Parser.y"
{System.out.println("");}
break;
case 46:
//#line 130 "Parser.y"
{System.out.println("");}
break;
case 47:
//#line 131 "Parser.y"
{System.out.println("");}
break;
case 48:
//#line 132 "Parser.y"
{System.out.println("");}
break;
case 49:
//#line 133 "Parser.y"
{System.out.println("");}
break;
case 50:
//#line 137 "Parser.y"
{System.out.println("");}
break;
case 51:
//#line 138 "Parser.y"
{System.out.println("");}
break;
case 52:
//#line 142 "Parser.y"
{System.out.println("");}
break;
case 53:
//#line 146 "Parser.y"
{System.out.println("");}
break;
case 54:
//#line 150 "Parser.y"
{System.out.println("");}
break;
case 55:
//#line 154 "Parser.y"
{System.out.println("");}
break;
case 56:
//#line 158 "Parser.y"
{System.out.println("");}
break;
case 57:
//#line 162 "Parser.y"
{System.out.println("");}
break;
case 58:
//#line 166 "Parser.y"
{System.out.println("");}
break;
case 59:
//#line 167 "Parser.y"
{System.out.println("");}
break;
case 60:
//#line 168 "Parser.y"
{System.out.println("");}
break;
case 61:
//#line 169 "Parser.y"
{System.out.println("");}
break;
case 62:
//#line 170 "Parser.y"
{System.out.println("");}
break;
case 63:
//#line 171 "Parser.y"
{System.out.println("");}
break;
case 64:
//#line 172 "Parser.y"
{System.out.println("");}
break;
case 65:
//#line 173 "Parser.y"
{System.out.println("");}
break;
case 66:
//#line 174 "Parser.y"
{System.out.println("");}
break;
case 67:
//#line 175 "Parser.y"
{System.out.println("");}
break;
case 68:
//#line 176 "Parser.y"
{System.out.println("");}
break;
case 69:
//#line 177 "Parser.y"
{System.out.println("");}
break;
case 70:
//#line 178 "Parser.y"
{System.out.println("");}
break;
case 71:
//#line 179 "Parser.y"
{System.out.println("");}
break;
case 72:
//#line 180 "Parser.y"
{System.out.println("");}
break;
case 73:
//#line 181 "Parser.y"
{System.out.println("");}
break;
case 74:
//#line 182 "Parser.y"
{System.out.println("");}
break;
case 75:
//#line 183 "Parser.y"
{System.out.println("");}
break;
case 76:
//#line 184 "Parser.y"
{System.out.println("");}
break;
case 77:
//#line 185 "Parser.y"
{System.out.println("");}
break;
case 78:
//#line 186 "Parser.y"
{System.out.println("");}
break;
case 79:
//#line 187 "Parser.y"
{System.out.println("");}
break;
case 80:
//#line 188 "Parser.y"
{System.out.println("");}
break;
case 81:
//#line 189 "Parser.y"
{System.out.println("");}
break;
case 82:
//#line 193 "Parser.y"
{System.out.println("");}
break;
case 83:
//#line 194 "Parser.y"
{System.out.println("");}
break;
case 84:
//#line 198 "Parser.y"
{System.out.println("");}
break;
case 85:
//#line 199 "Parser.y"
{System.out.println("");}
break;
case 86:
//#line 200 "Parser.y"
{System.out.println("");}
break;
case 87:
//#line 204 "Parser.y"
{System.out.println("");}
break;
case 88:
//#line 205 "Parser.y"
{System.out.println("");}
break;
case 89:
//#line 209 "Parser.y"
{System.out.println("");}
break;
case 90:
//#line 210 "Parser.y"
{System.out.println("");}
break;
case 91:
//#line 214 "Parser.y"
{System.out.println("");}
break;
case 92:
//#line 215 "Parser.y"
{System.out.println("");}
break;
case 93:
//#line 216 "Parser.y"
{System.out.println("");}
break;
case 94:
//#line 217 "Parser.y"
{System.out.println("");}
break;
case 95:
//#line 218 "Parser.y"
{System.out.println("");}
break;
//#line 1110 "Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        if (yychar<0) yychar=0;  //clean, if necessary
        if (yydebug)
          yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
/**
 * A default run method, used for operating this parser
 * object in the background.  It is intended for extending Thread
 * or implementing Runnable.  Turn off with -Jnorun .
 */
public void run()
{
  yyparse();
}
//## end of method run() ########################################



//## Constructors ###############################################
/**
 * Default constructor.  Turn off with -Jnoconstruct .

 */
public Parser()
{
  //nothing to do
}


/**
 * Create a parser, setting the debug to true or false.
 * @param debugMe true for debugging, false for no debug.
 */
public Parser(boolean debugMe)
{
  yydebug=debugMe;
}
//###############################################################



}
//################### END OF CLASS ##############################
