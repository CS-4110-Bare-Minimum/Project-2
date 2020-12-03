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
public final static short STRCON=283;
public final static short LEFTPAREN=284;
public final static short RIGHTPAREN=285;
public final static short LEFTBRACKET=286;
public final static short RIGHTBRACKET=287;
public final static short LEFTBRACE=288;
public final static short RIGHTBRACE=289;
public final static short SEMICOLON=290;
public final static short COMMA=291;
public final static short INTCONSTANT=292;
public final static short DOUBLECONSTANT=293;
public final static short STRINGCONSTANT=294;
public final static short BOOLEANCONSTANT=295;
public final static short PERIOD=296;
public final static short NOT=297;
public final static short MULTIPLICATION=298;
public final static short DIVISION=299;
public final static short MOD=300;
public final static short PLUS=301;
public final static short MINUS=302;
public final static short LESS=303;
public final static short LESSEQUAL=304;
public final static short GREATER=305;
public final static short GREATEREQUAL=306;
public final static short EQUAL=307;
public final static short NOTEQUAL=308;
public final static short AND=309;
public final static short OR=310;
public final static short ASSIGNOP=311;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    2,    2,    2,    2,    1,    1,    3,    8,    8,
    7,    9,    9,    9,    9,    9,    9,    4,    4,   12,
   12,   10,   10,   13,   13,    5,   15,   15,   14,   14,
    6,   17,   17,   16,   16,   11,   18,   18,   19,   19,
   19,   19,   19,   19,   19,   20,   21,   22,   23,   24,
   25,   26,   26,   26,   26,   26,   26,   26,   26,   26,
   26,   26,   26,   26,   26,   26,   26,   26,   26,   26,
   26,   26,   26,   26,   26,   27,   27,   28,   28,   28,
   30,   30,   31,   31,   29,   29,   29,   29,   29,
};
final static short yylen[] = {                            2,
    1,    1,    1,    1,    1,    1,    3,    2,    2,    0,
    2,    1,    1,    1,    1,    3,    1,    6,    6,    1,
    3,    1,    0,    1,    3,    9,    1,    1,    2,    0,
    5,    6,    6,    2,    0,    4,    2,    0,    1,    1,
    1,    1,    1,    1,    1,    7,    5,    9,    2,    3,
    6,    3,    1,    1,    1,    1,    3,    3,    3,    3,
    3,    3,    2,    3,    3,    3,    3,    3,    3,    3,
    3,    2,    3,    4,    6,    1,    3,    1,    4,    3,
    4,    6,    2,    0,    1,    1,    1,    1,    1,
};
final static short yydefred[] = {                         0,
   14,    0,   13,   12,    0,   15,    0,   17,    0,    0,
    6,    2,    3,    4,    5,    0,    0,    0,    0,    0,
    0,    8,    0,    0,    0,   35,    0,    7,    0,   16,
    0,    0,   20,    0,    0,    0,    0,    0,    0,   31,
    0,   34,   11,    0,    0,    0,   24,    0,    0,    0,
   10,   19,   21,   18,   30,    0,    0,    0,    0,    0,
   25,    0,    0,    9,    0,   26,   27,   28,   29,    0,
    0,    0,    0,    0,    0,    0,    0,   36,   45,   37,
   39,   40,   41,   42,   43,   44,   33,   32,   49,    0,
    0,    0,    0,    0,   89,    0,   55,    0,    0,   85,
   86,   87,   88,    0,    0,    0,    0,   53,   56,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   50,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   73,    0,    0,    0,   57,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   71,    0,   80,   52,    0,    0,    0,    0,
    0,   74,    0,    0,   81,    0,   79,   47,    0,    0,
   51,    0,    0,    0,   46,   75,   82,    0,   48,
};
final static short yydgoto[] = {                          9,
   10,   11,   12,   13,   14,   15,   16,   59,   34,   35,
   79,   36,   48,   60,   69,   32,   42,   65,   80,   81,
   82,   83,   84,   85,   86,  113,  147,  107,  108,  109,
  148,
};
final static short yysindex[] = {                       108,
    0, -251,    0,    0, -201,    0, -193,    0,    0, -199,
    0,    0,    0,    0,    0, -249, -271, -162, -186, -183,
  108,    0, -181, -178, -177,    0,  112,    0,  112,    0,
 -153, -255,    0, -250, -171, -175, -164, -155, -154,    0,
 -237,    0,    0, -156,  112, -156,    0, -192, -152, -150,
    0,    0,    0,    0,    0, -146,  112,  112,  112, -254,
    0, -149, -145,    0, -127,    0,    0,    0,    0, -161,
 -140, -137, -136, -130, -125, -151, -124,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0, -151,
 -151, -151, -123, -122,    0, -120,    0, -280, -151,    0,
    0,    0,    0, -151, -151,  260, -279,    0,    0, -151,
  281,  -49,  401, -118, -112, -115, -107, -151,  -87,  -23,
  401,  -40,    0, -151, -151, -151, -151, -151, -151, -151,
 -151, -151, -151, -151, -151, -151, -151,  -86, -151,    3,
 -151,  -65, -187,  -89,  -94,    0,  -93,  -84,  -82,    0,
  -64,  -64,  -64,  -40,  -40, -253, -253, -253, -253, -301,
 -301, -106,    0,  151,    0,    0,  -65,  302,  -58,  -85,
  401,    0,  112, -151,    0, -151,    0,    0, -151,  -65,
    0, -267,  -79,   29,    0,    0,    0,  -65,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  139,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  -77,    0,    0,    0,  -74,    0,  -74,    0,
    0,    0,    0,    0,    0,  -68,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  -74,  -74, -109,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0, -119,    0,    0,
    0,    0,    0,    0,    0,    0,  -75,    0,    0,    0,
    0,    0,  -83,    0,    0,    0,    0,  -67,    0,    0,
 -200,  328,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
 -240,  382,  398,  346,  364,  177,  199,  221,  243,  105,
  129,   55,    0,    0,    0,    0,    0,    0,    0,    0,
  -71,    0,    0,  -63,    0,  -67,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
    0,  200,   -7,  187,    0,    0,   66,    0,    1,  -18,
   32,    0,    0,    0,    0,    0,    0,    0, -142,    0,
    0,    0,    0,    0,    0,  -62,  156,    0,    0,    0,
   95,
};
final static int YYTABLESIZE=711;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        169,
   17,    1,    1,  118,    3,    3,  137,  135,  136,   23,
   37,    4,    4,  106,   24,  119,  138,  186,   24,    6,
    6,   17,   39,    7,  178,    8,    8,  111,  112,   18,
   43,  139,   41,   40,   66,   24,  120,  185,   62,   63,
   22,  121,  122,   50,   60,  189,   60,  140,   24,   60,
   60,   64,   67,  133,  134,  135,  136,   60,   60,   60,
   17,  151,  152,  153,  154,  155,  156,  157,  158,  159,
  160,  161,  162,  163,  164,   52,  166,   54,  168,   19,
  171,   93,   94,   95,   72,   96,   72,   20,   97,   72,
   72,   21,   33,   98,   33,   55,   99,  170,   56,   25,
   27,   26,   29,   31,  100,  101,  102,  103,   30,  104,
   53,  171,   38,   44,  105,   45,  184,   93,   94,   95,
   46,   96,   33,   33,   97,   47,   49,   51,   87,   98,
   72,   57,   99,   58,   61,   70,   73,   74,    1,   71,
  100,  101,  102,  103,   75,  104,   76,   90,   38,   88,
  105,   77,   89,   91,   38,   38,   51,   78,   92,  110,
  115,  116,   38,  117,   38,   78,   78,   78,  144,   38,
   78,   78,  143,  182,   38,   38,  145,  146,   78,   78,
   78,   78,   78,   78,   78,   78,   78,   78,   78,   78,
   78,   78,   72,  149,  165,  172,  173,  174,   73,   74,
  175,  176,  180,  136,  181,  187,   75,   76,   76,   54,
   23,   54,   11,   77,   54,   54,   22,   84,   51,   77,
   28,   83,   54,   54,   54,   54,   54,   54,   54,   54,
   54,   54,   54,   54,   54,  142,  127,  128,  129,  130,
  131,  132,  133,  134,  135,  136,   68,  114,  124,  125,
  126,  127,  128,  129,  130,  131,  132,  133,  134,  135,
  136,  150,  129,  130,  131,  132,  133,  134,  135,  136,
  183,    0,    0,    0,  124,  125,  126,  127,  128,  129,
  130,  131,  132,  133,  134,  135,  136,  167,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  124,  125,  126,  127,  128,  129,  130,  131,  132,  133,
  134,  135,  136,  188,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  124,  125,  126,  127,
  128,  129,  130,  131,  132,  133,  134,  135,  136,   70,
    0,   70,    0,    0,   70,   70,    0,    0,    0,    0,
    0,    0,   70,   70,   70,   70,   70,   70,   70,   70,
   70,   70,   70,   70,    1,    0,    2,    3,    1,    0,
    0,    3,    0,    0,    4,    5,    0,    0,    4,    0,
    0,    0,    6,    0,    0,    7,    6,    0,    8,   68,
    0,   68,    8,    0,   68,   68,    0,    0,    0,    0,
    0,    0,   68,   68,   68,   68,   68,   68,   68,   68,
   68,   68,   68,   69,    0,   69,    0,    0,   69,   69,
    0,    0,    0,    0,    0,    0,   69,   69,   69,   69,
   69,   69,   69,   69,   69,   69,   69,  177,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  124,  125,
  126,  127,  128,  129,  130,  131,  132,  133,  134,  135,
  136,   64,    0,   64,    0,    0,   64,   64,    0,    0,
    0,    0,    0,    0,   64,   64,   64,   64,   64,   64,
   64,   64,   64,   65,    0,   65,    0,    0,   65,   65,
    0,    0,    0,    0,    0,    0,   65,   65,   65,   65,
   65,   65,   65,   65,   65,   66,    0,   66,    0,    0,
   66,   66,    0,    0,    0,    0,    0,    0,   66,   66,
   66,   66,   66,   66,   66,   66,   66,   67,    0,   67,
    0,    0,   67,   67,    0,    0,    0,    0,    0,    0,
   67,   67,   67,   67,   67,   67,   67,   67,   67,  123,
    0,    0,    0,    0,    0,    0,    0,  124,  125,  126,
  127,  128,  129,  130,  131,  132,  133,  134,  135,  136,
  141,    0,    0,    0,    0,    0,    0,    0,  124,  125,
  126,  127,  128,  129,  130,  131,  132,  133,  134,  135,
  136,  179,    0,    0,    0,    0,    0,    0,    0,  124,
  125,  126,  127,  128,  129,  130,  131,  132,  133,  134,
  135,  136,   63,    0,   63,    0,    0,   63,   63,    0,
    0,    0,    0,    0,    0,   63,   63,   63,   63,   63,
   58,    0,   58,    0,    0,   58,   58,    0,    0,    0,
    0,    0,    0,   58,   58,   58,   58,   58,   59,    0,
   59,    0,    0,   59,   59,    0,    0,    0,    0,    0,
    0,   59,   59,   59,   59,   59,   61,    0,   61,    0,
    0,   61,   61,    0,    0,    0,    0,    0,    0,   61,
   61,   61,   62,    0,   62,    0,    0,   62,   62,    0,
    0,    0,    0,    0,    0,   62,   62,   62,  124,  125,
  126,  127,  128,  129,  130,  131,  132,  133,  134,  135,
  136,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                        142,
    0,  257,  257,  284,  260,  260,  286,  309,  310,  281,
   29,  267,  267,   76,  286,  296,  296,  285,  286,  275,
  275,   21,  278,  278,  167,  281,  281,   90,   91,  281,
  281,  311,   32,  289,  289,  286,   99,  180,   57,   58,
  290,  104,  105,  281,  285,  188,  287,  110,  286,  290,
  291,   59,   60,  307,  308,  309,  310,  298,  299,  300,
   60,  124,  125,  126,  127,  128,  129,  130,  131,  132,
  133,  134,  135,  136,  137,   44,  139,   46,  141,  281,
  143,  269,  270,  271,  285,  273,  287,  281,  276,  290,
  291,  291,   27,  281,   29,  288,  284,  285,  291,  262,
  284,  288,  284,  281,  292,  293,  294,  295,  287,  297,
   45,  174,  266,  285,  302,  291,  179,  269,  270,  271,
  285,  273,   57,   58,  276,  281,  281,  284,  290,  281,
  258,  284,  284,  284,  281,  285,  264,  265,    0,  285,
  292,  293,  294,  295,  272,  297,  274,  284,  258,  290,
  302,  279,  290,  284,  264,  265,  284,  285,  284,  284,
  284,  284,  272,  284,  274,  285,  286,  287,  281,  279,
  290,  291,  291,  173,  284,  285,  292,  285,  298,  299,
  300,  301,  302,  303,  304,  305,  306,  307,  308,  309,
  310,  311,  258,  281,  281,  285,  291,  291,  264,  265,
  285,  284,  261,  310,  290,  285,  272,  291,  274,  285,
  285,  287,  290,  279,  290,  291,  285,  285,  284,  291,
   21,  285,  298,  299,  300,  301,  302,  303,  304,  305,
  306,  307,  308,  309,  310,  285,  301,  302,  303,  304,
  305,  306,  307,  308,  309,  310,   60,   92,  298,  299,
  300,  301,  302,  303,  304,  305,  306,  307,  308,  309,
  310,  285,  303,  304,  305,  306,  307,  308,  309,  310,
  176,   -1,   -1,   -1,  298,  299,  300,  301,  302,  303,
  304,  305,  306,  307,  308,  309,  310,  285,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  298,  299,  300,  301,  302,  303,  304,  305,  306,  307,
  308,  309,  310,  285,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  298,  299,  300,  301,
  302,  303,  304,  305,  306,  307,  308,  309,  310,  285,
   -1,  287,   -1,   -1,  290,  291,   -1,   -1,   -1,   -1,
   -1,   -1,  298,  299,  300,  301,  302,  303,  304,  305,
  306,  307,  308,  309,  257,   -1,  259,  260,  257,   -1,
   -1,  260,   -1,   -1,  267,  268,   -1,   -1,  267,   -1,
   -1,   -1,  275,   -1,   -1,  278,  275,   -1,  281,  285,
   -1,  287,  281,   -1,  290,  291,   -1,   -1,   -1,   -1,
   -1,   -1,  298,  299,  300,  301,  302,  303,  304,  305,
  306,  307,  308,  285,   -1,  287,   -1,   -1,  290,  291,
   -1,   -1,   -1,   -1,   -1,   -1,  298,  299,  300,  301,
  302,  303,  304,  305,  306,  307,  308,  287,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  298,  299,
  300,  301,  302,  303,  304,  305,  306,  307,  308,  309,
  310,  285,   -1,  287,   -1,   -1,  290,  291,   -1,   -1,
   -1,   -1,   -1,   -1,  298,  299,  300,  301,  302,  303,
  304,  305,  306,  285,   -1,  287,   -1,   -1,  290,  291,
   -1,   -1,   -1,   -1,   -1,   -1,  298,  299,  300,  301,
  302,  303,  304,  305,  306,  285,   -1,  287,   -1,   -1,
  290,  291,   -1,   -1,   -1,   -1,   -1,   -1,  298,  299,
  300,  301,  302,  303,  304,  305,  306,  285,   -1,  287,
   -1,   -1,  290,  291,   -1,   -1,   -1,   -1,   -1,   -1,
  298,  299,  300,  301,  302,  303,  304,  305,  306,  290,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  298,  299,  300,
  301,  302,  303,  304,  305,  306,  307,  308,  309,  310,
  290,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  298,  299,
  300,  301,  302,  303,  304,  305,  306,  307,  308,  309,
  310,  290,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  298,
  299,  300,  301,  302,  303,  304,  305,  306,  307,  308,
  309,  310,  285,   -1,  287,   -1,   -1,  290,  291,   -1,
   -1,   -1,   -1,   -1,   -1,  298,  299,  300,  301,  302,
  285,   -1,  287,   -1,   -1,  290,  291,   -1,   -1,   -1,
   -1,   -1,   -1,  298,  299,  300,  301,  302,  285,   -1,
  287,   -1,   -1,  290,  291,   -1,   -1,   -1,   -1,   -1,
   -1,  298,  299,  300,  301,  302,  285,   -1,  287,   -1,
   -1,  290,  291,   -1,   -1,   -1,   -1,   -1,   -1,  298,
  299,  300,  285,   -1,  287,   -1,   -1,  290,  291,   -1,
   -1,   -1,   -1,   -1,   -1,  298,  299,  300,  298,  299,
  300,  301,  302,  303,  304,  305,  306,  307,  308,  309,
  310,
};
}
final static short YYFINAL=9;
final static short YYMAXTOKEN=311;
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
"NEWLINE","STRCON","LEFTPAREN","RIGHTPAREN","LEFTBRACKET","RIGHTBRACKET",
"LEFTBRACE","RIGHTBRACE","SEMICOLON","COMMA","INTCONSTANT","DOUBLECONSTANT",
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
"ClassDecl : CLASS ID EXTENDS ID IMPLEMENTS ID_PLUS LEFTBRACE Field_MULT RIGHTBRACE",
"Field : VariableDecl",
"Field : FunctionDecl",
"Field_MULT : Field_MULT Field",
"Field_MULT :",
"InterfaceDecl : INTERFACE ID LEFTBRACE Prototype_MULT RIGHTBRACE",
"Prototype : Type ID LEFTPAREN Formals RIGHTPAREN SEMICOLON",
"Prototype : VOID ID LEFTPAREN Formals RIGHTPAREN SEMICOLON",
"Prototype_MULT : Prototype_MULT Prototype",
"Prototype_MULT :",
"StmtBlock : LEFTPAREN VariableDecl_MULT Stmt_MULT RIGHTPAREN",
"Stmt_MULT : Stmt_MULT Stmt",
"Stmt_MULT :",
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

//#line 210 "Parser.y"

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
//#line 556 "Parser.java"
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
//#line 53 "Parser.y"
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
//#line 62 "Parser.y"
{System.out.println("");}
break;
case 19:
//#line 63 "Parser.y"
{System.out.println("");}
break;
case 20:
//#line 67 "Parser.y"
{System.out.println("");}
break;
case 21:
//#line 68 "Parser.y"
{System.out.println("");}
break;
case 22:
//#line 72 "Parser.y"
{System.out.println("");}
break;
case 23:
//#line 73 "Parser.y"
{System.out.println("");}
break;
case 26:
//#line 83 "Parser.y"
{System.out.println("");}
break;
case 27:
//#line 87 "Parser.y"
{System.out.println("");}
break;
case 28:
//#line 88 "Parser.y"
{System.out.println("");}
break;
case 29:
//#line 92 "Parser.y"
{System.out.println("");}
break;
case 30:
//#line 93 "Parser.y"
{System.out.println("");}
break;
case 31:
//#line 97 "Parser.y"
{System.out.println("");}
break;
case 32:
//#line 101 "Parser.y"
{System.out.println("");}
break;
case 33:
//#line 102 "Parser.y"
{System.out.println("");}
break;
case 34:
//#line 106 "Parser.y"
{System.out.println("");}
break;
case 35:
//#line 107 "Parser.y"
{System.out.println("");}
break;
case 36:
//#line 111 "Parser.y"
{System.out.println("");}
break;
case 37:
//#line 115 "Parser.y"
{System.out.println("");}
break;
case 38:
//#line 116 "Parser.y"
{System.out.println("");}
break;
case 39:
//#line 120 "Parser.y"
{System.out.println("");}
break;
case 40:
//#line 121 "Parser.y"
{System.out.println("");}
break;
case 41:
//#line 122 "Parser.y"
{System.out.println("");}
break;
case 42:
//#line 123 "Parser.y"
{System.out.println("");}
break;
case 43:
//#line 124 "Parser.y"
{System.out.println("");}
break;
case 44:
//#line 125 "Parser.y"
{System.out.println("");}
break;
case 45:
//#line 126 "Parser.y"
{System.out.println("");}
break;
case 46:
//#line 130 "Parser.y"
{System.out.println("");}
break;
case 47:
//#line 134 "Parser.y"
{System.out.println("");}
break;
case 48:
//#line 138 "Parser.y"
{System.out.println("");}
break;
case 49:
//#line 142 "Parser.y"
{System.out.println("");}
break;
case 50:
//#line 146 "Parser.y"
{System.out.println("");}
break;
case 51:
//#line 150 "Parser.y"
{System.out.println("");}
break;
case 52:
//#line 154 "Parser.y"
{System.out.println("");}
break;
case 53:
//#line 155 "Parser.y"
{System.out.println("");}
break;
case 54:
//#line 156 "Parser.y"
{System.out.println("");}
break;
case 55:
//#line 157 "Parser.y"
{System.out.println("");}
break;
case 56:
//#line 158 "Parser.y"
{System.out.println("");}
break;
case 57:
//#line 159 "Parser.y"
{System.out.println("");}
break;
case 58:
//#line 160 "Parser.y"
{System.out.println("");}
break;
case 59:
//#line 161 "Parser.y"
{System.out.println("");}
break;
case 60:
//#line 162 "Parser.y"
{System.out.println("");}
break;
case 61:
//#line 163 "Parser.y"
{System.out.println("");}
break;
case 62:
//#line 164 "Parser.y"
{System.out.println("");}
break;
case 63:
//#line 165 "Parser.y"
{System.out.println("");}
break;
case 64:
//#line 166 "Parser.y"
{System.out.println("");}
break;
case 65:
//#line 167 "Parser.y"
{System.out.println("");}
break;
case 66:
//#line 168 "Parser.y"
{System.out.println("");}
break;
case 67:
//#line 169 "Parser.y"
{System.out.println("");}
break;
case 68:
//#line 170 "Parser.y"
{System.out.println("");}
break;
case 69:
//#line 171 "Parser.y"
{System.out.println("");}
break;
case 70:
//#line 172 "Parser.y"
{System.out.println("");}
break;
case 71:
//#line 173 "Parser.y"
{System.out.println("");}
break;
case 72:
//#line 174 "Parser.y"
{System.out.println("");}
break;
case 73:
//#line 175 "Parser.y"
{System.out.println("");}
break;
case 74:
//#line 176 "Parser.y"
{System.out.println("");}
break;
case 75:
//#line 177 "Parser.y"
{System.out.println("");}
break;
case 76:
//#line 181 "Parser.y"
{System.out.println("");}
break;
case 77:
//#line 182 "Parser.y"
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
//#line 192 "Parser.y"
{System.out.println("");}
break;
case 82:
//#line 193 "Parser.y"
{System.out.println("");}
break;
case 83:
//#line 197 "Parser.y"
{System.out.println("");}
break;
case 84:
//#line 198 "Parser.y"
{System.out.println("");}
break;
case 85:
//#line 202 "Parser.y"
{System.out.println("");}
break;
case 86:
//#line 203 "Parser.y"
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
//#line 206 "Parser.y"
{System.out.println("");}
break;
//#line 1053 "Parser.java"
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
