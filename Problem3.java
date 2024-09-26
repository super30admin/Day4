class Solution {
    public int findPeakElement(int[] nums) {
        
    int low=0;
    int high= nums.length-1;
        
    while(low<=high){
        int mid= low + (high-low)/2;
        //if mid is peak
        if((mid==0 ||nums[mid-1]<nums[mid]) && (mid==nums.length-1 || nums[mid+1]<nums[mid]))
        {
            return mid;
        }
        //else moving to the part where the num is greater than mid
        // 1,2,1,3,5,6,4 mid is 3 and is not peak , we need to move to right part as 5 is greater
        // cause definitely to the number bigger side we will find peak for sure
        // 5,6,4 peak 6 or 5,4,3 peak 5 definitely we find on left part we may or maynot
        else if(nums[mid+1]>nums[mid])
        {
            low=mid+1;
        }
        else{
            high=mid-1;
        }
    }
     return -1;
    }
}        
