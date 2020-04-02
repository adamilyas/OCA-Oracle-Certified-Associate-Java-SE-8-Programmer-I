package JavaExamClassDesign;

public class ImplementingStaticInterfaces {

    public static void main(String[] args){
        System.out.println(InterfaceWithStatic.name);
        System.out.println(InterfaceWithStatic.getName());
        System.out.println(InterfaceWithStatic.getAuthorName());

    }

}

interface InterfaceWithStatic {
    static String name = "ImplementingInterfaces"; // static final
    static String getName(){return name;}
    static String getAuthorName(){return "adam";}

    static void changeName(){
    }
}