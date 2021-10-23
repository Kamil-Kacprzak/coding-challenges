package hackerrank.problemsolving.algorithms;
/*
 * https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem?isFullScreen=false
 */
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class BreakingTheRecords {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = breakingRecords(scores);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
    
    public static List<Integer> breakingRecords(List<Integer> scores) {
		List<Integer> results = new ArrayList<>();
		int min;
		int max;
		if (!scores.isEmpty()) {
			min = scores.get(0);
			max = scores.get(0);
			results.addAll(Collections.nCopies(2, 0));
		}else {
			return null;
		}
		
		for(int i : scores) {
			if (i < min) {
				min = i;
				results.set(1, results.get(1)+1);
			}
			if(i > max) {
				max = i;
				results.set(0, results.get(0)+1);
			}
		}
    	return results;
    }

}
