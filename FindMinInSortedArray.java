// Time Complexity: O(logn)
// Space Complexity : O(1)
// Approach : Apply Binary Search to reduce the search range by moving the pointer towards unsorted portion as chances of min on the sorted portion is less.
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            // array rotated n times then it becomes sorted array
            if(nums[low]<=nums[high]){
                return nums[low];
            }
            // mid happen to be the pivot where the rotation happened
            if((mid == 0 || (nums[mid-1] > nums[mid])) && (mid==high || (nums[mid+1] > nums[mid]))){
                return nums[mid];
            // right Array is sorted
            }else if(nums[mid]<nums[high]){
                high=mid-1;
            // left Array is sorted
            }else{
                low=mid+1;
            }
        }
        return -1;
    }
}
class Solution {
    // Time complexity: O(logn)
    // Space Complexity: O(1)
    // Approach : Binary Search and divide the search space by eliminating the sorted portion because min wont be present.
    public int findMin(int[] nums) {
        int n = nums.length;
        int low =0;
        int high=n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if((mid==0 || nums[mid-1]>nums[mid]) && (mid == high || nums[mid+1]>nums[mid])){
                    return nums[mid] ;// on the pivot - rotation happend
            }
            // sorted portion is on right
            if(nums[mid]<nums[high]){
                high=mid-1;
            }else{
                low=mid+1;
            }
            
        }
        return -1;
    }
}