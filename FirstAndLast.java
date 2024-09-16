#time complexity = O(logn)
 #space complexity = O(1)
#
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int h = nums.length-1;
        int index = 0;
        int[] ans = {-1,-1};
        
        if(nums.length == 0) return ans;
        if(nums.length == 1 && nums[0] == target) return new int[] {0,0};
        while(l<=h){
            int m = l+(h-l)/2;
            if(nums[m] == target){
                h =m-1;
                if(m==0 || nums[m-1] != nums[m])
                    ans[0] = m;
            }
            else if(nums[m]<target)
                l = m+1;
            else
                h = m-1;
        }
        if(ans[0] == -1){
            return ans;
        }
        l = 0;
        h = nums.length-1;
        while(l<=h){
            int m = l+(h-l)/2;
            if(nums[m] == target){
                l = m+1;
                if(m == nums.length-1 || nums[m+1] != nums[m])
                    ans[1] = m;
            }
            else if(nums[m]<target)
                l = m+1;
            else
                h = m-1;
        }
        return ans;
    }
}
