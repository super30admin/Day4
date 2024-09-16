class Solution {
public:
    int bsearch(int l, int r, vector<int> nums) {
        while(l<r){
            int mid= l+ (r-l)/2;
            if (nums[mid]>nums[mid+1]) { // if the nums[mid] is greater than the nums[mid+1] then shift to the right side
                r=mid;
            } else {
                l=mid+1;
            }
        }
        return l;
    }
    int findPeakElement(vector<int>& nums) {
        int l=0,r=nums.size()-1;
        return bsearch(l,r,nums);
    }
};