#!/bin/bash
## build
javac doublechecklock/PartiallyInitialized.java doublechecklock/Builder.java doublechecklock/PartiallyInitializedObject.java  -d target
## run
java -cp target  PartiallyInitialized