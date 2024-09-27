package s30Coding;

//time complexity : O(log(n)) worst case O(n)
//space complexity : O(1)

//Leet Code execution :- Yes

//Logic :

//Base case :- 	check if length is 1, if yes return first index
//				check if 2nd element is less than the first element, if yes, return index of first element
//				Perform BST :- if mid is greater than mid-1 and mid+1, that means min is the peak element
//				Traverse conditions for BST :- mid +1 greater than mid, traverse to 2nd half of the array, else first half

public class FindPeakElementInArray {
	
	    public int findPeakElement(int[] nums) {
	        if(nums.length == 0 || nums.length == 1){
	            return 0;
	        }
	        if(nums[1] < nums[0]){
	            return 0;
	        }
	        int left = 0;
	        int right = nums.length - 1;
	        
	        while(left < right){
	            int mid = left + (right -left)/2;
	            if(mid > 0 && nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
	                return mid;
	            }
	            
	            if( nums[mid] > nums[mid+1]){
	                right = mid;
	            }
	            else{
	                left = mid+1;
	            }
	        }
	        return left;
	    }
}
