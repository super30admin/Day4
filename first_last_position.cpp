// Time complexity-O(2log(n))
// space complexity O(1);
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


//we run two different binary search for the first and last position
// if we find the target we move to the position after it until we are using its the first and last

#include<iostream>
using namespace std;
#include<vector>


class Solution {
    public:
        int first (vector<int>nums,int low,int high,int target){
                while (low <= high){
                    int mid = low + (high - low)/2;
                    if(nums[mid] == target){
                        if( mid == low ||  nums[mid - 1] < nums[mid]) 
                        {
                            return mid;
                        }
                            // still go left
                        else {
                            high = mid - 1;
                        }
                    } 
                    else if(nums[mid] > target){
                        high = mid - 1;
                    } 
                    else {
                        low = mid + 1;
                    }
                }
            return -1;
    }
    int second(vector<int>nums,int low,int high,int target){
            while(low<=high){
                int mid = low + (high - low)/2;
                if(nums[mid] == target){
                    if( mid == high ||  nums[mid + 1] > nums[mid]) return mid;
                    // you can still go right
                    else {
                        low = mid + 1;
                    }

                } 
                else if(nums[mid] > target){

                    high = mid - 1;

                } else 
                {
                    low = mid + 1;
                } 
            }
            return -1;
        }
    vector<int> searchRange(vector<int>& nums, int target) {
            int low=0;int high= nums.size()-1;

            int left = first(nums, 0, nums.size() - 1, target);

            int right = second(nums, 0, nums.size() - 1, target);

            return  {left,right};

        }
    
};