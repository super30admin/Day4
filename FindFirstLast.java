/* Time Complexity : O(log n) because we are performing binary search for first index of the target and then performing binary seaarch to find the last index of the target.
 * Space Complexity : O(2) to store the result indices.
 * leetcode : yes
 * Any Problems : no
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        //Intialized the result with -1, if indices are not found we can just return them.
        int[] result = new int[]{-1, -1};
        //edge cases where the array is empty and if the target does't lie in the array range.
        if(nums.length == 0 || (target < nums[0] || target > nums[nums.length-1]))
            return result;
        
        int l =0;
        int h = nums.length;
        //performing binary search to find the starting index of the target, TC : O(log N)
        while(l<=h)
        {
            int m = l + (h-l)/2;
            //if we find the target at mid then we need to perform additional checks whether the mid is the first index
            //by comparing it with its previous element, if it is the first element then that means we can update the result.
            if(nums[m] == target)
            {
                if(m==0 || (m>0 && nums[m] != nums[m-1]))
                {
                    result[0] = m;
                    break;
                }
                else
                    h = m-1;
            }
            else if(nums[m] < target)
                l = m+1;
            else
                h = m-1;
        }
        l = 0;
        h = nums.length-1;
        //performing binary seacrh to find the ending index of the target TC : O(log n)
        while(l<=h)
        {
            int m = l + (h-l)/2;
            //if we find the target at mid then we need to perform additional checks whether the mid is the last index
            //by comparing it with its next element, if it is the last element then that means we can update the result.
            if(nums[m] == target)
            {
                if( m == nums.length-1 || (m<nums.length-1 && nums[m] != nums[m+1]))
                {
                    result[1] = m;
                    break;
                }
                else
                    l = m+1;
            }
            else if(nums[m] < target)
                l = m+1;
            else
                h = m-1;
        }
        //returning the result.
        return result;

    }
}