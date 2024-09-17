//Time complexity is O(log n)
//Space complexity is O(1)
//able to submit code in leetcode
class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        return new int[]{findleft(nums, target), findright(nums, target)};
    }
    public int findleft(int[] nums, int target){
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            //System.out.println(l);
            //System.out.println(r);
            int m = l+(r-l)/2;
            if(nums[m]==target){
                if((m)==0 || nums[m-1]!=target){
                    return m;
                }
                r=m-1;
            }
            else if(target>nums[m]){
                l=m+1;
            }
            else{
                r = m-1;
            }
        }
        return -1;
    }

    public int findright(int[] nums, int target){
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            //System.out.println(l);
            //System.out.println(r);
            int m = l+(r-l)/2;
            if(nums[m]==target){
                if((m)==r || nums[m+1]!=target){
                    return m;
                }
                l=m+1;
            }
            else if(nums[m]>target){
                r = m-1;
            }
            else{
                l=m+1;
            }
        }
        return -1;
    }
}