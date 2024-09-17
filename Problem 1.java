Time Complexity:O(logn)
Space COmplexity:O(1)

class Solution{
    public int[] searchRange(int[] nums, int target) {
	int minInd = -1, maxInd = -1, low = 0, high = nums.length -1, mid;
	
	//Binary Search to find the first occurrence
	while(low <= high){
		mid = low + (high - low) / 2;
		if(nums[mid] == target){
			minInd = mid;
			high = mid - 1;
		}
		else if (nums[mid] > target){
			high = mid - 1;
		}
		else{
			low = mid + 1;
		}
	}

	if(minInd != -1){
		low = 0;
		high = nums.length -1;
		
		//Binary Search to find the last occurrence
		while(low <= high){
			mid = low + (high - low) / 2;
			if(nums[mid] == target){
				maxInd = mid;
				low = mid + 1;
			}
			else if (nums[mid] > target){
				high = mid - 1;
			}
			else{
				low = mid + 1;
			}
		}
	}

	return new int[]{minInd, maxInd};
}
}