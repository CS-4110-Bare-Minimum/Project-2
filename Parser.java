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
    5,   17,   17,   18,   18,    6,   19,   19,   20,   20,
   12,   21,   21,   22,   22,   22,   22,   22,   22,   22,
   22,   30,   30,   24,   25,   26,   27,   28,   29,   23,
   23,   31,   31,   10,   10,   10,   10,   10,   10,   10,
   10,   10,   10,   10,   10,   10,   10,   10,   10,   10,
   10,   10,   10,   10,   10,   10,   10,   32,   32,   32,
   34,   34,   35,   35,   33,   33,   33,   33,   33,
};
final static short yylen[] = {                            2,
    1,    1,    1,    1,    1,    1,    2,    2,    2,    0,
    2,    4,    1,    1,    1,    1,    3,    1,    6,    6,
    1,    3,    1,    0,    1,    3,    0,    2,    0,    2,
    7,    2,    0,    1,    1,    5,    2,    0,    6,    6,
    4,    2,    0,    2,    1,    1,    1,    1,    1,    1,
    1,    0,    2,    6,    5,    9,    2,    3,    5,    0,
    1,    1,    3,    3,    1,    1,    1,    1,    3,    3,
    3,    3,    3,    3,    2,    3,    3,    3,    3,    3,
    3,    3,    3,    2,    3,    4,    6,    1,    4,    3,
    4,    6,    1,    0,    1,    1,    1,    1,    1,
};
final static short yydefred[] = {                         0,
   15,    0,   14,   13,    0,   16,    0,   18,    0,    0,
    6,    2,    3,    4,    5,    0,    0,    0,    0,    0,
    7,    8,    0,    0,    0,    0,   38,    0,    0,    0,
   17,   28,    0,    0,    0,   21,    0,    0,    0,    0,
    0,    0,   99,    0,   67,    0,    0,   95,   96,   97,
   98,    0,    0,    0,    0,   65,   68,   25,    0,   33,
    0,   36,    0,   37,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   10,   20,   22,   19,
    0,    0,   85,    0,    0,    0,    0,   69,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   83,    0,   90,   64,   26,   31,   34,   35,   32,    0,
    0,    0,   86,    0,    0,   91,    0,   89,    0,    0,
    9,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   41,    0,   51,   42,    0,   45,   46,
   47,   48,   49,   50,   87,   92,   40,   39,   57,    0,
    0,    0,    0,    0,   44,    0,    0,    0,   58,    0,
    0,    0,    0,    0,    0,    0,   59,   55,    0,    0,
   54,    0,   53,    0,   56,
};
final static short yydgoto[] = {                          9,
   10,   11,   12,   13,   14,   15,   16,  132,   37,  155,
   38,  156,   39,   59,   26,   34,   94,  129,   35,   64,
  142,  157,  158,  159,  160,  161,  162,  163,  164,  191,
  105,   55,   56,   57,  106,
};
final static short yysindex[] = {                       188,
    0, -255,    0,    0, -249,    0, -244,    0,    0,  188,
    0,    0,    0,    0,    0, -246, -267, -175, -187, -181,
    0,    0, -279, -173, -164, -145,    0, -247, -247,   -8,
    0,    0, -159, -156, -142,    0, -241, -161, -158, -146,
 -138, -135,    0, -131,    0, -271,   -8,    0,    0,    0,
    0,   -8,   -8,  445, -280,    0,    0,    0, -137,    0,
 -121,    0, -217,    0, -148, -124, -247, -124, -116, -122,
 -117,   -8, -111,   58,  445,   67,   -8,   -8,   -8,   -8,
   -8,   -8,   -8,   -8,   -8,   -8,   -8,   -8,   -8,   -8,
 -110,   -8, -107, -141, -108, -103,    0,    0,    0,    0,
 -101, -106,    0,  445, -105,  -97,  -93,    0,   43,   43,
   43,   67,   67, -179, -179, -179, -179, -236, -236, -118,
    0,  221,    0,    0,    0,    0,    0,    0,    0, -247,
 -247, -247,    0, -247,   -8,    0,   -8,    0,  -92,  -85,
    0, -115, -174,  445,  -83,  -87,  -84,  -81,  -79,  -77,
  -74,   -8,  -73,    0,  445,    0,    0,  -75,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   -8,
   -8,   -8,  -67,   -8,    0,  -66,   84, -265,    0,  110,
   -8,  -37,  -65,  -37,  330,  -42,    0,    0,   -8,  -37,
    0,  -58,    0,  -37,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  229,
    0,    0,    0,    0,    0,    0,    0, -258,    0,    0,
    0,    0,  -59,    0,    0,  -56,    0,  -46,  -46,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  -44,    0,
    0,    0,    0,    0,    0,    5,    0,    0,    0,    0,
    0,    0,    0, -223,   32,    0,    0,    0,  -40,    0,
    0,    0,    0,    0, -199,    0,    0,    0,    0,    0,
    0,  -43,    0,    0, -251,  356,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0, -219,  -41,    0,    0,    0,  410,  426,
  442,  374,  392,  247,  269,  291,  313,  175,  199,  136,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  -46,
  -46,  -76,    0,    0,    0,    0,  -43,    0,    0,    0,
    0,  -38,    0, -201,    0,    0,    0,    0,    0,    0,
    0,  -38,    0,    0, -268,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  -38,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  -38,    0,  -38,    0, -195,    0,    0,  -39,  -38,
    0,    0,    0,  -38,    0,
};
final static short yygindex[] = {                         0,
    0,  238,  -91,  155,    0,    0,  -22,    0,    1,  -30,
  -27,   14,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  -70, -143,    0,    0,    0,    0,    0,    0,    0,
   80,    0,    0,    0,  116,
};
final static int YYTABLESIZE=754;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         54,
   17,   40,  127,   29,   90,   36,   36,   27,  173,    1,
   17,   72,    3,   23,   91,   61,   74,   24,  183,    4,
   61,   75,   76,   73,  135,   18,  176,    6,   27,   92,
   30,   19,   84,    8,   84,   63,   20,   84,   84,   65,
  141,  104,   22,   24,   99,  192,  109,  110,  111,  112,
  113,  114,  115,  116,  117,  118,  119,  120,  121,  122,
   12,  124,   52,   96,   62,   12,   12,   24,   52,   52,
   62,   88,   89,   52,   52,   52,   52,   52,   52,   98,
   52,  100,   63,   52,   11,   52,   25,   52,   63,   11,
   11,   52,   52,   52,   17,   52,   52,   52,   52,   27,
   52,   28,  139,  140,  144,   52,  104,   36,   36,  165,
   24,  186,   31,  188,    1,    1,   32,    3,    3,  193,
   33,   58,   66,  195,    4,    4,   86,   87,   88,   89,
   60,   67,    6,    6,  143,   61,    7,   68,    8,    8,
  177,  104,  148,  180,   69,   62,  126,   70,  149,  150,
  185,   71,   93,   41,   42,   43,  151,   44,  152,   95,
   45,   30,   97,  153,  101,   46,  103,   47,  102,  107,
  123,   97,  154,  125,  130,   48,   49,   50,   51,  131,
   52,   43,  133,  134,  135,   53,  136,   43,   43,  137,
   89,  146,   43,   43,   43,   43,   43,   43,  147,   43,
  166,  167,   43,  170,  168,  171,   43,  169,  172,  174,
   43,   43,   43,  175,   43,   43,   43,   43,  190,   43,
  148,  179,  181,  187,   43,  194,  149,  150,    1,   11,
   29,   41,   42,   43,  151,   44,  152,   24,   45,   23,
   94,  153,   93,   46,   60,   47,   30,   21,  128,   97,
   60,  178,  145,   48,   49,   50,   51,    0,   52,    0,
   41,   42,   43,   53,   44,    0,    0,   45,    0,    0,
    0,    0,   46,    0,   47,    0,    0,    0,    0,    0,
    0,    0,   48,   49,   50,   51,    0,   52,   88,   88,
   88,    0,   53,   88,   88,    0,    0,    0,    0,    0,
    0,   88,   88,   88,   88,   88,   88,   88,   88,   88,
   88,   88,   88,   88,   88,   66,    0,   66,    0,    0,
   66,   66,    0,    0,    0,    0,    0,    0,   66,   66,
   66,   66,   66,   66,   66,   66,   66,   66,   66,   66,
   66,  108,   80,   81,   82,   83,   84,   85,   86,   87,
   88,   89,    0,    0,   77,   78,   79,   80,   81,   82,
   83,   84,   85,   86,   87,   88,   89,  182,   82,   83,
   84,   85,   86,   87,   88,   89,    0,    0,    0,    0,
   77,   78,   79,   80,   81,   82,   83,   84,   85,   86,
   87,   88,   89,  184,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   77,   78,   79,   80,
   81,   82,   83,   84,   85,   86,   87,   88,   89,   82,
    0,   82,    0,    0,   82,   82,    0,    0,    0,    0,
    0,    0,   82,   82,   82,   82,   82,   82,   82,   82,
   82,   82,   82,   82,    1,    0,    2,    3,    0,    0,
    0,    0,    0,    0,    4,    5,    0,    0,   80,    0,
   80,    0,    6,   80,   80,    7,    0,    0,    8,    0,
    0,   80,   80,   80,   80,   80,   80,   80,   80,   80,
   80,   80,   81,    0,   81,    0,    0,   81,   81,    0,
    0,    0,    0,    0,    0,   81,   81,   81,   81,   81,
   81,   81,   81,   81,   81,   81,  138,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   77,   78,   79,
   80,   81,   82,   83,   84,   85,   86,   87,   88,   89,
   76,    0,   76,    0,    0,   76,   76,    0,    0,    0,
    0,    0,    0,   76,   76,   76,   76,   76,   76,   76,
   76,   76,   77,    0,   77,    0,    0,   77,   77,    0,
    0,    0,    0,    0,    0,   77,   77,   77,   77,   77,
   77,   77,   77,   77,   78,    0,   78,    0,    0,   78,
   78,    0,    0,    0,    0,    0,    0,   78,   78,   78,
   78,   78,   78,   78,   78,   78,   79,    0,   79,    0,
    0,   79,   79,    0,    0,    0,    0,    0,    0,   79,
   79,   79,   79,   79,   79,   79,   79,   79,  189,    0,
    0,    0,    0,    0,    0,    0,   77,   78,   79,   80,
   81,   82,   83,   84,   85,   86,   87,   88,   89,   75,
    0,   75,    0,    0,   75,   75,    0,    0,    0,    0,
    0,    0,   75,   75,   75,   75,   75,   70,    0,   70,
    0,    0,   70,   70,    0,    0,    0,    0,    0,    0,
   70,   70,   70,   70,   70,   71,    0,   71,    0,    0,
   71,   71,    0,    0,    0,    0,    0,    0,   71,   71,
   71,   71,   71,   72,    0,   72,    0,    0,   72,   72,
    0,    0,    0,    0,    0,    0,   72,   72,   72,   73,
    0,   73,    0,    0,   73,   73,    0,    0,    0,    0,
    0,    0,   73,   73,   73,   74,    0,   74,    0,    0,
   74,   74,    0,    0,    0,    0,    0,    0,   74,   74,
   74,   77,   78,   79,   80,   81,   82,   83,   84,   85,
   86,   87,   88,   89,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         30,
    0,   29,   94,  283,  285,   28,   29,  266,  152,  257,
   10,  283,  260,  281,  295,  284,   47,  285,  284,  267,
  289,   52,   53,  295,  290,  281,  170,  275,  287,  310,
  310,  281,  284,  281,  286,   35,  281,  289,  290,  281,
  132,   72,  289,  285,   67,  189,   77,   78,   79,   80,
   81,   82,   83,   84,   85,   86,   87,   88,   89,   90,
  284,   92,  258,  281,  284,  289,  290,  285,  264,  265,
  290,  308,  309,  269,  270,  271,  272,  273,  274,   66,
  276,   68,  284,  279,  284,  281,  262,  283,  290,  289,
  290,  287,  288,  289,   94,  291,  292,  293,  294,  287,
  296,  283,  130,  131,  135,  301,  137,  130,  131,  284,
  285,  182,  286,  184,  257,  257,  281,  260,  260,  190,
  266,  281,  284,  194,  267,  267,  306,  307,  308,  309,
  287,  290,  275,  275,  134,  278,  278,  284,  281,  281,
  171,  172,  258,  174,  283,  288,  288,  283,  264,  265,
  181,  283,  290,  269,  270,  271,  272,  273,  274,  281,
  276,  310,  287,  279,  281,  281,  284,  283,  291,  281,
  281,  287,  288,  281,  283,  291,  292,  293,  294,  283,
  296,  258,  284,  290,  290,  301,  284,  264,  265,  283,
  309,  284,  269,  270,  271,  272,  273,  274,  284,  276,
  284,  289,  279,  283,  289,  283,  283,  289,  283,  283,
  287,  288,  289,  289,  291,  292,  293,  294,  261,  296,
  258,  289,  289,  289,  301,  284,  264,  265,    0,  289,
  287,  269,  270,  271,  272,  273,  274,  284,  276,  284,
  284,  279,  284,  281,  284,  283,  287,   10,   94,  287,
  289,  172,  137,  291,  292,  293,  294,   -1,  296,   -1,
  269,  270,  271,  301,  273,   -1,   -1,  276,   -1,   -1,
   -1,   -1,  281,   -1,  283,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  291,  292,  293,  294,   -1,  296,  284,  285,
  286,   -1,  301,  289,  290,   -1,   -1,   -1,   -1,   -1,
   -1,  297,  298,  299,  300,  301,  302,  303,  304,  305,
  306,  307,  308,  309,  310,  284,   -1,  286,   -1,   -1,
  289,  290,   -1,   -1,   -1,   -1,   -1,   -1,  297,  298,
  299,  300,  301,  302,  303,  304,  305,  306,  307,  308,
  309,  284,  300,  301,  302,  303,  304,  305,  306,  307,
  308,  309,   -1,   -1,  297,  298,  299,  300,  301,  302,
  303,  304,  305,  306,  307,  308,  309,  284,  302,  303,
  304,  305,  306,  307,  308,  309,   -1,   -1,   -1,   -1,
  297,  298,  299,  300,  301,  302,  303,  304,  305,  306,
  307,  308,  309,  284,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  297,  298,  299,  300,
  301,  302,  303,  304,  305,  306,  307,  308,  309,  284,
   -1,  286,   -1,   -1,  289,  290,   -1,   -1,   -1,   -1,
   -1,   -1,  297,  298,  299,  300,  301,  302,  303,  304,
  305,  306,  307,  308,  257,   -1,  259,  260,   -1,   -1,
   -1,   -1,   -1,   -1,  267,  268,   -1,   -1,  284,   -1,
  286,   -1,  275,  289,  290,  278,   -1,   -1,  281,   -1,
   -1,  297,  298,  299,  300,  301,  302,  303,  304,  305,
  306,  307,  284,   -1,  286,   -1,   -1,  289,  290,   -1,
   -1,   -1,   -1,   -1,   -1,  297,  298,  299,  300,  301,
  302,  303,  304,  305,  306,  307,  286,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  297,  298,  299,
  300,  301,  302,  303,  304,  305,  306,  307,  308,  309,
  284,   -1,  286,   -1,   -1,  289,  290,   -1,   -1,   -1,
   -1,   -1,   -1,  297,  298,  299,  300,  301,  302,  303,
  304,  305,  284,   -1,  286,   -1,   -1,  289,  290,   -1,
   -1,   -1,   -1,   -1,   -1,  297,  298,  299,  300,  301,
  302,  303,  304,  305,  284,   -1,  286,   -1,   -1,  289,
  290,   -1,   -1,   -1,   -1,   -1,   -1,  297,  298,  299,
  300,  301,  302,  303,  304,  305,  284,   -1,  286,   -1,
   -1,  289,  290,   -1,   -1,   -1,   -1,   -1,   -1,  297,
  298,  299,  300,  301,  302,  303,  304,  305,  289,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  297,  298,  299,  300,
  301,  302,  303,  304,  305,  306,  307,  308,  309,  284,
   -1,  286,   -1,   -1,  289,  290,   -1,   -1,   -1,   -1,
   -1,   -1,  297,  298,  299,  300,  301,  284,   -1,  286,
   -1,   -1,  289,  290,   -1,   -1,   -1,   -1,   -1,   -1,
  297,  298,  299,  300,  301,  284,   -1,  286,   -1,   -1,
  289,  290,   -1,   -1,   -1,   -1,   -1,   -1,  297,  298,
  299,  300,  301,  284,   -1,  286,   -1,   -1,  289,  290,
   -1,   -1,   -1,   -1,   -1,   -1,  297,  298,  299,  284,
   -1,  286,   -1,   -1,  289,  290,   -1,   -1,   -1,   -1,
   -1,   -1,  297,  298,  299,  284,   -1,  286,   -1,   -1,
  289,  290,   -1,   -1,   -1,   -1,   -1,   -1,  297,  298,
  299,  297,  298,  299,  300,  301,  302,  303,  304,  305,
  306,  307,  308,  309,
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
"Decl_PLUS : Decl_PLUS Decl",
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
"EXTEND_ZOO :",
"EXTEND_ZOO : EXTENDS ID",
"IMPLEMENT_ZOO :",
"IMPLEMENT_ZOO : IMPLEMENTS ID_PLUS",
"ClassDecl : CLASS ID EXTEND_ZOO IMPLEMENT_ZOO LEFTBRACE Field_MULT RIGHTBRACE",
"Field_MULT : Field_MULT Field",
"Field_MULT :",
"Field : VariableDecl",
"Field : FunctionDecl",
"InterfaceDecl : INTERFACE ID LEFTBRACE Prototype_MULT RIGHTBRACE",
"Prototype_MULT : Prototype_MULT Prototype",
"Prototype_MULT :",
"Prototype : Type ID LEFTPAREN Formals RIGHTPAREN SEMICOLON",
"Prototype : VOID ID LEFTPAREN Formals RIGHTPAREN SEMICOLON",
"StmtBlock : LEFTBRACE VariableDecl_MULT Stmt_MULT RIGHTBRACE",
"Stmt_MULT : Stmt_MULT Stmt",
"Stmt_MULT :",
"Stmt : Expr_ZOO SEMICOLON",
"Stmt : IfStmt",
"Stmt : WhileStmt",
"Stmt : ForStmt",
"Stmt : BreakStmt",
"Stmt : ReturnStmt",
"Stmt : PrintStmt",
"Stmt : StmtBlock",
"Else_ZOO :",
"Else_ZOO : ELSE Stmt",
"IfStmt : IF LEFTPAREN Expr RIGHTPAREN Stmt Else_ZOO",
"WhileStmt : WHILE LEFTPAREN Expr RIGHTPAREN Stmt",
"ForStmt : FOR LEFTPAREN Expr_ZOO SEMICOLON Expr SEMICOLON Expr_ZOO RIGHTPAREN Stmt",
"BreakStmt : BREAK SEMICOLON",
"ReturnStmt : RETURN Expr_ZOO SEMICOLON",
"PrintStmt : PRINTLN LEFTPAREN Expr_PLUS RIGHTPAREN SEMICOLON",
"Expr_ZOO :",
"Expr_ZOO : Expr",
"Expr_PLUS : Expr",
"Expr_PLUS : Expr_PLUS COMMA Expr",
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
"Lvalue : ID",
"Lvalue : Lvalue LEFTBRACKET Expr RIGHTBRACKET",
"Lvalue : Lvalue PERIOD ID",
"Call : ID LEFTPAREN Actuals RIGHTPAREN",
"Call : ID PERIOD ID LEFTPAREN Actuals RIGHTPAREN",
"Actuals : Expr_PLUS",
"Actuals :",
"Constant : INTCONSTANT",
"Constant : DOUBLECONSTANT",
"Constant : STRINGCONSTANT",
"Constant : BOOLEANCONSTANT",
"Constant : NULL",
};

//#line 235 "Parser.y"

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
	System.err.println ("Error: " + error);
	//System.err.println ("[Reject]");

}

public Parser(Reader r) {
	yydebug=true;
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
//#line 579 "Parser.java"
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
{System.out.println("");}
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
//#line 86 "Parser.y"
{System.out.println("");}
break;
case 29:
//#line 90 "Parser.y"
{System.out.println("");}
break;
case 30:
//#line 92 "Parser.y"
{System.out.println("");}
break;
case 31:
//#line 96 "Parser.y"
{System.out.println("+  + " " + ");}
break;
case 32:
//#line 100 "Parser.y"
{System.out.println("");}
break;
case 33:
//#line 101 "Parser.y"
{System.out.println("");}
break;
case 34:
//#line 105 "Parser.y"
{System.out.println("");}
break;
case 35:
//#line 106 "Parser.y"
{System.out.println("");}
break;
case 36:
//#line 110 "Parser.y"
{System.out.println("");}
break;
case 37:
//#line 114 "Parser.y"
{System.out.println("");}
break;
case 38:
//#line 115 "Parser.y"
{System.out.println("");}
break;
case 39:
//#line 119 "Parser.y"
{System.out.println("");;}
break;
case 40:
//#line 120 "Parser.y"
{System.out.println("");}
break;
case 41:
//#line 124 "Parser.y"
{System.out.println("");}
break;
case 42:
//#line 128 "Parser.y"
{System.out.println("");}
break;
case 43:
//#line 129 "Parser.y"
{System.out.println("");}
break;
case 44:
//#line 133 "Parser.y"
{System.out.println("");}
break;
case 45:
//#line 134 "Parser.y"
{System.out.println("");}
break;
case 46:
//#line 135 "Parser.y"
{System.out.println("");}
break;
case 47:
//#line 136 "Parser.y"
{System.out.println("");}
break;
case 48:
//#line 137 "Parser.y"
{System.out.println("");}
break;
case 49:
//#line 138 "Parser.y"
{System.out.println("");}
break;
case 50:
//#line 139 "Parser.y"
{System.out.println("");}
break;
case 51:
//#line 140 "Parser.y"
{System.out.println("");}
break;
case 52:
//#line 144 "Parser.y"
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
//#line 170 "Parser.y"
{System.out.println("");}
break;
case 60:
//#line 174 "Parser.y"
{System.out.println("");}
break;
case 61:
//#line 175 "Parser.y"
{System.out.println("");}
break;
case 62:
//#line 179 "Parser.y"
{System.out.println("");}
break;
case 63:
//#line 180 "Parser.y"
{System.out.println("");}
break;
case 64:
//#line 184 "Parser.y"
{System.out.println("");}
break;
case 65:
//#line 185 "Parser.y"
{System.out.println("");}
break;
case 66:
//#line 186 "Parser.y"
{System.out.println("");}
break;
case 67:
//#line 187 "Parser.y"
{System.out.println("");}
break;
case 68:
//#line 188 "Parser.y"
{System.out.println("");}
break;
case 69:
//#line 189 "Parser.y"
{System.out.println("");}
break;
case 70:
//#line 190 "Parser.y"
{System.out.println("");}
break;
case 71:
//#line 191 "Parser.y"
{System.out.println("");}
break;
case 72:
//#line 192 "Parser.y"
{System.out.println("");}
break;
case 73:
//#line 193 "Parser.y"
{System.out.println("");}
break;
case 74:
//#line 194 "Parser.y"
{System.out.println("");}
break;
case 75:
//#line 195 "Parser.y"
{System.out.println("");}
break;
case 76:
//#line 196 "Parser.y"
{System.out.println("");}
break;
case 77:
//#line 197 "Parser.y"
{System.out.println("");}
break;
case 78:
//#line 198 "Parser.y"
{System.out.println("");}
break;
case 79:
//#line 199 "Parser.y"
{System.out.println("");}
break;
case 80:
//#line 200 "Parser.y"
{System.out.println("");}
break;
case 81:
//#line 201 "Parser.y"
{System.out.println("");}
break;
case 82:
//#line 202 "Parser.y"
{System.out.println("");}
break;
case 83:
//#line 203 "Parser.y"
{System.out.println("");}
break;
case 84:
//#line 204 "Parser.y"
{System.out.println("");}
break;
case 85:
//#line 205 "Parser.y"
{System.out.println("");}
break;
case 86:
//#line 206 "Parser.y"
{System.out.println("");}
break;
case 87:
//#line 207 "Parser.y"
{System.out.println("");}
break;
case 88:
//#line 211 "Parser.y"
{System.out.println("");}
break;
case 89:
//#line 212 "Parser.y"
{System.out.println("");}
break;
case 90:
//#line 213 "Parser.y"
{System.out.println("");}
break;
case 91:
//#line 217 "Parser.y"
{System.out.println("");}
break;
case 92:
//#line 218 "Parser.y"
{System.out.println("");}
break;
case 93:
//#line 222 "Parser.y"
{System.out.println("");}
break;
case 94:
//#line 223 "Parser.y"
{System.out.println("");}
break;
case 95:
//#line 227 "Parser.y"
{System.out.println("");}
break;
case 96:
//#line 228 "Parser.y"
{System.out.println("");}
break;
case 97:
//#line 229 "Parser.y"
{System.out.println("");}
break;
case 98:
//#line 230 "Parser.y"
{System.out.println("");}
break;
case 99:
//#line 231 "Parser.y"
{System.out.println("");}
break;
//#line 1116 "Parser.java"
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
