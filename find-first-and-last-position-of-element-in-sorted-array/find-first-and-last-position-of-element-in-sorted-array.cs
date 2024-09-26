public class Solution {
    public int[] SearchRange(int[] nums, int target) {
        if(nums==null || nums.Length ==0) return new int[]{-1,-1};
       int[] targetrange = new int[] {-1,-1}; 
        for(int i=0;i<nums.Length;i++)
        {
            if(nums[i]==target)
            {
                targetrange[0]=i;
                break;
            }
        }
        
        if(targetrange[0]==-1)
        {
            return targetrange;
        }
        
        for(int j=nums.Length-1;j>=0;j--)
        {
            if(nums[j]==target)
            {
                targetrange[1]=j;
                break;
            }
        }
        return targetrange;
        
    }
}
