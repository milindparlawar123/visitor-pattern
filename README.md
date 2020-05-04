# CSX42: Assignment 5
## Name: Milind Keshav Parlawar

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in visitor/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

```commandline
ant -buildfile visitor/src/build.xml clean
```

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

```commandline
ant -buildfile visitor/src/build.xml all
```

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

#### Use the below command to run the program.

ant run -buildfile visitor/src/build.xml -Dinput="input.txt" -DacceptableWordsFile="acceptable_words.txt" -Dk="2" -DtopKOutputFile="topk_output.txt" -DspellCheckOutputFile="spellcheck_output.txt"

provide your files name in place of above given files name.

-----------------------------------------------------------------------
## Description:
1. Driver class takes 5 arguments - input file, acceptable words file, max size of the list containing the most frequent words, top K output File and spell checkOutput File.
2. Driver validator class validates to check whether provided inputs are valid or not.
3. Driver class initializes required classes and call methods of those classes.
4. Driver class calls MyArrayList class build method to read input file.
5. Driver class calls accept method of MyArrayList class and passes visitor.
6. Particular visitor class gets called to do processing of most frequent words of sentence and to spell check of words. 
7. finally persistResult method of driver calls result classes, result data will be written into output file.

Data Structure: 
 I have used PriorityQueue and ArrayList. 

References:
https://leetcode.com/problems/top-k-frequent-words/discuss/108346/My-simple-Java-solution-using-HashMap-and-PriorityQueue-O(nlogk)-time-and-O(n)-space
https://stackoverflow.com/questions/29872664/add-key-and-value-into-an-priority-queue-and-sort-by-key-in-java/29873362
https://www.journaldev.com/20601/java-bufferedwriter 
https://www.journaldev.com/19879/java-bufferedreade

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 05/04/2020

Note: I have used 2 slack day for this assignment.


