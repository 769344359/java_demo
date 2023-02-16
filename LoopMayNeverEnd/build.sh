#!/bin/bash
javac  LoopMayNeverEnd/LoopMayNeverEnd.java   -d  target
javap -c target/LoopMayNeverEnd.class



### visible 
javac LoopMayNeverEnd/Visiable.java  -d target/
java -cp target/ Visible 