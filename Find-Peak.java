// TC: O(log(n))
// SC: O(1)


// Approach: 
//     This is solved by intuition by searching element in the array whose value is greater than mid.
//     Find mid, then check whther mid is peak or not
//     Else, check left and right to the mid. If left value (mid-1) is greater than mid, then high = mid - 1.
//     Otherwise, low = mid + 1
      
//     Why we are considering only greater element side? The reason is peak eleemnt probability on the greater element side is high. 
//     That means we will find peak element for sure.
  
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 0) return -1;
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            System.out.println(mid);
            if((mid == 0 || nums[mid-1] < nums[mid]) && (mid == nums.length - 1 || nums[mid+1] < nums[mid])) {
                return mid;
            }
            if((mid == 0 || nums[mid-1] < nums[mid]) && (mid == nums.length - 1 || nums[mid+1] > nums[mid])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            } 
        }
        return -1;
    }
}
