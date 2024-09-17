    /*  Explanation
        Time Complexity for operators : log(n)
        Extra Space Complexity for operators : o(1) .. No extra space
        Did this code successfully run on Leetcode : Yes
        Any problem you faced while coding this : No
        The peak element is nothing but the element with both left and right of it has lower element.
        The result may contain multiple outputs. Return any of the one from it.
        Find mid and traveese to thr right by comparing the element of mid and if it
        is not greater thentraverse to left.
    */

public class findmininRotatedSortedArray{
    public static void main(String args[]){
            int arr[] = new int[]{1,2,3,1};
            int arr1 = findPeak(arr);
            System.out.println(arr1);
    }
   
    public static int findPeak(int[] nums){
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if((mid == 0 || nums[mid-1] < nums[mid]) && (mid == nums.length-1 || nums[mid+1] < nums[mid]))
                return mid;
            else if(nums[mid+1] > nums[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }    
        return -1;
    }
}