# Java Exam: OCA 1

## Order of initialisation
- Superclass
- static initializers and variables
- instance initializers and variables
- constructors

```java
class Egg {
    public Egg(){
        number = 5;
    }

    public static void main(String[] args){
        Egg egg = new Egg();
        System.out.println(egg.number);
    }

    // in order.
    private int number = 3;
    {number = 4;} // must be in code block
}
```
- number is initialised as 3
- number is changed to 4
- When constructor is called, number is changed to 5

## Java Primitive types
byte -> -128 to 127