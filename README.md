# Project-2

Outline: You are to implement a syntax analyzer for the programming language Toy, as defined in project #1. You should first design a CFG G for Toy based on the following Backus Normal Form (BNF) description, and then write a program to...
(1) create a parsing table for G 
(2) perform a one-symbol lookahead parsing on various input Toy programs and print appropriate parsing actions

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
5. Now with the Byaccj zip downloaded, you must unzip the file into somewhere you will remember such as C:\byaccj
6. Now you must add Byaccj to PATH
7. With Byaccj added to PATH, you must open up command prompt and cd to the directory of the files - cd target-path-here
8. Issue the command byaccj -j Parser.y and you will get Parser.java
9. Issue the command byaccj -v Parser.y and you will get y.output
10. Compile the Parser.java with JAVA using the command javac Parser.java
11. Now run the command java Parser and input which file you want to analyze
