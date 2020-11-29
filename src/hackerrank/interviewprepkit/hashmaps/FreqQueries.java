package hackerrank.interviewprepkit.hashmaps;
/*
 * https://www.hackerrank.com/challenges/frequency-queries/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 * 
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FreqQueries {

 // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<int[]> queries) {
        List<Integer> result = new LinkedList<>();
        HashMap<Integer,Long> quantities = new HashMap<>();
        
        for(int[] query : queries) {
            int queryType = query[0];
            int queryValue = query[1];
            switch(queryType){
            case 1:
                if(quantities.containsKey(queryValue)) {
                    Long value = quantities.get(queryValue) + 1;
                    quantities.put(queryValue, value);
                }else {
                    quantities.put(queryValue, (long) 1);                        
                }
                break;
            case 2:
                if(quantities.containsKey(queryValue)) {
                	Long value = quantities.get(queryValue) - 1;
                    if(value > 0) {
                        quantities.put(queryValue, value);
                    }else {
                        quantities.remove(queryValue);
                    }
                }                    
                break;
            case 3:
                boolean found = false;
                for(Long i : quantities.values()) {
                    if ( queryValue == i) {
                        found = true;
                        break;
                    }
                }
                if(found){
                    result.add(1);
                }else{
                    result.add(0);      
                }                
                break;         
            }
        }
             
        return result;
    }

   public static void main(String[] args) throws IOException {
    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
      int q = Integer.parseInt(bufferedReader.readLine().trim());
      List<int[]> queries = new ArrayList<>(q);
      Pattern p  = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
      for (int i = 0; i < q; i++) {
        int[] query = new int[2];
        Matcher m = p.matcher(bufferedReader.readLine());
        if (m.matches()) {
          query[0] = Integer.parseInt(m.group(1));
          query[1] = Integer.parseInt(m.group(2));
          queries.add(query);
        }
      }
      List<Integer> ans = freqQuery(queries);
      try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n");
      }
    }
  }
}
