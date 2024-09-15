// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

interface ArrayReader {
     public int get(int index);
 }

class SearchInUnknownLength {
    public int search(ArrayReader reader, int target) {
        int low = 0, high = 1;
        
        while(reader.get(high) < target) {
            low = high;
            high *= 2;
        }
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            int element = reader.get(mid);
            
            if(element == target) {
                return mid;
            } else if(target < element) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}