// ## Problem 3: (https://leetcode.com/problems/find-peak-element/)
// A peak element is an element that is greater than its neighbors.

// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
// Approach:  Modified binary search
//     check if mid is peak element, if yes return
// else chances of finding peak is in greater part of array



class Solution {
public:
    int findPeakElement(vector<int>& nums) {
     
        if(nums.size()==0){
            return -1;
        }
        
        int low =0;
        int high= nums.size() -1;
        
        while (low <=high){
            
            int mid = low + (high - low)/2;
            
            if ( (mid== low || nums[mid] > nums [mid-1])  && ( mid==high || nums[mid] > nums[mid+1]) ){
                return mid;
            }
            else{
                if ( nums[mid ]  <nums [mid+1]){
                    low =mid+1 ;
                }
                else{
                    high =mid-1;
                }
            }
        }
        return -1;
        
    }
};