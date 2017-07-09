# Miniature Compiler
This is a small compiler written in java for a subset of java instructions.
## Example:
Assume we have the file `input.txt`, containing the following set of instructions:
```
i = 0
j = ++i
x = i++ + 5
y = 5 + 3 * 10
i += y
```
Then running the file using the following method: `java -jar MiniatureCompiler.jar input.txt`.
Should result with `{i=37,j=1,x=6,y=35}`.
