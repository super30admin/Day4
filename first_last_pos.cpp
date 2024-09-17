/*
Time Complexity : O(log(n)) where n is the number of elements in the array.
Space Complexity : O(1)
Did this code successfully run on Leetcode :Yes
Any problem you faced while coding this :No


Your code here along with comments explaining your approach:
First we do binary search for the first duplicate element. Then we do binary search for the last duplicate element and then return these 2 ans.
*/





class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int>result;
        result.push_back(binarySearchfirst(nums,target,true));
        result.push_back(binarySearchfirst(nums,target,false));
        
        return result;
        
        
    }
    int binarySearchfirst(vector<int>&nums,int target,bool first){
        int l = 0;
        int r = nums.size()-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid]==target){
                if(first){
                if(mid == 0 || nums[mid]!=nums[mid-1])return mid;
                else r = mid-1;
                }
                else{
                if(mid == nums.size()-1 || nums[mid]!=nums[mid+1])return mid;
                else l = mid+1;
                    
                }
            }
            else if(target > nums[mid])l = mid + 1;
            else r = mid -1;
            
        }
        return -1;
    }

};