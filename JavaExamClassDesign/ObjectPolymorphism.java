package JavaExamClassDesign;

public class ObjectPolymorphism {

}

/**
 * Here, regardless of the type of reference, the object itself doesnt change
 * 
 * Access to the objects methods and variables is based on the reference type.
 */
class Lemur extends Primate implements HasTail {

    public boolean isTailStriped() {
        return false;
    }

    public boolean hasTail(){
        return false;}


    public int age = 10;
    public float init;

    double t = 0xE;
    float te = 0xE;
    int tei = 0b101;


    public static void main(String[] args) {
        Lemur lemur = new Lemur();
        System.out.println(lemur.age);                  // 10

        HasTail hasTail = lemur;
        System.out.println(lemur.isTailStriped());      // false
        System.out.println(hasTail.isTailStriped());    // false
        System.out.println(lemur.hasTail());            // false
        System.out.println(hasTail.hasTail());          // false. Has been overriden.

        Primate primate = lemur;
        System.out.println(primate.hasHair());          // true
        // System.out.println(primate.isTailStriped()); // DOES NOT COMPILE.

        // UP-CASTING  (from superclass to subclass.)
        Lemur lemur2 = (Lemur) primate;
        Lemur lemur3 = (Lemur) hasTail;

        System.out.println(lemur.init);

    }
}

class Primate {
    public boolean hasHair() {
        return true;
    }
}

interface HasTail {
    public boolean isTailStriped();

    public default boolean hasTail(){return true;}
}