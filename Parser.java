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
public final static short ID_PLUS=282;
public final static short NL=283;
public final static short STRCON=284;
public final static short LEFTPAREN=285;
public final static short RIGHTPAREN=286;
public final static short LEFTBRACKET=287;
public final static short RIGHTBRACKET=288;
public final static short LEFTBRACE=289;
public final static short RIGHTBRACE=290;
public final static short SEMICOLON=291;
public final static short COMMA=292;
public final static short INTCONSTANT=293;
public final static short DOUBLECONSTANT=294;
public final static short STRINGCONSTANT=295;
public final static short BOOLEANCONSTANT=296;
public final static short PERIOD=297;
public final static short NOT=298;
public final static short NEG=299;
public final static short MULTIPLICATION=300;
public final static short DIVISION=301;
public final static short MOD=302;
public final static short PLUS=303;
public final static short MINUS=304;
public final static short LESS=305;
public final static short LESSEQUAL=306;
public final static short GREATER=307;
public final static short GREATEREQUAL=308;
public final static short EQUAL=309;
public final static short NOTEQUAL=310;
public final static short AND=311;
public final static short OR=312;
public final static short ASSIGNOP=313;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    1,    1,    1,    1,    2,    6,    6,    7,    7,
    7,    7,    7,    3,    3,    8,    8,   10,   10,    4,
   12,   12,   11,   11,    5,   13,   13,    9,    9,   14,
   14,   14,   14,   14,   14,   14,   15,   16,   17,   18,
   19,   20,   21,   21,   21,   21,   21,   21,   21,   21,
   21,   21,   21,   21,   21,   21,   21,   21,   21,   21,
   21,   21,   21,   21,   21,   21,   22,   22,   23,   23,
   23,   25,   25,   26,   26,   24,   24,   24,   24,   24,
};
final static short yylen[] = {                            2,
    1,    1,    1,    1,    1,    1,    1,    1,    1,    1,
    1,    3,    1,    6,    6,    1,    0,    1,    3,   10,
    1,    1,    1,    3,    2,    5,    5,    1,    1,    1,
    1,    1,    1,    1,    1,    1,    7,    5,    9,    1,
    2,    5,    3,    1,    1,    1,    1,    3,    3,    3,
    3,    3,    3,    2,    3,    3,    3,    3,    3,    3,
    3,    3,    2,    3,    4,    6,    1,    3,    1,    4,
    3,    4,    6,    2,    0,    1,    1,    1,    1,    1,
};
final static short yydefred[] = {                         0,
    0,   10,    9,    0,   11,    0,    0,    0,    1,    2,
    3,    4,    5,    6,    0,    0,   25,    0,    0,    0,
    0,    0,    0,   12,    0,   18,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   40,    0,    0,    0,    0,
    0,   28,   15,   29,   30,   31,   32,   33,   34,   35,
   19,   14,    0,    0,    0,    0,    0,    0,   80,    0,
   46,    0,    0,   76,   77,   78,   79,    0,    0,    0,
    0,   44,   47,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   21,   22,    0,   23,    0,    0,
    0,    0,    0,   64,    0,    0,    0,   48,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   71,    0,    0,   20,    0,    0,   36,    0,
   42,    0,   65,    0,    0,   72,    0,   70,   29,   24,
    0,    0,   13,    0,    0,    0,   29,   66,   73,    0,
   29,
};
final static short yydgoto[] = {                          8,
    9,   42,  106,   12,   13,   14,   27,   28,  139,   29,
  107,  108,    0,   44,   45,   46,   47,   48,   49,   50,
   78,  115,   71,   72,   73,  116,
};
final static short yysindex[] = {                      -250,
 -278,    0,    0, -270,    0, -266,    0,    0,    0,    0,
    0,    0,    0,    0, -267, -239,    0, -243, -231, -232,
 -222, -234, -234,    0, -200,    0, -223, -214, -204, -199,
 -193, -189, -234, -189, -201,    0, -191, -190, -188,  370,
 -187,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0, -186,  370,  370,  370, -184, -183,    0, -181,
    0, -285,  370,    0,    0,    0,    0,  370,  370,  498,
  -57,    0,    0,  370, -254,  153,  160,  498, -196, -182,
 -185, -180,  370, -176,  167,  498,  498,  370,  370,  370,
  370,  370,  370,  370,  370,  370,  370,  370,  370,  370,
  370, -172,  370,  194,    0,    0, -256,    0,  370, -189,
  304, -175, -179,    0, -178, -174, -170,    0,  498,  498,
  498,  498,  498,  498,  498,  498,  498,  498,  498,  498,
  498,  201,    0,  498, -189,    0, -254,  208,    0, -151,
    0,  498,    0, -202,  370,    0,  370,    0,    0,    0,
  370, -189,    0, -205, -169,  491,    0,    0,    0, -189,
    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,   16,    0,    0,    0,
    0,    0,    0,    0,   39,    0,    0,    0,    0,    0,
    0, -168, -168,    0,    0,    0,  174,    0, -167,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    1,    0,    0,    0,    0,    0,    0,    0,   22,
    8,    0,    0,    0,    0,    0,    0, -171,    0,    0,
    0,    0, -166,    0,    0,   19,   52,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   60,   67,
   74,   84,   93,  100,  107,  116,  126,  133,  140,  148,
  159,    0,    0,  166,    0,    0,    0,    0,    0,    0,
    0, -165,    0,    0, -164,    0, -166,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,
};
final static short yygindex[] = {                         0,
    0,    5,  123,    0,    0,    7,    2,  101,    3,    0,
    0,  -12,    0, -103,    0,    0,    0,    0,    0,    0,
  579,   72,    0,    0,    0,  -18,
};
final static int YYTABLESIZE=817;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         83,
   69,   15,   16,  103,   10,    2,  140,   45,    1,    2,
   17,   84,    3,   19,   18,    8,    3,    4,   54,   20,
    5,   41,   21,    6,    5,    2,    7,    6,   26,   26,
    7,  149,    3,  136,   43,  137,   52,   69,    7,   51,
    5,   22,   69,   69,   45,   69,    7,   69,  157,   45,
   45,   63,   45,   23,   45,   24,  161,    2,   25,   49,
   69,   69,   69,   20,    3,   31,   50,   45,   36,   45,
    2,   32,    5,   51,   37,   38,   15,    3,  153,  105,
  158,   20,   39,   52,   40,    5,   34,   33,   35,   41,
   53,    7,   53,   54,   55,  111,   56,   74,  112,   55,
   80,   81,   75,   82,  117,  114,   56,  113,  133,  152,
  143,  146,  144,  145,  147,   57,  159,   17,   16,   75,
   67,   74,   11,   30,  150,   58,   68,   79,  155,    0,
    0,    0,   59,    0,    0,    0,    0,    0,   15,   60,
    0,  105,    0,    0,    0,  154,    0,   61,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   62,    0,
    0,    0,    0,    0,    0,   43,    0,    0,    0,    0,
    0,    0,    0,    7,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   92,
    0,    0,    0,    0,   90,   88,   92,   89,    0,   91,
    0,   90,   88,   92,   89,    0,   91,    0,   90,   88,
    0,   89,   93,   91,   95,    0,    0,    0,    0,   93,
    0,   95,    0,    0,    0,    0,   93,    0,   95,  101,
   92,    0,    0,    0,    0,   90,   88,   92,   89,  102,
   91,    0,   90,   88,   92,   89,    0,   91,    0,   90,
   88,    0,   89,   93,   91,   95,    0,    0,    0,    0,
   93,   69,   95,    0,    0,    0,    0,   93,   45,   95,
    0,    0,    0,    0,    0,    0,    8,    0,    0,   54,
    0,    0,   41,    0,    0,    0,   69,   69,   69,    0,
   69,   69,   69,   45,    0,   45,   13,   45,   45,   45,
    0,    8,   13,    0,   54,    8,   54,    8,   54,   54,
   54,   41,   63,   41,   69,   69,   69,   69,   69,   69,
   49,   45,   45,   45,   45,   45,   45,   50,    7,    0,
    7,    0,    0,    0,   51,    0,   69,   63,    0,   63,
    0,   63,   63,   63,   52,   49,    0,   49,   68,   49,
   49,   49,   50,   53,   50,    0,   50,   50,   50,   51,
   55,   51,    0,   51,   51,   51,    0,   56,    0,   52,
    0,   52,    0,   52,   52,   52,   57,    0,   53,    0,
   53,    0,   53,   53,   53,   55,   58,   55,    0,   55,
   55,   55,   56,   59,   56,    0,   56,   56,   56,    0,
   60,   57,   69,   57,    0,   57,   57,   57,   61,    0,
    0,   58,    0,   58,   68,   58,   58,   58,   59,   62,
   59,    0,   59,   59,   59,   60,   43,   60,    0,   60,
   60,   60,    0,   61,    7,   61,    0,   61,   61,   61,
    0,    0,    0,  109,   62,  110,   62,    0,   62,   62,
   62,   43,  118,   43,    0,   43,   43,   43,    0,    7,
    0,    0,    0,    7,    0,    7,   94,   96,   97,   98,
   99,  100,    0,   94,   96,   97,   98,   99,  100,  135,
   94,   96,   97,   98,   99,  100,    0,    0,  148,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  151,    0,
    0,    0,    0,    0,    0,    0,    0,   94,   96,   97,
   98,   99,  100,    0,   94,   96,   97,   98,   99,  100,
    0,   94,   96,   97,   98,   99,  100,   92,    0,    0,
    0,    0,   90,   88,   92,   89,    0,   91,    0,   90,
   88,    0,   89,    0,   91,    0,    0,    0,    0,    0,
   93,    0,   95,    0,    0,    0,    0,   93,    0,   95,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   57,   58,   59,    0,   60,    0,    0,   61,
    0,    0,    0,    0,   62,    0,    0,    0,   63,  141,
    0,    0,    0,    0,    0,    0,   64,   65,   66,   67,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   70,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   76,   77,    0,    0,    0,    0,   57,   58,
   59,   85,   60,    0,    0,   61,   86,   87,    0,    0,
   62,    0,  104,    0,   63,    0,    0,    0,    0,    0,
    0,    0,   64,   65,   66,   67,  119,  120,  121,  122,
  123,  124,  125,  126,  127,  128,  129,  130,  131,  132,
    0,  134,    0,    0,    0,    0,    0,  138,    0,  142,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  142,    0,    0,    0,    0,    0,  156,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  160,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   94,   96,   97,   98,   99,  100,
    0,   94,   96,   97,   98,   99,  100,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                        285,
    0,    0,  281,   61,    0,  260,  110,    0,  259,  260,
  281,  297,  267,  281,  281,    0,  267,  268,    0,  287,
  275,    0,  262,  278,  275,  260,  281,  278,   22,   23,
  281,  135,  267,  290,   32,  292,   34,   37,    0,   33,
  275,  285,   42,   43,   37,   45,  281,   47,  152,   42,
   43,    0,   45,  285,   47,  288,  160,  260,  281,    0,
   60,   61,   62,  287,  267,  266,    0,   60,  258,   62,
  260,  286,  275,    0,  264,  265,   75,  267,  281,   75,
  286,  287,  272,    0,  274,  275,  286,  292,  282,  279,
  292,  281,    0,  285,  285,  292,  285,  285,  281,    0,
  285,  285,  289,  285,  281,  286,    0,  293,  281,  261,
  286,  286,  292,  292,  285,    0,  286,  286,  286,  286,
  292,  286,    0,   23,  137,    0,  292,   56,  147,   -1,
   -1,   -1,    0,   -1,   -1,   -1,   -1,   -1,  137,    0,
   -1,  137,   -1,   -1,   -1,  144,   -1,    0,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,    0,   -1,
   -1,   -1,   -1,   -1,   -1,    0,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,    0,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   37,
   -1,   -1,   -1,   -1,   42,   43,   37,   45,   -1,   47,
   -1,   42,   43,   37,   45,   -1,   47,   -1,   42,   43,
   -1,   45,   60,   47,   62,   -1,   -1,   -1,   -1,   60,
   -1,   62,   -1,   -1,   -1,   -1,   60,   -1,   62,  287,
   37,   -1,   -1,   -1,   -1,   42,   43,   37,   45,  297,
   47,   -1,   42,   43,   37,   45,   -1,   47,   -1,   42,
   43,   -1,   45,   60,   47,   62,   -1,   -1,   -1,   -1,
   60,  261,   62,   -1,   -1,   -1,   -1,   60,  261,   62,
   -1,   -1,   -1,   -1,   -1,   -1,  261,   -1,   -1,  261,
   -1,   -1,  261,   -1,   -1,   -1,  286,  287,  288,   -1,
  290,  291,  292,  286,   -1,  288,  281,  290,  291,  292,
   -1,  286,  287,   -1,  286,  290,  288,  292,  290,  291,
  292,  290,  261,  292,  314,  315,  316,  317,  318,  319,
  261,  314,  315,  316,  317,  318,  319,  261,  290,   -1,
  292,   -1,   -1,   -1,  261,   -1,   33,  286,   -1,  288,
   -1,  290,  291,  292,  261,  286,   -1,  288,   45,  290,
  291,  292,  286,  261,  288,   -1,  290,  291,  292,  286,
  261,  288,   -1,  290,  291,  292,   -1,  261,   -1,  286,
   -1,  288,   -1,  290,  291,  292,  261,   -1,  286,   -1,
  288,   -1,  290,  291,  292,  286,  261,  288,   -1,  290,
  291,  292,  286,  261,  288,   -1,  290,  291,  292,   -1,
  261,  286,   33,  288,   -1,  290,  291,  292,  261,   -1,
   -1,  286,   -1,  288,   45,  290,  291,  292,  286,  261,
  288,   -1,  290,  291,  292,  286,  261,  288,   -1,  290,
  291,  292,   -1,  286,  261,  288,   -1,  290,  291,  292,
   -1,   -1,   -1,  291,  286,  286,  288,   -1,  290,  291,
  292,  286,  286,  288,   -1,  290,  291,  292,   -1,  286,
   -1,   -1,   -1,  290,   -1,  292,  314,  315,  316,  317,
  318,  319,   -1,  314,  315,  316,  317,  318,  319,  286,
  314,  315,  316,  317,  318,  319,   -1,   -1,  288,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  291,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  314,  315,  316,
  317,  318,  319,   -1,  314,  315,  316,  317,  318,  319,
   -1,  314,  315,  316,  317,  318,  319,   37,   -1,   -1,
   -1,   -1,   42,   43,   37,   45,   -1,   47,   -1,   42,
   43,   -1,   45,   -1,   47,   -1,   -1,   -1,   -1,   -1,
   60,   -1,   62,   -1,   -1,   -1,   -1,   60,   -1,   62,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  269,  270,  271,   -1,  273,   -1,   -1,  276,
   -1,   -1,   -1,   -1,  281,   -1,   -1,   -1,  285,  286,
   -1,   -1,   -1,   -1,   -1,   -1,  293,  294,  295,  296,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   40,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   54,   55,   -1,   -1,   -1,   -1,  269,  270,
  271,   63,  273,   -1,   -1,  276,   68,   69,   -1,   -1,
  281,   -1,   74,   -1,  285,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  293,  294,  295,  296,   88,   89,   90,   91,
   92,   93,   94,   95,   96,   97,   98,   99,  100,  101,
   -1,  103,   -1,   -1,   -1,   -1,   -1,  109,   -1,  111,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  145,   -1,   -1,   -1,   -1,   -1,  151,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  286,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  314,  315,  316,  317,  318,  319,
   -1,  314,  315,  316,  317,  318,  319,
};
}
final static short YYFINAL=8;
final static short YYMAXTOKEN=319;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,"'!'",null,null,null,"'%'",null,null,null,null,"'*'","'+'",null,
"'-'",null,"'/'",null,null,null,null,null,null,null,null,null,null,null,null,
"'<'","'='","'>'",null,null,null,null,null,null,null,null,null,null,null,null,
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
null,null,null,null,null,null,"BOOLEAN","BREAK","CLASS","DOUBLE","ELSE",
"EXTENDS","FALSE","FOR","IF","IMPLEMENTS","INT","INTERFACE","NEW","NEWARRAY",
"NULL","PRINTLN","READLN","RETURN","STRING","THIS","TRUE","VOID","WHILE",
"INTEGER","ID","ID_PLUS","NL","STRCON","LEFTPAREN","RIGHTPAREN","LEFTBRACKET",
"RIGHTBRACKET","LEFTBRACE","RIGHTBRACE","SEMICOLON","COMMA","INTCONSTANT",
"DOUBLECONSTANT","STRINGCONSTANT","BOOLEANCONSTANT","PERIOD","NOT","NEG",
"MULTIPLICATION","DIVISION","MOD","PLUS","MINUS","LESS","LESSEQUAL","GREATER",
"GREATEREQUAL","EQUAL","NOTEQUAL","AND","OR","ASSIGNOP","\"<=\"","\">=\"",
"\"==\"","\"!=\"","\"&&\"","\"||\"",
};
final static String yyrule[] = {
"$accept : Program",
"Program : Decl",
"Decl : VariableDecl",
"Decl : FunctionDecl",
"Decl : ClassDecl",
"Decl : InterfaceDecl",
"VariableDecl : Variable",
"Variable : Type",
"Variable : ID",
"Type : INT",
"Type : DOUBLE",
"Type : STRING",
"Type : Type LEFTBRACKET RIGHTBRACKET",
"Type : ID",
"FunctionDecl : Type ID LEFTPAREN Formals RIGHTPAREN StmtBlock",
"FunctionDecl : VOID ID LEFTPAREN Formals RIGHTPAREN StmtBlock",
"Formals : Variable_PLUS",
"Formals :",
"Variable_PLUS : Variable",
"Variable_PLUS : Variable_PLUS COMMA Variable",
"ClassDecl : CLASS ID EXTENDS ID IMPLEMENTS ID_PLUS COMMA LEFTBRACE Field_PLUS RIGHTBRACE",
"Field : VariableDecl",
"Field : FunctionDecl",
"Field_PLUS : Field",
"Field_PLUS : Field_PLUS COMMA Field",
"InterfaceDecl : INTERFACE ID",
"Prototype : Type ID LEFTPAREN Formals RIGHTPAREN",
"Prototype : VOID ID LEFTPAREN Formals RIGHTPAREN",
"StmtBlock : VariableDecl",
"StmtBlock : Stmt",
"Stmt : IfStmt",
"Stmt : WhileStmt",
"Stmt : ForStmt",
"Stmt : BreakStmt",
"Stmt : ReturnStmt",
"Stmt : PrintStmt",
"Stmt : StmtBlock",
"IfStmt : IF LEFTPAREN Expr RIGHTPAREN Stmt ELSE Stmt",
"WhileStmt : WHILE LEFTPAREN Expr RIGHTPAREN Stmt",
"ForStmt : FOR LEFTPAREN Expr SEMICOLON Expr SEMICOLON Expr RIGHTPAREN Stmt",
"BreakStmt : BREAK",
"ReturnStmt : RETURN Expr",
"PrintStmt : PRINTLN LEFTPAREN Expr_PLUS COMMA RIGHTPAREN",
"Expr : Lvalue '=' Expr",
"Expr : Constant",
"Expr : Lvalue",
"Expr : THIS",
"Expr : Call",
"Expr : LEFTPAREN Expr RIGHTPAREN",
"Expr : Expr '+' Expr",
"Expr : Expr '-' Expr",
"Expr : Expr '*' Expr",
"Expr : Expr '/' Expr",
"Expr : Expr '%' Expr",
"Expr : '-' Expr",
"Expr : Expr '<' Expr",
"Expr : Expr \"<=\" Expr",
"Expr : Expr '>' Expr",
"Expr : Expr \">=\" Expr",
"Expr : Expr \"==\" Expr",
"Expr : Expr \"!=\" Expr",
"Expr : Expr \"&&\" Expr",
"Expr : Expr \"||\" Expr",
"Expr : '!' Expr",
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

//#line 182 "Parser.y"

private Yylex lexer;

private int yylex () {
	int yyl_return = -1;
	try {
		yylval = new ParserVal(0);
		yyl_return = lexer.yylex();
	}
	catch (IOException e) {
		System.err.println("IO error :"+e);
	}
return yyl_return;
}


public void yyerror (String error) {
	System.err.println ("Error: " + error);

}


public Parser(Reader r) {
	yydebug=true;
	lexer = new Yylex(r, this);
}

public static void main(String args[]) throws IOException {
	Parser yyparser;
	System.out.print("Enter File Name: ");
	Scanner scanner = new Scanner(System.in);
	FileReader fr = new FileReader(scanner.nextLine());
	yyparser = new Parser(fr);
yyparser.yyparse();
}
//#line 560 "Parser.java"
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
//#line 23 "Parser.y"
{System.out.println("[Reduce");}
break;
case 2:
//#line 27 "Parser.y"
{System.out.println("[Reduce ");}
break;
case 3:
//#line 28 "Parser.y"
{System.out.println("[Reduce");}
break;
case 4:
//#line 29 "Parser.y"
{System.out.println("[Reduce");}
break;
case 5:
//#line 30 "Parser.y"
{System.out.println("[Reduce");}
break;
case 6:
//#line 34 "Parser.y"
{System.out.println("[Reduce");}
break;
case 7:
//#line 38 "Parser.y"
{System.out.println("[Reduce");}
break;
case 8:
//#line 39 "Parser.y"
{System.out.println("[Reduce");}
break;
case 9:
//#line 43 "Parser.y"
{System.out.println("[Reduce");}
break;
case 10:
//#line 44 "Parser.y"
{System.out.println("[Reduce");}
break;
case 11:
//#line 45 "Parser.y"
{System.out.println("[Reduce");}
break;
case 12:
//#line 46 "Parser.y"
{System.out.println("[Reduce");}
break;
case 13:
//#line 47 "Parser.y"
{System.out.println("[Reduce");}
break;
case 14:
//#line 51 "Parser.y"
{System.out.println("[Reduce");}
break;
case 15:
//#line 52 "Parser.y"
{System.out.println("[Reduce");}
break;
case 16:
//#line 56 "Parser.y"
{System.out.println("[Reduce");}
break;
case 17:
//#line 57 "Parser.y"
{System.out.println("[Reduce");}
break;
case 18:
//#line 61 "Parser.y"
{System.out.println("[Reduce");}
break;
case 19:
//#line 62 "Parser.y"
{System.out.println("[Reduce");}
break;
case 20:
//#line 67 "Parser.y"
{System.out.println("[Reduce");}
break;
case 21:
//#line 70 "Parser.y"
{System.out.println("[Reduce");}
break;
case 22:
//#line 71 "Parser.y"
{System.out.println("[Reduce");}
break;
case 23:
//#line 75 "Parser.y"
{System.out.println("[Reduce");}
break;
case 24:
//#line 76 "Parser.y"
{System.out.println("[Reduce");}
break;
case 25:
//#line 80 "Parser.y"
{System.out.println("[Reduce");}
break;
case 26:
//#line 84 "Parser.y"
{System.out.println("[Reduce");}
break;
case 27:
//#line 85 "Parser.y"
{System.out.println("[Reduce");}
break;
case 28:
//#line 89 "Parser.y"
{System.out.println("[Reduce");}
break;
case 29:
//#line 90 "Parser.y"
{System.out.println("[Reduce");}
break;
case 30:
//#line 93 "Parser.y"
{yyval = val_peek(0);}
break;
case 31:
//#line 94 "Parser.y"
{yyval = val_peek(0);}
break;
case 32:
//#line 95 "Parser.y"
{yyval = val_peek(0);}
break;
case 33:
//#line 96 "Parser.y"
{yyval = val_peek(0);}
break;
case 34:
//#line 97 "Parser.y"
{yyval = val_peek(0);}
break;
case 35:
//#line 98 "Parser.y"
{yyval = val_peek(0);}
break;
case 36:
//#line 99 "Parser.y"
{yyval = val_peek(0);}
break;
case 37:
//#line 103 "Parser.y"
{System.out.println("[Reduce");}
break;
case 38:
//#line 107 "Parser.y"
{System.out.println("[Reduce");}
break;
case 39:
//#line 111 "Parser.y"
{System.out.println("[Reduce");}
break;
case 40:
//#line 115 "Parser.y"
{System.out.println("[Reduce");}
break;
case 41:
//#line 119 "Parser.y"
{System.out.println("[Reduce");}
break;
case 42:
//#line 123 "Parser.y"
{System.out.println("[Reduce");}
break;
case 43:
//#line 127 "Parser.y"
{System.out.println("[Reduce");}
break;
case 44:
//#line 128 "Parser.y"
{System.out.println("[Reduce");}
break;
case 45:
//#line 129 "Parser.y"
{System.out.println("[Reduce");}
break;
case 46:
//#line 130 "Parser.y"
{System.out.println("[Reduce");}
break;
case 47:
//#line 131 "Parser.y"
{System.out.println("[Reduce");}
break;
case 48:
//#line 132 "Parser.y"
{System.out.println("[Reduce");}
break;
case 49:
//#line 133 "Parser.y"
{System.out.println("[Reduce");}
break;
case 50:
//#line 134 "Parser.y"
{System.out.println("[Reduce");}
break;
case 51:
//#line 135 "Parser.y"
{System.out.println("[Reduce");}
break;
case 52:
//#line 136 "Parser.y"
{System.out.println("[Reduce");}
break;
case 53:
//#line 137 "Parser.y"
{System.out.println("[Reduce");}
break;
case 54:
//#line 138 "Parser.y"
{System.out.println("[Reduce");}
break;
case 55:
//#line 139 "Parser.y"
{System.out.println("[Reduce");}
break;
case 56:
//#line 140 "Parser.y"
{System.out.println("[Reduce");}
break;
case 57:
//#line 141 "Parser.y"
{System.out.println("[Reduce");}
break;
case 58:
//#line 142 "Parser.y"
{System.out.println("[Reduce");}
break;
case 59:
//#line 143 "Parser.y"
{System.out.println("[Reduce");}
break;
case 60:
//#line 144 "Parser.y"
{System.out.println("[Reduce");}
break;
case 61:
//#line 145 "Parser.y"
{System.out.println("[Reduce");}
break;
case 62:
//#line 146 "Parser.y"
{System.out.println("[Reduce");}
break;
case 63:
//#line 147 "Parser.y"
{System.out.println("[Reduce");}
break;
case 64:
//#line 148 "Parser.y"
{System.out.println("[Reduce");}
break;
case 65:
//#line 149 "Parser.y"
{System.out.println("[Reduce");}
break;
case 66:
//#line 150 "Parser.y"
{System.out.println("[Reduce");}
break;
case 67:
//#line 154 "Parser.y"
{System.out.println("[Reduce");}
break;
case 68:
//#line 155 "Parser.y"
{System.out.println("[Reduce");}
break;
case 69:
//#line 159 "Parser.y"
{System.out.println("[Reduce");}
break;
case 70:
//#line 160 "Parser.y"
{System.out.println("[Reduce");}
break;
case 71:
//#line 161 "Parser.y"
{System.out.println("[Reduce");}
break;
case 72:
//#line 165 "Parser.y"
{System.out.println("[Reduce");}
break;
case 73:
//#line 166 "Parser.y"
{System.out.println("[Reduce");}
break;
case 74:
//#line 170 "Parser.y"
{System.out.println("[Reduce");}
break;
case 75:
//#line 171 "Parser.y"
{System.out.println("[Reduce");}
break;
case 76:
//#line 174 "Parser.y"
{System.out.println("[Reduce");}
break;
case 77:
//#line 175 "Parser.y"
{System.out.println("[Reduce");}
break;
case 78:
//#line 176 "Parser.y"
{System.out.println("[Reduce");}
break;
case 79:
//#line 177 "Parser.y"
{System.out.println("[Reduce");}
break;
case 80:
//#line 178 "Parser.y"
{System.out.println("[Reduce");}
break;
//#line 1029 "Parser.java"
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
