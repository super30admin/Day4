//Time Complexity : O(logn)
//Space Complexity : O(1) As no auxilary space is used
// Runs successfully on leetcode
// Problems :  If the element is not the peak element, we move to the size on which there is a greater element.

/*
Here we are using binary search algorithm
For the element to be the peak element, it needs to be greater than its neighboring elements
If its not the peak, we move the side which has a greater element.
 */



public class Binary_Search_2_Problem_3 {
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0)return -1;
        int left = 0 ;
        int right = nums.length -1;
        while (left<=right)
        {
            int mid = left + (right - left)/2;
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.length -1 || nums[mid]>nums[mid+1]))
            {
                return mid;
            }
            else if(mid==0 || nums[mid]>nums[mid-1])
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
    }
}
