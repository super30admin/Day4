// Time Complexity: O(log n) where n is the size of the nums array
// Space Complexity: O(1)
public class Solution {
    public int FindMin(int[] nums) {
        int s = 0, e = nums.Length-1;
        
        // if the array is not rotated it is sorted already
        // or if array size is 1
        if(nums[s] <= nums[e])
            return nums[s];
        
        
        // applying binary search
        while(s<=e){
            int m = s + (e-s)/2;
            
            // if mid element is greater than next then mid+1 is the smallest
            // mid+1 would be the point of change
            if(nums[m]>nums[m+1])
                return nums[m+1];
            
            // if mid element is less than previous then mid is the smallest
            // mid would be the point of change
            if(nums[m-1]>nums[m])
                return nums[m];
            
            if(nums[s] < nums[m])
                s = m+1;
            else
                e = m-1;
        }
        
        return Int32.MaxValue;
    }
}