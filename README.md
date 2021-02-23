# Frogger Revamped
My take on the classic game Frogger developed using JavaFX as a part of my coursework for a module called Software Maintenance (COMP2042). The goal of the coursework was to work on an existing code by maintaining, improving and adding to it. Rather than working from scratch, we were given an incomplete, messy code and were tasked with fixing it to create our own version of the game.

**IDE:** JetBrains IntelliJ IDEA 2020.2.2\
**Java Version:** 15\
**JUnit Version:** 4\
**JavaFX Version:** 11.0.2

**Tests created:** 206\
**Tests passed:** 206

## How to import and run
1. Download the zip file
2. Unzip it to the desired location
2. Open IntelliJ
3. Select Open if the Welcome screen opens (Or File -> Open from the menu)
4. Go to the directory where the ``Frogger`` folder is inside the unzipped folder
(make sure the imported folder is the ``Frogger`` folder)
5. Click Open

## Contents of Every Folder Inside the ``Frogger`` Folder
1. **Test:** JUnit tests
2. **src:** source code files
3. **out:** output files
4. **JavaDocs:** Java docs for the source code
5. **Frogger Game:** contains the executable JAR file that allows the user to run the game by double clicking
6. **.idea:** IntelliJ generated folder containing the project's settings

## Key changes made for extension and maintenance

**1)	Separated functionalities to promote single responsibility**\
In the original project, there were several large classes with multiple responsibilities. For example, the Animal class in the Models package, was responsible for the movement of the Animal object, its setting, and its behavior at a death or at an intersection with another object. After maintenance, the Animal class is solely responsible for the setting of the Animal object (its image and its initial coordinates) and another two classes were created to control the Animal object’s movement and behavior. The same behavior was followed for all classes. Large classes were broken up into smaller ones and each class now has a single responsibility. This also improved encapsulation as all related data and methods are together in one class.

**2)	Views created**\
The original project contained only one screen for the game. After maintenance and extension, more views and screens were added to it. There is now a Start screen, a Help screen, a High Scores screen, an End screen, and a Levels Menu screen. When the user starts the game, they are greeted with the Start screen through which they can access the Help screen to see how to play the game, the High Scores screen so they can view the different scores scored at different levels, an option to exit the game and the menu to select a level to play. At the end of the game, the user is displayed their high score and then a list of all high scores in that level sorted in from largest to smallest.\

**3)	More levels added**\
The original project contained only one level, but the game now has 5 levels each with a different number of obstacles at different speeds. The users can choose to play any of the levels and there are separate records kept for the high scores of each level.

**4)	Factories created**\
Following the Factory Design Pattern, two factories were created: the SelectViewFactory and the SelectModelsFactory. These factories are responsible for instantiating objects as per the caller class’ selection and help reduce the dependency between the classes as a caller class is now only dependent on the Factory rather than the class it is calling. If any class changes, changes are only reflected on the factory while the caller class remains in the unknown.

**5)	Interfaces and Abstract classes**\
Two new interfaces were created: GameViews and ActorControllers while there are also two abstract classes Actor and World. These interfaces and abstract classes were used in the constructors of classes to reduce the dependency on concrete implementations. This helps to facilitate reusability as any class that extends/implements the interfaces or abstract classes can be used and classes are not only dependent on one concrete class.

As classes now mainly communicate through Interfaces, Abstract Classes or Factories, there is a significant reduction in the dependency between them.

**6)	Executable JAR file created**\
An Executable JAR file of the game Frogger was created in the ```Frogger\Frogger Game``` directory. This allows users to directly run the game without an IDE as they would only have to double click on the ``Run Game`` file in the directory.

 ## Screenshots of the Game

**Start Screen:**\
<img src="https://i.imgur.com/KT7o9oV.png" height="550">

**Help Screen 1:**\
<img src="https://i.imgur.com/oMS0b1c.png" height="550">

**Help Screen 2 (points system):**\
<img src="https://i.imgur.com/Zsg4utr.png" height="550">

**High Scores Menu Screen:**\
<img src="https://i.imgur.com/wPfjYc9.png" height="550">

**High Scores Table Screen:**\
<img src="https://i.imgur.com/PR2M27c.png" height="550">

**Levels Menu Screen:**\
<img src="https://i.imgur.com/aW9d9ba.png" height="550">

**Level 1:**\
<img src="https://i.imgur.com/MMn4wIg.png" height="550">

**Level 2:**\
<img src="https://i.imgur.com/xj9okuW.png" height="550">

**Level 3:**\
<img src="https://i.imgur.com/W9C3f7P.png" height="550">

**Level 4:**\
<img src="https://i.imgur.com/npysxcV.png" height="550">

**Level 5:**\
<img src="https://i.imgur.com/sQ2CDw0.png" height="550">

**Display at the end of the game:**\
<img src="https://i.imgur.com/dB09OPo.png" height="550">
