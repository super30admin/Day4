// Time Complexity : O(log n)
// Space Complexity : O(1) no extra space used for any operation 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

#include<vector>
#include<iostream>

using namespace std;

int findPeakElement(vector<int>& nums) {
        
        int n = nums.size();
        int low = 0;
        int high = n - 1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == n-1 || nums[mid] > nums[mid+1]))
                return mid;
            else if(mid < n && nums[mid] < nums[mid+1])
                low = mid+1;
            else
                high = mid - 1;
        }
        return -1;
    }