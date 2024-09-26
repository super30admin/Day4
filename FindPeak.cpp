// Time Complexity = O(log(n))
// Space Complexity = O(1)
// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Find Peak Element.
// Memory Usage: 8.8 MB, less than 50.21% of C++ online submissions for Find Peak Element.



class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        
        int n = nums.size();
        
        int l = 0, r = n-1;
        
        while(l <= r){
            if(l == r) return l;
            
            int mid = l + ((r-l)>>1);
            
            if(nums[mid] > nums[mid+1])
            {
                r = mid;
            }else
            {
                l = mid+1;
            }
        }
        return -1;
    }
};