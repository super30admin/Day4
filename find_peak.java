// Time complexity: O(log N) where N represents the number of elements in array
//Space Complexity: O(1)
/* This is a modified binary search, If the middle element is greater than next middle element, we get to know that the peak element if in the left 
 * half of the array, or else we restrict our search to the right half of the array, we repeat the same process of searching
 * the remaining half of the array once we know which side of the array to search.
 * */
public class find_peak {
	
	public int find_peak(int[] nums) {
		int st = 0;
		int end = nums.length-1;
		
		while(st<end) {
			int mid = st+(end-st)/2;
			if(nums[mid]>nums[mid+1])
				end = mid;
			else
				st = mid+1;
		}
		return st;
	}
	public static void main(String[] args) {
		
		find_peak fp = new find_peak();
		int[] nums = {1, 2, 1, 3, 5, 6, 4};
		System.out.println("Peak element of the array: "+fp.find_peak(nums));
		
	}
}
