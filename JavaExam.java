import java.util.ArrayList;
import java.util.List;

// package JavaExamTutorial;

public class JavaExam {
    public static void main(String[] args){

        Chicken.method(); // doesnt call other code

        new Chicken(); // initialised code outside first.

    }

    static class orderOfOperation {
        /*
        first, increment/decrement based on pre/post unary operators
        then. do arithmetic operations
        */
        public static void main(String args[]){

            int x = 3;
            int y = ++x * 5 / x-- + --x; // 4 * 5/4  + 2
            System.out.println("x is " + x);
            System.out.println("result is " + y);
            System.out.println(4 * 5/4  + 2);

            long lb = 0b101;
            float bf = 0b101;
            long lh = 0xE;
            float fh = 0xF; // not G

            long lo = 10; // can
            long lon = 10000000000000L; // if is out of int range, can

            int xa = 4;
            long ya = xa * 4 - xa++; // 4 * 4 - 4
            System.out.println(ya);
            if(y<10) System.out.println("Too Low");
            else System.out.println("Just right");

            xa = 5;
            System.out.println(xa > 2 ? xa < 4 ? 10 : 8 : 7);
            System.out.println((xa > 2) ? (xa < 4 ? 10 : 8) : 7);

            int x1 = 50, x2 = 75;
            boolean b = x1 >= x2;
            System.out.println(b);
            System.out.println((b=true)); // true
            System.out.println((b=false)); // false

            System.out.println(x1=60); // 60
        }
    }


    static class numericPromotion {
        /**
         * 1. Promote to larger of data types
         * 2. integral and floating point -> floating point
         * 3. (byte, short, char) promoted to int if used with operator
         */
        public static void main(String args[]){
            int x = 1; long y = 33;
            Object xy = x*y;
            System.out.println(xy.getClass());
    
            float yFloat = 2.1f; // must have f
            System.out.println(yFloat);
        }

    }

    static class primitiveNumbers {
        // byte -128 to 127 (8bit hence 2^8 values (256))
        // short : 18 bits
        // int has 32 bits hence 2^32 values. Largest int : (2^32)/2-1
        // long : 64 bits. 
        public static void main(String args[]){
            byte b = 127;
            ++b;
            System.out.println("Adding 1 to byte(127) : " + b);

            int maxInt = Integer.MAX_VALUE;
            System.out.println(++maxInt);
        }
    }

    static class numericLiterals {
        /**
         * numeric literals is a feature added in Java 7. You
         * can have underscores in numbers to make them easier to read
         */
        public static void main(String args[]){
            // double notAtStart = _1000.00; // DOES NOT COMPILE
            // double notAtEnd = 1000.00_; // DOES NOT COMPILE
            // double notByDecimal = 1000_.00; // DOES NOT COMPILE
            // double notByDecimal2 = 1000._00; // DOES NOT COMPILE
            double annoyingButLegal = 1_00_0.0_0; // this one compiles

            int legalInt = 1_000;

            float legalFloat = 1_000.000f;

        }
    }

    static class DefaultInit {
        /**
         * Instance and class variables do not require you to initialize them.
         * They will be initia
         * boolean : false
         * byte, short, int, long : 0
         * float, double : 0.0
         * char \u0000'
         * all other object reference: null 
         */
        private boolean bool; // TODO: ???
        byte b; short s; int i; long l;
        float f; double d;
        public char c;
        Chicken chicken;
        public static void main(String args[]){
            DefaultInit test = new DefaultInit();
            System.out.println(String.format("bool : %s", test.bool));
            System.out.println(String.format("char : %s", test.c));

            test.bool = true;
            test.c = 'c';

            System.out.println(String.format("bool : %s", test.bool));
            System.out.println(String.format("char : %s", test.c));
        }
    }

    static class SwitchStatment {

        public static void main(String args[]){
            int variableToTest = 0;
            switch (variableToTest) {
                case 5:
                case 0:
                    System.out.println("variable: 0");
                case 1:
                    System.out.println("variable: 1");
                    break;   
                default:
                    System.out.println("default: rest");
                    break;
            }
        }
    }

    static class FinalKeyWord {

        public static void main(String args[]){
            final String[] names = new String[3];
            names[0] = "Lisa";
            names[1] = "Kevin";
            names[2] = "Roger";
            names[0] = "adam"; // state of object can be changed

            // names = new String[] {"1", "2", "3"}; // DOESNT COMPILE: cannot reassign final variable.
        }
    }

    static class OptionalLabelForFlowControl {

        public static void main(String args[]){
            int[] arr = {1,2,3};
            for (int i : arr){
                for (int j : arr){
                    System.out.println(String.format("i : %s, j : %s", i, j));
                    if (i == 2 && j == 2){
                        System.out.println("break");
                        break;
                    }
                }
            }

            System.out.println("\nOptional Label Example: ");
            OUTER_LOOP: for (int i : arr){
                INNER_LOOP: for (int j : arr){
                    System.out.println(String.format("i : %s, j : %s", i, j));
                    if (i == 2 && j == 2){
                        System.out.println("break");
                        break OUTER_LOOP;
                    }
                }
            }
        }
    }

    static class MoreOptionalLabel {



        public static void main(String[] s){
            int count = 0;
            ROW_LOOP: for(int row = 1; row <=3; row++)
                for(int col = 1; col <=2 ; col++) {
                    System.out.println("row: " + row + " col: " + col);
                    if(row * col % 2 == 0) continue ROW_LOOP;
                        count++;
                }
            System.out.println(count);

        }
    }
}


class Chicken {

    public Chicken(){
        System.out.println("In constructor");

        System.out.println(intAttribute);
    }

    public static void method(){
        System.out.println("static Chicken::method");
    }

    public static void main(String[] args){
        new Chicken();

    }

    // Upon init. via constructor, these runs in order.
    {System.out.println("In class, outside constructor");}
    int intAttribute = 1;
    {intAttribute++;} 
}

class Duck {

    public List<Duck> duckList = new ArrayList<>();

    Duck(){
        System.out.println(this);
    }

    public void addSelfDuck(){
        duckList.add(this);
    }

    public static void main(String[] args){
        Duck duck = new Duck();
        duck.addSelfDuck();
        for (Duck d : duck.duckList){
            System.out.println(d);
        }


    }

}