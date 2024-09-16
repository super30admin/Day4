//Time Complexity:O(logn)
//Space Complexity:O(1)
//Did it run on leet code : Yes

public class minInRotatedArray {
    class Solution {
        public int findMin(int[] nums) {
            //if there array is not rotated or array has only one element
        if(nums[0]<nums[nums.length-1]||nums.length==1){
                return nums[0];
        }
            //comparing mid with first element change decrease high or increase low
            int low =0;
            int high =nums.length-1;
            while(low <= high){
                int mid = (low + high) /2;
                if(nums[mid]>=nums[0]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
          //return low
            return nums[low];
        }
    }
}
