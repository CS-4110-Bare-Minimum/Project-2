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
    0,    1,    1,    2,    2,    2,    2,    7,    7,    3,
    9,    9,    8,    8,   10,   10,   10,   10,   10,   10,
    4,    4,   12,   12,   14,   14,   15,   15,   16,   16,
    5,   17,   17,   18,   18,    6,   19,   19,   20,   20,
   13,   13,   21,   21,   22,   22,   22,   22,   22,   22,
   22,   22,   30,   30,   24,   25,   26,   27,   28,   29,
   23,   23,   31,   31,   11,   11,   11,   11,   11,   11,
   11,   11,   11,   11,   11,   11,   11,   11,   11,   11,
   11,   11,   11,   11,   11,   11,   11,   11,   32,   32,
   32,   34,   34,   35,   35,   33,   33,   33,   33,   33,
};
final static short yylen[] = {                            2,
    1,    1,    2,    1,    1,    1,    1,    2,    0,    2,
    1,    3,    2,    4,    1,    1,    1,    1,    3,    1,
    6,    6,    1,    0,    1,    3,    0,    2,    0,    2,
    7,    2,    0,    1,    1,    5,    2,    0,    6,    6,
    4,    5,    2,    0,    2,    1,    1,    1,    1,    1,
    1,    1,    0,    2,    7,    5,    9,    2,    3,    5,
    0,    1,    1,    3,    3,    1,    1,    1,    1,    3,
    3,    3,    3,    3,    3,    2,    3,    3,    3,    3,
    3,    3,    3,    3,    2,    3,    4,    6,    1,    4,
    3,    4,    6,    1,    0,    1,    1,    1,    1,    1,
};
final static short yydefred[] = {                         0,
   17,    0,   16,   15,    0,   18,    0,   20,    0,    0,
    2,    4,    5,    6,    7,    0,    0,    0,    0,    0,
    3,   10,    0,    0,    0,    0,   38,    0,    0,    0,
   19,   28,    0,    0,    0,   11,    0,    0,    0,    0,
    0,    0,  100,    0,   68,    0,    0,   96,   97,   98,
   99,    0,    0,    0,    0,   66,   69,   25,    0,   33,
    0,   36,    0,   37,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   12,    9,   22,   21,
    0,    0,   86,    0,    0,    0,    0,   70,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   84,    0,   91,   65,   26,   31,   34,   35,   32,    0,
    0,    0,   87,    0,    0,   92,    0,   90,    0,    0,
    8,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   41,    0,    0,   52,   43,    0,   46,
   47,   48,   49,   50,   51,   88,   93,   40,   39,   58,
    0,    0,    0,    0,    0,   42,   45,    0,    0,    0,
   59,    0,    0,    0,    0,    0,    0,    0,   60,   56,
    0,    0,    0,    0,   54,   55,    0,   57,
};
final static short yydgoto[] = {                          9,
   10,   11,   12,   13,   14,   15,  132,   16,   37,   38,
  156,   39,  157,   59,   26,   34,   94,  129,   35,   64,
  142,  158,  159,  160,  161,  162,  163,  164,  165,  193,
  105,   55,   56,   57,  106,
};
final static short yysindex[] = {                       180,
    0, -265,    0,    0, -255,    0, -253,    0,    0,  180,
    0,    0,    0,    0,    0, -243, -267, -190, -207, -201,
    0,    0, -279, -197, -187, -166,    0,    9,    9, -155,
    0,    0, -171, -185, -248,    0, -178, -198, -167, -153,
 -134, -131,    0, -122,    0, -270, -155,    0,    0,    0,
    0, -155, -155,  437, -275,    0,    0,    0, -127,    0,
 -117,    0, -158,    0,    9, -144, -120, -120, -113, -121,
 -112, -155, -110,   50,  437,   59, -155, -155, -155, -155,
 -155, -155, -155, -155, -155, -155, -155, -155, -155, -155,
 -105, -155, -100,   -8,  -99,  -98,    0,    0,    0,    0,
  -96, -104,    0,  437,  -97,  -93,  -83,    0,   35,   35,
   35,   59,   59,   10,   10,   10,   10, -179, -179, -107,
    0,  213,    0,    0,    0,    0,    0,    0,    0,    9,
    9,    9,    0,    9, -155,    0, -155,    0,  -92,  -81,
    0, -195, -151,  437,  -79,  -82,  -80,  -78,  -70,  -68,
  -63, -155,  -60,    0,    4,  437,    0,    0,  -65,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
 -155, -155, -155,  -64, -155,    0,    0,  -62,   76, -269,
    0,  102, -155,  -36,  -59,  -36,  322,  -51,    0,    0,
 -155,  -36,  -36,  -53,    0,    0,  -36,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  232,
    0,    0,    0,    0,    0,    0,    0, -258,    0,    0,
    0,    0,  -50,    0,    0,  -46,    0,  -42,  -42,    0,
    0,    0,    0,    0,    0,    0,  -40,    0,    0,    0,
    0,    0,    0,    0,    0,   -3,    0,    0,    0,    0,
    0,    0,    0, -223,   24,    0,    0,    0,  -41,    0,
    0,    0,    0,    0,    0, -199,    0,    0,    0,    0,
    0,  -34,    0,    0, -252,  348,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0, -245,  -31,    0,    0,    0,  402,  418,
  434,  366,  384,  239,  261,  283,  305,  167,  191,  128,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  -42,
  -42, -114,    0,    0,    0,    0,  -34,    0,    0,    0,
    0, -135,    0, -219,    0,    0,    0,    0,    0,    0,
    0,  -35,    0,    0,    0, -216,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  -35,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  -35,    0,  -35,    0,  -75,    0,    0,
  -21,  -35,  -35,    0,    0,    0,  -35,    0,
};
final static short yygindex[] = {                         0,
    0,  238,  -91,  168,    0,    0,  126,  -22,    0,    1,
  -30,  -27,   80,    0,    0,    0,    0,    0,    0,    0,
    0,  -73, -147,    0,    0,    0,    0,    0,    0,    0,
   99,    0,    0,    0,  137,
};
final static int YYTABLESIZE=746;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         54,
   17,   40,  127,   29,  174,   36,   36,   27,    1,   90,
   17,    3,   72,   23,  185,   18,   74,   24,    4,   91,
  135,   75,   76,  178,   73,   19,    6,   20,   27,   61,
   30,   85,    8,   85,   92,   63,   85,   85,   63,   62,
  141,  104,   97,  194,   63,   22,  109,  110,  111,  112,
  113,  114,  115,  116,  117,  118,  119,  120,  121,  122,
   14,  124,  148,  141,   64,   14,   14,   62,  149,  150,
   64,   25,   62,   41,   42,   43,  151,   44,  152,   27,
   45,   28,   66,  153,   13,   46,   24,   47,   31,   13,
   13,   98,  154,   32,   17,   48,   49,   50,   51,   33,
   52,   60,  139,  140,  144,   53,  104,   36,   36,   58,
  188,   65,  190,   41,   42,   43,   67,   44,  195,  196,
   45,    9,   96,  198,    9,   46,   24,   47,   88,   89,
   68,    9,  166,   24,  143,   48,   49,   50,   51,    9,
   52,  179,  104,   44,  182,   53,   99,  100,   69,   44,
   44,   70,  187,   61,   44,   44,   44,   44,   44,   44,
   71,   44,   93,   95,   44,   30,   98,  101,   44,  102,
  107,  103,   44,   44,   44,  123,   44,   44,   44,   44,
  125,   44,   53,  130,  131,  134,   44,  133,   53,   53,
  136,  146,  135,   53,   53,   53,   53,   53,   53,  137,
   53,   89,  147,   53,  167,   53,  168,   53,  169,  192,
  170,   53,  171,   53,  172,   53,   53,   53,   53,  173,
   53,  148,  175,  177,  181,   53,  183,  149,  150,  189,
  197,    1,   41,   42,   43,  151,   44,  152,   13,   45,
   29,   24,  153,   23,   46,   30,   47,   21,    1,   95,
   98,    3,   94,   61,   48,   49,   50,   51,    4,   52,
    1,  128,   61,    3,   53,    1,    6,  155,    3,    7,
    4,  180,    8,  145,    0,    4,    0,    0,    6,  126,
   89,   89,   89,    6,    8,   89,   89,    0,    0,    8,
    0,  176,    0,   89,   89,   89,   89,   89,   89,   89,
   89,   89,   89,   89,   89,   89,   89,   67,    0,   67,
    0,    0,   67,   67,    0,   86,   87,   88,   89,    0,
   67,   67,   67,   67,   67,   67,   67,   67,   67,   67,
   67,   67,   67,  108,   80,   81,   82,   83,   84,   85,
   86,   87,   88,   89,    0,    0,   77,   78,   79,   80,
   81,   82,   83,   84,   85,   86,   87,   88,   89,  184,
   82,   83,   84,   85,   86,   87,   88,   89,    0,    0,
    0,    0,   77,   78,   79,   80,   81,   82,   83,   84,
   85,   86,   87,   88,   89,  186,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   77,   78,
   79,   80,   81,   82,   83,   84,   85,   86,   87,   88,
   89,   83,    0,   83,    0,    0,   83,   83,    0,    0,
    0,    0,    0,    0,   83,   83,   83,   83,   83,   83,
   83,   83,   83,   83,   83,   83,    1,    0,    2,    3,
    0,    0,    0,    0,    0,    0,    4,    5,    0,    0,
   81,    0,   81,    0,    6,   81,   81,    7,    0,    0,
    8,    0,    0,   81,   81,   81,   81,   81,   81,   81,
   81,   81,   81,   81,   82,    0,   82,    0,    0,   82,
   82,    0,    0,    0,    0,    0,    0,   82,   82,   82,
   82,   82,   82,   82,   82,   82,   82,   82,  138,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   77,
   78,   79,   80,   81,   82,   83,   84,   85,   86,   87,
   88,   89,   77,    0,   77,    0,    0,   77,   77,    0,
    0,    0,    0,    0,    0,   77,   77,   77,   77,   77,
   77,   77,   77,   77,   78,    0,   78,    0,    0,   78,
   78,    0,    0,    0,    0,    0,    0,   78,   78,   78,
   78,   78,   78,   78,   78,   78,   79,    0,   79,    0,
    0,   79,   79,    0,    0,    0,    0,    0,    0,   79,
   79,   79,   79,   79,   79,   79,   79,   79,   80,    0,
   80,    0,    0,   80,   80,    0,    0,    0,    0,    0,
    0,   80,   80,   80,   80,   80,   80,   80,   80,   80,
  191,    0,    0,    0,    0,    0,    0,    0,   77,   78,
   79,   80,   81,   82,   83,   84,   85,   86,   87,   88,
   89,   76,    0,   76,    0,    0,   76,   76,    0,    0,
    0,    0,    0,    0,   76,   76,   76,   76,   76,   71,
    0,   71,    0,    0,   71,   71,    0,    0,    0,    0,
    0,    0,   71,   71,   71,   71,   71,   72,    0,   72,
    0,    0,   72,   72,    0,    0,    0,    0,    0,    0,
   72,   72,   72,   72,   72,   73,    0,   73,    0,    0,
   73,   73,    0,    0,    0,    0,    0,    0,   73,   73,
   73,   74,    0,   74,    0,    0,   74,   74,    0,    0,
    0,    0,    0,    0,   74,   74,   74,   75,    0,   75,
    0,    0,   75,   75,    0,    0,    0,    0,    0,    0,
   75,   75,   75,   77,   78,   79,   80,   81,   82,   83,
   84,   85,   86,   87,   88,   89,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         30,
    0,   29,   94,  283,  152,   28,   29,  266,  257,  285,
   10,  260,  283,  281,  284,  281,   47,  285,  267,  295,
  290,   52,   53,  171,  295,  281,  275,  281,  287,  278,
  310,  284,  281,  286,  310,   35,  289,  290,  284,  288,
  132,   72,   65,  191,  290,  289,   77,   78,   79,   80,
   81,   82,   83,   84,   85,   86,   87,   88,   89,   90,
  284,   92,  258,  155,  284,  289,  290,  284,  264,  265,
  290,  262,  289,  269,  270,  271,  272,  273,  274,  287,
  276,  283,  281,  279,  284,  281,  285,  283,  286,  289,
  290,  287,  288,  281,   94,  291,  292,  293,  294,  266,
  296,  287,  130,  131,  135,  301,  137,  130,  131,  281,
  184,  290,  186,  269,  270,  271,  284,  273,  192,  193,
  276,  257,  281,  197,  260,  281,  285,  283,  308,  309,
  284,  267,  284,  285,  134,  291,  292,  293,  294,  275,
  296,  172,  173,  258,  175,  301,   67,   68,  283,  264,
  265,  283,  183,  289,  269,  270,  271,  272,  273,  274,
  283,  276,  290,  281,  279,  310,  287,  281,  283,  291,
  281,  284,  287,  288,  289,  281,  291,  292,  293,  294,
  281,  296,  258,  283,  283,  290,  301,  284,  264,  265,
  284,  284,  290,  269,  270,  271,  272,  273,  274,  283,
  276,  309,  284,  279,  284,  281,  289,  283,  289,  261,
  289,  287,  283,  289,  283,  291,  292,  293,  294,  283,
  296,  258,  283,  289,  289,  301,  289,  264,  265,  289,
  284,    0,  269,  270,  271,  272,  273,  274,  289,  276,
  287,  284,  279,  284,  281,  287,  283,   10,  257,  284,
  287,  260,  284,  289,  291,  292,  293,  294,  267,  296,
  257,   94,  284,  260,  301,  257,  275,  142,  260,  278,
  267,  173,  281,  137,   -1,  267,   -1,   -1,  275,  288,
  284,  285,  286,  275,  281,  289,  290,   -1,   -1,  281,
   -1,  288,   -1,  297,  298,  299,  300,  301,  302,  303,
  304,  305,  306,  307,  308,  309,  310,  284,   -1,  286,
   -1,   -1,  289,  290,   -1,  306,  307,  308,  309,   -1,
  297,  298,  299,  300,  301,  302,  303,  304,  305,  306,
  307,  308,  309,  284,  300,  301,  302,  303,  304,  305,
  306,  307,  308,  309,   -1,   -1,  297,  298,  299,  300,
  301,  302,  303,  304,  305,  306,  307,  308,  309,  284,
  302,  303,  304,  305,  306,  307,  308,  309,   -1,   -1,
   -1,   -1,  297,  298,  299,  300,  301,  302,  303,  304,
  305,  306,  307,  308,  309,  284,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  297,  298,
  299,  300,  301,  302,  303,  304,  305,  306,  307,  308,
  309,  284,   -1,  286,   -1,   -1,  289,  290,   -1,   -1,
   -1,   -1,   -1,   -1,  297,  298,  299,  300,  301,  302,
  303,  304,  305,  306,  307,  308,  257,   -1,  259,  260,
   -1,   -1,   -1,   -1,   -1,   -1,  267,  268,   -1,   -1,
  284,   -1,  286,   -1,  275,  289,  290,  278,   -1,   -1,
  281,   -1,   -1,  297,  298,  299,  300,  301,  302,  303,
  304,  305,  306,  307,  284,   -1,  286,   -1,   -1,  289,
  290,   -1,   -1,   -1,   -1,   -1,   -1,  297,  298,  299,
  300,  301,  302,  303,  304,  305,  306,  307,  286,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  297,
  298,  299,  300,  301,  302,  303,  304,  305,  306,  307,
  308,  309,  284,   -1,  286,   -1,   -1,  289,  290,   -1,
   -1,   -1,   -1,   -1,   -1,  297,  298,  299,  300,  301,
  302,  303,  304,  305,  284,   -1,  286,   -1,   -1,  289,
  290,   -1,   -1,   -1,   -1,   -1,   -1,  297,  298,  299,
  300,  301,  302,  303,  304,  305,  284,   -1,  286,   -1,
   -1,  289,  290,   -1,   -1,   -1,   -1,   -1,   -1,  297,
  298,  299,  300,  301,  302,  303,  304,  305,  284,   -1,
  286,   -1,   -1,  289,  290,   -1,   -1,   -1,   -1,   -1,
   -1,  297,  298,  299,  300,  301,  302,  303,  304,  305,
  289,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  297,  298,
  299,  300,  301,  302,  303,  304,  305,  306,  307,  308,
  309,  284,   -1,  286,   -1,   -1,  289,  290,   -1,   -1,
   -1,   -1,   -1,   -1,  297,  298,  299,  300,  301,  284,
   -1,  286,   -1,   -1,  289,  290,   -1,   -1,   -1,   -1,
   -1,   -1,  297,  298,  299,  300,  301,  284,   -1,  286,
   -1,   -1,  289,  290,   -1,   -1,   -1,   -1,   -1,   -1,
  297,  298,  299,  300,  301,  284,   -1,  286,   -1,   -1,
  289,  290,   -1,   -1,   -1,   -1,   -1,   -1,  297,  298,
  299,  284,   -1,  286,   -1,   -1,  289,  290,   -1,   -1,
   -1,   -1,   -1,   -1,  297,  298,  299,  284,   -1,  286,
   -1,   -1,  289,  290,   -1,   -1,   -1,   -1,   -1,   -1,
  297,  298,  299,  297,  298,  299,  300,  301,  302,  303,
  304,  305,  306,  307,  308,  309,
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
"Decl_PLUS : Decl",
"Decl_PLUS : Decl_PLUS Decl",
"Decl : VariableDecl",
"Decl : FunctionDecl",
"Decl : ClassDecl",
"Decl : InterfaceDecl",
"VariableDecl_MULT : VariableDecl_MULT VariableDecl",
"VariableDecl_MULT :",
"VariableDecl : Variable SEMICOLON",
"Variable_PLUS : Variable",
"Variable_PLUS : Variable_PLUS COMMA Variable",
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
"StmtBlock : LEFTBRACE VariableDecl_MULT Stmt_MULT VariableDecl_MULT RIGHTBRACE",
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
"IfStmt : IF LEFTPAREN Expr RIGHTPAREN Stmt Else_ZOO Stmt",
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

//#line 236 "Parser.y"

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
//#line 578 "Parser.java"
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
//#line 33 "Parser.y"
{System.out.println(" ");}
break;
case 5:
//#line 34 "Parser.y"
{System.out.println("");}
break;
case 6:
//#line 35 "Parser.y"
{System.out.println("");}
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
//#line 41 "Parser.y"
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
{System.out.println("");}
break;
case 14:
//#line 55 "Parser.y"
{System.out.println("");}
break;
case 15:
//#line 59 "Parser.y"
{System.out.println(yyval);}
break;
case 16:
//#line 60 "Parser.y"
{System.out.println("");}
break;
case 17:
//#line 61 "Parser.y"
{System.out.println("");}
break;
case 18:
//#line 62 "Parser.y"
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
case 25:
//#line 78 "Parser.y"
{System.out.println("");}
break;
case 26:
//#line 80 "Parser.y"
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
{System.out.println("");}
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
{System.out.println("");}
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
//#line 125 "Parser.y"
{System.out.println("");}
break;
case 43:
//#line 129 "Parser.y"
{System.out.println("");}
break;
case 44:
//#line 130 "Parser.y"
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
//#line 141 "Parser.y"
{System.out.println("");}
break;
case 53:
//#line 145 "Parser.y"
{System.out.println("");}
break;
case 54:
//#line 147 "Parser.y"
{System.out.println("");}
break;
case 55:
//#line 151 "Parser.y"
{System.out.println("");}
break;
case 56:
//#line 155 "Parser.y"
{System.out.println("");}
break;
case 57:
//#line 159 "Parser.y"
{System.out.println("");}
break;
case 58:
//#line 163 "Parser.y"
{System.out.println("");}
break;
case 59:
//#line 167 "Parser.y"
{System.out.println("");}
break;
case 60:
//#line 171 "Parser.y"
{System.out.println("");}
break;
case 61:
//#line 175 "Parser.y"
{System.out.println("");}
break;
case 62:
//#line 176 "Parser.y"
{System.out.println("");}
break;
case 63:
//#line 180 "Parser.y"
{System.out.println("");}
break;
case 64:
//#line 181 "Parser.y"
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
//#line 208 "Parser.y"
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
//#line 214 "Parser.y"
{System.out.println("");}
break;
case 92:
//#line 218 "Parser.y"
{System.out.println("");}
break;
case 93:
//#line 219 "Parser.y"
{System.out.println("");}
break;
case 94:
//#line 223 "Parser.y"
{System.out.println("");}
break;
case 95:
//#line 224 "Parser.y"
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
case 100:
//#line 232 "Parser.y"
{System.out.println("");}
break;
//#line 1127 "Parser.java"
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
