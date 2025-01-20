//Time Complexity: O(log n)
//Space Complexity O(1)
//Yes the code ran successfully in leetcode
//No problem faced
//162. Find Peak Element

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int n =nums.length;
        int high = n-1;

        while(low<=high){
            int mid = low + (high-low)/2;

            if((mid == 0 || nums[mid-1]<nums[mid]) && (mid==n-1 || nums[mid+1]<nums[mid])){ // checking the peak condition
                return mid;
            }
            else if(nums[mid+1]>nums[mid]) // right element is greater than mid element
            {
                low=mid+1; // move right
            }
            else{
                high=mid-1; // move left
            }
        }
        return 43231;
    }
}