# The Legend of Perlin

## URCA's first year final project
### TLoP
This project was made by four students in 2021 (Kouadjo, Brian, Ylon, Sébastien) and is today maintained by me. We were instructed to make a small minigame in Java, using the library Swing as a way to display the game. There are a lot of issues within the code which I won't fix, so it probably shouldn't be used as a starting point.

### How to compile
You can either use CMake or Ant to compile the project, or you can compile the sources by yourself and build a jar out of it. Note that the project was developped under Java 16, so compiling using an older version may have undesired effects.

CMake (Unix)
```bash
mkdir out && cd out && cmake ../
```

Ant (Unix & Windows)
```bash
ant
```
### Build directory & starting
The generated jar can be found in the "out" folder. Starting the jar:
```bash
java -jar TLOP.jar
```
