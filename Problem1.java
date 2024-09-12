//Problem: Leetcode34:  Find First and Last Position of Element in Sorted Array
// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Approach
/*
Use Binary Search to find the target element. If the target element is found, do not return. Store the index in result.
If you have to find the first Occurance:Go towards the left of the target element, keep updating result for any occurance of target till low==high. 
If you have to find the last Occurance:Go towards the right of the target element, keeep updating result for any occurance of target till low ==high.
*/

class Problem1 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findOccurance(nums, target, true);
        result[1] = findOccurance(nums, target, false);
        
        return result;
    }
    
    public int findOccurance(int[] nums, int target, boolean isFirst){
        int low =0;
        int high = nums.length-1;
        int result = -1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                result = mid;
                if(isFirst){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else if(target>nums[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return result;
    }
    
}

class Main{
	public static void main(String args[]){
		Problem1 p = new Problem1();
		int[] nums = {5,7,7,8,8,10}; 
		int target = 8;
		int[] result = new int[2];
		result = p.searchRange(nums, target);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}
}
