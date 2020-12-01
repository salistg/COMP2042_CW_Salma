# COMP2042_CW_Salma
COMP2042 Software Maintenance Coursework.

**IDE:** JetBrains IntelliJ IDEA 2020.2.2\
**Java Version:** 15\
**JUnit Version:** 4\
**JavaFX Version:** 11.0.2

**Tests created:** 206\
**Tests passed:** 206

**Key changes made for extension and maintenance:**

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
An Executable JAR file of the game Frogger was created in the ```Frogger\out\artifacts\Frogger_jar2``` directory. This allows users to directly run the game without an IDE as they would only have to double click on the .bat file in the directory.

 **Screenshots of the Game:** 

**Start Screen:**\
![start screen screenshot](https://i.imgur.com/KT7o9oV.png)

**Help Screen 1:**\
![help screen screenshot](https://i.imgur.com/oMS0b1c.png)

**Help Screen 2 (points system):**\
![help screen screenshot (points system)](https://i.imgur.com/Zsg4utr.png)

**High Scores Menu Screen:**\
![high scores menu screenshot](https://i.imgur.com/wPfjYc9.png)

**High Scores Table Screen:**\
![high scores table screenshot](https://i.imgur.com/PR2M27c.png)

**Levels Menu Screen:**\
![levels menu screenshot](https://i.imgur.com/aW9d9ba.png)

**Level 1:**\
![level 1 screenshot](https://i.imgur.com/MMn4wIg.png)

**Level 2:**\
![level 2 screenshot](https://i.imgur.com/xj9okuW.png)

**Level 3:**\
![level 3 screenshot](https://i.imgur.com/W9C3f7P.png)

**Level 4:**\
![level 4 screenshot](https://i.imgur.com/npysxcV.png)

**Level 5:**\
![level 5 screenshot](https://i.imgur.com/sQ2CDw0.png)

**Display at the end of the game:**\
![a screenshot of the display at the end of the game](https://i.imgur.com/dB09OPo.png)














