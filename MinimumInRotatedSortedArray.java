/*
Time complexity: O(log(n)) binary search 
Space complexity: O(1) No auxilary space needed to compute 
*/
public class MinimumInRotatedSortedArray {
        public int findMin(int[] nums) {
            int left = 0, right = nums.length-1;
            int ans = -1;
            while(left < right){
                int mid = left + (right-left)/2;
                if(nums[mid] > nums[right]){
                    left = mid+1;
                }else{
                    right = mid;
                }
            }
            return nums[left];
        }
    }