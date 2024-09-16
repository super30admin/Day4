
// Time Complexity: O(logn);
// Space Complexity: O(1);

class MInInRotatedSubArray{

    public int findMin(int[] nums) {
        int left =0; int right = nums.length-1;
        int mid;

        if (nums.length == 1) {
            return nums[0];
        }

        if(nums[right] > nums[left]) return nums[0];

        while(left <= right){
            mid = left + (right - left)/2;


            if( nums[mid] > nums[mid+1]) return nums[mid+1];

            if(nums[mid-1] > nums[mid]) return nums[mid];

            if(nums[left]> nums[mid]){

                right = mid-1;
            }
            else {

                left = mid+1;
            }
        }

        return -1;

    }
}