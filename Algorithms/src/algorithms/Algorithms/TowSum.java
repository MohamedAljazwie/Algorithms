/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MohamedSayed Given an array of integers, find two numbers such that
 * they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 *
 * For example:
 *
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=0, index2=1
 *
 */
public class TowSum {

    public static List<Integer[]> twoSum(int[] nums, int target) {
        List<Integer[]> towSum = new ArrayList<Integer[]>();
        if (nums == null || nums.length < 2) {
            towSum.add(new Integer[]{0, 0});
            return towSum;
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                towSum.add(new Integer[]{map.get(nums[i]), i});
            } else {
                map.put(target - nums[i], i);
            }
        }

        return towSum;
    }

    public static List<Integer[]> twoSumII(int[] numbers, int target) {
        List<Integer[]> towSum = new ArrayList<Integer[]>();
        if (numbers == null || numbers.length == 0) {
            towSum.add(new Integer[]{0, 0});
            return towSum;
        }

        int i = 0;
        int j = numbers.length - 1;
        Arrays.sort(numbers);
        while (i < j) {
            int x = numbers[i] + numbers[j];
            if (x < target) {
                ++i;
            } else if (x > target) {
                j--;
            } else {
                towSum.add(new Integer[]{i,j});
                i++;

            }
        }

        return towSum;
    }
    public static List<Integer[]> twoSumIII(int[] numbers, int target) {
      
        List<Integer[]> towSum = new ArrayList<Integer[]>();
       if (numbers == null || numbers.length == 0) {
            towSum.add(new Integer[]{0, 0});
            return towSum;
        }
        Map<Integer,Integer> elements=new HashMap<>();
        addValues(numbers, elements);
        for(Integer i:elements.keySet())
        {
            int value=target-i;
            if(elements.containsKey(value))
            {
                if(i==value&&elements.get(value)>=2)
                {
                    int count =elements.get(value);
                    while (count>1) {                        
                         towSum.add(new Integer[]{i,value});
                         count--;
                    }
                    elements.put(value, count);
                     elements.put(i, count);
                }
                else{
                  if(elements.get(value)>=1)
                  {
                    int count =elements.get(value);
                    while (count>0) {                        
                         towSum.add(new Integer[]{i,value});
                         count--;
                    }
                 elements.put(value, count);
                 elements.put(i, count);
                  }
                }
            }
        }
        return towSum;
    }
private static void addValues(int[]numbers ,Map<Integer,Integer> elements)
{
    for(int i:numbers)
    {
        if(elements.containsKey(i))
            elements.put(i, elements.get(i)+1);
        else
            elements.put(i, 1);
    }
}
    public static void main(String[] args) {
        int[] nums = {3, 4, 6, 9,10, 10,9,3,4,7,6,7, 13};
        
        List<Integer[]> integers = twoSumIII(nums, 13);
        StringBuffer buffer = new StringBuffer();
        buffer.append("{");
        for (Integer[] is : integers) {
            buffer.append("[");
            for (Integer i : is) {
                buffer.append(i).append(" ,");
            }

            buffer.deleteCharAt(buffer.length() - 1);
            buffer.append("]");
        }
        buffer.append("}");

        System.out.println(buffer.toString());
    }
}
