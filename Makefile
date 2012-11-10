run: compile
	java -jar hockey.jar

compile:
	javac -cp .:hockey.jar team25/*.java

deps:
	javac -cp .:hockey.jar samples/*.java
	javac -cp .:hockey.jar teamTemplate/*.java
