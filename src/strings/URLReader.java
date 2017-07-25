package strings; /**
 * Created by sanjay on 7/3/17.
 */
    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.net.URL;
    import java.net.URLConnection;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;


    class URLReader {

        public static List<String> getAttributesFromURL(String urlString,
                                                        String [] keys) {
            StringBuilder sb = new StringBuilder();
            try {

                //Opening the URL
                URL url = new URL(urlString);
                URLConnection urlConnection = url.openConnection();
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(urlConnection.getInputStream()));

                // Reading the URL contents into a StringBuilder object
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line + "\n");
                }
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Copying the StringBuilder contents into a string
            String contents = sb.toString();


            List<String> keyList = Arrays.asList(keys);
            List<String> result = new ArrayList<String>();
            for (String key : keyList) {

                // Defining the pattern to be found in contents
                String patternToFind = key + "=\"(.*)\"";
                Pattern p = Pattern.compile(patternToFind);
                Matcher m = p.matcher(contents);
                if (m.find()) {

                    // If pattern found, store them in the result list
                    result.add(key + ": " + m.group(1).trim());
                }
            }
            // Returning the result
            return result;
        }
        public static void main(String[] args) throws java.lang.Exception {
            String urlString ="http://www.metar.gr/ws/alexan/ZWNTANA.htm";

            // List all the keys whose values need to be extracted
            String[] keys = {"sunriseTime", "outsideTemp", "outsideHumidity"};
            List<String> attributeValuePairs = getAttributesFromURL(urlString, keys);
            System.out.println(attributeValuePairs);
        }
    }