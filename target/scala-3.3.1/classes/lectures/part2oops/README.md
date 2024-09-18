# Object Oriented Programming 

### Defining a class
- ```class Person(name: String, age: Int)```

### Instantiating or Creating the object or Creating an Instance of a class (Create outside the class)
- ```val person = new Person("Sohaib",21)```

### To print the parameters, you should declare them as val or var within the class so they become accessible as fields.
- ```class Person(val name: String, val age: Int )```
- ```prinln(person.name + " " + person.age) // Sohaib 21```
<br>
<br>
- <b>'this'</b> keyword refers to the parameter of the object (of the class),

### Defining methods
- ```def greet(): String = { ... }```

### Calling methods
- ```val bobSaysHi = bob.greet```