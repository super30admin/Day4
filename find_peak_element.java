TC: O(log n)
SC: O(1)

Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Peak Element.
Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Find Peak Element.
// we just need one peak.We bring the left and right poiters closer to each other.

class Solution {
   
    
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right  = nums.length-1;
        while(left < right){
            int mid= left + (right-left)/2;            
            
            if(nums[mid] < nums[mid+1])
                left= mid+1;
            else
                right= mid;
        }
        return right;
    }
}
