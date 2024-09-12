//Time Complexity: log(n)
//Space Complexity: O(1)
// Did it run on leetcode: yes
public class FindMinInSortedRotated {
    private static int findMinIndex(int[] nums, int low, int high, int n){

        while(low <= high){
            // Calculate Mid
            int mid = low + (high - low)/2;
            // Calculate the next index to mid. I have done %n because if the mid is last then next element should be first element (0th index) in a rotated array
            int next = (mid + 1) % n;
            // Calculate the prev index to mid. I have done (mid - 1 + n) %n because if the mid is first element then prev element should be last element (n-1 index) in a rotated array
            int prev = ( mid - 1 + n ) % n;

            // If the mid is less than its next element and less than prev element then it is min element
            if(nums[mid] < nums[prev] && nums[mid] < nums[next]) return mid;
            // if mid is less than high then the array from [mid .... high] is sorted then search in [0...mid-1] else search in [mid + 1...n]
            else if(nums[mid] < nums[high]){
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return -1;
    }
}
