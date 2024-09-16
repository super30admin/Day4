class Solution {
public:
    int findMin(vector<int>& nums) {

        if(nums.empty() || nums.size() == 0) return -1;

        int low = 0;
        int high = size(nums) - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if (mid == 0 && (nums[mid] < nums[mid - 1])){
                return nums[mid];
            }
            else if ((nums[low] <= nums[mid])  && (nums[mid] > nums[high])){
                low = mid + 1;
            }else{
                high = mid - 1;
            }

        }
        return nums[low];

    }
};
