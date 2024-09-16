/* We just make the middle the peak to begin with. 
We will move whichever way we find an element greater than the mid element. 
If there's no element greater than mid element in both sides, then we found our element.
The peak element could be the left most element or the right most element.
So if the element on the left of the right most element is smaller, then right most element is also a peak
Time complexity: O(LogN)
Space complexity: O(1) 
*/
class Solution {
    public int findPeakElement(int[] nums) {
        int high=nums.length-1;
        int low=0;
        int mid; int peak=0;
        
        if(nums.length==1)
            return 0;
        
        while(low<=high)
        {
            mid=(low+(high-low)/2);
            peak = mid;
            /** If there is a element on the right of the middle element, and it greater than the mid, then go through
             * right side of the array. Otherwise, left.
            */
            if(mid+1<=nums.length-1 && nums[mid+1]>nums[mid])
                low=mid+1;
            else if(mid-1>=0 && nums[mid-1]>nums[mid])
                high=mid-1;
            else
                break;
        }
        return peak;
    }
}