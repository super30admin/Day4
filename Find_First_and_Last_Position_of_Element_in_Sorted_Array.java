/*
Time Complexity- O(log n)
Space Complexity- O(n)
Problem solved after class
 */
class Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    int[] output = new int[]{-1,-1};
    public int[] searchRange(int[] nums, int target) {

        if(nums.length == 0 || nums == null) return output;
        int left = 0, right = nums.length-1;

        binarySearch(nums, left, right, target, true);
        binarySearch(nums, left, right, target, false);

        return output;

    }

    private void binarySearch(int[] nums, int left, int right, int target, boolean isLeft){

        while(left <= right){
            int mid = left + (right-left)/2;

            if(nums[mid] == target){
                if(isLeft) {
                    output[0] = mid;
                    right = mid-1;
                }

                else{
                    output[1] = mid;
                    left = mid+1;
                }
            }
            else if(nums[mid] < target)
                left = mid+1;
            else
                right = mid -1;
        }
    }
}