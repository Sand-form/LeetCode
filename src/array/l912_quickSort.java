package array;

import java.lang.management.PlatformLoggingMXBean;
import java.util.Random;
import java.util.Scanner;

public class l912_quickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String[] parts = line.trim().split("\\s+");
        int[] nums = new int[parts.length];
        for(int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        funQuickSort(nums, 0, nums.length - 1);

        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if(i != nums.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    private static void funQuickSort(int[] nums, int l, int r) {
        if(l < r) {
            int pos = funPartition(nums, l, r);
            funQuickSort(nums, l, pos - 1);
            funQuickSort(nums, pos + 1, r);
        }
    }

    // 随机选择主元并划分
    private static int funPartition(int[] nums, int l, int r) {
        // 在[l, r]范围随机选择一个索引作为主元
        int i = new Random().nextInt(r - l + 1) + l;

        // 将随机选中的主元交换到数组末尾，方便调用固定的 partition 方法
        swap(nums, r, i);

        // 调用划分函数，返回主元最终位置
        return paritation(nums, l , r);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static int paritation(int[] nums, int l, int r) {
        int p = nums[r];
        int i = l - 1;
        for(int j = l; j <= r - 1; j++) {
            if(nums[j] < p) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }
}
