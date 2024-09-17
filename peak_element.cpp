/*
Time Complexity :O(log(n))where n is the number of elements in the array.
Space Complexity :O(1)
Did this code successfully run on Leetcode :Yes
Any problem you faced while coding this :No


Your code here along with comments explaining your approach
The major contraint given in this problem is that there cannot be 2 consecutive elements.
That is why we can make use of binary search.

Did not like this question tbh :(
 
*/

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int low = 0;
        int high = nums.size()-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if((mid ==0 || nums[mid]>nums[mid-1])&&(mid == nums.size()-1 || nums[mid]>nums[mid+1]))return mid;
            else if (nums[mid + 1]>nums[mid])low = mid+1;
            else high = mid;
        }  
        return -1;
    }
};