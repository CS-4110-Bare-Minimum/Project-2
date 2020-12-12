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
#define LEFTPAREN 283
#define RIGHTPAREN 284
#define LEFTBRACKET 285
#define RIGHTBRACKET 286
#define LEFTBRACE 287
#define RIGHTBRACE 288
#define SEMICOLON 289
#define COMMA 290
#define INTCONSTANT 291
#define DOUBLECONSTANT 292
#define STRINGCONSTANT 293
#define BOOLEANCONSTANT 294
#define PERIOD 295
#define NOT 296
#define MULTIPLICATION 297
#define DIVISION 298
#define MOD 299
#define PLUS 300
#define MINUS 301
#define LESS 302
#define LESSEQUAL 303
#define GREATER 304
#define GREATEREQUAL 305
#define EQUAL 306
#define NOTEQUAL 307
#define AND 308
#define OR 309
#define ASSIGNOP 310
#define YYERRCODE 256
short yylhs[] = {                                        -1,
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
short yylen[] = {                                         2,
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
short yydefred[] = {                                      0,
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
short yydgoto[] = {                                       9,
   10,   11,   12,   13,   14,   15,   16,  132,   37,  155,
   38,  156,   39,   59,   26,   34,   94,  129,   35,   64,
  142,  157,  158,  159,  160,  161,  162,  163,  164,  191,
  105,   55,   56,   57,  106,
};
short yysindex[] = {                                    188,
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
short yyrindex[] = {                                      0,
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
short yygindex[] = {                                      0,
    0,  238,  -91,  155,    0,    0,  -22,    0,    1,  -30,
  -27,   14,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  -70, -143,    0,    0,    0,    0,    0,    0,    0,
   80,    0,    0,    0,  116,
};
#define YYTABLESIZE 754
short yytable[] = {                                      54,
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
short yycheck[] = {                                      30,
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
#define YYFINAL 9
#ifndef YYDEBUG
#define YYDEBUG 0
#endif
#define YYMAXTOKEN 310
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
"VOID","WHILE","INTEGER","ID","NEWLINE","LEFTPAREN","RIGHTPAREN","LEFTBRACKET",
"RIGHTBRACKET","LEFTBRACE","RIGHTBRACE","SEMICOLON","COMMA","INTCONSTANT",
"DOUBLECONSTANT","STRINGCONSTANT","BOOLEANCONSTANT","PERIOD","NOT",
"MULTIPLICATION","DIVISION","MOD","PLUS","MINUS","LESS","LESSEQUAL","GREATER",
"GREATEREQUAL","EQUAL","NOTEQUAL","AND","OR","ASSIGNOP",
};
char *yyrule[] = {
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
#line 235 "Parser.y"

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
#line 514 "y.tab.c"
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
{System.out.println("");}
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
#line 50 "Parser.y"
{System.out.println("");}
break;
case 13:
#line 54 "Parser.y"
{System.out.println(yyval);}
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
#line 59 "Parser.y"
{System.out.println("");}
break;
case 19:
#line 63 "Parser.y"
{System.out.println("");}
break;
case 20:
#line 64 "Parser.y"
{System.out.println("");}
break;
case 21:
#line 68 "Parser.y"
{System.out.println("");}
break;
case 22:
#line 69 "Parser.y"
{System.out.println("");}
break;
case 23:
#line 73 "Parser.y"
{System.out.println("");}
break;
case 24:
#line 74 "Parser.y"
{System.out.println("");}
break;
case 25:
#line 78 "Parser.y"
{System.out.println("");}
break;
case 26:
#line 80 "Parser.y"
{System.out.println("");}
break;
case 27:
#line 84 "Parser.y"
{System.out.println("");}
break;
case 28:
#line 86 "Parser.y"
{System.out.println("");}
break;
case 29:
#line 90 "Parser.y"
{System.out.println("");}
break;
case 30:
#line 92 "Parser.y"
{System.out.println("");}
break;
case 31:
#line 96 "Parser.y"
{System.out.println("");}
break;
case 32:
#line 100 "Parser.y"
{System.out.println("");}
break;
case 33:
#line 101 "Parser.y"
{System.out.println("");}
break;
case 34:
#line 105 "Parser.y"
{System.out.println("");}
break;
case 35:
#line 106 "Parser.y"
{System.out.println("");}
break;
case 36:
#line 110 "Parser.y"
{System.out.println("");}
break;
case 37:
#line 114 "Parser.y"
{System.out.println("");}
break;
case 38:
#line 115 "Parser.y"
{System.out.println("");}
break;
case 39:
#line 119 "Parser.y"
{System.out.println("");;}
break;
case 40:
#line 120 "Parser.y"
{System.out.println("");}
break;
case 41:
#line 124 "Parser.y"
{System.out.println("");}
break;
case 42:
#line 128 "Parser.y"
{System.out.println("");}
break;
case 43:
#line 129 "Parser.y"
{System.out.println("");}
break;
case 44:
#line 133 "Parser.y"
{System.out.println("");}
break;
case 45:
#line 134 "Parser.y"
{System.out.println("");}
break;
case 46:
#line 135 "Parser.y"
{System.out.println("");}
break;
case 47:
#line 136 "Parser.y"
{System.out.println("");}
break;
case 48:
#line 137 "Parser.y"
{System.out.println("");}
break;
case 49:
#line 138 "Parser.y"
{System.out.println("");}
break;
case 50:
#line 139 "Parser.y"
{System.out.println("");}
break;
case 51:
#line 140 "Parser.y"
{System.out.println("");}
break;
case 52:
#line 144 "Parser.y"
{System.out.println("");}
break;
case 53:
#line 146 "Parser.y"
{System.out.println("");}
break;
case 54:
#line 150 "Parser.y"
{System.out.println("");}
break;
case 55:
#line 154 "Parser.y"
{System.out.println("");}
break;
case 56:
#line 158 "Parser.y"
{System.out.println("");}
break;
case 57:
#line 162 "Parser.y"
{System.out.println("");}
break;
case 58:
#line 166 "Parser.y"
{System.out.println("");}
break;
case 59:
#line 170 "Parser.y"
{System.out.println("");}
break;
case 60:
#line 174 "Parser.y"
{System.out.println("");}
break;
case 61:
#line 175 "Parser.y"
{System.out.println("");}
break;
case 62:
#line 179 "Parser.y"
{System.out.println("");}
break;
case 63:
#line 180 "Parser.y"
{System.out.println("");}
break;
case 64:
#line 184 "Parser.y"
{System.out.println("");}
break;
case 65:
#line 185 "Parser.y"
{System.out.println("");}
break;
case 66:
#line 186 "Parser.y"
{System.out.println("");}
break;
case 67:
#line 187 "Parser.y"
{System.out.println("");}
break;
case 68:
#line 188 "Parser.y"
{System.out.println("");}
break;
case 69:
#line 189 "Parser.y"
{System.out.println("");}
break;
case 70:
#line 190 "Parser.y"
{System.out.println("");}
break;
case 71:
#line 191 "Parser.y"
{System.out.println("");}
break;
case 72:
#line 192 "Parser.y"
{System.out.println("");}
break;
case 73:
#line 193 "Parser.y"
{System.out.println("");}
break;
case 74:
#line 194 "Parser.y"
{System.out.println("");}
break;
case 75:
#line 195 "Parser.y"
{System.out.println("");}
break;
case 76:
#line 196 "Parser.y"
{System.out.println("");}
break;
case 77:
#line 197 "Parser.y"
{System.out.println("");}
break;
case 78:
#line 198 "Parser.y"
{System.out.println("");}
break;
case 79:
#line 199 "Parser.y"
{System.out.println("");}
break;
case 80:
#line 200 "Parser.y"
{System.out.println("");}
break;
case 81:
#line 201 "Parser.y"
{System.out.println("");}
break;
case 82:
#line 202 "Parser.y"
{System.out.println("");}
break;
case 83:
#line 203 "Parser.y"
{System.out.println("");}
break;
case 84:
#line 204 "Parser.y"
{System.out.println("");}
break;
case 85:
#line 205 "Parser.y"
{System.out.println("");}
break;
case 86:
#line 206 "Parser.y"
{System.out.println("");}
break;
case 87:
#line 207 "Parser.y"
{System.out.println("");}
break;
case 88:
#line 211 "Parser.y"
{System.out.println("");}
break;
case 89:
#line 212 "Parser.y"
{System.out.println("");}
break;
case 90:
#line 213 "Parser.y"
{System.out.println("");}
break;
case 91:
#line 217 "Parser.y"
{System.out.println("");}
break;
case 92:
#line 218 "Parser.y"
{System.out.println("");}
break;
case 93:
#line 222 "Parser.y"
{System.out.println("");}
break;
case 94:
#line 223 "Parser.y"
{System.out.println("");}
break;
case 95:
#line 227 "Parser.y"
{System.out.println("");}
break;
case 96:
#line 228 "Parser.y"
{System.out.println("");}
break;
case 97:
#line 229 "Parser.y"
{System.out.println("");}
break;
case 98:
#line 230 "Parser.y"
{System.out.println("");}
break;
case 99:
#line 231 "Parser.y"
{System.out.println("");}
break;
#line 1050 "y.tab.c"
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
