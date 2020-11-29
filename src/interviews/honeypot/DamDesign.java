package interviews.honeypot;

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



class Result2 {
	// TODO: Finish task

    /*
     * Complete the 'maxHeight' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY wallPositions
     *  2. INTEGER_ARRAY wallHeights
     */

    public static int maxHeight(List<Integer> wallPositions, List<Integer> wallHeights) {
    	int result = 0;
    	
    	int preWallSize = -1;
    	int postWallSize = -1;
    	int preWallPlace = -1;
    	int postWallPlace = -1;
    	
    	int diffPositions = 0;
    	int diffHeights = -1;
    	
    	if(wallPositions.size() > 1) {    		
	    	preWallPlace = wallPositions.get(0);
			preWallSize = wallHeights.get(0);
			
			postWallPlace = wallPositions.get(1);
			postWallSize = wallHeights.get(1);
    	}
    	
    	for ( int i = 0 ; i < wallPositions.size()-1; i++) {
    		
    		diffPositions = postWallPlace - preWallPlace;
    		diffHeights = preWallSize>postWallSize ? preWallSize-postWallSize : postWallSize-preWallSize;
    		
    		if(diffPositions == 1) {
    			preWallPlace = postWallPlace;
    			preWallSize = postWallSize;
    			
    			postWallPlace = wallPositions.get(i+1);
    			postWallSize = wallHeights.get(i+1);
    			
    		}else {
    			int tmpResult = -1;
    			int mudSize = preWallSize;
    			
    			for(int j = 1; j < diffPositions; j++) {
    				int height = (mudSize - (diffPositions-j)) ;
    				if(postWallSize >= mudSize || height  <= postWallSize+1 ) {
    					mudSize++;
    				}else {
    					mudSize--; 
    				}
    				tmpResult = tmpResult<mudSize ? mudSize : tmpResult; 
    			}
    			
    			result = result<tmpResult ? tmpResult:result;
    		}
    	}    	
    	return result;
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