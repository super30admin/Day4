package BinarySearch2;

/*          Successfully ran on leetcode
*           Time Complexity: O(logn)
*           Space Complexity: O(1)
* */

public class FindMinElementInRoatedSortedArray {
    public static void main(String args[]){
        int a[] = {4,5,6,7,1,2};
        System.out.println(findMin(a));
    }

    public static int findMin(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        else if(nums[nums.length -1] > nums[0])
            return nums[0];
        else{
            int low = 0;
            int high = nums.length-1;
            while(high >= low){
                int mid = low +(high - low)/2;
                if(nums[mid] > nums[mid+1])
                    return nums[mid+1];
                else if(nums[low] > nums[mid])
                    high = mid -1;  // search in unsorted part
                else
                    low = mid + 1;
            }
            return nums[0];
        }
    }
}
