package com.xc.study.likou;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 向左旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 下标 3 上向左旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -104 <= target <= 104
 */
public class Task33 {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println(result(nums, 0, nums.length - 1, 0));
    }

    public static int search(int[] nums, int target) {
        return result(nums, 0, nums.length - 1, target);
    }


    private static int result(int[] nums, int startIndex, int endIndex, int target) {
        int middle = (startIndex + endIndex) / 2;
        if (target == nums[startIndex]) {
            return startIndex;
        }
        if (target == nums[endIndex]) {
            return endIndex;
        }
        if (middle == endIndex || middle == startIndex) {
            return -1;
        }
        if (target == nums[middle]) {
            return middle;
        } else {
            if (target > nums[middle]) {
                if (target > nums[startIndex]) {
                    if (nums[middle] > nums[startIndex]) {
                        return result(nums, middle + 1, endIndex, target);
                    } else {
                        return result(nums, startIndex, middle - 1, target);
                    }
                } else {
                    if (nums[middle] > nums[startIndex]) {
                        return result(nums, startIndex, middle - 1, target);
                    } else {
                        return result(nums, middle + 1, endIndex, target);
                    }
                }
            } else {
                if (target > nums[startIndex]) {
                    if (nums[middle] > nums[startIndex]) {
                        return result(nums, startIndex, middle - 1, target);
                    } else {
                        return result(nums, middle + 1, endIndex, target);
                    }
                } else {
                    if (nums[middle] > nums[startIndex]) {
                        return result(nums, middle + 1, endIndex, target);
                    } else {
                        return result(nums, startIndex, middle - 1, target);
                    }
                }
            }
        }
    }

}
