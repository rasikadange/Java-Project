CCRM (Campus Course & Records Manager)
A Java Project by Rasika Dange

Repo: (https://github.com/rasikadange/Java-Project)
Hey there. So this is CCRM, a little command-line project I built. Honestly, the main reason I made this was to really sink my teeth into some modern Java features. The idea was simple: build a tool to manage basic college stuff like student records, courses, and grades. Something practical, you know? It runs completely in the console.

It's pretty straightforward. You can add and remove students or courses, mess with their info, and enroll them in classes. I put in a small check to make sure no student takes on more than 18 credits, just for fun. It also handles grading and can spit everything out to CSV files if you need to export the data. Or import from them, for that matter. A lot of the data-crunching parts, like a search tool I added, are powered by Java's Streams API. It made filtering and finding things way cleaner. For the file import/export stuff, I used the newer NIO.2 library.

The whole thing is built on Java SE, which is the standard edition for apps like this. No need for the heavy enterprise stuff. And all the code is structured around basic OOP principles. I tried to do it right, so you'll see examples of inheritance (the Student class builds on a general Person class), encapsulation with private fields, and stuff like that. I even used the Singleton pattern for my configuration manager, which was a good learning exercise.

Wanna run it?
You'll need JDK 21 or something newer.

First, just clone the repo to your machine using the link above. From there, you'll have to compile it. Open your terminal in the project directory and run this command:

javac -d bin src/edu/ccrm/cli/Main.java

That just tells the Java compiler where to find the main source file and where to stick the compiled output (the bin folder). After that's done, you can actually run the program with this:

java -ea -cp bin edu.ccrm.cli.Main

A quick heads-up on that command: -ea means "enable assertions." I have some sanity checks in the code that only run when you use that flag. It's good for catching bugs. The -cp bin part just tells Java to look in the bin folder for the compiled code.

Once it's running, you'll see the menu. There's some test data in the test-data folder you can use to see how it works.# Java-Project
