// This solutin uses binary search to first find the occurence of the element and 
//then uses binary search again to find the first occurence of the element and last occurence of the elements
// Time Complexity: O(log n)
//Space complexity: O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int midIndex;
        while (low <= high) {
            midIndex = low + (high - low) / 2;
            if (nums[midIndex] == target) {

                int chigh = midIndex;
                int cmid;
                while (low < chigh) {
                    cmid = low + (chigh - low) / 2;
                    if (nums[cmid] < target) {
                        low = cmid + 1;
                    } else
                        chigh = cmid;
                }
                int firtOccurence = low;
                low = midIndex;
                while (low <= high) {
                    midIndex = low + (high - low) / 2;
                    if (nums[midIndex] > target) {
                        high = midIndex - 1;
                    } else
                        low = midIndex + 1;
                }
                int lastOccurence = high;
                return new int[] { firtOccurence, lastOccurence };
            } else if (nums[midIndex] < target) {
                low = midIndex + 1;
            } else {
                high = midIndex - 1;
            }
        }

        return new int[] { -1, -1 };
    }
}