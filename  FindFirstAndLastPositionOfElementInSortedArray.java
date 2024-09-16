class Solution {
    /* Perform 2 binary searches. One to find the left most element
    Second to find the right most element.
    Time complexity: 2*O(logN)
    Space compelxity: O(1)
    * */
    public int[] searchRange(int[] nums, int target) {
        int min=0;
        int max=nums.length-1; int i = -1; int j = -1;
        int mid=0;
        int[] returnValue;
        
        if(nums==null ||nums.length==0) 
            return new int[]{-1,-1};
        //Finding the lest most element
        while(min<=max)
        {
            mid=min+(max-min)/2;
            if(target==nums[mid])
            {
                /* We found the target:
                1. If there is a nums on the left of the target and it is smaller than the target OR
                if it is the left most element, then we have found the left most target
                2. We found the target, but it is not the left most element OR the element on its left
                is not smaller than target, that'd mean that there is at least one more element ==
                target on the left, so move high to left of mid.
                */
                if((mid-1>=0 && nums[mid-1]<target) || mid==0)
                {
                    i=mid;
                    break;
                }
                else
                    max=mid-1;
            }
            else if(target<nums[mid])
                max=mid-1;
            else
                min=mid+1;
        }
        
        if(i==-1)
            return new int[]{-1,-1};
        else
        {
            min = i;
            max = nums.length-1;
        }
        while(min<=max)
        {
            mid=min+(max-min)/2;
            /* We found the target:
                1. If there is a nums on the right of the target and it is greater than the target OR
                if it is the right most element, then we have found the right most target
                2. We found the target, but it is not the right most element OR the element on its
                right is not greater than target, that'd mean that there is at least one more 
                element == target on the right, so move min to right of mid.
                */
            if(target==nums[mid])
            {
                if((mid+1<=nums.length-1 && nums[mid+1]>target) || mid==nums.length-1)
                {
                    j=mid;
                    break;
                }
                else
                    min=mid+1;
            }
            else if(target<nums[mid])
                max=mid-1;
            else
                min=mid+1;
        }
        return new int[]{i,j};
    }
}