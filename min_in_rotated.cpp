/*
Time Complexity :O(log(n))where n is the number of elements in the array.
Space Complexity :O(1)
Did this code successfully run on Leetcode :Yes
Any problem you faced while coding this :No


Your code here along with comments explaining your approach
There are 2 condtions here.
1) If the array is sorted and not rotated -> Return nums[l]
2) If the array is sorted and rotated -> then we can divide the search in 2 halves. the sorted half and the unsorted half and we 
know for sure that the inflexion point will always be in the unsorted half.
*/

class Solution {
public:
    int findMin(vector<int>& nums) {
        int l = 0;int r = nums.size()-1;
        while(l < r){
            if(nums[r]>nums[l])return nums[l];
            int mid = l + (r-l)/2;
            if(nums[mid]>=nums[l])l = mid+1;
            else r = mid;
        }
        return nums[l];
        
        
    }
};