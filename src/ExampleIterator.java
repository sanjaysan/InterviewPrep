/**
 * Created by sanjay on 2/14/17.
 */
import java.util.ArrayList;
import java.util.Iterator;

public class ExampleIterator {

    public static void main(String args[]){
        ArrayList  animal = new ArrayList();
        animal.add("Horse");
        animal.add("Lion");
        animal.add("Tiger");

        Iterator animalItr = animal.iterator();

        while(animalItr.hasNext()) {
            String animalObj = (String)animalItr.next();
            System.out.println(animalObj);
        }
    }

}