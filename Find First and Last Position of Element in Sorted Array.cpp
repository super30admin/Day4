// Approach: if mid reaches the target, it can either be one of the middle targets or the last one. so once we reach the target, 
// take that range and apply BS to find the last index, then continue to find the first index.
// Time: O(log n + log m) -> m for the last index BS inside the main BS
// Space: O(1)

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> result(2, -1); // initialize result arr as [-1,-1]
        
        int l1 = 0, r1 = nums.size() - 1;
        while (l1 <= r1) {
            int mid = l1 + (r1 - l1) / 2;
            if (nums[mid] == target) {
                
                // second bin search for the last index
                if(result[1] == -1) { // checking if last index not found yet, bcoz we want to run this code just once   
                    int l2 = l1;
                    int r2 = r1;
                    while (l2 <= r2) {
                        int m = l2 + (r2 - l2) / 2;
                        if (nums[m] == target) {
                            
                            if (m == nums.size()-1 || nums[m + 1] != target) { // checking if we reached the last element or last index found
                                result[1] = m; // update the result
                                break; // get out of the while
                            }
                            else {
                                l2 = m+1; // means we are still in the middle targets
                            }

                        } else if (nums[m] < target) { // target > mid => target on the right
                            l2 = m + 1;
                        } else {
                            r2 = m - 1; // target on the left (actually this will never be possible)
                        }
                    }
                }

                // back to the original bin search to search the first index
                if (mid == 0 || nums[mid - 1] != target) { // if we reached the first element or the first index of the target
                    result[0] = mid; // update result
                    break; // get out
                }
                else {
                    r1 = mid-1; // means we are still in the middle targets
                }

            } else if (nums[mid] < target) { // target > mid => target on the right
                l1 = mid + 1;
            } else {
                r1 = mid - 1; // target on the left
            }
        }
        
        
        return result;
    }
};