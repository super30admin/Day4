//Time Complexity: O(logn)
//Space Complexity: O(1)

public class MinValueOfRotatedArray {
    public static int findMin(int[] nums) {
        int i = 0, j = nums.length - 1;
        if(nums[0] < nums[nums.length-1] || nums.length == 1)
            return nums[0];
        if(nums.length == 0)
            return -1;
        while (i < nums.length && j < nums.length && i <= j) {
            int m = (i+j)/2;
            //check if min is larger than mid+1 if true return the mid+1 element
            if (m+1 < nums.length && nums[m] > nums[m+1]) 
                return nums[m+1];
            //check if the mid is lesser than the mid-1 element and mid is also lesser than the mid+1 element if true return mid element
            if (nums[m] < nums[m-1] && m+1 < nums.length && nums[m] < nums[m+1]) {
                return nums[m];
            }
            //if mid is greater than 0 index elemnt than the min will be on right else on left
            if(nums[m] > nums[0])
                i=m+1;
            else{
                j=m-1;
            }
        }
        return -1;  
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }    
}