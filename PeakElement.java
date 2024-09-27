public class PeakElement {
    //TC is O(logn) as we are dividing array into half each iteration
    public static int findPeakElement(int[] a) {
        int low=0, high = a.length-1, mid=0;
        while(low<=high){
            mid = low + (high - low)/2;
            if((mid == 0 || a[mid-1]<a[mid]) && (mid == a.length-1 || a[mid+1]<a[mid])){ //if peak element is in corners
                return mid;
            }else if(mid != 0 && a[mid-1]>a[mid]){ // go towards larger element
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return mid;
    }

    public static void main(String args[]){
        int[] arr = {1,2,3,1};
        
        System.out.printf("Expected 2, got %d",findPeakElement(arr));
    }
}