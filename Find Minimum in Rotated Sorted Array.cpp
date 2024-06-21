// Time: O(log n)
// Space: O(1)

class Solution {
public:
    int findMin(vector<int>& nums) {
        int n = nums.size();

        //if first element <= last element => either array is sorted and not rotated or there is just one element, return the first element
        if(nums[0] <= nums[n-1]) {
            return nums[0];
        }

        int l = 0, r = n-1;
        while(l <= r) {
            int mid = l + (r-l)/2;

            //if at any point there is just one element or the leftmost < rightmost, return leftmost
            if(nums[l] <= nums[r]) {
                return nums[l];
            }

            //if we reach last element OR when mid < both neighbors, return mid element
            else if(mid == n-1 || (mid != 0 && nums[mid] < nums[mid+1] && nums[mid] < nums[mid-1])) {
                return nums[mid];
            }

            //left sorted arr, min element has to be on the right
            else if(nums[mid] >= nums[l]) {
                l = mid+1;
            }

            //right sorted arr, min has to be on the left
            else {
                r = mid-1;
            }
        }
        return 0;
    }
};