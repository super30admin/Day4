//Time Complexity : O(logn) (logn + logn)
//Space Complexity : O(1) As no auxilary space is used
// Runs successfully on leetcode
// Problems :  No problem


/*
As we are supposed to find first and last index, we need to
apply to separate binary searches for that.
 */




public class Binary_Search_2_Problem_1 {
    public static int[] searchRange(int[] nums, int target)
    {
        if(nums== null || nums.length ==0)
        {
            return new int[]{-1,-1};
        }
        return new int[]{BinarySearchFirst(nums,target),BinarySearchLast(nums, target)};
    }
    public static int BinarySearchFirst(int[] nums,int target)
    {
        int left =0;
        int right = nums.length -1;
        while(left<=right)
        {
            int mid = left + (right - left)/2;
            if(nums[mid]==target)
            {
                if(mid-1==-1 || nums[mid]>nums[mid-1])
                {
                    return mid;
                }
                else
                {
                    right = mid -1;
                }
            }
            else if(nums[mid] < target)
            {
                left = mid + 1;
            }
            else
            {
                right = mid -1;
            }
        }
        return -1;
    }
    public static int BinarySearchLast(int[] nums,int target)
    {
        int left =0 ;
        int right = nums.length-1;
        while(left<=right)
        {
            int mid = left + (right-left)/2;
            if(nums[mid]==target)
            {
                if(mid+1==nums.length || nums[mid] < nums[mid+1])
                {
                    return mid;
                }
                else
                {
                    left = mid +1;
                }
            }
            else if(target < nums[mid])
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {1};
        int[] arrz = searchRange(arr,1);
        System.out.println(arrz[0] + " "+ arrz[1]);
    }
}
