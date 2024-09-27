// Time Complexity : O(log n)
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinInRotatedSortedArray {
    public int findMin(int[] nums) {
        
        if(nums.length == 1) return nums[0]; //checking if there's just one member
        
        int start = 0, end = nums.length - 1;
        
        if(nums[start] < nums[end]) return nums[start]; //checking if it is already sorted normally
        
        while(start <= end){
            int mid = start + (end-start) / 2; //calculating mid with avoidance of integer overflow
            
            if(nums[mid+1] < nums[mid]){ //checking if the right side element of mid is lesser, because then that will be the min
                return nums[mid+1];
            }
            if(nums[mid-1] > nums[mid]){ //checking if the left side element of mid is greater, because that will make mid element the min
                return nums[mid];
            }
            
            if(nums[mid] > nums[0]) { //checking if the mid is greater than first element
                start = mid + 1; //if that is true, the left part is sorted and min element will always be on unsorted side
            }
            else {
                end = mid - 1; //else condition means the unsorted part is on left
            }
            
        }
        return -1;
    }
}