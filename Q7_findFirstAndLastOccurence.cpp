//
// ## Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
// Approach:  Modified binary search
//      find the target element, once found check further if its first / last occurence



class Solution {
public:
    
    //apply binary search with additional check when find target
    int findFirst( vector<int>& nums , int target){
        
        int low= 0;
        int high = nums.size()-1;
        
        while( low <=high){
            
            int mid = low + (high -low )/2;
            
            if( nums[mid] == target){
                
                //additional check to see if first occurence
                if(mid==low || nums[mid -1 ] < nums[mid]){
                    return mid;
                }
                else{
                    //if not, move search space to left
                    high = mid-1;
                }
            }
            else if ( nums[mid] < target){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return -1;
    }
    
    //apply binary search with additional check when find target
    int findLast( vector<int>& nums, int target){
        
        int low= 0;
        int high = nums.size()-1;
        
        while( low <=high){
            
            int mid = low + (high -low )/2;
            
            if( nums[mid] == target){
                
                //additional check to see if last occurence
                if(mid==high || nums[mid ] < nums[mid+1]){
                    return mid;
                }
                else{
                     //if not, move search space to right
                    low =mid +1;
                }
            }
            
            else if ( nums[mid] < target){
                low =mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return -1;
    }
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> output;
        int f= findFirst(nums, target);
        output.push_back(f);
        int l= findLast(nums, target);
        output.push_back(l);
        
        return output;
    }
};