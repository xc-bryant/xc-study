package com.xc.study.likou;

/**
 * @author bryant
 * @date 2025/8/22
 **/

/**
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * <p>
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * <p>
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 * <p>
 * 必须 原地 修改，只允许使用额外常数空间。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 */
public class Task31 {
    public static void main(String[] args) {
        nextPermutation(new int[]{2,3,1});
    }

    public static void nextPermutation(int[] nums) {
        int swap; //全局用来交换的值
        boolean exit = false; //是否需要替换元素，不需要，直接取反的列表
        for (int i = nums.length - 1; i > 0; i--) {
            //判断是否需要替换数字
            if (nums[i] > nums[i - 1]) {
                int flag = nums[i -1]; //用于记录需要替换的位置
                int min = 100; //用来保存后面需要替换的最小数字与需要替换数字的差最小值
                int index = i; //记录后面需要替换数字的下标
                //替换后面的数字进行排序
                for (int n = i; n < nums.length - 1; n++) {
                    for (int m = i; m < nums.length - 1; m++) {
                        if (nums[m] > nums[m + 1]) {
                            swap = nums[m];
                            nums[m] = nums[m + 1];
                            nums[m + 1] = swap;
                        }
                    }
                }
                //对后面排序后的数字，比较与当前需要替换值的差值，取最小的那一个
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > flag) {
                        if (min > (nums[j] - flag)) {
                            min = nums[j] - flag;
                            index = j;
                        }
                    }
                }
                //进行替换
                swap = nums[index];
                nums[index] = nums[i - 1];
                nums[i - 1] = swap;
                //是否替换标识记录
                exit = true;
                //替换结束跳出循环
                break;
            }
        }
        //不需要替换，则对数组直接排序输出即可
        if (!exit) {
            for (int n = 0; n < nums.length - 1; n++) {
                for (int m = 0; m < nums.length - n - 1; m++) {
                    if (nums[m] > nums[m + 1]) {
                        swap = nums[m];
                        nums[m] = nums[m + 1];
                        nums[m + 1] = swap;
                    }
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
