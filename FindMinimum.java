/**
 * Time complexity = O(log(n))
 * Space Complexiy = O(1)
 * 
 * Calculate the mimimum in rotated sorted array
 * Approach used - 
 * Our best friend is the sorted array. so move there.
 * when we get that, we go for the next index of the target. 
 */

class FindMinimum {
    public int findMin(int[] a) {
    // [4,5,6,7,0,1,2]
        int left =0;
        int right = a.length-1;
        
        while(left<=right) {
            if(a[left]<= a[right]) {// just 1 element or perfectly sorted array.
                return a[left]; 
            }
            int mid = left + (right-left)/2;
            // check whether the mid element is less than the neighboring elements. 
            if((mid==0 || a[mid]< a[mid-1]) && (mid==a.length-1 || a[mid]< a[mid+1]) ) {
                return a[mid];
            } else if(a[left]<=a[mid]) {// eg 4,5,6,7,0,1,2 <- a[mid]>= a[left] True, so move the pointer on the right
                    left = mid+1;
            } else {// eg 4,5,6,7
                right = mid-1;
            }
        }
        return a[left];
    }
}