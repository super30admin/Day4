//Time complexity : O(logn)
//Space complexity : O(1)
//Leetcode : success

class Solution {
    public int findPeakElement(int[] nums) {    
    int start = 0;
    int end = nums.length -1;
        
    while(start<=end){
        int mid = start + (end -start)/2;
            
        if((mid ==0 || nums[mid-1]<nums[mid]) && (mid==nums.length -1 || nums[mid+1]<nums[mid])){
            return mid;
        }
        if(nums[mid]<nums[mid+1]){
            start = mid +1;
        }else{
            end = mid -1;
        }
    }
        return -1;
    }
}