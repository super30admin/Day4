//time O(log n)
//Space O(1)
//Leetcode yes
//issues: none
class Solution {
public:
    int findMin(vector<int>& nums) {
        int n = nums.size();
        int start = 0;
        int end = n-1;
        int mid =0;

        if(nums[0] <= nums[n-1]) return nums[0];
        
        while(start <=end){
            mid = start + (end-start)/2;     
            if(nums[mid] <= nums[n-1]) {
                end = mid -1;
            } else {
                start = mid+1;
            }
        }
        return nums[start];
    }
};
