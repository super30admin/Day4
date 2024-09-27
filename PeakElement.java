public class PeakElement {
    // time complexity O(log(n))
    public int findPeakElement(int[] nums) {
        int first = 0;
        int last = nums.length -1;

        if(nums.length == 1){
            return 0;
        }

        while(first<last){
            int mid = first + (last - first)/2;
            if(nums[mid] > nums[mid+1]){ // slope goes down as we go right, so the peak is expected at the left sub array
                last = mid;
            }
            else{
                first = mid + 1;
            }
        }

        return last;
    }

}
