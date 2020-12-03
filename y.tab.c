#ifndef lint
static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";
#endif
#define YYBYACC 1
#line 2 "Parser.y"
  import java.io.*;
  import java.util.Scanner;
#line 9 "y.tab.c"
#define BOOLEAN 257
#define BREAK 258
#define CLASS 259
#define DOUBLE 260
#define ELSE 261
#define EXTENDS 262
#define FALSE 263
#define FOR 264
#define IF 265
#define IMPLEMENTS 266
#define INT 267
#define INTERFACE 268
#define NEW 269
#define NEWARRAY 270
#define NULL 271
#define PRINTLN 272
#define READLN 273
#define RETURN 274
#define STRING 275
#define THIS 276
#define TRUE 277
#define VOID 278
#define WHILE 279
#define INTEGER 280
#define ID 281
#define NEWLINE 282
#define STRCON 283
#define LEFTPAREN 284
#define RIGHTPAREN 285
#define LEFTBRACKET 286
#define RIGHTBRACKET 287
#define LEFTBRACE 288
#define RIGHTBRACE 289
#define SEMICOLON 290
#define COMMA 291
#define INTCONSTANT 292
#define DOUBLECONSTANT 293
#define STRINGCONSTANT 294
#define BOOLEANCONSTANT 295
#define PERIOD 296
#define NOT 297
#define MULTIPLICATION 298
#define DIVISION 299
#define MOD 300
#define PLUS 301
#define MINUS 302
#define LESS 303
#define LESSEQUAL 304
#define GREATER 305
#define GREATEREQUAL 306
#define EQUAL 307
#define NOTEQUAL 308
#define AND 309
#define OR 310
#define ASSIGNOP 311
#define YYERRCODE 256
short yylhs[] = {                                        -1,
    0,    2,    2,    2,    2,    1,    1,    3,    8,    8,
    7,    9,    9,    9,    9,    9,    9,    4,    4,   12,
   12,   10,   10,   13,   13,    5,   15,   15,   14,   14,
    6,   17,   17,   16,   16,   11,   18,   18,   19,   19,
   19,   19,   19,   19,   19,   20,   21,   22,   23,   24,
   25,   26,   26,   26,   26,   26,   26,   26,   26,   26,
   26,   26,   26,   26,   26,   26,   26,   26,   26,   26,
   26,   26,   26,   26,   26,   27,   27,   28,   28,   28,
   28,   30,   30,   31,   31,   29,   29,   29,   29,   29,
};
short yylen[] = {                                         2,
    1,    1,    1,    1,    1,    1,    3,    2,    2,    0,
    2,    1,    1,    1,    1,    3,    1,    6,    6,    1,
    3,    1,    0,    1,    3,    9,    1,    1,    2,    0,
    5,    6,    6,    2,    0,    4,    2,    0,    1,    1,
    1,    1,    1,    1,    1,    7,    5,    9,    2,    3,
    6,    3,    1,    1,    1,    1,    3,    3,    3,    3,
    3,    3,    2,    3,    3,    3,    3,    3,    3,    3,
    3,    2,    3,    4,    6,    1,    3,    1,    1,    4,
    3,    4,    6,    2,    0,    1,    1,    1,    1,    1,
};
short yydefred[] = {                                      0,
   14,    0,   13,   12,    0,   15,    0,   17,    0,    0,
    6,    2,    3,    4,    5,    0,    0,    0,    0,    0,
    0,    8,    0,    0,    0,   35,    0,    7,    0,   16,
    0,    0,   20,    0,    0,    0,    0,    0,    0,   31,
    0,   34,   11,    0,    0,    0,   24,    0,    0,    0,
   10,   19,   21,   18,   30,    0,    0,    0,    0,    0,
   25,    0,    0,    9,    0,   26,   27,   28,   29,    0,
    0,    0,    0,    0,    0,    0,    0,   36,   45,   37,
   39,   40,   41,   42,   43,   44,   33,   32,   49,    0,
    0,    0,    0,    0,   90,    0,   55,    0,    0,   86,
   87,   88,   89,    0,    0,   78,    0,    0,   53,   56,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   50,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   73,    0,    0,    0,
   57,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   71,    0,   81,   52,    0,    0,    0,
    0,    0,   74,    0,    0,   82,    0,   80,   47,    0,
    0,   51,    0,    0,    0,   46,   75,   83,    0,   48,
};
short yydgoto[] = {                                       9,
   10,   11,   12,   13,   14,   15,  106,   59,   34,   35,
   79,   36,   48,   60,   69,   32,   42,   65,   80,   81,
   82,   83,   84,   85,   86,  114,  148,  108,  109,  110,
  149,
};
short yysindex[] = {                                    137,
    0, -274,    0,    0, -266,    0, -257,    0,    0, -252,
    0,    0,    0,    0,    0, -206, -278, -168, -201, -160,
  137,    0, -155, -157, -150,    0, -175,    0, -175,    0,
 -133, -255,    0, -227, -141, -146, -138, -126, -125,    0,
 -183,    0,    0, -136, -175, -136,    0, -241, -123, -121,
    0,    0,    0,    0,    0, -116, -175, -175, -175, -246,
    0, -119, -114,    0,  -62,    0,    0,    0,    0, -118,
 -113, -112, -108, -105, -104, -135,  -89,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0, -135,
 -135, -135,  -87,  -86,    0,  -84,    0, -247, -135,    0,
    0,    0,    0, -135, -135,    0,  278, -256,    0,    0,
 -135,  299,  -21,  401,  -90,  -77,  -85,  -76, -135,  -73,
    5,  401,  -12,    0, -135, -135, -135, -135, -135, -135,
 -135, -135, -135, -135, -135, -135, -135, -135,  -70, -135,
   32, -135,  -37, -174,  -71,  -75,    0,  -72,  -67,  -60,
    0,  -36,  -36,  -36,  -12,  -12, -194, -194, -194, -194,
 -205, -205,  -81,    0,  169,    0,    0,  -37,  320,  -31,
  -58,  401,    0, -175, -135,    0, -135,    0,    0, -135,
  -37,    0, -177,  -54,   58,    0,    0,    0,  -37,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  233,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  -56,    0,    0,    0,  -49,    0,  -49,    0,
    0,    0,    0,    0,    0,  -46,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  -49,  -49,  -59,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0, -117,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  -47,    0,    0,
    0,    0,    0,  -50,    0,    0,    0,    0,  -40,    0,
    0, -234, -148,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0, -281,  382,  398,  346,  364,  195,  217,  239,  261,
  123,  147,   84,    0,    0,    0,    0,    0,    0,    0,
    0,  -45,    0,    0,  -35,    0,  -40,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
    0,  227,   67,  189,    0,    0,   31,    0,    1,  -13,
   34,    0,    0,    0,    0,    0,    0,    0, -143,    0,
    0,    0,    0,    0,    0,  -63,  183,    0,    0,    0,
   99,
};
#define YYTABLESIZE 711
short yytable[] = {                                     170,
   17,    1,   23,   60,    3,   60,   18,   24,   60,   60,
    1,    4,  107,    3,   19,   37,   60,   60,   60,    6,
    4,   17,   39,   20,  179,    8,  112,  113,    6,  138,
   16,    7,   41,   40,    8,  121,  119,  186,   21,  139,
  122,  123,   66,   62,   63,  190,   55,  141,  120,   56,
   72,   16,   72,   43,  140,   72,   72,   33,   24,   33,
   17,  152,  153,  154,  155,  156,  157,  158,  159,  160,
  161,  162,  163,  164,  165,   53,  167,   52,  169,   54,
  172,    1,    1,   22,    3,    3,   26,   33,   33,   16,
   16,    4,    4,   25,   93,   94,   95,   50,   96,    6,
    6,   97,   24,  136,  137,    8,   98,  187,   24,   99,
  171,  172,  134,  135,  136,  137,  185,  100,  101,  102,
  103,    1,  104,   27,    3,   64,   67,  105,   29,   30,
   31,    4,   38,   93,   94,   95,   63,   96,   63,    6,
   97,   63,   63,   44,   45,   98,   46,   51,   99,   63,
   63,   63,   63,   63,   47,   49,  100,  101,  102,  103,
   57,  104,   58,   17,   61,   70,  105,   79,   17,   79,
   71,   87,   79,   79,  183,   90,   88,   89,   91,   92,
   79,   79,   79,   79,   79,   79,   79,   79,   79,   79,
   79,   79,   79,   79,  111,   72,  116,  117,   38,  118,
  144,   73,   74,  145,   38,   38,  146,  150,  147,   75,
  166,   76,   38,  173,   38,  174,   77,  176,  175,   38,
   72,   51,   78,  177,   38,   38,   73,   74,  137,  181,
  188,  182,    1,   11,   75,   23,   76,   54,   22,   54,
   76,   77,   54,   54,   85,   77,   51,   28,   68,   84,
   54,   54,   54,   54,   54,   54,   54,   54,   54,   54,
   54,   54,   54,  143,  128,  129,  130,  131,  132,  133,
  134,  135,  136,  137,  115,  184,  125,  126,  127,  128,
  129,  130,  131,  132,  133,  134,  135,  136,  137,  151,
  130,  131,  132,  133,  134,  135,  136,  137,    0,    0,
    0,    0,  125,  126,  127,  128,  129,  130,  131,  132,
  133,  134,  135,  136,  137,    0,  168,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  125,
  126,  127,  128,  129,  130,  131,  132,  133,  134,  135,
  136,  137,  189,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  125,  126,  127,  128,  129,
  130,  131,  132,  133,  134,  135,  136,  137,   70,    0,
   70,    0,    0,   70,   70,    0,    0,    0,    0,    0,
    0,   70,   70,   70,   70,   70,   70,   70,   70,   70,
   70,   70,   70,    1,    0,    2,    3,    0,    0,    0,
    0,    0,    0,    4,    5,    0,    0,   68,    0,   68,
    0,    6,   68,   68,    7,    0,    0,    8,    0,    0,
   68,   68,   68,   68,   68,   68,   68,   68,   68,   68,
   68,   69,    0,   69,    0,    0,   69,   69,    0,    0,
    0,    0,    0,    0,   69,   69,   69,   69,   69,   69,
   69,   69,   69,   69,   69,  178,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  125,  126,  127,  128,
  129,  130,  131,  132,  133,  134,  135,  136,  137,   64,
    0,   64,    0,    0,   64,   64,    0,    0,    0,    0,
    0,    0,   64,   64,   64,   64,   64,   64,   64,   64,
   64,   65,    0,   65,    0,    0,   65,   65,    0,    0,
    0,    0,    0,    0,   65,   65,   65,   65,   65,   65,
   65,   65,   65,   66,    0,   66,    0,    0,   66,   66,
    0,    0,    0,    0,    0,    0,   66,   66,   66,   66,
   66,   66,   66,   66,   66,   67,    0,   67,    0,    0,
   67,   67,    0,    0,    0,    0,    0,    0,   67,   67,
   67,   67,   67,   67,   67,   67,   67,  124,    0,    0,
    0,    0,    0,    0,    0,  125,  126,  127,  128,  129,
  130,  131,  132,  133,  134,  135,  136,  137,  142,    0,
    0,    0,    0,    0,    0,    0,  125,  126,  127,  128,
  129,  130,  131,  132,  133,  134,  135,  136,  137,  180,
    0,    0,    0,    0,    0,    0,    0,  125,  126,  127,
  128,  129,  130,  131,  132,  133,  134,  135,  136,  137,
   58,    0,   58,    0,    0,   58,   58,    0,    0,    0,
    0,    0,    0,   58,   58,   58,   58,   58,   59,    0,
   59,    0,    0,   59,   59,    0,    0,    0,    0,    0,
    0,   59,   59,   59,   59,   59,   61,    0,   61,    0,
    0,   61,   61,    0,    0,    0,    0,    0,    0,   61,
   61,   61,   62,    0,   62,    0,    0,   62,   62,    0,
    0,    0,    0,    0,    0,   62,   62,   62,  125,  126,
  127,  128,  129,  130,  131,  132,  133,  134,  135,  136,
  137,
};
short yycheck[] = {                                     143,
    0,  257,  281,  285,  260,  287,  281,  286,  290,  291,
  257,  267,   76,  260,  281,   29,  298,  299,  300,  275,
  267,   21,  278,  281,  168,  281,   90,   91,  275,  286,
    0,  278,   32,  289,  281,   99,  284,  181,  291,  296,
  104,  105,  289,   57,   58,  189,  288,  111,  296,  291,
  285,   21,  287,  281,  311,  290,  291,   27,  286,   29,
   60,  125,  126,  127,  128,  129,  130,  131,  132,  133,
  134,  135,  136,  137,  138,   45,  140,   44,  142,   46,
  144,  257,  257,  290,  260,  260,  288,   57,   58,   59,
   60,  267,  267,  262,  269,  270,  271,  281,  273,  275,
  275,  276,  286,  309,  310,  281,  281,  285,  286,  284,
  285,  175,  307,  308,  309,  310,  180,  292,  293,  294,
  295,  257,  297,  284,  260,   59,   60,  302,  284,  287,
  281,  267,  266,  269,  270,  271,  285,  273,  287,  275,
  276,  290,  291,  285,  291,  281,  285,  284,  284,  298,
  299,  300,  301,  302,  281,  281,  292,  293,  294,  295,
  284,  297,  284,  281,  281,  285,  302,  285,  286,  287,
  285,  290,  290,  291,  174,  284,  290,  290,  284,  284,
  298,  299,  300,  301,  302,  303,  304,  305,  306,  307,
  308,  309,  310,  311,  284,  258,  284,  284,  258,  284,
  291,  264,  265,  281,  264,  265,  292,  281,  285,  272,
  281,  274,  272,  285,  274,  291,  279,  285,  291,  279,
  258,  284,  285,  284,  284,  285,  264,  265,  310,  261,
  285,  290,    0,  290,  272,  285,  274,  285,  285,  287,
  291,  279,  290,  291,  285,  291,  284,   21,   60,  285,
  298,  299,  300,  301,  302,  303,  304,  305,  306,  307,
  308,  309,  310,  285,  301,  302,  303,  304,  305,  306,
  307,  308,  309,  310,   92,  177,  298,  299,  300,  301,
  302,  303,  304,  305,  306,  307,  308,  309,  310,  285,
  303,  304,  305,  306,  307,  308,  309,  310,   -1,   -1,
   -1,   -1,  298,  299,  300,  301,  302,  303,  304,  305,
  306,  307,  308,  309,  310,   -1,  285,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  298,
  299,  300,  301,  302,  303,  304,  305,  306,  307,  308,
  309,  310,  285,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  298,  299,  300,  301,  302,
  303,  304,  305,  306,  307,  308,  309,  310,  285,   -1,
  287,   -1,   -1,  290,  291,   -1,   -1,   -1,   -1,   -1,
   -1,  298,  299,  300,  301,  302,  303,  304,  305,  306,
  307,  308,  309,  257,   -1,  259,  260,   -1,   -1,   -1,
   -1,   -1,   -1,  267,  268,   -1,   -1,  285,   -1,  287,
   -1,  275,  290,  291,  278,   -1,   -1,  281,   -1,   -1,
  298,  299,  300,  301,  302,  303,  304,  305,  306,  307,
  308,  285,   -1,  287,   -1,   -1,  290,  291,   -1,   -1,
   -1,   -1,   -1,   -1,  298,  299,  300,  301,  302,  303,
  304,  305,  306,  307,  308,  287,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  298,  299,  300,  301,
  302,  303,  304,  305,  306,  307,  308,  309,  310,  285,
   -1,  287,   -1,   -1,  290,  291,   -1,   -1,   -1,   -1,
   -1,   -1,  298,  299,  300,  301,  302,  303,  304,  305,
  306,  285,   -1,  287,   -1,   -1,  290,  291,   -1,   -1,
   -1,   -1,   -1,   -1,  298,  299,  300,  301,  302,  303,
  304,  305,  306,  285,   -1,  287,   -1,   -1,  290,  291,
   -1,   -1,   -1,   -1,   -1,   -1,  298,  299,  300,  301,
  302,  303,  304,  305,  306,  285,   -1,  287,   -1,   -1,
  290,  291,   -1,   -1,   -1,   -1,   -1,   -1,  298,  299,
  300,  301,  302,  303,  304,  305,  306,  290,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  298,  299,  300,  301,  302,
  303,  304,  305,  306,  307,  308,  309,  310,  290,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  298,  299,  300,  301,
  302,  303,  304,  305,  306,  307,  308,  309,  310,  290,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  298,  299,  300,
  301,  302,  303,  304,  305,  306,  307,  308,  309,  310,
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
#define YYFINAL 9
#ifndef YYDEBUG
#define YYDEBUG 0
#endif
#define YYMAXTOKEN 311
#if YYDEBUG
char *yyname[] = {
"end-of-file",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,"BOOLEAN","BREAK","CLASS",
"DOUBLE","ELSE","EXTENDS","FALSE","FOR","IF","IMPLEMENTS","INT","INTERFACE",
"NEW","NEWARRAY","NULL","PRINTLN","READLN","RETURN","STRING","THIS","TRUE",
"VOID","WHILE","INTEGER","ID","NEWLINE","STRCON","LEFTPAREN","RIGHTPAREN",
"LEFTBRACKET","RIGHTBRACKET","LEFTBRACE","RIGHTBRACE","SEMICOLON","COMMA",
"INTCONSTANT","DOUBLECONSTANT","STRINGCONSTANT","BOOLEANCONSTANT","PERIOD",
"NOT","MULTIPLICATION","DIVISION","MOD","PLUS","MINUS","LESS","LESSEQUAL",
"GREATER","GREATEREQUAL","EQUAL","NOTEQUAL","AND","OR","ASSIGNOP",
};
char *yyrule[] = {
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
"Lvalue : Variable",
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
#endif
#ifndef YYSTYPE
typedef int YYSTYPE;
#endif
#define yyclearin (yychar=(-1))
#define yyerrok (yyerrflag=0)
#ifdef YYSTACKSIZE
#ifndef YYMAXDEPTH
#define YYMAXDEPTH YYSTACKSIZE
#endif
#else
#ifdef YYMAXDEPTH
#define YYSTACKSIZE YYMAXDEPTH
#else
#define YYSTACKSIZE 500
#define YYMAXDEPTH 500
#endif
#endif
int yydebug;
int yynerrs;
int yyerrflag;
int yychar;
short *yyssp;
YYSTYPE *yyvsp;
YYSTYPE yyval;
YYSTYPE yylval;
short yyss[YYSTACKSIZE];
YYSTYPE yyvs[YYSTACKSIZE];
#define yystacksize YYSTACKSIZE
#line 211 "Parser.y"

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
#line 492 "y.tab.c"
#define YYABORT goto yyabort
#define YYACCEPT goto yyaccept
#define YYERROR goto yyerrlab
int
yyparse()
{
    register int yym, yyn, yystate;
#if YYDEBUG
    register char *yys;
    extern char *getenv();

    if (yys = getenv("YYDEBUG"))
    {
        yyn = *yys;
        if (yyn >= '0' && yyn <= '9')
            yydebug = yyn - '0';
    }
#endif

    yynerrs = 0;
    yyerrflag = 0;
    yychar = (-1);

    yyssp = yyss;
    yyvsp = yyvs;
    *yyssp = yystate = 0;

yyloop:
    if (yyn = yydefred[yystate]) goto yyreduce;
    if (yychar < 0)
    {
        if ((yychar = yylex()) < 0) yychar = 0;
#if YYDEBUG
        if (yydebug)
        {
            yys = 0;
            if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
            if (!yys) yys = "illegal-symbol";
            printf("yydebug: state %d, reading %d (%s)\n", yystate,
                    yychar, yys);
        }
#endif
    }
    if ((yyn = yysindex[yystate]) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
    {
#if YYDEBUG
        if (yydebug)
            printf("yydebug: state %d, shifting to state %d (%s)\n",
                    yystate, yytable[yyn],yyrule[yyn]);
#endif
        if (yyssp >= yyss + yystacksize - 1)
        {
            goto yyoverflow;
        }
        *++yyssp = yystate = yytable[yyn];
        *++yyvsp = yylval;
        yychar = (-1);
        if (yyerrflag > 0)  --yyerrflag;
        goto yyloop;
    }
    if ((yyn = yyrindex[yystate]) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
    {
        yyn = yytable[yyn];
        goto yyreduce;
    }
    if (yyerrflag) goto yyinrecovery;
#ifdef lint
    goto yynewerror;
#endif
yynewerror:
    yyerror("syntax error");
#ifdef lint
    goto yyerrlab;
#endif
yyerrlab:
    ++yynerrs;
yyinrecovery:
    if (yyerrflag < 3)
    {
        yyerrflag = 3;
        for (;;)
        {
            if ((yyn = yysindex[*yyssp]) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
#if YYDEBUG
                if (yydebug)
                    printf("yydebug: state %d, error recovery shifting\
 to state %d\n", *yyssp, yytable[yyn]);
#endif
                if (yyssp >= yyss + yystacksize - 1)
                {
                    goto yyoverflow;
                }
                *++yyssp = yystate = yytable[yyn];
                *++yyvsp = yylval;
                goto yyloop;
            }
            else
            {
#if YYDEBUG
                if (yydebug)
                    printf("yydebug: error recovery discarding state %d\n",
                            *yyssp);
#endif
                if (yyssp <= yyss) goto yyabort;
                --yyssp;
                --yyvsp;
            }
        }
    }
    else
    {
        if (yychar == 0) goto yyabort;
#if YYDEBUG
        if (yydebug)
        {
            yys = 0;
            if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
            if (!yys) yys = "illegal-symbol";
            printf("yydebug: state %d, error recovery discards token %d (%s)\n",
                    yystate, yychar, yys);
        }
#endif
        yychar = (-1);
        goto yyloop;
    }
yyreduce:
#if YYDEBUG
    if (yydebug)
        printf("yydebug: state %d, reducing by rule %d (%s)\n",
                yystate, yyn, yyrule[yyn]);
#endif
    yym = yylen[yyn];
    yyval = yyvsp[1-yym];
    switch (yyn)
    {
case 1:
#line 24 "Parser.y"
{System.out.println("");}
break;
case 2:
#line 28 "Parser.y"
{System.out.println(" ");}
break;
case 3:
#line 29 "Parser.y"
{System.out.println("");}
break;
case 4:
#line 30 "Parser.y"
{System.out.println("");}
break;
case 5:
#line 31 "Parser.y"
{System.out.println("");}
break;
case 6:
#line 35 "Parser.y"
{System.out.println(" ");}
break;
case 7:
#line 36 "Parser.y"
{System.out.println("");}
break;
case 8:
#line 40 "Parser.y"
{System.out.println("");}
break;
case 9:
#line 44 "Parser.y"
{System.out.println("");}
break;
case 10:
#line 45 "Parser.y"
{System.out.println("");}
break;
case 11:
#line 49 "Parser.y"
{System.out.println("");}
break;
case 12:
#line 53 "Parser.y"
{System.out.println("");}
break;
case 13:
#line 54 "Parser.y"
{System.out.println("");}
break;
case 14:
#line 55 "Parser.y"
{System.out.println("");}
break;
case 15:
#line 56 "Parser.y"
{System.out.println("");}
break;
case 16:
#line 57 "Parser.y"
{System.out.println("");}
break;
case 17:
#line 58 "Parser.y"
{System.out.println("");}
break;
case 18:
#line 62 "Parser.y"
{System.out.println("");}
break;
case 19:
#line 63 "Parser.y"
{System.out.println("");}
break;
case 20:
#line 67 "Parser.y"
{System.out.println("");}
break;
case 21:
#line 68 "Parser.y"
{System.out.println("");}
break;
case 22:
#line 72 "Parser.y"
{System.out.println("");}
break;
case 23:
#line 73 "Parser.y"
{System.out.println("");}
break;
case 26:
#line 83 "Parser.y"
{System.out.println("");}
break;
case 27:
#line 87 "Parser.y"
{System.out.println("");}
break;
case 28:
#line 88 "Parser.y"
{System.out.println("");}
break;
case 29:
#line 92 "Parser.y"
{System.out.println("");}
break;
case 30:
#line 93 "Parser.y"
{System.out.println("");}
break;
case 31:
#line 97 "Parser.y"
{System.out.println("");}
break;
case 32:
#line 101 "Parser.y"
{System.out.println("");}
break;
case 33:
#line 102 "Parser.y"
{System.out.println("");}
break;
case 34:
#line 106 "Parser.y"
{System.out.println("");}
break;
case 35:
#line 107 "Parser.y"
{System.out.println("");}
break;
case 36:
#line 111 "Parser.y"
{System.out.println("");}
break;
case 37:
#line 115 "Parser.y"
{System.out.println("");}
break;
case 38:
#line 116 "Parser.y"
{System.out.println("");}
break;
case 39:
#line 120 "Parser.y"
{System.out.println("");}
break;
case 40:
#line 121 "Parser.y"
{System.out.println("");}
break;
case 41:
#line 122 "Parser.y"
{System.out.println("");}
break;
case 42:
#line 123 "Parser.y"
{System.out.println("");}
break;
case 43:
#line 124 "Parser.y"
{System.out.println("");}
break;
case 44:
#line 125 "Parser.y"
{System.out.println("");}
break;
case 45:
#line 126 "Parser.y"
{System.out.println("");}
break;
case 46:
#line 130 "Parser.y"
{System.out.println("");}
break;
case 47:
#line 134 "Parser.y"
{System.out.println("");}
break;
case 48:
#line 138 "Parser.y"
{System.out.println("");}
break;
case 49:
#line 142 "Parser.y"
{System.out.println("");}
break;
case 50:
#line 146 "Parser.y"
{System.out.println("");}
break;
case 51:
#line 150 "Parser.y"
{System.out.println("");}
break;
case 52:
#line 154 "Parser.y"
{System.out.println("");}
break;
case 53:
#line 155 "Parser.y"
{System.out.println("");}
break;
case 54:
#line 156 "Parser.y"
{System.out.println("");}
break;
case 55:
#line 157 "Parser.y"
{System.out.println("");}
break;
case 56:
#line 158 "Parser.y"
{System.out.println("");}
break;
case 57:
#line 159 "Parser.y"
{System.out.println("");}
break;
case 58:
#line 160 "Parser.y"
{System.out.println("");}
break;
case 59:
#line 161 "Parser.y"
{System.out.println("");}
break;
case 60:
#line 162 "Parser.y"
{System.out.println("");}
break;
case 61:
#line 163 "Parser.y"
{System.out.println("");}
break;
case 62:
#line 164 "Parser.y"
{System.out.println("");}
break;
case 63:
#line 165 "Parser.y"
{System.out.println("");}
break;
case 64:
#line 166 "Parser.y"
{System.out.println("");}
break;
case 65:
#line 167 "Parser.y"
{System.out.println("");}
break;
case 66:
#line 168 "Parser.y"
{System.out.println("");}
break;
case 67:
#line 169 "Parser.y"
{System.out.println("");}
break;
case 68:
#line 170 "Parser.y"
{System.out.println("");}
break;
case 69:
#line 171 "Parser.y"
{System.out.println("");}
break;
case 70:
#line 172 "Parser.y"
{System.out.println("");}
break;
case 71:
#line 173 "Parser.y"
{System.out.println("");}
break;
case 72:
#line 174 "Parser.y"
{System.out.println("");}
break;
case 73:
#line 175 "Parser.y"
{System.out.println("");}
break;
case 74:
#line 176 "Parser.y"
{System.out.println("");}
break;
case 75:
#line 177 "Parser.y"
{System.out.println("");}
break;
case 76:
#line 181 "Parser.y"
{System.out.println("");}
break;
case 77:
#line 182 "Parser.y"
{System.out.println("");}
break;
case 78:
#line 186 "Parser.y"
{System.out.println("");}
break;
case 79:
#line 187 "Parser.y"
{System.out.println("");}
break;
case 80:
#line 188 "Parser.y"
{System.out.println("");}
break;
case 81:
#line 189 "Parser.y"
{System.out.println("");}
break;
case 82:
#line 193 "Parser.y"
{System.out.println("");}
break;
case 83:
#line 194 "Parser.y"
{System.out.println("");}
break;
case 84:
#line 198 "Parser.y"
{System.out.println("");}
break;
case 85:
#line 199 "Parser.y"
{System.out.println("");}
break;
case 86:
#line 203 "Parser.y"
{System.out.println("");}
break;
case 87:
#line 204 "Parser.y"
{System.out.println("");}
break;
case 88:
#line 205 "Parser.y"
{System.out.println("");}
break;
case 89:
#line 206 "Parser.y"
{System.out.println("");}
break;
case 90:
#line 207 "Parser.y"
{System.out.println("");}
break;
#line 984 "y.tab.c"
    }
    yyssp -= yym;
    yystate = *yyssp;
    yyvsp -= yym;
    yym = yylhs[yyn];
    if (yystate == 0 && yym == 0)
    {
#if YYDEBUG
        if (yydebug)
            printf("yydebug: after reduction, shifting from state 0 to\
 state %d\n", YYFINAL);
#endif
        yystate = YYFINAL;
        *++yyssp = YYFINAL;
        *++yyvsp = yyval;
        if (yychar < 0)
        {
            if ((yychar = yylex()) < 0) yychar = 0;
#if YYDEBUG
            if (yydebug)
            {
                yys = 0;
                if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
                if (!yys) yys = "illegal-symbol";
                printf("yydebug: state %d, reading %d (%s)\n",
                        YYFINAL, yychar, yys);
            }
#endif
        }
        if (yychar == 0) goto yyaccept;
        goto yyloop;
    }
    if ((yyn = yygindex[yym]) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn];
    else
        yystate = yydgoto[yym];
#if YYDEBUG
    if (yydebug)
        printf("yydebug: after reduction, shifting from state %d \
to state %d\n", *yyssp, yystate);
#endif
    if (yyssp >= yyss + yystacksize - 1)
    {
        goto yyoverflow;
    }
    *++yyssp = yystate;
    *++yyvsp = yyval;
    goto yyloop;
yyoverflow:
    yyerror("yacc stack overflow");
yyabort:
    return (1);
yyaccept:
    return (0);
}
