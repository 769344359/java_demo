#!/bin/bash
javac  counter/IncrementTestDemo.java   -d  target
javap -c target/IncrementTestDemo.class
