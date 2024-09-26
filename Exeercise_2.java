class Solution {
    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while(start < end) {

            int mid = start + (end - start) / 2;


            /** if pivot element is less then end element then traverse left most part else traverse right most part*/
            if(nums[mid] < nums[end]) {

                end = mid;

            }

            else {

                start = mid + 1;

            }


        }

        return nums[start];
    }

}