// Time Complexity : O( Log n) since we are dividing the arr and checking.
// Space Complexity : O(1) since only extra variables and no other copy of arr is created.
// Did this code successfully run on Leetcode : Yes; (https://leetcode.com/submissions/detail/636536956/)
// Any problem you faced while coding this : No;
// My Notes : The idea is to move to the direction, where the value is higher, so that there is chance you will find the peak or it might be at the end, 
// since the end are - infinity, you can return them. If mid reaches start, then check with the rightElem or mid reached end then check with the left Elem.
class FindPeakElem {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midLeftElem = mid - 1;
            int midRightElem = mid + 1;
            int midElem = nums[mid];
            System.out.println(" left, mid, right " + start + "," + mid + "," + end);
            //  If mid reaches start, then check with the rightElem or mid reached end then check with the left Elem.
            if ((mid == 0 || midElem > nums[midLeftElem]) && ((mid == nums.length-1) || midElem > nums[midRightElem])) {
                // peak found else continue
                return mid;
            }
            
            if (mid == 0 || nums[mid-1] < nums[mid]) {
                // Search right side; move towards the greater side
                start = mid + 1;
                
            } else  {
                // Search left side; move towards the greater side
                end = mid - 1;
               
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Hey there");
        FindPeakElem obj = new FindPeakElem();
        int[] nums = { 0, 1 };
        System.out.println(obj.findPeakElement(nums));
    }
}