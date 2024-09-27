
//Time Complexity: O(log N ) where N represents the number of elements in the array
//Space complexity: O(1) since we are not using any extra data structure to store values
/* This is a modified binary search, If the last element is greater than middle element then we know that minimum element will be in first half of the array
 * So, we retrict our search to first half, or else we move to the other half of the array until we start index becomes less than ending index.
 * */
public class find_mid {
	
	public int find_mid_rotated(int nums[]) {
		int st = 0;
		int end = nums.length-1;
		
		while(st<end) {
			int mid = st+(end-st)/2;
			
			if(nums[end]>nums[mid])
				end = mid-1;
			else 
				st = mid+1;
		}
		return nums[st];
	}
	public static void main(String[] args) {
		int nums[] = {4, 5, 7, -2, 1, -3};
		find_mid fm = new find_mid();
		System.out.println("The minimum element: "+fm.find_mid_rotated(nums));
	}
}
