import java.util.ArrayList;
import java.util.List;

public class JavaExamChapter4 {


}

class ImmutableAttributes {
    private String string = "attribute"; // not update-able
    public String getString(){
        return string;
    }
    public static void main(String[] args){
        ImmutableAttributes example = new ImmutableAttributes();
        String exampleString = example.getString(); // string is not accessible
        exampleString = "new attribute";
        System.out.println(example.getString());

        exampleString += " added"; // not updateble
        System.out.println(example.getString());

    }
}

class NotImmutableAttributes {
    private List<String> list = new ArrayList<>();
    public List<String> getList() {return list;}

    private StringBuilder sb = new StringBuilder();
    public StringBuilder getSb(){return sb;}
    public static void main(String[] args){
        NotImmutableAttributes example = new NotImmutableAttributes();
        List<String> list = example.getList();
        list.add("added element.");
        System.out.println(list);

        example.getSb().append("added chars");
        System.out.print(example.getSb());
    }
}