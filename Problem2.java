//Time Complexity: O(log n)
//Space Complexity O(1)
//Yes the code ran successfully in leetcode
//No problem faced
//153. Find Minimum in Rotated Sorted Array


class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1){ // one element
            return nums[0];
        }
        int n=nums.length;
        int low=0;
        int high=n-1;

        while(low<=high){
            if(nums[low]<=nums[high]){
                return nums[low];
            }
            int mid=low+(high-low)/2;
            if((mid==0 || nums[mid-1]>nums[mid]) && (mid==n-1 || nums[mid+1]>nums[mid])){ // check if mid is the minimum
                return nums[mid];
            }
            else if(nums[low]<=nums[mid]){ // check if left side is sorted
                low=mid+1; // move right
            }
            else{
                high=mid-1; // move left
            }
        }
        return nums[low];
    }
}

