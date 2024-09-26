package BinarySearch2;

/*          Successfully ran on leetcode
*           Time Complexity: O(logn)
*           Space Complexity: O(1)
*
* */

public class PeakFinding {
    public static void main(String args[]){
        int a[] = {2,3,4,1,6,8,10,12,14,13};
        System.out.println(findPeakElement(a));
    }

    public static int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;
        int low = 0;
        int high = nums.length -1;
        while(high >= low){
            int mid = low+ (high-low)/2;
            if(mid == 0 && nums[mid] > nums[mid+1])
                return mid;
            else if(mid == nums.length-1 && nums[mid] > nums[mid-1])
                return mid;
            else if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1])
                return mid;
            else{
                if(nums[mid+1] > nums[mid])
                    low = mid+1;
                else if(nums[mid-1] > nums[mid])
                    high = mid -1;
            }
        }
        return -1;
    }
}
