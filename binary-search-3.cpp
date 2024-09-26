class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        //O(logn) + O(1)
       int l = 0;
       int r = nums.size()-1;
        while(l<r){//this avoids issue with mid+1 comparison, savse me from null check
            int mid = l+(r-l)/2;
            //if nums[mid]>nums[mid+1], we need to move left, as peak might be there, peak is guarenteed to be on side of bigger element, so it works 
            if(nums[mid]>nums[mid+1]) r = mid;
            //else we move right
            else l = mid+1;
        }
        return l;
    }
};
