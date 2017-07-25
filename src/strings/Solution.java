package strings; /**
 * Created by sanjay on 1/11/17.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution
{
    /*
 * Complete the function below.
 */

    static String[] findPotentialInsiderTraders(String[] datafeed)
    {
        int n = datafeed.length;
        String[] init = datafeed[1].split("|");
        int initDay = Integer.parseInt(init[0]);
        int initVal = Integer.parseInt(init[1]);
        int price = initVal;
        int day = Integer.parseInt(init[0]);
        boolean transact = false;
        LinkedHashMap<Integer, Integer> priceTable = new LinkedHashMap<Integer, Integer>();

        priceTable.put(initDay, initVal);

        HashMap<String,Integer[]> h = new HashMap<String,Integer[]>();

        for(int i=2; i< Integer.parseInt(datafeed[0]); i++)
        {
            String[] splitLine = datafeed[i].split("|");
            if(splitLine.length == 2 && transact == true)
            {
                priceTable.put(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]));
                price = Integer.parseInt(splitLine[1]);
                day = Integer.parseInt(splitLine[0]);
                transact = false;
            }
            else if(splitLine.length == 4)
            {
                transact = true;
                if(h.containsKey(splitLine[1]))
                {
                    Integer[] arr = h.get(splitLine[1]);
                    int existingPrice = arr[1];
                    if(splitLine[2].equalsIgnoreCase("SELL"))
                    {
                        Integer lastKey = new ArrayList<>(priceTable.keySet()).get(priceTable.size() - 1);

                        arr[1] = arr[1] + Integer.parseInt(splitLine[3])* priceTable.get(lastKey);
                        h.put(splitLine[1], arr );
                    }
                    else
                    {
                        int lastKey = new ArrayList<>(priceTable.keySet()).get(priceTable.size() - 1);

                        arr[1] = arr[1] - Integer.parseInt(splitLine[3])*priceTable.get(lastKey);
                        h.put(splitLine[1], arr);
                    }


                }
                else
                {
                    Integer[] arr = new Integer[2];
                    arr[0] = Integer.parseInt(splitLine[0]);
                    if(splitLine[2].equalsIgnoreCase("SELL"))
                    {
                        int lastKey =  new ArrayList<>(priceTable.keySet()).get(priceTable.size() - 1);
                        arr[1] = Integer.parseInt(splitLine[3])*priceTable.get(lastKey);
                        h.put(splitLine[1], arr );
                    }
                    else
                    {
                        int lastKey = new ArrayList<>(priceTable.keySet()).get(priceTable.size() - 1);

                        arr[1] = Integer.parseInt(splitLine[3])*priceTable.get(lastKey)*-1;
                        h.put(splitLine[1], arr);
                    }

                }
            }
        }
        ArrayList<String> result = new ArrayList<String>();
        for(Map.Entry<String,Integer[]> entry : h.entrySet()) {
            String key = entry.getKey();
            Integer [] value = entry.getValue();
            if(value[1] > 5000000) {
                String s = value[0] + "|" + key;
                result.add(s);
            }
        }

        return result.toArray(new String [result.size()]);


    }
}
