package JavaExamClassDesign;

public class JavaExamInheritance {}


/**
 * Example 1: Inheriting variables and methods
 */
class Lion extends Cats {

    public static void main(String[] args){
        Cats animal = new Cats();
        System.out.println("Cat age : " + animal.getAge());
        Lion lion = new Lion();
        System.out.println("Lion age : " + lion.getAge()); // Lion inherits age and getAge
    }

}

class Cats {
    private int age = 1;
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}






/**
 * Example 2: Constructor rule
 * 
 * Constructor rules:
 *      The first statement of every constructer is a call to this() or super()
 *      super() or this() must be the first statement in the constructor
 *      if parent doesnt have a no arg constructor, must explicitly define which super constructor
 */
class Elephant extends Mammal {
    public Elephant(){ 
        super(1); // specifying which parent constructor is required as the constructer Mammal() does not exist
    }
    public Elephant(int age){
        super(age); // still required.
    }

    public Elephant(String ageValue){
        this(Integer.parseInt(ageValue)); // this() or super() is valid.
    }
}

class Mammal {
    public Mammal (int age){}
}

/**
 * Example 3: Inhertinng Exception rule
 * 
 * Inherited exception cannot be broader then parent exception.
 */
class Parent {
    int value = 10;
    public int getValue() {
        return value;
    }

    public void methodThatThrowsE() throws Exception {}

    public void anotherMethodThatThrowsE() throws Exception {}

}

class Child extends Parent {
    int value = 5; // override the parent.value
    
    public int getValue() {
        System.out.println("Overriding the parent::getValue (same method sign)");
        return value;
    }

    public int getParentValue(){
        return super.value;
    }
    public static void main(String[] args) throws NewException, AnotherException {
        Child child = new Child();

        System.out.println(child.value);
        System.out.println(child.getValue());

        child.methodThatThrowsE(); // doesn not throw e

        child.anotherMethodThatThrowsE(); // throws multiple Exception

    }

    public void methodThatThrowsE(){}

    public void anotherMethodThatThrowsE() throws NewException, AnotherException{}

}

class NewException extends Exception {}

class AnotherException extends Exception {}

/**
 * Example 4: Hidden Variables
 *      Variables are hidden not overriden.
 *      Methods are overriden unless specifically called super.methodName(). Check isOld() method.
 * 
 */
class Son extends Father {
    public int age = 15;
    public int getAge() {return age;}
    public int getFatherAge(){return super.age;}
    public int getFatherGetAge(){return super.getAge();}

    public boolean isOld(){return false;}
    public boolean isFatherOld(){return super.isOld();}


    public static void main(String[] args){
        Son son = new Son();
        System.out.println(son.age);                // 15
        System.out.println(son.getAge());           // 15
        System.out.println(son.getFatherAge());     // 50
        System.out.println(son.getFatherGetAge());  // 50

        System.out.println(son.isOld());            // false
        System.out.println(son.isFatherOld());      // true : because specifically asking the parent's method
        System.out.println(son.checkifIsOld());     // false : in this case, isOld is overriden and replaced with the method in son.

    }
}
class Father {
    int age = 50;
    public int getAge() {return age;}

    public boolean isOld(){return true;}

    public boolean checkifIsOld(){return isOld();}

}
