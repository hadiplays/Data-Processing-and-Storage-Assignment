# Data-Processing-and-Storage-Assignment
An in memory database with transaction support

# Setup Instructions
To setup this project you will need:
- Intellij IDE --> [Download](https://www.jetbrains.com/idea/download/?section=windows)
- Java --> [Download](https://www.java.com/download/ie_manual.jsp)

# Run Program
To run the program (Assuming you cloned the repository on your local device):
- Enter the src folder and open Main.java
- Run the main class by clicking the green arrow on the top left corner of the IDE or hitting Shift + F10

# Testing Functionalities:
If you want to create or run unit tests:
- Add junit to your program if it is not already there. To do this:
  - Go to File -> Project Structure -> Modules.
  - Then click the plus below module sdk.
  - Then click library and then from maven.
  - In the box that appears type junit.jupiter and hit enter.
  - Once a list appears select the one with version 5.5 or if that isn’t there any version >= 5.0.
  - Then click ok and then apply.
- To run the junit tests:
  - Enter the src folder and open TransactionTest.java
  - Run all the test cases the same way you run Main.java

# How This Assignment Should Be Modified:
In order for this to be a future assignment, the instructions must be fixed for claraity.
Change the instructions to clearly have each function have its own section where you explain all about it.
In the current instructions, one function might be spoken about, then another, and then it will go back and speak
on the previous function once again (such as instructions 3 - 5).
Another suggestion is changing "InMemoryDB inmemoryDB;" on Fig 2 to a different variable name and class.
This is because on Java, you cannot instantiate an interface and the class names are not case sensitive.
