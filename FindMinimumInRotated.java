/*
Time complexity of solution : O(log n)
Space COmplexity of solution : O(n)
*/
class Solution {
    public int findMin(int[] nums) {
        int index =  binarySearch(nums,0,nums.length-1,nums[0]);
        if(index == nums.length){
            return nums[0];
        }else{
            return nums[index];
        }
    }
    
    public int binarySearch(int[] nums, int low, int high,int target){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]<target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}