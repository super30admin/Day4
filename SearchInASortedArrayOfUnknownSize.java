/**
 * Time complexity is O(log n)
 * Space complexity is O(1)
 * Did this code successfully run on Leet code : Yes
 * Any problem you faced while coding this : No
 */
public class SearchInASortedArrayOfUnknownSize {
    public static void main(String[] args) {
        int target = 9;
        SearchInASortedArrayOfUnknownSize obj = new SearchInASortedArrayOfUnknownSize();
        ArrayReader reader = new ArrayReader();
        int index = obj.search(reader, target);
        System.out.println(index);
    }

    private int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;

        while(reader.get(high) < target){
            low = high;
            high = 2 * high;
        }
        return binarySearch(reader, target, low, high);
    }

    private int binarySearch(ArrayReader reader, int target, int low, int high){
        while(low <=  high){
            int mid = low + (high - low)/2;
            if(reader.get(mid) == target){
                return mid;
            }
            else if(target < reader.get(mid)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
}

class ArrayReader{
    public int get(int high) {
        return 12;
    }
    //some impl
}