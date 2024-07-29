/**
 * Time complexity = O(log(n))
 * Space Complexiy = O(1)
 * 
 * Calculate the first and last indexes of target.
 * Approach used - 
 * did 2 times binary search. First searched for the first index of the target and
 * when we get that, we go for the next index of the target. 
 */
class FirstAndLast {
    public int[] searchRange(int[] nums, int target) {

        // non decreasing is equal to or increasing order 
        if(nums== null || nums.length==0) {
            return new int[]{-1,-1};
        }
        if(nums[0]> target || target > nums[nums.length-1]) {
            return new int[]{-1,-1};
        }
        int firstNo = binarySearchFirst(nums, 0, nums.length-1, target);
        int secondNo;
        if(firstNo == -1) {
            return new int[]{firstNo, firstNo};
        } else {
// This is firstNo instead of firstNo+1, so that we can compare the numbers nums[mid]!=a[mid+1] in binarySearchSecond function.
            secondNo = binarySearchSecond(nums, firstNo, nums.length-1, target); 
            return new int[]{firstNo, secondNo};
        }
        //return new int[]{firstNo, secondNo};
    }
    
    // simple binary search 0 to n-1.
    private int binarySearchFirst(int[] nums, int low, int high, int target) {
        while(low<= high) {
            int mid = low + (high-low)/2;
            if(target == nums[mid]) {
                if(mid==0  || nums[mid]!= nums[mid-1]) {
                    return mid;
                }
                high = mid-1;
            }else if (target < nums[mid] ) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
        
    }
    
    // simple binary search from firstNo (to compare with the second element) to high(n-1).
    private int binarySearchSecond(int[] nums, int low, int high, int target) {
        while(low<= high) {
            int mid = low + (high-low)/2;
            if(target == nums[mid]) {
                if(mid==nums.length-1  || nums[mid]!= nums[mid+1]) {
                    return mid;
                }
                low = mid+1;
            }else if (target < nums[mid] ) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return -1;
        
    }
}