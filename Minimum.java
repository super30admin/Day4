/* Time complexity: O(log n)
 * Space Complexity: O(1)
 * Ran successfully on LeetCode: Yes
 */

public class Minimum {
    public int findMin(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
                
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(arr[low] <= arr[high])
            {
                return arr[low];
            }
            
            if((mid == 0 || arr[mid] < arr[mid - 1]) && 
               (mid == arr.length - 1 || arr[mid] < arr[mid + 1]))
            {
                return arr[mid];
            }
            
            else if(arr[low] <= arr[mid])
            {
                low = mid + 1;
            }
            
            else
            {
                high = mid - 1;
            }
        }
        
        return 7979;
    }    

    public static void main(String[] args) {
        int arr[] = {3,4,5,1,2};
        Minimum m = new Minimum();
        System.out.println(m.findMin(arr));
    }
}
