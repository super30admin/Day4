class Solution {
    public int findPeakElement(int[] nums) {

        /*
        Time Complexity: 0(log n)
        Space Complexity: 0(1)
        Approach: Perform binary search and move towards the larger value if the mid isnt
        satisfying the condition.
         */

        // few base cases to look into
        if (nums.length == 1){
            return 0;
        }

        int peak = 0; // return the peak index

        int low = 0;
        int high = nums.length-1;

        int mid = 0;
        int midLft = 0;
        int midRt = 0;

        while(low<=high){
            mid = (high-low)/2 + low;

            // set midLft & midRt values
            if (mid - 1 == -1) {
                midLft = Integer.MIN_VALUE;
            }else{
                midLft = nums[mid-1];
            }

            if(mid+1 == nums.length){
                midRt = Integer.MIN_VALUE;
            }else{
                midRt = nums[mid+1];
            }

            // System.out.println("midLft= "+midLft+ " mid= "+nums[mid] + " midRt= "+midRt);

            // chk if nums[mid] is peak element
            // if not, more toward the larger value side

            if (nums[mid] > midLft && nums[mid] > midRt){
                // nums[mid] is peak
                peak = mid;
                break;
            }
            else if (nums[mid] < midRt) {
                // midRt is grt, move towards that direction
                low = mid + 1;
            }
            else if (nums[mid] < midLft){
                // midLft is grt, move towards that directions
                high = mid - 1;
            }
        }

        return peak;
        
    }
}