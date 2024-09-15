package S30_Codes.Binary_Search_2;

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Binary-Search-2

class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;

            boolean midGtLeft = (mid == 0) || (nums[mid] > nums[mid-1]);
            boolean midGtRight = (mid == nums.length-1) || (nums[mid] > nums[mid+1]);

            if(midGtLeft && midGtRight)
                return mid;
            if(midGtLeft)
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }
}