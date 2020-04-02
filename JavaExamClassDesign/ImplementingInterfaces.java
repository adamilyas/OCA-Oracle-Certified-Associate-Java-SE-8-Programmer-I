package JavaExamClassDesign;

/**
 * All interface methods are public
 * 
 * A concrete class can implement multiple interfaces
 * 
 * Final vs interface. because interface is assumed to be abstract, but final cannot be extended..
 * 
 * default keyword is for interface. Hence, it not abstracted, doesnt force implementation but is method is inherited
 * 
 * In multiple inheritance of interfaces, 2 default methods of the same signature cannot conflict.
 *      This can be solve by the child, declaring its own impl.
 * 
 */
public class ImplementingInterfaces{

}

// abstract is assumed
abstract interface MyInterface {

    public static final String staticName = "My Interface";     // static final is assumed
    public abstract void abstractMethodToImplement();           // public abstract is assumed 

    public String name = "name: my interface";
} 

interface OtherInterface {
    public void otherMethodToImplement();

    /**
     * default can only be declared within an interface. and has a method body.
     * Not assumed to be final, abstract or static as can be overriden.
     * Cannot be private
     */
    public default void defaultMethod(){
        System.out.println("This is a method from Other Interface and can be overriden.");
    }
}

interface AnotherInterface extends OtherInterface {}

class MyInterfaceImpl implements MyInterface, OtherInterface {
    public void abstractMethodToImplement(){}                   // Must be implemented/
    public void otherMethodToImplement(){}                      // first concert class must implement.

    public static void main(String[] args){
        MyInterfaceImpl impl = new MyInterfaceImpl();
        System.out.println(impl.name);
        // impl.name = "name: new name"; // DOES NOT COMPILE : interface variable is assumed to be static and final

    }
}