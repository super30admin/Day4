class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
    int idx1 = lower_bound(nums, target);
    int idx2 = lower_bound(nums, target+1)-1;
    if (idx1 < nums.size() && nums[idx1] == target)
        return {idx1, idx2};
    else
        return {-1, -1};
}

 //I implemented stl function of std::lower_bound https://www.cplusplus.com/reference/algorithm/lower_bound/
 //target+1 works because, the best pointer can go o is at the last element (notice we are returning l, not mid here) so even if we don't find target+1 in array, we simply go to whatever the next element 
 // in the array is since function by nature has to return value not less than the target
 //T.C O(logn), S.C O(1)
int lower_bound(vector<int>& nums, int target) {
    int l = 0, r = nums.size()-1;
    while (l <= r) {
        int mid = l+ (r-l)/2;
        if (nums[mid] < target)
            l = mid+1;
        else
            r = mid-1;
    }
    return l;
}
};
