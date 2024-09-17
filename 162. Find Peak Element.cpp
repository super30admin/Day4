//Time Complexity = O(log n)
//Space Complexity = O(1)
class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int low = 0, mid, high = nums.size()-1;
        while(low<=high)
        {
            mid = low + (high-low)/2;
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.size()-1 || nums[mid]>nums[mid+1]))
                return mid;
            else if(mid!=nums.size()-1 && nums[mid]<nums[mid+1])
                low = mid+1;
            else
                high = mid - 1;
        }
        return 1;
    }
};
