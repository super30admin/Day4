/*
time complexity - O(N)
space complexity - O(1)
*/
class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        if (nums.size() == 0) return -1;
        int l = 0, r = nums.size() - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if ((mid < nums.size() - 1) && nums[mid] < nums[mid + 1]) l = mid + 1;
            else if ((mid != 0) && nums[mid - 1] > nums[mid]) r = mid - 1;
            else return mid;
        }
        return -1;
    }
};