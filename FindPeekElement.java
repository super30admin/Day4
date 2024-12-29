class Solution {
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    // Did this code successfully run on Leetcode : Yes
    // note : the main idea is to find any peak element in the array
    //if we end up at one of the sides, that edges are considered as peak element as outside the array is -infinity
    // we're sure to find a peak element at O(log n) time

    public int findPeakElement(int[] nums) {
       if (nums == null || nums.length ==0 ){
         return Integer.MIN_VALUE;
       } 
        return find (nums, 0, nums.length -1);

    }

    public int find (int[] nums, int l, int h){

        if (h ==l){
            return l;
        }

        int mid = l + (h- l)/2;
        if (mid > 0 && mid <nums.length && nums[mid -1] < nums[mid] && nums[mid +1] < nums[mid]){
            return mid;
        }
        else if (nums[mid] < nums[mid +1]){
           return find (nums, mid +1 , h);
        } else {

           return find (nums, l , mid);
        }

    }
}