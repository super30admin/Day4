// Time Complexity: O(logn)
// Space Complexity: O(1)
public class FindPeakElementInArray {
    public static int findPeakElement(int[] nums) {
        // int max = nums[0], index = 0;
        // for(int i=1; i<nums.length; i++){
        //     System.out.println(nums[i]);
        //     if(i+1 < nums.length && max < nums[i] && nums[i-1] < nums[i] && nums[i] > nums[i+1]){
        //         max = nums[i];
        //         index = i;
        //     }
        //     else if(i+1 == nums.length && nums[i] > max){
        //         max = nums[i];
        //         index = i;
        //     }
        // }
        return bs(nums, 0, nums.length-1);
    }
    
    public static int bs(int[] nums, int l, int r){
        int m = (l+r)/2;
        if (l == r) 
            return m; 
        if (nums[m] > nums[m+1]) 
            return bs(nums, l, m); 
        return bs(nums, m+1, r); 
        
    }
    public static void main(String[] args) {
        int[] nums = {1,1,3,4,5,6};
        System.out.println(findPeakElement(nums));
    }
}