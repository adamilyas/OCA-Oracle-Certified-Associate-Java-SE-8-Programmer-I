
package JavaExamClassDesign;

public class JavaExamInheritanceForAbstract {}

/**
 * Abstract class:
 *      if u dont want the parent to be instantiated unless is inherted by a child class
 * 
 * Abstract method (of an abstract class) 
 *      This method MUST BE IMPLEMENTED BY CHILD CLASS
 * 
 * Final vs abstract
 *      NO. recall that FINAL cannot be extended. hence there is no final abstract class or method/.
 * 
 * Private vs abstract
 *      a method cannot be marked private and abstract. because abstract method forces implementation 
 */
class CreatingAbstractClass extends CreatingAbstractParent{
    public static void main(String[] args){
        CreatingAbstractClass child = new CreatingAbstractClass();          // compiles
        // CreatingAbstractParent parent = new CreatingAbstractParent();    // DOESNT COMPILE : because abstract

        System.out.println(child.name);
        System.out.println(child.getParentName());


    }

    public String name = "child";
    public String getName(){return name;}
    public String getParentName(){return super.name;}

    public String getValue(){return "This method must be implemented.";} // MUST BE IMPLEMENTED

}

abstract class CreatingAbstractParent {
    public String name = "parent";
    {System.out.println("[PARENT] Init.");}

    int value = 5;
    public abstract String getValue(); // no body provided here. MUST BE USED BY CHILD
}

abstract class AbstractParent extends CreatingAbstractParent{
    public abstract String printValue();
}

class ConcreteChild extends AbstractParent{
    /**
     * This class must implement:
     *      printValue
     *      getValue
     */
    public String getValue(){return "Concrete Child";};

    public String printValue(){
        String value = getValue();
        System.out.println(value);
        return value;
    };

}