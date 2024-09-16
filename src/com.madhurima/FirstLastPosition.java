/*
    Time Complexity = O(logN)
    Space Complexity = O(1)
    Did this code successfully run on Leetcode : yes
 */


package com.madhurima;

public class FirstLastPosition {
}

class Solution1 {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }

        int first = getFirst(nums, target);
        if(first == -1){
            return new int[]{-1, -1};
        }
        int last = getLast(nums, target);

        return new int[]{first, last};
    }

    private int getFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid -1] != target){
                    return mid;
                }else{
                    high = mid -1;
                }
            }else if(target > nums[mid]){
                low = mid + 1;
            }else{
                high = mid -1;
            }
        }

        return -1;
    }

    private int getLast(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid+1] != target){
                    return mid;
                }else{
                    low = mid + 1;
                }
            }else if(target > nums[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int arr[] = {5,7,7,8,8,10};
        int target = 8;
        int[] result = s.searchRange(arr, target);
        System.out.println(result[0] + " , " + result[1]);
    }
}
