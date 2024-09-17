public class FindPeakElement {

    public int FindPeak(int[] arr)
    {
        if(arr==null || arr.length==0) return -1;
        int n = arr.length;
        int low=0;
        int high=n-1;
        while(low<=high)
        {
            //Find middle
            int mid =low+(high-low)/2;
            //check if the peak is at the start or end of the array
            if((mid==0||arr[mid]>arr[mid-1]) && (mid==n-1 ||arr[mid]>arr[mid+1]))
            {
                return mid;
                
            }
            //Left side
            else if(arr[mid]<arr[mid-1])
            {
                high = mid-1;
                
            }
            //Right side
            else 
            {
                low=mid+1;
            }

        }
        return -1;
    }
}
