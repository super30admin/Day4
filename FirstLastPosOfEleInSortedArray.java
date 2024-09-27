// Time Complexity : O(logn) n is size of input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {

    public int findPosition(boolean firstOccurence, int[] nums, int target)
    {
        int l=0, h=nums.length-1;

        while(l<=h)
        {
            int mid = l + (h-l)/2;

            if(target == nums[mid])
            {
                //we're looking for the first occurence
                if(firstOccurence)
                {
                    //1. if target is the first index of array, or
                    //2. ele just before mid is not target itself
                    //then this is the first occurence
                    if(mid==l || nums[mid-1]!=target)
                        return mid;
                    h = mid-1; //if not first occurence, discard right half
                }
                else //we're looking for last occurence
                {
                    //1. if target is the last index of array, or
                    //2. ele just after mid is not target itself
                    //then this is the last occurence
                    if(mid==h || nums[mid+1]!=target)
                        return mid;
                    l=mid+1; //if not last occurence, discard left half
                }
            }
            //continue with binary search of at least one occurence of target
            else if (target < nums[mid])
                h = mid-1;
            else
                l = mid+1;
        }

        return -1;
    }

    public int[] searchRange(int[] nums, int target) {

        //find the first occurence
        int first = findPosition(true, nums, target);

        //return if first occurence not found
        if(first==-1)
            return new int[] {-1, -1};

        //find the second occurence
        int second = findPosition(false, nums, target);

        return new int[] {first, second};
    }
}
