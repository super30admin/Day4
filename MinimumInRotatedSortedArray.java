// Time Complexity :O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public int findMin(int[] nums) {
    if(nums == null || nums.length == 0){
        return -1;
    }
    
    int low=0;
    int high =nums.length-1;
    
    while(low<=high){
        if(nums[low] < nums[high]){
            return nums[low];
        }
        int mid = low + (high-low)/2;
        //checking if the mid is the minimum element in the array
        if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == nums.length-1 || nums[mid] < nums[mid+1])){
            return nums[mid];
        //moving towards the side which has minimum element
        }else if(nums[mid] < nums[high]){
            high=mid-1;
        }else{
            low=mid+1;
        }
    }
    return nums[low];
}