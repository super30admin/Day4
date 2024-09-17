// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class searchRange{
    int first;
    //first binarysearch function to find out the first occurance of element
    private int binarySearchLeft(int [] nums, int target){
        int low=0;
        int high=nums.length-1;
        
        while(low<=high){
            int mid=low+high-low/2;
            if(nums[mid]==target){ // when element is same as mid element
                if(mid==0 || nums[mid]>nums[mid-1]){ // check if mid element at 0th index or it is greater than the right side element in this case return mid
                    return mid;
                }
                else{ // if target is smaller than other elements then we will search element on left side
                    high=mid-1;
                }
            }
            else if(nums[mid]>target){ //when target is smaller than the target it self
                high=mid-1;
            }
            else{
                low=mid+1;
            }

        }
        return -1;
    }
// second binarysearch function to find the last position of an array in program
    private int binarySearchRight(int [] nums, int target){
        int low=0;
        int high=nums.length-1;
        
        while(low<=high){
            int mid=low+high-low/2;
            if(nums[mid]==target){
                if(mid==nums.length-1 || nums[mid]<nums[mid+1]){ //check if mid element at last index or it is less than the right side element in this case return mi
                    return mid;
                }
                else{ //if target is greater than target search in right subarray
                    low=mid+1;
                }
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }

        }
        return -1;
    }
    public int[] searchRange(int [] nums,int target){
        if(nums == null || nums.length==0) return new int []{-1,-1};
        if(nums[0] > target || nums[nums.length-1]<target) return new int []{-1,-1};
        first=binarySearchLeft(nums, target);
        if(first==-1) return new int[]{-1,-1};
        int last=binarySearchRight(nums, target);
        return new int []{first,last};
    }

}