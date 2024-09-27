// Time complexity-O(log(n))
// space complexity O(1);
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : 


// peak element must be greater than those on its left and right
// modify binary search 
// we always move to the side of the array wich is larger than mid



#include <iostream>
using namespace std;
#include<vector>

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int low =0; int high = nums.size()-1;
        
        while(low <= high){
            int mid = low +(high-low)/2;
            if((mid== nums.size()-1 || nums[mid]>nums[mid+1]) && (mid==0 || nums[mid]> nums[mid -1])){
                return mid;
            }
            else if(nums[mid]<  nums[mid+1]){
                low= mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
};


