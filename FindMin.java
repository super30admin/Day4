//  Time Complexity O(logn). Space complexity O(1)

// Approach 
// we will approach this by using binary search
// we will first look for the unsorted array
// we will then check for the condition if the correponding elements to mid are greater or not. If they are the mid element is returned as min in the rotated sorted. 
class FindMin {
    public int findMin(int[] nums) {
        if(nums == null || nums.length ==0) return -1;
        int left = 0;
        int right = nums.length -1;
        while(left<=right){
            if(nums[left]<nums[right]) return nums[left];
            int mid = left + (right-left)/2;
            if((mid == 0 || nums[mid-1]>nums[mid]) && (mid == nums.length-1 || nums[mid+1]>nums[mid])){
                return nums[mid];
            }else if(nums[left]<=nums[mid]){
                   left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        return -1;
    }
}