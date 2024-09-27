// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[] {-1, -1};
        if(target < nums[0] || target > nums[nums.length - 1]) return new int[] {-1, -1};

        int low = 0;
        int high = nums.length - 1;

        //checking first occurance
        int firstOccuerance = binarySearchFirst(nums, target);
        //No first occurance then return -1. -1
        if(firstOccuerance == -1) {
            return new int[] {-1, -1};
        }

        //get second occurance.
        int secondOccurance = binarySearchSecond(nums, target);

        return new int[] {firstOccuerance, secondOccurance};
    }

    int binarySearchFirst(int[] nums, int target) {

        int l = 0;
        int h = nums.length -1;

        while(l <= h) {
            int m = l+(h-l)/2;

            if(target == nums[m]) {
                //check if element immidiate to left of mid is not equal or small than mid.
                if( m == l || nums[m-1] < nums[m]) {
                    return m;
                }
                h = m - 1;
            }//check if target is less than mid
            else if(target < nums[m]) {
                h = m - 1;
            } //target is greater than mid element.
            else {
                l = m + 1;
            }
        }
        return -1;
    }

    int binarySearchSecond(int[] nums, int target) {
        int l = 0;
        int h = nums.length -1 ;
        while(l <= h) {
            int m = l+(h-l)/2;

            if(target == nums[m]) {
                //check if element to immidiate right of mid element is greater than to return mid as second occurance.
                if(m==h || nums[m+1] > nums[m]) {
                    return m;
                }
                l = m +1;
            } else if(target < nums[m]) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}