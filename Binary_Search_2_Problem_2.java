//Time Complexity : O(logn)
//Space Complexity : O(1) As no auxilary space is used
// Runs successfully on leetcode
// Problems :  If the array is already sorted, we return the left pointer


/*
We are using the basic binary search here, we need to check if the element is
lesser than both of it's minimum.
If the array if sorted already, we need to return the number on the left index
 */

public class Binary_Search_2_Problem_2 {
    public static int findMin(int[] nums) {
        if(nums == null || nums.length == 0)return -1;
        int left = 0 ;
        int right = nums.length -1;
        while(left<=right)
        {
            if(nums[left]<nums[right]) return nums[left];
            int mid = left + (right - left)/2;
            if((mid==0 || nums[mid]<nums[mid-1]) && (mid==nums.length-1 || nums[mid]< nums[mid+1]))
            {
                return nums[mid];
            }
            else if(nums[left]<=nums[mid])
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
        int[] arr= {4,5,6,7,0,1,2};
        System.out.println(findMin(arr));
    }


}
