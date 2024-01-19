if not exist bin mkdir bin
javac -d bin/ -sourcepath src/ src/swordfighting/Main.java
java -cp bin/ swordfighting.Main 