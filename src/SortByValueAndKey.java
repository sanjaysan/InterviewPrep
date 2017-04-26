import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


/**
 * Created by sanjay on 4/26/17.
 */
public class SortByValueAndKey
{
    private static void sortByValueThenByKey(Map<String, Integer> map)
    {
        final List<Map.Entry<String, Integer>> result = map.entrySet().stream().sorted(
                (Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) ->
                {
                    return o1.getValue().equals(o2.getValue()) ?
                            o1.getKey().compareTo(o2.getKey()) : o2.getValue().compareTo(o1.getValue());
                }).collect(Collectors.toList());
        for (Map.Entry<String, Integer> s : result)
        {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Map<String, Integer> fruits = new HashMap<String, Integer>();
        while (true)
        {
            String fruitName = input.nextLine();
            if (fruitName.equals("end"))
            {
                break;
            } else
            {
                if (fruits.containsKey(fruitName))
                {
                    int count = fruits.get(fruitName);
                    fruits.put(fruitName, count + 1);
                } else
                {
                    fruits.put(fruitName, 1);
                }
            }
        }
        sortByValueThenByKey(fruits);
    }
}
