

//Time Complexitiy: O(N)
//Space Complexity : O(1)
//Brute force solution to compare each element to its previous and next to find the max
//Will implement and submit the O(logN) solution.
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length<=1)
            return 0;
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]>nums[i-1] && nums[i]>nums[i+1])
                return i;
        }
        if(nums[0]>nums[1])
            return 0;
        if(nums[nums.length-1]>nums[nums.length-2])
            return nums.length-1;
        return -1;
    }
}