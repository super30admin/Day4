    /*  Explanation
    Time Complexity for operators : log(n)
    Extra Space Complexity for operators : o(1) .. No extra space
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
    Minimum in sorted array means it's previous element is higher and next element is loweer than the minnium element itself
    The implemntation consists dividing array and then compare an element with previous and next element. If condition matches then return itself.
    else compare  mid and high if mid is greater then go towards right else go towards left.
    */

public class findmininRotatedSortedArray{
    public static void main(String args[]){
            int arr[] = new int[]{5,7,8,10};
            int arr1 = findMin(arr);
            System.out.println(arr1);
    }
   
    public static int findMin(int[] nums){
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if((mid == 0 || nums[mid-1] > nums[mid]) && (mid == nums.length-1 || nums[mid+1] > nums[mid]))
                return nums[mid];
            else if(nums[mid] > nums[high]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }    
        return -1;
    }
}