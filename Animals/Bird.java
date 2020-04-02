package Animals;

public class Bird {
    
    boolean hasFeathers = true; // default : classes in same package

    protected boolean isAnimal = true;
}

class Duck {

    public static void main(String[] args){
        Bird bird = new Bird();
        System.out.println(bird.hasFeathers);
    }
}