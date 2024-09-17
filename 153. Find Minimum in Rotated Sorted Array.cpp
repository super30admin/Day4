//Time Complexity = O(log n)
//Space Complexity = O(1)
//To find the element in the rotated sorted array we have to go to the unsorted part of the array.
class Solution {
public:
    int findMin(vector<int>& nums) {
        int low = 0, high = nums.size()-1;
        if(nums[low] <= nums[high])
            return nums[low];
        int mid;
        while(low<=high)
        {
            mid = low+(high-low)/2;
            if(nums[low] <= nums[high])
                return nums[low];
            if((mid == 0 || nums[mid-1]>nums[mid]) && (mid == nums.size()-1 || nums[mid]<nums[mid+1]))
                return nums[mid];
            else if(nums[low]<=nums[mid])
                low = mid+1;
            else 
                high = mid-1;  
        }
        return 9999;
    }
};
