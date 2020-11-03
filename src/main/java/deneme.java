import java.util.ArrayList;
import java.util.List;

public class deneme {

    public static void main(String[] args) {
        List<String> deneme = new ArrayList<>();

        deneme.add("Ali");
        deneme.add("");
        deneme.add("Veli");
        deneme.add("");


        for (int i = 0; i < deneme.size(); i++) {
           if(deneme.get(i).isEmpty()){
               deneme.remove(deneme.get(i));
           }
        }

        System.out.println("deneme.size() = " + deneme.size());
        System.out.println("deneme = " + deneme);

    }
}
