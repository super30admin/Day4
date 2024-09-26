// Time Complexity: O(log n)
// Space Complexity: O(1) Will this be O(n) where n is the number of postions required in the output? In our case its 2 so it would be constant space right?

public class FirstAndLastOccurenceBinarySearch {
    int[] res = new int[]{-1,-1};
    public int[] searchRange(int[] nums, int target) {
        if(nums.length >= 2){ 
            res[0] = bs(nums, 0, nums.length, target, false);
            res[1] = bs(nums, 0, nums.length, target, true);
        }
        else if(nums.length == 1 && nums[0] == target)
            return new int[]{0,0};
        return res;
    }
    
    public int bs(int[] a, int fromIndex, int toIndex, int key, boolean check){
        int low = fromIndex;
        int high = toIndex - 1;
        int found = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = a[mid];
            if (midVal < key) {
                low = mid + 1;
            } 
            else if (midVal > key) {
                high = mid - 1;
            } 
            // for last occurence
            else if (check == true){
                found = mid;
                low = mid + 1;
            }
            // for first occurence
            else if (check == false){
                found = mid;
                high = mid - 1;
                
            }
        }
        return found;
    }
    
}