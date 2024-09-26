class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;

        while(start < end) {

            int mid = start + (end- start) / 2;


            /** if pivot element is less then neighbor right element then traverse right side to find the greatest elements
             index position */
            if(nums[mid] < nums[mid+1]) {

                start = mid + 1;

            }

            else {

                end = mid;

            }
        }

        return start;

    }

}