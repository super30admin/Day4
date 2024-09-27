
//Time Complexity is O(logn)
//Space Complexity is O(1)
class Solution {
    public int findMin(int[] nums) {
        int start=0;
        int end=nums.length-1;
        
    while(start<end){
        int mid=start+(end-start)/2;
        
    //checking the edge case when mid can be last element    
    if(mid<end && nums[mid]>nums[mid+1]){
        return nums[mid+1];
    }
    //checking the edge case when mid can be the first element
    if(mid>start && nums[mid-1]>nums[mid]){
        return nums[mid];
    }
        
    if(nums[start]<nums[mid]){
        start=mid+1;
    }
        else{
            end=mid-1; 
        }
    
    }
    return nums[0];
    }
}