// Time Complexity :O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


public int[] searchRange(int[] nums, int target) {
    if(nums == null || nums.length ==0) return new int[]{-1,-1};
    
    if(target < nums[0] || target > nums[nums.length-1  ]) return new int[]{-1,-1};
    
    //case right search
    int right = rightSearch(nums,target);
    int left = leftSearch(nums,target);
    
    return new int[]{left,right};
    
}
//creating a binary search for the last occurence of the target in the list
private int rightSearch(int[] nums, int target){
    int low=0;
    int high=nums.length-1;
    while(low <= high){
        int mid = low + (high-low)/2;
        if(mid+1 < nums.length && nums[mid+1] == target){ // peeking if the next right element is same as target, then search again
            low = mid+1;
        }else{ // binary search
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] >= target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
    }
    return -1;
}

private int leftSearch(int[] nums, int target){
    int low=0;
    int high=nums.length-1;
    while(low <= high){
        int mid = low + (high-low)/2;
        if(mid-1 >=0 && nums[mid-1] == target){ // peeking if the left element is same as target, then searching in left half
            high = mid-1;
        }else{
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] >= target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
    }
    return -1;
}