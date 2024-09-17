//Time complexity: O(log(n))
//Space Complexity: O(1)
//Notes: If [mid+1] or [mid-1] is greater than [mid] , then there surely lies a peak towards the [mid+1] or [mid-1] side or both sides from the mid.

public class PeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length == 0 ) return -1;
        
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            
            int mid = low + (high - low)/2;
            
            if((mid == 0 || nums[mid-1] < nums[mid]) && (mid == nums.length-1 || nums[mid+1] < nums[mid] )){
                return mid;
            } else if(mid > 0 && nums[mid-1] > nums[mid]){
                high = mid - 1; 
            } else{
                low = mid + 1;
            }  
        }
        
        return -1;
    }
}
