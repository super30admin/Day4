class Solution {
    public int findPeakElement(int[] nums) {
        
        return findPeak(nums,0,nums.length-1,nums.length);
    }
    
    private int findPeak(int[] arr,int l,int h,int n){

        int mid = l + (h - l) / 2;
 
        if ((mid == 0 || arr[mid - 1] <= arr[mid])
            && (mid == n - 1 || arr[mid + 1] <= arr[mid]))
            return mid;
 

        else if (mid > 0 && arr[mid - 1] > arr[mid])
            return findPeak(arr, l, (mid - 1), n);
 

        else
            return findPeak(
                arr, (mid + 1), h, n);
    }
}