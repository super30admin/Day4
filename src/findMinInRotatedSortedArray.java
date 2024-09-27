// Time Complexity :O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class findMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int l=0;
        int h=nums.length-1;
        while(l<=h){
            int mid = l + (h-l)/2;
            int a = nums[mid];
            int b = mid-1 >= 0 ? nums[mid-1] : nums[mid];
            int c = mid+1 < nums.length  ? nums[mid+1] : nums[mid];
            if(a<=b && a<=c){
                return a;
            }
            else {
                if(nums[mid] < nums[h]){
                    h = mid-1;
                }else if( nums[mid] >= nums[h]){
                    l = mid+1;
                }
            }
        }
        return -1;
    }
}
