# Project-2

Outline: You are to implement a syntax analyzer for the programming language Toy, as defined in project #1. You should first design a CFG G for Toy based on the following Backus Normal Form (BNF) description, and then write a program to...
(1) create a parsing table for G 
(2) perform a one-symbol lookahead parsing on various input Toy programs and print appropriate parsing actions

Java - https://www.oracle.com/java/technologies/javase-downloads.html

JFlex Installation - https://www.jflex.de/  
JFlex Installation Help - https://www.jflex.de/manual.html#Installing  
JFlex 1.8.2 

Byaccj Download - http://byaccj.sourceforge.net/#download
Byaccj 1.15

How to compile and run JFLEX
1. With JFlex installed and added to PATH, you need to open the command prompt/terminal window.
2. Change to the directory of the files using the cd command - cd target-path-here
3. Run JFlex by issuing the jflex command on the .jflex file - jflex project1.jflex
4. If done corectly, JFlex will output a .java file called Yylex.java

How to compile and run Byaccj
1. Now with the Byaccj zip downloaded, you must unzip the file into somewhere you will remember such as C:\byaccj
2. Now you must add Byaccj to PATH
3. With Byaccj added to PATH, you must open up command prompt and cd to the directory of the files - cd target-path-here
4. To get Parser.java issue the command - byaccj -J Parser.y
5. To get y.output issue the command - byaccj -v Parser.y
6. Compile the Parser.java with JAVA using the command - javac Parser.java
7. Now run the command - java Parser
8. Enter the input you wish to analyze i.e input1.txt
