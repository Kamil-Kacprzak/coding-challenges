package interviews.honeypot;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;



class Result2 {

    /*
     * Complete the 'maxHeight' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY wallPositions
     *  2. INTEGER_ARRAY wallHeights
     */

    public static int maxHeight(List<Integer> wallPositions, List<Integer> wallHeights) {
    	int wallP = wallPositions.size();
    	int wallH = wallHeights.size();
    	int max = 0;
    	
    	for(int i = 0; i<wallP-1; i++) {
    		if(wallPositions.get(i) < wallPositions.get(i+1)-1) {
    			int heightDiff = Math.abs(wallHeights.get(i+1) - wallHeights.get(i));
    			int gapLen = wallPositions.get(i+1) - wallPositions.get(i) - 1;
    			int localMax = 0;
    			if(gapLen > heightDiff) {
    				int low = Math.max(wallHeights.get(i+1), wallHeights.get(i+1)) + 1;
                    int remainingGap = gapLen - heightDiff - 1;
                    localMax = low + remainingGap/2;
    			}else {
                    localMax = Math.min(wallHeights.get(i+1), wallHeights.get(i+1)) + gapLen;
                }
    			max = Math.max(max, localMax);
    		}
    	}
    	System.out.println(max);
    	return max;
    }

}

public class DamDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int wallPositionsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> wallPositions = IntStream.range(0, wallPositionsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int wallHeightsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> wallHeights = IntStream.range(0, wallHeightsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result2.maxHeight(wallPositions, wallHeights);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}