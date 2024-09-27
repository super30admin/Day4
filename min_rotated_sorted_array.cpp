// Time complexity-O(log(n))
// space complexity O(1);
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

// one part of the array will always be sorted definitely
// we modify our binar search to check the unsorted side as that is where the rotation will be 
// we run binary search on the unsorted which would again eliminate the sorted side until we fin our minimum

#include<iostream>
using namespace std;
#include<vector>



class Solution {
public:
    int findMin(vector<int>& nums) {
        if(nums.size() ==0) return -1;
         int left = 0,  right = nums.size() - 1;
         // 
        while(left <= right) {
           // if(nums[left] < nums[right]) {
           //      return nums[left]; // the array is sorted so just return the first element
           //  }
            int mid = left + (right-left)/2;
            
                
            if(   mid==0 || (nums[mid]< nums[mid-1]  )
               &&
               mid == nums.size()-1 || (nums[mid]< nums[mid+1])   ){
                return nums[mid];
            }
            else if(nums[mid] <     nums[right]){
                right = mid - 1;
            }    
            else{
                left = mid+1;
            }
                
        }
    return 343535345;
    }
};