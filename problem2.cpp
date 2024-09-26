/*
Time complexity - O(logN)
space complexity - O(1)
*/
class Solution {
public:
    int findMin(vector<int>& nums) {
        if (nums.size() == 0) return -1;
        int l = 0, r = nums.size() - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (mid != 0 && nums[mid - 1] > nums[mid]) return nums[mid];
            else if (nums[l] > nums[mid]) r = mid - 1;
            else if (nums[l] < nums[mid] && nums[l] > nums[r]) l = mid + 1;
            else if (nums[l] <= nums[mid] && nums[l] <= nums[r]) return nums[l];
            else return nums[r];
        }
        return -1;
    }
};