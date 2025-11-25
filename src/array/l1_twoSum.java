package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 你可以按任意顺序返回答案。
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 */
public class l1_twoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();

        // 解析 nums
        int start = line.indexOf('[');
        int end = line.indexOf(']');
        // 取出中括号内的内容
        String numStr = line.substring(start + 1, end).trim();
        // 按 ","分割得到字符串数组
        String[] parts = numStr.split(",");
        int[] nums = new int[parts.length];
        for(int i = 0; i < parts.length; i++) {
            // 去掉空白并把每个字符串转化为整数
            nums[i] = Integer.parseInt(parts[i].trim());
        }

        // 解析 target
        int targetIndex = line.indexOf("target");
        int target = Integer.parseInt(line.substring(line.indexOf('=', targetIndex) + 1).trim());

        // 调用函数
        int[] res = twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }

    private static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if(map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
