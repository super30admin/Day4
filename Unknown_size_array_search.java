// Time Complexity : O(log n)
// Space Complexity : 1
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this :

// Find high index by multiplying initial value by 2 each time when 
// target is greater than element at high position.
// Do binary search on low and newly found high index   
// Your code here along with comments explaining your approach in three sentences only

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        while(target > reader(high)){
            low = high;
            high *= 2;
        }
        
        binarySearch(reader,low,high,target);
    }

    private int binarySearch(ArrayReader reader,int low,int high,int target){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(target == reader.get(mid)){
                return mid;
            }
            if(target < reader.get(mid)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }   
        return -1;
    } 
}
