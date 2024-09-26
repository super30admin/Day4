class Solution {
public:
    int findMin(vector<int>& nums) {
        int low = 0;
        int high = nums.size() - 1;
        while(low <= high){
            //base case: if the array turns out to be sorted
            if(nums[low] < nums[high]){
                return nums[low];
            }
            int mid = low + (high - low)/2;
            //The minimum element is always lesser than its immediate neighbbors
            if((mid == low || nums[mid] < nums[mid - 1]) && (mid == high || nums[mid] < nums[mid + 1])){
                return nums[mid];
            }
            
            if(nums[low] <= nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
};