#Updated Binary-Search-2

## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
#LC -> 34

// Time Complexity : 0(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO
class Solution {
    public int leftbs(int nums[], int l, int h, int target){
        while (l <= h){
            int mid = l + (h-l) / 2;
            if(nums[mid] ==  target){
                if(mid==0 || nums[mid-1]<nums[mid]){
                    return mid;
                }
                else{
                    h = mid - 1;
                }
            }
            else if(target < nums[mid]){ // target still on the left
                h = mid - 1;
                //l = mid + 1;
            }
            else {
                //h = mid - 1; // target still on the left
                l = mid + 1;
            }
        }
        return -1;
    }
    public int rightbs(int nums[], int l, int h, int target){
        while (l <= h){
            int mid = l + (h-l) / 2;
            if(nums[mid] ==  target){
                if(mid==h || nums[mid+1]>nums[mid]){
                    return mid;
                }
                else{
                    l = mid + 1;    // target still on right
                }
            }
            else if(target > nums[mid]){ // if target is still on the right
                l = mid + 1;
                //h = mid - 1;
            }
            else {
                h = mid - 1;
                //l = mid + 1;
            }
        }
        return -1;
        
    }
    public int[] searchRange(int[] nums, int target) {
        int res[] = new int[2];
        res[0] = leftbs(nums, 0, nums.length-1, target);
        res[1] = rightbs(nums, 0, nums.length-1, target);
        return res;
    }
}









## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
#LC -> 153

// Time Complexity : O(logn)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

//Linear: 
class Solution {
    public int findMin(int[] nums) {
        if(nums == null) return -1;
        //if(nums.length==1) return nums[0];
        int min =  Integer.MAX_VALUE;
        for(int i = 0; i < nums.length;i++){
            if(nums[i]<min){
                min=nums[i];
            }
        }
    return min;
    }
}

//Binary Search
class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while(l <= h){

        if(nums[l]<nums[h]) return nums[l];

        int mid=l+(h-l)/2;
        
        if ((mid == 0 || nums[mid] < nums[mid-1]) && 
           (mid == nums.length-1 || nums[mid] < nums[mid+1])) return nums[mid];
        else if(nums[l] <= nums[mid]){
            l = mid + 1;
        }
        else{
            h = mid - 1;
        }
        }
        return -1;
    }
}





## Problem 3: (https://leetcode.com/problems/find-peak-element/)
A peak element is an element that is greater than its neighbors.
#LC -> 34

// Time Complexity : O(logn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int l = 0;
        int h = nums.length-1;
        while(l<=h){
            int mid = l + (h - l) / 2;
            if ((mid==0 || nums[mid] > nums[mid-1])  
                && (mid == nums.length-1 || nums[mid] > nums[mid+1])){
                return mid;
            }
            else if(mid>0 && nums[mid-1] > nums[mid]){
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return -1;
    }
}