class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int low = 0;
        int high = nums.size() - 1;
        int mid;
        while(low <= high){
            mid = low + (high - low)/2;
            if((mid == low || nums[mid] > nums[mid -1]) && (high == mid || nums[mid] > nums[mid + 1])){
                return mid;
            }
            //move towards the highest element to eventually find the peak
            if(high == mid || nums[mid] < nums[mid + 1]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
};