# Trump-Bovary
 Generates pseudo-random text from respectively all chapters of Madame Bovary (by Flaubert) or D. Trump's speeches

If wanted, modify "n" in either Trump.java or Bovary.java : it refers to the number of succeeding words to consider :
DEFAULT : If n=3, every 3-words sequence in the generated text will be present somewhere in the database. 
If n=1, the text is completely random (and makes no sense whatsoever)
If n is too big, the generated text will just be a whole random chapter/speech

RUN:
$ javac -d ./bin  ./src/*.java
$ cd bin
$ java Trump (or java Bovary) > output.txt
