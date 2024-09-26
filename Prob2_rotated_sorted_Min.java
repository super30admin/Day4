class Solution {
    public int findMin(int[] nums) {
        
        // Time Complexity:O(log(n))
        //Space Complexity:O(1)
        int low=0,high=nums.length-1;
        if(nums[low]<=nums[high])
            return nums[low];
        while(high>=low){
            int mid=low+(high-low)/2;
            if(nums[low]<=nums[high])
                return nums[low];
            if((mid==nums.length-1||nums[mid]<nums[mid+1]) && (mid==0||nums[mid]<nums[mid-1])){
                return nums[mid];
            }
            if(nums[low]<=nums[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
        
        // Brute Force Solution
        // Time Complexity=O(n)
        // Space Complexity=0(1)
        
        // int i=0;
        // if(nums.length==1)
        //     return nums[0];
        // while(!(nums[i+1]<nums[i]) &&i<nums.length-2){
        //     i++;
        // }
        // if(nums.length-2==i && nums[i+1]>nums[i])
        //     return nums[0];
        // return nums[i+1];
    }
}