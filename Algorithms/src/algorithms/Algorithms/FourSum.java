/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author MohamedSayed
 */
public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums == null || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int m = nums.length - 1;

                while (  k<m) {
                    if (nums[i] + nums[j] + nums[k] + nums[m] == 0) {
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        l.add(nums[m]);
                        result.add(l);

                        k++;
                        m--;

                        //handle duplicate here
                        while (k < m && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while (k < m && nums[m] == nums[m + 1]) {
                            m--;
                        }

                    } else if (nums[i] + nums[j] + nums[k] + nums[m] < 0) {
                        k++;
                    } else {
                        m--;
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {-1, 0, 1, 2, -1, -4};
        System.out.println(fourSum(num));
    }
}
