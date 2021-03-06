%{
  import java.io.*;
  import java.util.Scanner;
%}

%token BOOLEAN BREAK CLASS DOUBLE ELSE EXTENDS FALSE FOR IF IMPLEMENTS INT INTERFACE NEW
%token NEWARRAY NULL PRINTLN READLN RETURN STRING THIS TRUE VOID WHILE INTEGER DOUBLE ID NEWLINE
%token LEFTPAREN RIGHTPAREN LEFTBRACKET RIGHTBRACKET LEFTBRACE RIGHTBRACE SEMICOLON COMMA
%token INTCONSTANT DOUBLECONSTANT STRINGCONSTANT BOOLEANCONSTANT

%left LEFTBRACKET RIGHTBRACKET PERIOD
%left NOT
%left MULTIPLICATION DIVISION MOD
%left PLUS MINUS
%left LESS LESSEQUAL GREATER GREATEREQUAL
%left EQUAL NOTEQUAL
%left AND
%left OR
%left ASSIGNOP
      
%%

Program:
	Decl_PLUS	{System.out.println("");}
	;

Decl_PLUS:
	Decl	{System.out.println("");}
	| Decl_PLUS Decl	{System.out.println("");}
	;

Decl:
	VariableDecl	{System.out.println("");}
	| FunctionDecl	{System.out.println("");}
	| ClassDecl	{System.out.println("");}
	| InterfaceDecl	{System.out.println("");}
	;

VariableDecl_MULT:
	VariableDecl_MULT VariableDecl	{System.out.println("");}
	| /* Epsilon */	{System.out.println("");}
	;

VariableDecl:
	Variable SEMICOLON	{System.out.println("");}
	;

Variable_PLUS:
	Variable	{System.out.println("");}
	| Variable_PLUS COMMA Variable	{System.out.println("");}
	;

Variable:
	Type ID	{System.out.println("");}
	| Type ID ASSIGNOP Expr {System.out.println("");}
	;

Type:
	INT	{System.out.println($$);}
	| DOUBLE	{System.out.println("");}
	| BOOLEAN	{System.out.println("");}
	| STRING	{System.out.println("");}
	| Type LEFTBRACKET RIGHTBRACKET	{System.out.println("");}
	| ID	{System.out.println("");}
	;

FunctionDecl:
	Type ID LEFTPAREN Formals RIGHTPAREN StmtBlock	{System.out.println("");}
	| VOID ID LEFTPAREN Formals RIGHTPAREN StmtBlock	{System.out.println("");}
	;

Formals:
	Variable_PLUS	{System.out.println("");}
	| /* Epsilon */	{System.out.println("");}
	;

ID_PLUS:
	ID	{System.out.println("");}
	|
	ID_PLUS COMMA ID	{System.out.println("");}
	;

EXTEND_ZOO:
	/* Epsilon */	{System.out.println("");}
	|
	EXTENDS ID	{System.out.println("");}
	;

IMPLEMENT_ZOO:
	/* Epsilon */	{System.out.println("");}
	|
	IMPLEMENTS ID_PLUS	{System.out.println("");}
	;

ClassDecl:
	CLASS ID EXTEND_ZOO IMPLEMENT_ZOO LEFTBRACE Field_MULT RIGHTBRACE	{System.out.println("");}
	;

Field_MULT:
        Field_MULT Field	{System.out.println("");}
        | /* Epsilon */	{System.out.println("");}
        ;

Field:
	VariableDecl	{System.out.println("");}
	| FunctionDecl	{System.out.println("");}
	;

InterfaceDecl:
	INTERFACE ID LEFTBRACE Prototype_MULT RIGHTBRACE	{System.out.println("");}
	;

Prototype_MULT:
	Prototype_MULT Prototype	{System.out.println("");}
	| /* Epsilon */	{System.out.println("");}
	;

Prototype:
	Type ID LEFTPAREN Formals RIGHTPAREN SEMICOLON	{System.out.println("");}
	| VOID ID LEFTPAREN Formals RIGHTPAREN SEMICOLON	{System.out.println("");}
	;

StmtBlock:
	LEFTBRACE VariableDecl_MULT Stmt_MULT RIGHTBRACE	{System.out.println("");}
		| LEFTBRACE VariableDecl_MULT Stmt_MULT VariableDecl_MULT RIGHTBRACE	{System.out.println("");}
    	;

Stmt_MULT:
    	Stmt_MULT Stmt 	{System.out.println("");}
        | /* Epsilon */	{System.out.println("");}
        ;

Stmt:
	Expr_ZOO SEMICOLON	{System.out.println("");}
    	| IfStmt	{System.out.println("");}
    	| WhileStmt    	{System.out.println("");}
    	| ForStmt      	{System.out.println("");}
    	| BreakStmt    	{System.out.println("");}
    	| ReturnStmt   	{System.out.println("");}
    	| PrintStmt    	{System.out.println("");}
    	| StmtBlock    	{System.out.println("");}
    	;

Else_ZOO:
	/* Epsilon */ 	{System.out.println("");}
        |
        ELSE Stmt	{System.out.println("");}
        ;

IfStmt:
	IF LEFTPAREN Expr RIGHTPAREN Stmt Else_ZOO Stmt	{System.out.println("");}
	;

WhileStmt:
	WHILE LEFTPAREN Expr RIGHTPAREN Stmt	{System.out.println("");}
	;

ForStmt:
	FOR LEFTPAREN Expr_ZOO SEMICOLON Expr SEMICOLON Expr_ZOO RIGHTPAREN Stmt	{System.out.println("");}
	;

BreakStmt:
	BREAK SEMICOLON	{System.out.println("");}
	;

ReturnStmt:
	RETURN Expr_ZOO SEMICOLON	{System.out.println("");}
	;

PrintStmt:
	PRINTLN LEFTPAREN Expr_PLUS RIGHTPAREN SEMICOLON	{System.out.println("");}
	;

Expr_ZOO:
	/* Epsilon*/	{System.out.println("");}
	| Expr		{System.out.println("");}
	;

Expr_PLUS:
	Expr	{System.out.println("");}
        | Expr_PLUS COMMA Expr	{System.out.println("");}
        ;

Expr:
	Lvalue ASSIGNOP Expr 		{System.out.println("");}
	| Constant			{System.out.println("");}
	| Lvalue			{System.out.println("");}
	| THIS				{System.out.println("");}
	| Call				{System.out.println("");}
	| LEFTPAREN Expr RIGHTPAREN	{System.out.println("");}
       	| Expr PLUS Expr        		{System.out.println("");}
       	| Expr MINUS Expr        		{System.out.println("");}
       	| Expr MULTIPLICATION Expr        		{System.out.println("");}
       	| Expr DIVISION Expr        		{System.out.println("");}
       	| Expr MOD Expr			{System.out.println("");}
       	| MINUS Expr		{System.out.println("");}
       	| Expr LESS Expr			{System.out.println("");}
       	| Expr LESSEQUAL Expr		{System.out.println("");}
       	| Expr GREATER Expr			{System.out.println("");}
       	| Expr GREATEREQUAL Expr		{System.out.println("");}
       	| Expr EQUAL Expr		{System.out.println("");}
       	| Expr NOTEQUAL Expr		{System.out.println("");}
       	| Expr AND Expr		{System.out.println("");}
       	| Expr OR Expr		{System.out.println("");}
       	| NOT Expr			{System.out.println("");}
       	| READLN LEFTPAREN RIGHTPAREN			{System.out.println("");}
       	| NEW LEFTPAREN ID RIGHTPAREN			{System.out.println("");}
       	| NEWARRAY LEFTPAREN INTCONSTANT COMMA Type RIGHTPAREN	{System.out.println("");}
       	;

Lvalue:
	ID 	{System.out.println("");}
	| Lvalue LEFTBRACKET Expr RIGHTBRACKET	{System.out.println("");}
	| Lvalue PERIOD ID	{System.out.println("");}
	;

Call:
	ID LEFTPAREN Actuals RIGHTPAREN	{System.out.println("");}
	| ID PERIOD ID LEFTPAREN Actuals RIGHTPAREN	{System.out.println("");}
	;

Actuals:
	Expr_PLUS	{System.out.println("");}
	| /* Epsilon */	{System.out.println("");}
	;

Constant:
	INTCONSTANT	{System.out.println("");}
	| DOUBLECONSTANT	{System.out.println("");}
	| STRINGCONSTANT	{System.out.println("");}
	| BOOLEANCONSTANT	{System.out.println("");}
	| NULL	{System.out.println("");}
	;

%%

private Yylex lexer;

private int yylex () {
	int yyl_return = -1;
	try {
		yylval = new ParserVal(0);
		yyl_return = lexer.yylex();
		System.out.println(" - " + yyl_return);
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