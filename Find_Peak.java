package Solution;

public class Find_Peak {
	
	public static int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[mid + 1])
                end = mid;
            
            else start = mid + 1;
        }
        return start;
    }
	
	public static void main(String args[]){
		int nums[] = new int[]{1,2,4,2,4,6,2,4,6};
		System.out.println(findPeakElement(nums));
		
	}

}
