//  Time Complexity O(logn). Space complexity O(1)

// Approach 
// we will approach this by using binary search
// we will first look for occurance of the element in the array
// we will iterate the binary search on left and right once the element is found to find the first occurrence and last occurrence.
// On left side we will look for either element smaller from target n-1 or very first index that is different from target, similarly we will look for n+1 on right side to check last occurrence 
// Once found we can return both the indexes
class FirstLastInSortedArray {
    public static int bsFirst(int [] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                //move left
                if(mid == 0 || nums[mid-1]<nums[mid]){
                    return mid;
                }else{
                    right = mid - 1;
                }
            }else if(target < nums[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
        
    }
    public static int bsSecond(int [] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                //move left
                if(mid == nums.length-1 || nums[mid + 1] > nums[mid]){
                    return mid;
                }else{
                    left = mid + 1;
                }
            }else if(target < nums[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 || nums == null){ 
            return new int []{-1,-1};
        }
        if(nums[0] > target || nums[nums.length-1] < target){ 
            return new int []{-1,-1};
        }
        int first = bsFirst(nums, target);
        if(first == -1) return new int []{-1,-1};
        int last = bsSecond(nums, target);
        return new int []{first, last};
    }
}