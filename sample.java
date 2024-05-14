//Prob-1: find-first-and-last-position-of-element-in-sorted-array
/**
 * // Time Complexity : O(log n) + O(log n) = logn. where n is the num of elements in the array
 * // Space Complexity : O(1)
 * // Did this code successfully run on Leetcode : yes
 * // Any problem you faced while coding this : no
 *
 * // Your code here along with comments explaining your approach
 */
 /**
 * We are going to use Binary search approach here. As we need to find both the first and last index of a given target, Binary search technique is used two times.
 * First time to find the starting index of the given target. Second one to get the last index. We are doing it two times separately because there is no grantee that
 * the given target will have only two duplicates.
 */
 class Solution {
    
    private int binarySearch(int[] nums, int target){
        int l=0, r=nums.length-1;
        while(l <= r){
            int mid = l+ (r-l)/2;
            if(nums[mid] < target){
                l = mid+1;
            }else if(nums[mid] > target){
                r = mid-1;
            }else{
                if(mid == 0 || nums[mid-1] < target){
                    return mid;
                }else{
                    r = mid-1;
                }
            }
        }
        return -1;
    }
    private int binarySearchTwo(int[] nums, int target){
        int l=0, r=nums.length-1;
        while(l <= r){
            int mid = l+ (r-l)/2;
            if(nums[mid] < target){
                l = mid+1;
            }else if(nums[mid] > target){
                r = mid-1;
            }else{
                if(mid == nums.length-1 || nums[mid+1] > target){
                    return mid;
                }else{
                    l = mid+1;
                }
            }
        }
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        
        int[] ans = new int[2];
        if(nums == null || nums.length == 0) return new int[]{-1,-1};
        if(nums[0] > target) return new int[]{-1,-1}; // in case the element is not present in the sorted array
        int idx = binarySearch(nums, target); // to find the first index of a given target
        int idx2 = binarySearchTwo(nums,target); // to find the first index of a given target

        return new int[]{idx,idx2};
    }
}
 /** Prob-2: find-minimum-in-rotated-sorted-array
 
 * // Time Complexity : O(log n)  where n is the num of elements in the array
 * // Space Complexity : O(1)
 * // Did this code successfully run on Leetcode : yes
 * // Any problem you faced while coding this : no
 *
 * // Your code here along with comments explaining your approach
 */
 /**
 * Using the BS technique to find the min element in the array. The main goal is to find such a mid element that is lesser than its mid-1 element (that means the sorted part ends here)
 * and greater than mid+1. Will keep moving low and high pointers according to the above described scenario. 
 */
 class Solution {
    public int findMin(int[] nums) {
        
        if(nums == null || nums.length == 0) return -1; //edge case
        
        int l=0, r=nums.length-1; // low and high pointers
        
        while(l <= r){
            
             if(nums[l] < nums[r]) return nums[l]; // in case the array is alredy sorted at this point in time
            int mid = l+ (r-l)/2; 
            if( (mid == nums.length -1 || nums[mid] < nums[mid+1]) 
               && (mid == 0 || nums[mid] < nums[mid-1])){ // Then the element is the min element
                return nums[mid];
            }else if(nums[l] <= nums[mid]){ // then we are on the sorted part of the array
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        
        return -1;
    }
}
 /** Prob-3: find-peak-element
 
 * // Time Complexity : O(logn) where n is the num of elements in the array
 * // Space Complexity : O(1)
 * // Did this code successfully run on Leetcode : yes
 * // Any problem you faced while coding this : no
 *
 * // Your code here along with comments explaining your approach
 */
 /**
 * BS search technique is used. The requirement is to find such an element that is greater that its left and right element.
 * Simply keep calculating the mid element that is greater than mid-1 and mid +1. Low pointer is moved to the right to the mid when the when nums[mid] > nums[mid-1]
 */
 class Solution {
    public int findPeakElement(int[] nums) {
        // edge case
        if(nums == null || nums.length == 0) return -1;
        
        int l=0, r=nums.length-1;
        
        while(r >= l){
            
            // calculate the cur mid position
            int mid = l + (r-l)/2;
            
            if( (mid==0 || nums[mid] > nums[mid-1]) && (mid == nums.length -1 || nums[mid] > nums[mid+1])){ // case we found the peak
                return mid; // returning the index of the peak
            }else if( mid > 0 && nums[mid-1] > nums[mid]){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
    
        return -1;
    }
}
