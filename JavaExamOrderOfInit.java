public class JavaExamOrderOfInit extends InitSuperClass {
    /**
     * Order of Init:
     *      1. Super Class - static
     *      2. static variables and initializers (in the order they appear)
     *      3. instance variables and initializers (in the order they appear)
     *      4. The Constructor
     */
    public static void main(String[] args){
        System.out.println("[THIS : MAIN] Main method. After static, before Constructor init.");
        JavaExamOrderOfInit example = new JavaExamOrderOfInit(); // init via constructor
    }

    public static String staticStr;
    static {
        System.out.println("[THIS : STATIC]");
        staticStr = "[THIS : STATIC] first static variable to init";
        System.out.println(staticStr);

    }

    public String str;
    {str = "[THIS : INSTANCE] after static"; System.out.println(str);}

    public JavaExamOrderOfInit(){
        System.out.println("[THIS : CONSTRUCTOR] is last to run.");
    }
}

class InitSuperClass extends InitSuperSuper {
    static { System.out.println("[SUPER : STATIC]");}
    {System.out.println("[SUPER : INSTANCE]");}
    public InitSuperClass(){System.out.println("[SUPER : CONSTRUCTOR]");}
}

class InitSuperSuper {
    // static { System.out.println("[SUPER-SUPER : STATIC]");}
    // {System.out.println("[SUPER-SUPER : INSTANCE]");}
    // public InitSuperSuper(){System.out.println("[SUPER-SUPER : CONSTRUCTOR]");}
}