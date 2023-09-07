package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : fang
 * @date : 2023/9/7 11:13
 */
public class Test1 {



    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int target = 6;

        System.out.println(Arrays.toString(getSum1(nums,target)));
    }





    private static int[] getSum(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            for (int j = i+1; j < nums.length; j++) {
                int num1 = nums[j];
                if(num+num1 == target){
                    return new int[]{i,j};
                }

            }
        }
        return null;
    }

    private static int[] getSum1(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(map.get(target-num) != null){
                return new int[]{i,map.get(target-num)};
            }
            map.put(num,i);
        }
        return null;
    }


}
