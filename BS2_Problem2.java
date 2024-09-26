// Time Complexity : O(Log N base 2)
// Space Complexity : O(1)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/* 

In rotatted search array, we will get at least one side completely sorted

So, we check for first case as if it is already sorted or not by checking value of first and last index of the array -- If is it, return first element 

Then at mid index, we check for left/right side is sorted ? -- If mid is less than both of its neighbiurs then it is minimum element
Otherwise if mid element is greater than low element == Left is sorted -- Move to right part by changing value of low
Otherwise go to left by changing the value of high bcz right part is sorted

*/

class RotatedArraySearch {
    public int findMin(int[] nums) {
        if(nums == null && nums.length == 0){
            return -1;
        }
        
        int l = 0, h = nums.length - 1;
        
        while(l <= h){
            int mid = l + (h - l) / 2;
            
            if(nums[l] <= nums[h]) return nums[l];
           
            
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])){
                return nums[mid];
            }
            else if(nums[l] <= nums[mid] ){
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }
        
        return -1;
    }
}






public class BS2_Problem2 {
    public static void main(String[] args){
        RotatedArraySearch r1 = new RotatedArraySearch();

        int[] nums = {3,4,5,1,2};

        System.out.println("Min in Rotated SearcH ARRAY : " + r1.findMin(nums));
    }
}
