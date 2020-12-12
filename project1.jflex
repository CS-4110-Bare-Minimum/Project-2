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
    /*
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
     */
%eof}
%%
//rules
"boolean"       {System.out.print("BOOLEAN"); return Parser.BOOLEAN;}
"break"         {System.out.print("BREAK"); return Parser.BREAK;}
"class"         {System.out.print("CLASS"); return Parser.CLASS;}
"double"        {System.out.print("DOUBLE"); return Parser.DOUBLE;}
"else"          {System.out.print("ELSE"); return Parser.ELSE;}
"extends"       {System.out.print("EXTENDS"); return Parser.EXTENDS;}
"false"         {System.out.print("FALSE"); return Parser.FALSE;} //false or booleanconstant
"for"           {System.out.print("FOR"); return Parser.FOR;}
"if"            {System.out.print("IF"); return Parser.IF;}
"implements"    {System.out.print("IMPLEMENTS"); return Parser.IMPLEMENTS;}
"int"           {System.out.print("INT"); return Parser.INT;}
"interface"     {System.out.print("INTERFACE"); return Parser.INTERFACE;}
"new"           {System.out.print("NEW"); return Parser.NEW;}
"newarray"      {System.out.print("NEWARRAY"); return Parser.NEWARRAY;}
"null"          {System.out.print("NULL"); return Parser.NULL;}
"println"       {System.out.print("PRINTLN"); return Parser.PRINTLN;}
"readln"        {System.out.print("READLN"); return Parser.READLN;}
"return"        {System.out.print("RETURN"); return Parser.RETURN;}
"string"        {System.out.print("STRING"); return Parser.STRING;}
"this"          {System.out.print("THIS"); return Parser.THIS;}
"true"          {System.out.print("TRUE"); return Parser.TRUE;} //true or booleanconstant
"void"          {System.out.print("VOID"); return Parser.VOID;}
"while"         {System.out.print("WHILE"); return Parser.WHILE;}
{Comment}       {/* ignore */}
{integer}       {System.out.print("INTCONSTANT"); return Parser.INTCONSTANT;}
{double}        {System.out.print("DOUBLECONSTANT"); return Parser.DOUBLECONSTANT;}
{identifier}    {temp = yytext();
                 identifiers.insert(temp);
                 System.out.print("ID"); return Parser.ID;}
{newline}       {/* ignore */}
{whitespace}    {/* ignore */}
{strcon}        {System.out.print("STRINGCONSTANT"); return Parser.STRINGCONSTANT;}
"("             {System.out.print("LEFTPAREN"); return Parser.LEFTPAREN;}
")"             {System.out.print("RIGHTPAREN"); return Parser.RIGHTPAREN;}
"["             {System.out.print("LEFTBRACKET"); return Parser.LEFTBRACKET;}
"]"             {System.out.print("RIGHTBRACKET"); return Parser.RIGHTBRACKET;}
"{"             {System.out.print("LEFTBRACE"); return Parser.LEFTBRACE;}
"}"             {System.out.print("RIGHTBRACE"); return Parser.RIGHTBRACE;}
";"             {System.out.print("SEMICOLON"); return Parser.SEMICOLON;}
">"             {System.out.print("GREATER"); return Parser.GREATER;}
">="            {System.out.print("GREATEREQUAL"); return Parser.GREATEREQUAL;}
"<"             {System.out.print("LESS"); return Parser.LESS;}
"<="            {System.out.print("LESSEQUAL"); return Parser.LESSEQUAL;}
"=="            {System.out.print("EQUAL"); return Parser.EQUAL;}
"!="            {System.out.print("NOTEQUAL"); return Parser.NOTEQUAL;}
"&&"            {System.out.print("AND"); return Parser.AND;}
"||"            {System.out.print("OR"); return Parser.OR;}
"!"             {System.out.print("NOT"); return Parser.NOT;}
"="             {System.out.print("ASSIGNOP"); return Parser.ASSIGNOP;}
"+"             {System.out.print("PLUS"); return Parser.PLUS;}
"-"             {System.out.print("MINUS"); return Parser.MINUS;}
"*"             {System.out.print("MULTIPLICATION"); return Parser.MULTIPLICATION;}
"/"             {System.out.print("DIVISION"); return Parser.DIVISION;}
"%"             {System.out.print("MOD"); return Parser.MOD;}
","             {System.out.print("COMMA"); return Parser.COMMA;}
"."             {System.out.print("PERIOD"); return Parser.PERIOD;}
[^]             {throw new Error("Illegal character <" + yytext()+">"); }