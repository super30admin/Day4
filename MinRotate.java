#time complexity = O(logn)
 #space complexity = O(1)
  
class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length-1;
        while(l<=h){
            int m = (l/2) + (h/2);
            if(nums[l]<=nums[h]) return nums[l]; 
            if((m==0 || nums[m]<nums[m-1]) && (m==nums.length-1 || nums[m]<nums[m+1]))
                return nums[m];
            else if(nums[l]<=nums[m]){
                    l = m+1;
                }else{
                    h = m-1;
                }
        }
         return 897;
    }
}
