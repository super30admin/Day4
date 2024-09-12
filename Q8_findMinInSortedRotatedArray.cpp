// ## Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
 
// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
// Approach:  Modified binary search
//find mid , if mid is minimum than adjacent elements --> that's the pivot found minimum
//else move to unsorted part of array



class Solution {
public:
    int findMin(vector<int>& nums) {
        int low = 0;
        int high = nums.size()-1;
    
        
        while( low <= high){
            
            int mid = low + (high -low)/2;
            
            if (nums[low] < nums[high]){
                return nums[low];
            }
            
            if( (low==mid || nums[mid-1] > nums[mid] ) && (high ==mid || nums[mid +1] > nums[mid])){
                return nums[mid];
            }
            
            if( nums[low] <= nums[mid]){
                low =  mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
};