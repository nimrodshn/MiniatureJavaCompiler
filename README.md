# Miniature Compiler
This is a small compiler written in java for a subset of java instructions.

## How to run the application:
Running the application is done from MiniatureCompiler class (That is the entrypoint of the application).
You can also change the first line the main function to accept input from command line arguments which will allow you to run the application from the command line once it is compiled,
using the following line: `java -jar MiniatureCompiler.jar input.txt`.

## Example:
Assume we have the file `input.txt`, containing the following set of instructions:
```
i = 0
j = ++i
x = i++ + 5
y = 5 + 3 * 10
i += y
```
Running the application on the file should result with `{i=37,j=1,x=6,y=35}`.
