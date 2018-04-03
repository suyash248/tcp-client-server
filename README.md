# TCP Client & Server 

**TCP Client & Server in Scala, Python3, Node.js**

***

## Scala

### Requirements
 - JDK 1.8.x
 - Scala 2.12.x (defined under `../build.sbt`)
 - sbt 1.1.x (defined under `..project/build.properties`)

### How to run?
Project can be run either by using an IDE(`eclipse`, `IntelliJ`) or via `sbt` console.

#### Using IDE -

- ***Server*** 
  1. Refresh & build project to install required dependencies.
  2. Import `<project-dir>/scala/tcp-server` project to IDE. 
  3. Run `Main.scala`.
  
- ***Client*** 
  1. Refresh & build project to install required dependencies.
  2. Import `<project-dir>/scala/tcp-client` project to IDE. 
  3. Run `Main.scala`.

#### Using sbt console -

- ***Server*** 
  1. Move to ```<project-dir>/scala/tcp-server``` and enter into `sbt` console -
    ```sh
    $ cd <project-dir>/scala/tcp-server
    $ sbt
    > 
    ```
  2. Install plugins and dependencies under `sbt` console - 
    ```sh
    > reload
    > update
    ```
  3. Run server as - 
    ```sh
    > run
    ```
 
- ***Client*** 
  1. Move to ```<project-dir>/scala/tcp-client``` and enter into `sbt` console -
    ```sh
    $ cd <project-dir>/scala/tcp-client
    $ sbt
    > 
    ```
  2. Install plugins and dependencies under `sbt` console - 
    ```sh
    > reload
    > update
    ```
  3. Run server as - 
    ```sh
    > run
    ```

***

## Python3

### Requirements
 - Python3

> Note: `server.py` creates single threaded server and can handle single connection at a time. Although it can be easily be extended to support multiple connections.

### How to run?

- ***Server*** 
  Run server as -
  
  ```sh
  $ python3 <project-dir>/python3/server.py
  ```
  
- ***Client*** 
  Run client as - 
  
  ```sh
  $ python3 <project-dir>/python3/client.py
  ```
