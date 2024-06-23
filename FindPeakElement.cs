//Algo: Binary search
//TC: O(logN)
//SC: O(1)

public class Solution {
    public int FindPeakElement(int[] nums) {
        int len = nums.Length-1;
        int high = len;
        int low = 0;
             
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if((mid == 0 || nums[mid]>nums[mid-1]) 
            && (mid==len || nums[mid]>nums[mid+1]))
            {
                return mid;
            }
            
            if(mid>0 && nums[mid-1]>nums[mid]){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        
        return 0;
    }
}