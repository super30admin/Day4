//Time complexity: O(log(n))
//Space Complexity: O(1)
//Notes: When sorted array is rotated, then one part of the sub-array from mid is always sorted , while the other part of the sub-array contains the pivot.

public class MinInRotatedSortedArray {
    public int findMin(int[] nums) {
        
        if(nums == null || nums.length == 0) return -1;
        
        int low = 0;
        int high = nums.length - 1;
        
        int minVal = Integer.MAX_VALUE;
        
        while( low <= high){
            int mid  = low + (high - low)/2;
            
            if(nums[low] <= nums[mid]){
                minVal = min(minVal, nums[low]);
                
                low = mid + 1;
            } else {
                minVal = min(minVal, nums[mid]);
                
                high = mid - 1;
            } 
        }
        
        return minVal;
    }
    
    public int min(int a, int b){
        return a<b ? a : b ;
    }
}
