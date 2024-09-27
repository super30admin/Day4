// Time Complexity : T(n) = O(logn)
// Space Complexity :S(n)=O(1)
// Did this code successfully run on Leetcode :yes

class Solution {
public:
    vector<int> nums1;
    vector<int> searchRange(vector<int>& nums, int target) {
        nums1.push_back(-1);
        nums1.push_back(-1);
        int low=0;
        int high=nums.size()-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target && mid==low)
            {
                nums1[0]=mid;
                break;
            }
            else if(nums[mid]==target && nums[mid-1]!=target)
            {
                nums1[0]=mid;
                break;
            }
            else if(nums[mid]==target && nums[mid-1]==target)
            {
                high=mid-1;
            }
            else if(nums[mid]>target)
            {
                high=mid-1;
            }
            else if(nums[mid]<target)
            {
                low=mid+1;
            }
        }
         low=0;
         high=nums.size()-1;
         while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target && mid==high)
            {
                nums1[1]=mid;
                break;
            }
            else if(nums[mid]==target && nums[mid+1]!=target)
            {
                nums1[1]=mid;
                break;
            }
            else if(nums[mid]==target && nums[mid+1]==target)
            {
                low=mid+1;
            }
            else if(nums[mid]>target)
            {
                high=mid-1;
            }
            else if(nums[mid]<target)
            {
                low=mid+1;
            }
        }
        return nums1;
    }
};
