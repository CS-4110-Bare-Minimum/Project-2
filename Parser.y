%{
  import java.io.*;
  import java.util.Scanner;
%}

%token BOOLEAN BREAK CLASS DOUBLE ELSE EXTENDS FALSE FOR IF IMPLEMENTS INT INTERFACE NEW
%token NEWARRAY NULL PRINTLN READLN RETURN STRING THIS TRUE VOID WHILE INTEGER DOUBLE ID ID_PLUS NL STRCON
%token LEFTPAREN RIGHTPAREN LEFTBRACKET RIGHTBRACKET LEFTBRACE RIGHTBRACE SEMICOLON COMMA
%token INTCONSTANT DOUBLECONSTANT STRINGCONSTANT BOOLEANCONSTANT

%left LEFTBRACKET RIGHTBRACKET PERIOD
%left NOT NEG
%left MULTIPLICATION DIVISION MOD
%left PLUS MINUS
%left LESS LESSEQUAL GREATER GREATEREQUAL
%left EQUAL NOTEQUAL
%left AND
%left OR
%left ASSIGNOP
      
%%
Program:
	Decl	{System.out.println("[Reduce");}
	;

Decl:
	VariableDecl	{System.out.println("[Reduce ");}
	| FunctionDecl	{System.out.println("[Reduce");}
	| ClassDecl	{System.out.println("[Reduce");}
	| InterfaceDecl	{System.out.println("[Reduce");}
	;

VariableDecl:
	Variable	{System.out.println("[Reduce");}
	;

Variable:
	Type	{System.out.println("[Reduce");}
	| ID	{System.out.println("[Reduce");}
	;

Type:
	INT	{System.out.println("[Reduce");}
	| DOUBLE	{System.out.println("[Reduce");}
	| STRING	{System.out.println("[Reduce");}
	| Type LEFTBRACKET RIGHTBRACKET	{System.out.println("[Reduce");}
	| ID	{System.out.println("[Reduce");}
	;

FunctionDecl:
	Type ID LEFTPAREN Formals RIGHTPAREN StmtBlock	{System.out.println("[Reduce");}
	| VOID ID LEFTPAREN Formals RIGHTPAREN StmtBlock	{System.out.println("[Reduce");}
	;

Formals:
	Variable_PLUS	{System.out.println("[Reduce");}
	| /* Epsilon */	{System.out.println("[Reduce");}
	;

Variable_PLUS:
	Variable	{System.out.println("[Reduce");}
	| Variable_PLUS COMMA Variable	{System.out.println("[Reduce");}
	;


ClassDecl:
	CLASS ID EXTENDS ID IMPLEMENTS ID_PLUS COMMA LEFTBRACE Field_PLUS RIGHTBRACE	{System.out.println("[Reduce");}

Field:
	VariableDecl	{System.out.println("[Reduce");}
	| FunctionDecl	{System.out.println("[Reduce");}
	;

Field_PLUS:
        Field	{System.out.println("[Reduce");}
        | Field_PLUS COMMA Field	{System.out.println("[Reduce");}
        ;

InterfaceDecl:
	INTERFACE ID	{System.out.println("[Reduce");}
	;

Prototype:
	Type ID LEFTPAREN Formals RIGHTPAREN	{System.out.println("[Reduce");}
	| VOID ID LEFTPAREN Formals RIGHTPAREN	{System.out.println("[Reduce");}
	;

StmtBlock:
	VariableDecl	{System.out.println("[Reduce");}
    	| Stmt		{System.out.println("[Reduce");}

Stmt:
    	IfStmt		{$$ = $1;}
    	| WhileStmt    	{$$ = $1;}
    	| ForStmt      	{$$ = $1;}
    	| BreakStmt    	{$$ = $1;}
    	| ReturnStmt   	{$$ = $1;}
    	| PrintStmt    	{$$ = $1;}
    	| StmtBlock    	{$$ = $1;}
    	;

IfStmt:
	IF LEFTPAREN Expr RIGHTPAREN Stmt ELSE Stmt	{System.out.println("[Reduce");}
	;

WhileStmt:
	WHILE LEFTPAREN Expr RIGHTPAREN Stmt	{System.out.println("[Reduce");}
	;

ForStmt:
	FOR LEFTPAREN Expr SEMICOLON Expr SEMICOLON Expr RIGHTPAREN Stmt	{System.out.println("[Reduce");}
	;

BreakStmt:
	BREAK	{System.out.println("[Reduce");}
	;

ReturnStmt:
	RETURN Expr	{System.out.println("[Reduce");}
	;

PrintStmt:
	PRINTLN LEFTPAREN Expr_PLUS COMMA RIGHTPAREN	{System.out.println("[Reduce");}
	;

Expr:
	Lvalue '=' Expr 		{System.out.println("[Reduce");}
	| Constant			{System.out.println("[Reduce");}
	| Lvalue			{System.out.println("[Reduce");}
	| THIS				{System.out.println("[Reduce");}
	| Call				{System.out.println("[Reduce");}
	| LEFTPAREN Expr RIGHTPAREN	{System.out.println("[Reduce");}
       	| Expr '+' Expr        		{System.out.println("[Reduce");}
       	| Expr '-' Expr        		{System.out.println("[Reduce");}
       	| Expr '*' Expr        		{System.out.println("[Reduce");}
       	| Expr '/' Expr        		{System.out.println("[Reduce");}
       	| Expr '%' Expr			{System.out.println("[Reduce");}
       	| '-' Expr  %prec NEG 		{System.out.println("[Reduce");}
       	| Expr '<' Expr			{System.out.println("[Reduce");}
       	| Expr '<=' Expr		{System.out.println("[Reduce");}
       	| Expr '>' Expr			{System.out.println("[Reduce");}
       	| Expr '>=' Expr		{System.out.println("[Reduce");}
       	| Expr '==' Expr		{System.out.println("[Reduce");}
       	| Expr '!=' Expr		{System.out.println("[Reduce");}
       	| Expr '&&' Expr		{System.out.println("[Reduce");}
       	| Expr '||' Expr		{System.out.println("[Reduce");}
       	| '!' Expr			{System.out.println("[Reduce");}
       	| READLN LEFTPAREN RIGHTPAREN			{System.out.println("[Reduce");}
       	| NEW LEFTPAREN ID RIGHTPAREN			{System.out.println("[Reduce");}
       	| NEWARRAY LEFTPAREN INTCONSTANT COMMA Type RIGHTPAREN	{System.out.println("[Reduce");}
       	;

Expr_PLUS:
	Expr	{System.out.println("[Reduce");}
        | Expr_PLUS COMMA Expr	{System.out.println("[Reduce");}
        ;

Lvalue:
	ID	{System.out.println("[Reduce");}
	| Lvalue LEFTBRACKET Expr RIGHTBRACKET	{System.out.println("[Reduce");}
	| Lvalue PERIOD ID	{System.out.println("[Reduce");}
	;

Call:
	ID LEFTPAREN Actuals RIGHTPAREN	{System.out.println("[Reduce");}
	| ID PERIOD ID LEFTPAREN Actuals RIGHTPAREN	{System.out.println("[Reduce");}
	;

Actuals:
	Expr_PLUS COMMA	{System.out.println("[Reduce");}
	| /* Epsilon */	{System.out.println("[Reduce");}

Constant:
	INTCONSTANT	{System.out.println("[Reduce");}
	| DOUBLECONSTANT	{System.out.println("[Reduce");}
	| STRINGCONSTANT	{System.out.println("[Reduce");}
	| BOOLEANCONSTANT	{System.out.println("[Reduce");}
	| NULL	{System.out.println("[Reduce");}
	;

%%

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