# Java Beans - Reflection

Create the non-visual Java bean TempSensor that implements a temperature sensor (if you use NetBeans create the bean in the project TempSensor and in the package tempsensor). 

The idea is that this bean periodically, for example every second, reads the current temperature and makes it available as the property currentTemp of type float. 
The class TempSensor must have also the method void go() that starts the sensing. 

To implement the sensing use the class Timer to periodically generate a random float value in the range [-20,50] through the class Random and assign it to the property currentTemp. 
Note that every time the value of currentTemp changes TempSensor must notify that event through a PropertyChangeEvent. 

Export the bean TempSensor Exercise 1 in the jar file TempSensor.jar.

__Solution format: Source java file TempSensor.java and jar file TempSensor.jar.__