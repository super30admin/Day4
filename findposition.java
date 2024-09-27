//Time Complexity : O(log N)
//Space Complexity : O(1)
// did you try it on leetcode : yes

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[][](-1,-1);
        int first = binarysearch(nums , target ,true);
        int last = binarysearch(nums , target , false);
        return new int[](first,last);
        }
    private int binarysearch(int[] nums , int target , boolean first)
    {
        int low = 0;
        int high = nums.length;
        while(low<=high)
        {
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
            {
                //First Occurence
                if(first)
                {
                  if(mid == 0 || nums[mid] > nums[mid-1])
                      return mid;
                    else
                    {
                        high = mid - 1;
                    }
                }
                //Last Occurence
                else
                {
                  if(mid == nums.length || nums[mid]< nums[mid+1])
                      return mid;
                    else
                    {
                        low = mid + 1;
                    }
                }
            }
            else if(nums[mid] > target)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        
    }
    }
}