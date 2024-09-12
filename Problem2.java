// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : took time to understand the conditions.


//Approach
/*
Use Binary Search to find the min element. 
In a rotated array, low pointer element is greater than the high pointer element untill it reaches the min value.
So we do a search till nums[low]>nums[high]. Once the condition is false, we have our low pointer at the min value. Return nums[low];
Till the condition is true,  check:
If the mid element < the high element,  it means that we are on the right side of the min element. Move the high to mid elememt
If the mid element is >= the high element, it means we are on the right side of the min element. Move the left to mid+1.

*/


class Problem2 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(nums[low]>nums[high]){
            int mid = low +(high-low)/2;
            if(nums[mid]< nums[high]){
                high = mid;
            }else{
                low = mid+1;
            }
            
            
            
        }
        
         return nums[low]; 
    }
}

class Main{
    public static void main(String args[]){
        Problem2 p = new Problem2();
        int[] nums = {3,4,5,1,2}; 
        System.out.println(p.findMin(nums));
    }
}