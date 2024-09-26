/**
 * Time Complexity : O(logn) where n = size of the array nums
 * Space Complexity : O(1)
 * Approach : If element at mid-1 is less greater than mid, then peak will lie on the left side of mid, else right side
 */
public class Peak {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low<high){
            int mid = low + (high-low)/2;
            if(nums[mid+1]<nums[mid]){
                high = mid;
            }
            else low = mid + 1;      
        }
        return low;
    }
    

    public static void main(String args[]){
        Peak obj =new Peak();
        int[] myArr = {1,2,8,7,5,6,4};
        System.out.println(obj.findPeakElement(myArr));
    }
}