// // brute force solution


// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         int[] arr={-1,-1};
//         if(nums.length==0){
//             return arr;
//         }
        
        
        
//         for(int i=0;i<nums.length;i++){
//             if(nums[i]==target){
//                 arr[0]=i;
//                 break;
//             }
            
//         }
        
//         for(int i=nums.length-1;i>=0;i--){
//             if(nums[i]==target){
                
//                 arr[1]=i;
                
//                 break;
//             }
            
//         }
        
       
//         return arr;
//     }
// }




// binary search 
// Time: O(log n)

class Solution {
public int[] searchRange(int[] nums, int target) {
	int start = findPosition(nums, target, false);
	int end = findPosition(nums, target, true);
	return new int[]{start, end};
}

private int findPosition(int[] nums, int target, boolean isLast) {
	int low = 0, high = nums.length-1, index = -1;
	while (low <= high) {
		int mid = low + ((high - low)/2);
        
		if(isLast){
			if (nums[mid] <= target) 
                low = mid + 1;
			else high = mid-1;
		} else{
			if (nums[mid] < target) 
                low = mid + 1;
			else high = mid-1;
		}
        
		if(nums[mid] == target) 
            index = mid; 
	}
	return index;
}}