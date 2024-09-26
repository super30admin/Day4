// Time Complexity : O(log(n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : figuring out the code for many of the edge cases

class MinimumInSortedPivotedArray {
    public int findMin(int[] nums) {
        
        int low = 0;
        int high = nums.length - 1;

        while(low<=high) {

            int mid = (low + high) / 2;
            //System.out.println("low: " + low + " mid: " + mid + " high: " + high + " ele: " + nums[mid]);

            // If the array is already sorted, the minimum element is the first element
            if(nums[high] > nums[0]) {
                return nums[0];
            }

            // If the array contains a single element, that is the minimum element
            else if(nums.length == 1) {
                return nums[0];
            }

            // If mid is at index 0 and it's not the minimum, increment the low index
            else if(mid == 0) {
                if(nums[0] > nums[1]) {
                    low = 1;
                }
            }

            // If the minimum is at the last index, all pointers evetually would point to the last index
            else if(low == nums.length - 1 && mid == nums.length - 1 && high == nums.length - 1) {
                return nums[mid];
            }

            // If an element at mid is smaller than both its neighbors, it's the minimum element
            else if(nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1]) {
                return nums[mid];
            } 

            // If element at mid is larger than element at high, search the right part of the array
            else if(nums[mid] > nums[high]) {
                low = mid + 1;
            } 
            
            // Else search the left part of the array
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}

class MainMinPivoted {
    public static void main(String[] args) {
        MinimumInSortedPivotedArray s = new MinimumInSortedPivotedArray();
        System.out.println(s.findMin(new int[]{1}));
    }
}