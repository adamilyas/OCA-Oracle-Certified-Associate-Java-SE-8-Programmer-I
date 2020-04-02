import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import Animals.Bird;

public class JavaExamChapter3 {
    /**
     * Using operators and Decision constructs 
     *      (Test equality between String and other objects using == and equals)
     * 
     * Creating and using arrays
     *      one-d and multi-d arrays
     * 
     * Strings, StringBuilder, ArrayList, calendar data (java.time)
     * 
     * Java Data Types
     */
    static class StringMethods {

        public static void main(String[] args){
            String s = "string";
            s.length(); // 6
            s.charAt(0); // 's' s.charAt(7) throws exception: java.lang.StringIndexOutOfBoundsException: String index out of range: 7

            String newString = "strings";
            System.out.println("strings .indexOf(s) -> " + newString.indexOf("s")); // 0 : first element
            System.out.println("strings .indexOf(a) -> " + newString.indexOf("a")); // -1 : element doesnt exist in strings

            // String.indexOf(String: "string to look for", int: int to start looking for)
            System.out.println("strings .indexOf(s,1) -> " + newString.indexOf("s", 1)); // 6
            System.out.println("strings .indexOf(s,6) -> " + newString.indexOf("s", 6)); // 6

            // int substring(int beginIndex)
            // int substring(int beginIndex, int endIndex)

            System.out.println(s.startsWith("t", 1)); // offset
        }
    }

    static class StringBuilderMethods {
        public static void main(String[] args){
            StringBuilder sb = new StringBuilder("start");
            sb.append(" middle");
            System.out.println("sb after appending: " + sb);
            StringBuilder same = sb.append(" end");
            System.out.println("is same == sb ?? " + (same == sb)); // both is "start middle end"

            sb.substring(6); // this returns a  new String instead of modifying sb object
            // same.insert(100, "news"); // does not compille at runtime

            StringBuilder one = new StringBuilder("one");
            StringBuilder two = new StringBuilder("two");
            StringBuilder three = one;
            one = two;
            System.out.println(one == two);
            System.out.println(one == three);

            System.out.println(one + " " + two + " " + three);

            
        }
    }

    static class ArrayMethods {
        /**
         * 
         */
        {
            // HOW TO INIT AN ARRAY
            int[] arr = new int[3]; // easiest way to init an arr
            // int[] numbers2 = new int[] {42, 55, 99}; // not required
            int[] numbers2 = {42, 55, 99}; // init with init values : this is called anonymous array    
        }

        public static void main(String[] args){
            String[] arr = new String[2];
            System.out.println(Arrays.toString(arr));

            int[][] differentSize = {{1, 4}, {3}, {9,8,7}}; // DOEST
            System.out.println(Arrays.deepToString(differentSize));

        }
    }

    static class ArrayListMethods {
        /**
         * 
         */

        public static void main(String[] args){
            // String[] arr = {""};

            ArrayList list1 = new ArrayList();
            ArrayList list2 = new ArrayList(10);
            ArrayList list3 = new ArrayList(list2);
            System.out.println(list2);
            System.out.println(list3);

            list1.add("hawk");
            list1.add(true);
            System.out.println(list1); // [hawk, true]

            // safer
            List<String> safer = new ArrayList<>();
            safer.add("sparrow");
            safer.add(0, "hawk"); // add at the start
            System.out.println(safer);
            System.out.println(safer.set(0, "first")); // returns the element that got replace
            System.out.println(safer);

            // constant size List
            List<String> constSizeList = Arrays.asList("boy", "girl");
            List<String> anotherConstSizeList = Arrays.asList(new String[] {"boy", "girl"});

            // constSizeList.add("another boy"); // DOES NOT COMPILE
            // anotherConstSizeList.add("another boy"); // DOES NOT COMPILE


            // dynamo size List
            List<String> dynamicSizeList = new ArrayList<>(Arrays.asList("boy", "girl"));
            dynamicSizeList.add("another boy");

            // SORTING
            Collections.sort(dynamicSizeList);
        }
    }

    static class StaticAttributes {
        public static void main(String[] args){
            StaticExample e1 = new StaticExample();
            StaticExample e2 = new StaticExample();
            StaticExample.name = "new name but same everywhere";
            System.out.println(e1.getName());
            System.out.println(e2.getName());
            System.out.println(StaticExample.name);

            e2.setName("different but still the same everywhere");
            System.out.println(e1.getName());
            System.out.println(e2.getName());
            System.out.println(StaticExample.name);
            
            e1 = null;
            System.out.println(e1.name); // still can access name even though e1 -> null
        }
    }
}

class StaticInitExample {
    public static final int myConstant;
    public static final int constantConstant = 4;
    public static final int randomConstant;

    static {
        myConstant = new Random().nextInt();
        randomConstant = new Random().nextInt();

    }
    public static void main(String[] args){
        int example1 = StaticInitExample.myConstant;
        int example2 = StaticInitExample.myConstant;
        System.out.println(String.format("%s == %s : %s", example1, example2, (example1 == example2))); // true, but for every run of main(), values is different as Random()
    }
}

class StaticExample {
    public static String name = "same everywhere";
    String getName(){
        return name;
    }
    void setName(String newName){
        name = newName;
    }

    private static final ArrayList<String> values = new ArrayList<>();
    public static void main(String[] args){
        values.add("changed"); // modifying object state is OKAY. Because not reassigning reference.
        System.out.println(values.toString());
    }
}

class AttributeModifer {

    // it can change class state/attribute but not a primitive ()

    public static void staticChangeValueToFour(MyObject obj){
        obj.value = 4;
    }

    public static void staticChangeStaticValueToFour(MyObject obj){
        obj.staticValue = 4;
    }

    public static void staticChangeIntValueToThree(int i){
        i = 4;
    }

    public void ChangeValueToFour(MyObject obj){
        obj.value = 4;
    }

    public void ChangeIntValueToThree(int i){
        i = 4;
    }

    public static void main(String[] arg){
        MyObject obj = new MyObject();
        staticChangeValueToFour(obj); // modifies the state
        System.out.println(obj.value);
        staticChangeIntValueToThree(obj.value); // doesnt change the value
        System.out.println(obj.value);

        MyObject anotherObj = new MyObject();
        staticChangeStaticValueToFour(anotherObj); // modifies the state
        System.out.println(anotherObj.staticValue);
        staticChangeIntValueToThree(anotherObj.staticValue); // doesnt change the value
        System.out.println(anotherObj.staticValue);

        MyObject newObj = new MyObject();
        AttributeModifer am = new AttributeModifer();
        am.ChangeValueToFour(newObj); // modifies the state
        System.out.println(newObj.value);
        am.ChangeIntValueToThree(newObj.value); // doesnt change the value
        System.out.println(newObj.value);
    }
}

class StringModifer {

    public static void staticChangeStringToHelloWorld(String s){
        s = "HelloWorld";
    }
    public static void staticAppendHelloWorld(String s){
        s += "HelloWorld";
    }

    public static void staticChangeObjectStringToHelloWorld(MyObject obj){
        obj.string = "HelloWorld";
    }

    public static void main(String[ ]args){
        String s = new String("new String");
        staticChangeStringToHelloWorld(s); // doesnt change because immutable
        System.out.println(s); // still new string as s is being copied into the method

        staticAppendHelloWorld(s); // doesnt change because immutable
        System.out.println(s); // still new string as s is being copied into the method

        MyObject newObj = new MyObject();
        staticChangeObjectStringToHelloWorld(newObj); // change the attribute reference
        System.out.println(newObj.string);
    }
}

class MyObject {
    int value = 5;
    static int staticValue = 10;

    String string = "string";
}


class ObjectReferenceModifier {
    /**
     * THIS DOES NOT WORK.  
     */
    public static void changeObjectReference(ObjectWithName obj){
        obj = new ObjectWithName("new object"); // DOESNT WORK
    }

    public static void main(String[ ]args){
        ObjectWithName obj = new ObjectWithName("my name");
        changeObjectReference(obj);
        System.out.println(obj.name);   
    }
}

class ObjectWithName {
    String name;
    ObjectWithName(String name){
        this.name = name;
    }
}

class DefaultConstructorExample {

    public DefaultConstructorExample(String s){
        System.out.println(s);
    }

    public static void main(String[] args){
        // DefaultConstructorExample example = new DefaultConstructorExample(); // DOESNT COMPILE UNLESS U DEFINE A NO ARGS CONSTRUCTOR
    }
}

class Peacock extends Bird{

    {
        if (isAnimal) System.out.println("is Animal");
        // able to be used by Peacock class as is a child class of Bird
        // Note that bird.isAnimal is protected
    }

    public static void main(String[] args){

        Peacock peacock = new Peacock();
    }
}