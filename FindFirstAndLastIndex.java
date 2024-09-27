// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : trying to decide the limits of the conditions was a bit difficult
//Time taken : 15 mins

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {-1,-1};

        if(nums == null || nums.length == 0 || target<nums[0] || target>nums[nums.length-1])
            return res;

        int first = binarySearchFirst(nums, target);
        if(first == -1)
            return res;

        int second = binarySearchSecond(nums, target);
        if(second == -1)
            return res;
        return new int[] {first, second};
    }

    // Can probably optimize into 1 binarySearch function

    public int binarySearchFirst(int[] n, int t) {
        int left = 0, right = n.length-1;

        while(left<=right){
            int mid = left + (right-left) / 2;
            if(n[mid] == t){
                if(mid == 0 || n[mid-1] != t){
                    return mid;
                }
                else {
                    right = mid-1;
                }
            }else if(t < n[mid]) {
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return -1;
    }
    public int binarySearchSecond(int[] n, int t) {
        int left = 0, right = n.length-1;

        while(left<=right){
            int mid = left + (right-left) / 2;
            if(n[mid] == t){
                if(mid == n.length-1 || n[mid+1] != t){
                    return mid;
                }
                else {
                    left = mid+1;
                }
            }else if(t < n[mid]) {
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return -1;
    }
}