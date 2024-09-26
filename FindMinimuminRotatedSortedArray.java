/* Time Complexity :O(logN)
* */
class Solution{
    public int findMin(int[] nums)
    {
        int start=0, end= nums.length-1;
        while(start <= end)
        {
            if(nums[start] <= nums[end])
                return nums[start];
            if(mid !=0 &&nums[mid-1] > nums[mid])
            {
                return nums[mid];
            }

            //pivot is left of mid => only right arr is sorted
            if(nums[mid]< nums[end])
            {
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        return 5002;
    }
}