public class MinimumInSortedArray {

    public int FindMin(int[] arr)
    {
        //Empty array
        if(arr.length==0 || arr==null)
        {
            return -1;
        }
        int low = 0;
        int high = arr.length-1;
        while(low<=high)
        {
            int mid = low +(high -low)/2;
            if(arr[mid]<arr[high]){
                high=mid;
            }
            else
            {
                low=mid+1;

            }
        }
        return arr[low-1];

    }
    public static void main(String args[])
    {
        MinimumInSortedArray MinArr = new MinimumInSortedArray();
        int[] arr={5,6,7,8,2,3,4};
        System.out.println(MinArr.FindMin(arr));
    }
}
