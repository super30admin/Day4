// Find first and last position of an element in the sorted array LC 34

// We will do a binary search to find the target such that it is its first occurence 
// we will do the second binary search to find the last occurence
// these end points would be found by comparing it with left and right neighbors
// For finding the last occurence, we can move low pointer to the first occurence found before

//OPTIMIZATIONS-
//Target is surely not in the range id first is larger than target/last is lower than target
//if the first element is not found, we will not find any last element as well

class Solution {
    int lowforsearch2;
    private int binarySearch1(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==0||nums[mid]>nums[mid-1]){
                    return mid;
                }else{
                    high = mid-1;
                }
            } else if(nums[mid]>target){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            return -1;
        }
    
    
    private int binarySearch2(int[] nums, int target){
        int low = lowforsearch2;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1||nums[mid]<nums[mid+1]){
                    return mid;
                }
                else{
                    low=mid+1;
                }}
                else if(nums[mid]>target){
                    high = mid-1;
                }else {
                    low=mid+1;
                }
   
            }
            return -1;
        }
    
    public int[] searchRange(int[] nums, int target) {
        //null
        if (nums==null||nums.length==0) return new int [] {-1,-1};
        //Target is surely not in the range id first is larger than target/last is lower than target
        if(nums[0]>target || nums[nums.length-1]<target) return new int[] {-1,-1};
        int first=binarySearch1(nums, target);
            //if the first element is not found, we will not find any last element as well
        lowforsearch2 =first;
        if (first ==-1) return new int [] {-1,-1};
        int last=binarySearch2(nums, target);
        return new int []{first, last};
        
        
        

    }
}
