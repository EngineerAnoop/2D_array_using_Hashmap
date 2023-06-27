import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArraySumCombinations {
    public static int[][] findSumCombinations(int[] nums, int target) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                List<Integer> pair = Arrays.asList(nums[i], nums[j]);
                
                if (!map.containsKey(sum)) {
                    List<List<Integer>> combinations = new ArrayList<>();
                    combinations.add(pair);
                    map.put(sum, combinations);
                } else {
                    map.get(sum).add(pair);
                }
            }
        }
        
        List<List<Integer>> result = map.get(target);
        int[][] output = new int[result.size()][2];
        
        for (int i = 0; i < result.size(); i++) {
            List<Integer> pair = result.get(i);
            output[i][0] = pair.get(0);
            output[i][1] = pair.get(1);
        }
        
        return output;
    }
    
    public static int[] mergeAndSort(int[][] combinations) {
        List<Integer> merged = new ArrayList<>();
        
        for (int[] pair : combinations) {
            for (int num : pair) {
                merged.add(num);
            }
        }
        
        int[] mergedArray = new int[merged.size()];
        
        for (int i = 0; i < merged.size(); i++) {
            mergedArray[i] = merged.get(i);
        }
        
        Arrays.sort(mergedArray);
        
        return mergedArray;
    }
    
    public static int[][] findDoubleSumCombinations(int[] nums, int target) {
        int doubledTarget = target * 2;
        
        List<List<Integer>> combinations = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                
                if (sum == doubledTarget) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(nums[i]);
                    pair.add(nums[j]);
                    combinations.add(pair);
                }
            }
        }
        
        int[][] output = new int[combinations.size()][];
        
        for (int i = 0; i < combinations.size(); i++) {
            List<Integer> pair = combinations.get(i);
            output[i] = new int[pair.size()];
            
            for (int j = 0; j < pair.size(); j++) {
                output[i][j] = pair.get(j);
            }
        }
        
        return output;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, -4, -6, -2, 8};
        int target = 4;
        
        int[][] sumCombinations = findSumCombinations(nums, target);
        System.out.println("First Combination for \"" + target + "\":");
        for (int[] pair : sumCombinations) {
            System.out.println(Arrays.toString(pair));
        }
        
        int[] mergedArray = mergeAndSort(sumCombinations);
        System.out.println("Merge Into a Single Array:");
        System.out.println(Arrays.toString(mergedArray));
        
        int[][] doubleSumCombinations = findDoubleSumCombinations(mergedArray, target);
        System.out.println("Second Combination for \"" + (target * 2) + "\":");
        for (int[] pair : doubleSumCombinations) {
            System.out.println(Arrays.toString(pair));
        }
    }
}
