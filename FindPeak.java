/*
Time complexity of solution : O(log n)
Space COmplexity of solution : O(n)
*/
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums== null || nums.length<=1){
            return 0; // first index
        }
        return binarySearch(nums,0,nums.length-1);
    }
    
    public int binarySearch(int[] nums, int low,int high){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(mid<nums.length-1 && nums[mid]>nums[mid+1]){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        if(low == nums.length){
            return low-1; //  last index is peak.
        }
        return low;
    }
}