
package BinarySearch2;

/*      Successfully ran on leetcode
*       Time complexity: O(logn)
*       Space complexity: O(1)
*
* */

public class FirstLastPositionOfElementInSortedArray {

    public static void main(String args[]){
        int a[] = {5};
        int target = 5;
        int firstLast[] = searchRange(a,target);
        System.out.println(firstLast[0]+" "+ firstLast[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
            int indices[] = new int[2];
            indices[0] = binarySearch(nums,target,true);
            indices[1] = binarySearch(nums,target,false);
            return indices;
    }

    public static int binarySearch(int[] nums, int target, boolean firstOccurence){
            int result = -1;
            int high = nums.length-1;
            int low = 0;
            while(high >= low ){
                int mid = low + (high - low)/2;
                if(nums[mid] == target) {
                    result = mid;
                    if(firstOccurence)
                        high = mid -1;
                    else
                        low = mid + 1;
                }
                else if(target > nums[mid])
                    low = mid+1;
                else
                    high = mid - 1;
            }
            return result;
    }


}

