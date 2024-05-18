/*  Approach: Assume low - 0, high - 1, multiply high by 2, to increase the size of the array until its out of bounds
                Everytime we have an upper bound for the array (high*2), we do a binary search on that array to find the element

 *  Time Complexity: O(log n) 
 *  Space Complexity: constant O(1)
 */

class Solution{
    public int searchArray(ArrayReader reader, int target){
        int low = 0;
        int high = 1;
        
        while(target > reader.get(high)){
            low = high;
            high = high*2;
        }
        return binarySearchReader(reader, low, high, target);
    }

    public int binarySearchReader(ArrayReader reader, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(reader.get(mid) == target) {
                return mid;
            } else if(reader.get(mid) > target){
                high = low - 1;
            } else {
                low = high + 1;
            }
        }
        return -1;
    }
}