//  Time Complexity O(logn). Space complexity O(1)

// Approach 
// we will approach this by using binary search we will check for if the before and after element is smaller then current if yes that our peak, if not then we will move towards the side where the neighbouring element is greater than the current.
class PeakElement {
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if((mid == nums.length-1 || nums[mid]> nums[mid+1]) && (mid == 0 || nums[mid]> nums[mid-1])){
                return mid;
            }else if(mid != 0 && nums[mid-1]>nums[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
        
    }
}