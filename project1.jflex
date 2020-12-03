import java.util.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
%%

%byaccj

%{
  private Parser yyparser;

  public Yylex(java.io.Reader r, Parser yyparser) {
    this(r);
    this.yyparser = yyparser;
  }
%}

digit = [0-9]
number = {digit}+
integer = (("0X" | "0x") + ({number} | [a-fA-F])+) | {number}
decimal = {number} + "." + {number}*
double = {decimal} (("E-"|"E+"|"e+"|"e-") + {number})?
letter = [a-zA-Z]
identifier = {letter}({letter}|{digit})*
newline = \n|\r|\r\n
InputCharacter = [^\r\n]
SpecialChar = (\!|\.|\,|\\|\/|\^|\?|\#|\&|\%|\$])*
whitespace = [\t\ ]+
Comment = ({TraditionalComment} | {EndOfLineComment} | {DocumentationComment}) {newline}?
TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment     = "//" {InputCharacter}* {newline}?
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*
strcon = ("\""|"\“") + ({letter}|{whitespace}|{digit}|{SpecialChar})* + ("\""|"\”")

%{
   String output = "";
   String temp = "";
   Trie identifiers = new Trie();
%}
%eof{
      System.out.print("What should output file be called? ");
      Scanner kb = new Scanner(System.in);
      String file = kb.nextLine();
      try
      {
         BufferedWriter writer = new BufferedWriter(new FileWriter(file));
         writer.write(output);
         writer.close();
      }
      catch(IOException e)
      {
      }

      identifiers.print();

%eof}
%%
//rules
"boolean"       {return Parser.BOOLEAN;}
"break"         {return Parser.BREAK;}
"class"         {return Parser.CLASS;}
"double"        {return Parser.DOUBLE;}
"else"          {return Parser.ELSE;}
"extends"       {return Parser.EXTENDS;}
"false"         {return Parser.FALSE;} //false or booleanconstant
"for"           {return Parser.FOR;}
"if"            {return Parser.IF;}
"implements"    {return Parser.IMPLEMENTS;}
"int"           {return Parser.INT;}
"interface"     {return Parser.INTERFACE;}
"new"           {return Parser.NEW;}
"newarray"      {return Parser.NEWARRAY;}
"null"          {return Parser.NULL;}
"println"       {return Parser.PRINTLN;}
"readln"        {return Parser.READLN;}
"return"        {return Parser.RETURN;}
"string"        {return Parser.STRING;}
"this"          {return Parser.THIS;}
"true"          {return Parser.TRUE;} //true or booleanconstant
"void"          {return Parser.VOID;}
"while"         {return Parser.WHILE;}
{Comment}       {/* ignore */}
{integer}       {return Parser.INTCONSTANT;}
{double}        {return Parser.DOUBLECONSTANT;}
{identifier}    {return Parser.ID;}
{newline}       {/* ignore */}
{whitespace}    {/* ignore */}
{strcon}        {return Parser.STRINGCONSTANT;}
"("             {return Parser.LEFTPAREN;}
")"             {return Parser.RIGHTPAREN;}
"["             {return Parser.LEFTBRACKET;}
"]"             {return Parser.RIGHTBRACKET;}
"{"             {return Parser.LEFTBRACE;}
"}"             {return Parser.RIGHTBRACE;}
";"             {return Parser.SEMICOLON;}
">"             {return Parser.GREATER;}
">="            {return Parser.GREATEREQUAL;}
"<"             {return Parser.LESS;}
"<="            {return Parser.LESSEQUAL;}
"=="            {return Parser.EQUAL;}
"!="            {return Parser.NOTEQUAL;}
"&&"            {return Parser.AND;}
"||"            {return Parser.OR;}
"!"             {return Parser.NOT;}
"="             {return Parser.ASSIGNOP;}
"+"             {return Parser.PLUS;}
"-"             {return Parser.MINUS;}
"*"             {return Parser.MULTIPLICATION;}
"/"             {return Parser.DIVISION;}
"%"             {return Parser.MOD;}
","             {return Parser.COMMA;}
"."             {return Parser.PERIOD;}
[^]             {throw new Error("Illegal character <" + yytext()+">"); }