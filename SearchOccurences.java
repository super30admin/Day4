// Time Complexity : O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class SearchOccurences {
        public int[] search(int[] nums, int target) {
            
            int firstOccurrence = this.find(nums, target, true);
            
            if (firstOccurrence == -1) {
                return new int[]{-1, -1};
            }
            
            int lastOccurrence = this.find(nums, target, false);
            
            return new int[]{firstOccurrence, lastOccurrence};
        }
        
        private int find(int[] nums, int target, boolean isFirst) {
            int N = nums.length;
            int start = 0, end = N - 1;
            
            while (start <= end) {
                
                int mid = (start + end) / 2;
                
                if (nums[mid] == target) {
                    
                    if (isFirst) {
                        
                        // This means we found our first occurrence.
                        if (mid == start || nums[mid - 1] != target) {
                            return mid;
                        }
                        
                        // Search on the left side for.
                        end = mid - 1;
                        
                    } else {
                        
                        // This means we found our second occurrence.
                        if (mid == end || nums[mid + 1] != target) {
                            return mid;
                        }
                        
                        // Search on the right side.
                        start = mid + 1;
                    }
                    
                } else if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            
            return -1;
        }
    }
