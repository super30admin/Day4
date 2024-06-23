//Algo: Binary Search
//TC:O(logN)
//SC:O(1) no extra space used

public class Solution {
    public int FindMin(int[] nums) {
        int low = 0;
        int high = nums.Length-1;
        
        if(nums[low]<=nums[high]){
                return nums[low];
            }
        while(low<=high){
            int mid = low + (high-low)/2;
             if(nums[low]<=nums[high]){
                return nums[low];
            }
            if((mid>0 && nums[mid]<nums[mid-1])){
                return nums[mid];
            }else if(nums[mid]>=nums[low]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        
        return 1;
    }
}