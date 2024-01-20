if not exist bin mkdir bin
javac -d bin/ -sourcepath src/ src/dodge/Main.java
java -cp bin/ dodge.Main