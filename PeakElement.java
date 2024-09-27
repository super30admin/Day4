// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


public  class PeakElement {

    static int getPeak(int [] arr){
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid =  (start + end) / 2;
            boolean isLeftHigher = mid == 0 || arr[mid] > arr[mid - 1] ;
            boolean isRightHigher = mid == arr.length - 1 || arr[mid] > arr[mid + 1];

            if (isLeftHigher && isRightHigher){
                return arr[mid];
            }
            if (isLeftHigher){
                start = mid + 1;
            }
            else{
                end = mid -1;
            }
        }

        return -1;
    }
    public static void main(String[] args){
        int arr[] = {1,2,1,3,5,6,4};
        System.out.println(PeakElement.getPeak(arr));

    }
}
