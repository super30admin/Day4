class Solution {
    public int findPeakElement(int[] nums) {
        int i = 0;
        int prev = Integer.MIN_VALUE;
        int next = i + 1;
        int nextValue = 0;
        
        while(i < nums.length) {
            if(next < nums.length) {
                nextValue = nums[next];
            }else{
                nextValue = Integer.MIN_VALUE;
            }
            
            if(nums[i] >= prev && nums[i] >= nextValue) {
                return i;
            }else {
                prev = nums[i];
                i++;
                next++;
            }
        }
            
        
        return -1;
    }
}
