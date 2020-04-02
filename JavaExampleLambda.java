import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Java 8
 *      LAMBDA
 *      PREDICATE
 */
public class JavaExampleLambda {

    public static List<Animal> filter(Iterable<Animal> animals, CheckTrait checker){
        List<Animal> filteredAnimals = new ArrayList<>();
        for (Animal animal : animals){
            if (checker.test(animal)){
                filteredAnimals.add(animal);
            }
        }
        return filteredAnimals;
    }

    public static void main(String[] args){
        List<Animal> animals = new ArrayList<>(Arrays.asList(
            new Animal("fish", false, true),
            new Animal("kangaroo", true, false),
            new Animal("rabbit", true, false),
            new Animal("turtle", false, true)
        ));
        CheckTraitImpl checkHopper = new CheckTraitImpl(); // canHop
        System.out.println(filter(animals, checkHopper)); // old way






        
        /**
         * How Java knows:
         *      Java maps the input lambda (a -> a.canHop()) to the second parameter (CheckTrait Interface)
         *      Basically an anonymous impl of CheckTrait
         */
        System.out.println("Hopper " + filter(animals, a -> a.canHop()));
        System.out.println("Non-Hopper " + filter(animals, a -> ! a.canHop()));
        System.out.println("Swimmer " + filter(animals, a -> a.canSwim()));
        System.out.println("Swimmer or Hopper " + filter(animals, a -> (a.canHop() || a.canSwim())));

        List<Animal> results = filter(animals, a -> (a.canHop() || a.canSwim()));
        System.out.println("Swimmer or Hopper " + results);

        List<Animal> animalList = filter(animals, (Animal a) -> {
            if (a.toString().equals("fish") || a.toString().equals("kangaroo")) {
                return true;
            } else {
                return false;
            }
        });
        System.out.println("Custom " + animalList);
    }
}

class JavaExamplePredicate {

    public static void main(String[] args){
        List<Animal> animals = new ArrayList<>(Arrays.asList(
            new Animal("fish", false, true),
            new Animal("kangaroo", true, false),
            new Animal("rabbit", true, false),
            new Animal("turtle", false, true)
        ));
        System.out.println("canHop : " + predicateFilter(animals, a -> a.canHop()));

        animals.removeIf(a -> ! a.canHop());
        System.out.println("canHop : " + animals);
    }

    public static List<Animal> predicateFilter(Iterable<Animal> animals, Predicate<Animal> checker){
        List<Animal> filteredAnimals = new ArrayList<>();
        for (Animal animal : animals){
            if (checker.test(animal)){
                filteredAnimals.add(animal);
            }
        }
        return filteredAnimals;
    }
}

class Animal {
    private String species;
    private boolean canHop;
    private boolean canSwim;
    public Animal (String species, boolean canHop, boolean canSwim){
        this.species = species;
        this.canHop = canHop;
        this.canSwim = canSwim;
    }

    // getters
    public String toString(){return species;}

    public boolean canHop(){return canHop;}

    public boolean canSwim(){return canSwim;}
}


interface CheckTrait {
    public boolean test(Animal animal);
}

class CheckTraitImpl implements CheckTrait {
    public boolean test(Animal animal){
        return animal.canHop();
    }
}