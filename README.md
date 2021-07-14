This is a small compilator in java that uses ANTLR as a lexer and parser

After parsing our grammar we check lexical errors, generate Quadruples, and then assembly code using the visitor class to walk our tree

# Depencencies
* install JAVA 
* download ANTLR (you can download it [here](https://www.antlr.org/download.html)) and add it to your project

# HOW TO RUN IT

## Generate the ANTLR Graph
You can generate the ANTLR graph from the file grammar/tiny_parser.g4

## Run the rest of the project
You can simply run the class "Launch.java" that execute the compiler on a test file.

# Project Structure
* The Lexer and Parser rules are defined in the grammar package
* The generated files package contains the ANTLR generated files
