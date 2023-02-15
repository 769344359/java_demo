#!/bin/bash
javac  LoopMayNeverEnd/LoopMayNeverEnd.java   -d  target
javap -c target/LoopMayNeverEnd.class