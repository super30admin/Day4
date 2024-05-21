/**
 Approach: Using Binary Search

 Working:
 Find mid, check if right and left elemnt of mid if lesser thean the mid, then
 return mid index
 if right is greate than mid, move right
 low = mid+1
 else //move to left part
 high = mid -1

 Time Complexity: O(log n)
 Space Complexity: O(1)

 */

class FindPeakElement {
    public int findPeakElement(int[] a) {


        int n = a.length;

        int low = 0;
        int high = n-1;

        while(low<=high) {

            int mid = low+(high-low)/2;

            if((mid == low || a[mid-1]< a[mid]) && (mid == high || a[mid+1]<a[mid])) {
                return mid;
            }

            if(mid == high || a[mid+1]>a[mid]) {
                low = mid+1;
            }else{
                high = mid - 1;
            }
        }

        return -1;
    }
}