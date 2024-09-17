// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int start =0;
        int end = nums.size()-1;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if((mid==0 ||nums[mid-1] < nums[mid]) &&
               (mid==nums.size()-1 ||nums[mid+1]<nums[mid]))
                return mid;
            
            if(mid<nums.size()-1 && nums[mid+1]>nums[mid])
                start = mid+1;
            
            else{
                end = mid-1;
            }
        }
        
        return -1;
    }
};
