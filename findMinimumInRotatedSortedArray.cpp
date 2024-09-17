//time complexity: O(n)
//space complexity:O(1)
//approach: binary search, found the target first, which is the minimum element in array, then used binary search to find the index of that array
//solved on leetcode? yes
//problem faced? yes, it is a brute force approach. Although I'm using binary search but still the complexity will be O(n)
//because I scanned the array linearly to find the min element which is O(n)
class Solution {
public:
    int findMin(vector<int>& nums) {
        int target=INT_MAX;
        for(int i=0; i<nums.size(); i++)
        {
            if(nums[i]<target)
            {
                target=nums[i];
            }
        }
        int l=0;
        int r=nums.size()-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(nums[mid]==target)
                return nums[mid];
            if(nums[l]<=nums[mid])
            {
                if(nums[l]<=target && target<nums[mid])
                    r=mid-1;
                else
                    l=mid+1;
            }
            else
            {
                if(nums[mid]<target && target<=nums[r])
                    l=mid+1;
                else
                    r=mid-1;
            }
        }
        return -1;
    }
};



//Approach -2

class Solution {
public:
    int findMin(vector<int>& nums) {
        int l=0;
        int r=nums.size()-1;
        if(nums[r]>nums[l] || nums.size()==1)
            return nums[l];
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(nums[mid]>nums[mid+1])
            {
                return nums[mid+1];
            }
            else if(nums[mid-1]>nums[mid])
            {
                return nums[mid];
            }
            if(nums[mid]>nums[0])
            {
                l=mid+1;
            }
            else
            {
                r=mid-1;
            }
        }
        return -1;
    }
};