// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class FirstLastPosition {
    public int[] searchRange(int[] nums, int target) {
        //null checks
        if(nums == null || nums.length ==0)
            return new int[] {-1,-1};
        if(target<nums[0] || target >nums[nums.length -1])
            return new int[]{-1,-1};
        int firstOccurence = binarySearchFirst(nums,target);
        if(firstOccurence == -1){
            return new int[] {-1,-1};
        }
        int lastOccurence = binarySearchRight(nums,target,firstOccurence);
        return new int[] {firstOccurence,lastOccurence};
    }
    //binary search for first occurence
    private int binarySearchFirst(int[] nums, int target){
        int low=0;
        int n=nums.length;
        int high=  n-1;
        while(low<=high){
            int mid= low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==low || nums[mid-1] <nums[mid]){
                    return mid;
                }
                high=mid-1;
            }
            else if(target<nums[mid]){
                high = mid -1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
    //binary search for last occurence
    private int binarySearchRight(int[] nums, int target, int bound){
       int low=bound; 
        int n=nums.length;
        int high=  n-1;
        while(low<=high){
            int mid= low+(high-low)/2; 
            if(nums[mid]==target){
                if(mid==n-1 || nums[mid+1] > nums[mid]){
                    return mid;
                }
                low=mid+1;
            }
            else if(target<nums[mid]){
                high= mid-1;
            }
            else{
                low= mid+1;
            }
        }
        return -1;
}
}