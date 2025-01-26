public class MinElement {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l =0;
        int h = n-1;

        while(l <= h){

            if(nums[l] <= nums[h]){
                return nums[l];
            }

            int mid = l + (h-l)/2;

            //check pivot
            if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == n - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }//else check which array partition is unsorted
            else if(nums[l] <= nums[mid]){
                l = mid +1;
            }else{
                h = mid - 1;
            }
        }
        return -1;
    }
}

//Time Complexity -> O(log(n))
//Space Complexity -> O(1)