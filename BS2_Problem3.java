// Time Complexity : O(Log N base 2)
// Space Complexity : O(1)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*

Here, the neighbour of mid element is greater than mid element, peak element will be on that side .

So, if mid is greater than both of its neighbours then mid element is peak element and return element at mid index.

If left neighbour is greater, move to left part otherwise move to right part

*/


class FindPeak {
    public int findPeakElement(int[] nums) {
        if(nums == null && nums.length == 0){
            return -1;
        }
        
        int l = 0, h = nums.length - 1;
        
        while(l <= h){
            int mid = l + (h - l) / 2;
            
            if((mid == 0 || nums[mid] > nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])){
                return nums[mid];
            }
            else if(mid != 0 && nums[mid] < nums[mid - 1] ){
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        
        return -1;
    }
}

public class BS2_Problem3 {
    public static void main(String[] args){
        FindPeak f = new FindPeak();

        int[] nums = {1,2,3,1};
        System.out.println("Peak element is : " + f.findPeakElement(nums));
    }
}