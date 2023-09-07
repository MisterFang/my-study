package main;

import java.util.*;

/**
 * @author : fang
 * @date : 2023/9/5 10:25
 */
public class TestController {


    public static void main(String[] args) {
        /*int[] nums = {3,2,4};
        int target = 6;

        System.out.println(Arrays.toString( getSum1(nums,target)));*/
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> list = groupAnagrams1(strs);
        System.out.println(list);
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

    public static List<List<String>> groupAnagrams(String[] strs) {


        Map<String,List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String newStr = new String(chars);

            if(map.get(newStr) != null){
                map.get(newStr).add(s);
            }else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(newStr,list);
            }
        }

        return new ArrayList<>(map.values());
    }


    public static List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            int[] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于 0 的字母和出现次数按顺序拼接成字符串，作为哈希表的键
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }

            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }





}
