This is a simple port of the Mandelbrot set generation program as described by Jim Blandy
is his seminal book, "Programming Rust". Creative liberties have been taken in this project,
and this attribution must be considered just that - an attribution to the original author of
the idea.

This first iteration will handle the operation using a single thread of execution. The next step
will be to improve performance using one thread per CPU core.


## Usage

If using Maven on the command-line:

```
$ mvn exec:java -Dexec.args="FILE PIXELS UPPERLEFT LOWERRIGHT"
```

Sample invocation:

```
$ mvn exec:java -Dexec.args="mandel.png 1000x750 -1.20,0.35 -1.0,0.20"

```

## Build

You can import the Maven project into your IDE of choice - Eclipse, IntelliJ, and NetBeans should be able to import this project
without any problems.

Just to be IDE-agnostic, here is how you can compile and build the project from the command-line. Ensure that you have the latest
version of `Maven` installed on your machine.

Assuming your are inside the project root,

```
$ mvn clean && mvn compile

```

and, optionally,

```
$ mvn package

```

if you want to generate a JAR file. 


## Demo

```
Macushla:Projects z0ltan$ cd mandelbrot-fractals/
Macushla:mandelbrot-fractals z0ltan$ mvn clean && mvn compile
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building mandelbrot-fractals 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 0.241 s
[INFO] Finished at: 2017-06-27T17:01:46+05:30
[INFO] Final Memory: 12M/41M
[INFO] ------------------------------------------------------------------------
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building mandelbrot-fractals 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1.274 s
[INFO] Finished at: 2017-06-27T17:01:48+05:30
[INFO] Final Memory: 13M/45M
[INFO] ------------------------------------------------------------------------

Macushla:mandelbrot-fractals z0ltan$ mvn exec:java -Dexec.args="my-mandelbrot.png 1024x768 -1.20,0.35 -1.0,0.20"
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building mandelbrot-fractals 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- exec-maven-plugin:1.6.0:java (default-cli) @ mandelbrot-fractals ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1.175 s
[INFO] Finished at: 2017-06-27T17:02:44+05:30
[INFO] Final Memory: 7M/26M
[INFO] ------------------------------------------------------------------------

```

And the following image file is generated from these parameters:

![mandel-java.png](https://raw.githubusercontent.com/timmyjose/mandelbrot-fractals/master/sample-image/mandel-java.png)




