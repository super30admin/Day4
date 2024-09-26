// Time Complexity : O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no
/*Approach
*we have to find the pivot od the rotated array and it will always be on the unsorted size because that's where it is different
*we will divide the array and always choose the unsorted side
* the point where the element is smaller than both of its neighbouring element is the pivot
 */

public class FindMinimumInRotatedSortedArray {
    public int findMinimum(int arr[]){
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = low+(high - low)/2;
            if((mid == 0  || arr[mid]<arr[mid-1])&& (mid == arr.length-1 || arr[mid]<arr[mid+1]) ){
                return mid;
            }
            if(arr[mid] < arr[high]) high = mid-1;
            else low = mid +1;
        }
        return -1;

    }
    public static void main(String args[]){
        FindMinimumInRotatedSortedArray obj = new FindMinimumInRotatedSortedArray();
        int position  = obj.findMinimum(new int[]{3,4,5,1,2});
        System.out.println("Minimum was found in position "+position);

    }
}