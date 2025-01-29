class Solution {
    // Function to find the first occurrence of the target
    private int firstOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int first = -1;

        // Applying Binary Search Algorithm
        while(low <= high) {
            int mid = low + (high - low) / 2;

            /*  If the target element is found, we 
                update the first variable to mid and
                eliminate the right half to look for 
                more smaller index where target is present */
            if(nums[mid] == target) {
                first = mid;
                high = mid - 1;  
            } 

            /*  If middle element is smaller,
                we eliminate the left half  */
            else if(nums[mid] < target) {
                low = mid + 1;  
            } 
            
            /*  If middle element is greater,
                we eliminate the right half  */
            else {
                high = mid - 1;  
            }
        }
        return first;
    }

    // Function to find the last occurrence of the target
    private int lastOccurrence(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int last = -1;

        // Applying Binary Search Algorithm
        while(low <= high) {
            int mid = low + (high - low) / 2;

            /*  If the target element is found, we 
                update the first variable to mid and
                eliminate the right half to look for 
                more greater index where target is present */
            if(nums[mid] == target) {
                last = mid;
                low = mid + 1;
            } 
            
            /*  If middle element is smaller,
                we eliminate the left half  */
            else if(nums[mid] < target) {
                low = mid + 1;  
            } 
            
            /*  If middle element is greater,
                we eliminate the right half  */
            else {
                high = mid - 1; 
            }
        }
        return last;
    }

    // Function to find the first and last occurrences of the target
    public int[] searchRange(int[] nums, int target) {

        // Function call to find the first occurence of target
        int first = firstOccurrence(nums, target); 
        
        // If the target is not present in the array
        if(first == -1) return new int[]{-1, -1};  

        // Function call to find the last occurence of target
        int last = lastOccurrence(nums, target);  

        return new int[]{first, last};  
    }
}