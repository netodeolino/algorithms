import java.util.List;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        List<List<Integer>> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length-2; i++) {
            int j = i+1, k = nums.length-1;
            
            while (j < k) {
                String str = "" + nums[i] + nums[j] + nums[k];
                
                if (nums[i] + nums[j] + nums[k] == target) {
                    if (map.containsKey(str)) {
                        j++;
                        k--;
                    } else {
                        map.put(str, 1);
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        
                        j++;
                        k--;
                    }
                } else if (nums[i] + nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}