
// Time Complexity: O(n)
// Space Complexity: O(1);


class FindPeak{
    public int findPeakElement(int[] nums) {
        return findPeakRec(nums,0, nums.length-1);
    }

    private int findPeakRec(int[] nums, int start, int end){

        //base
        if(start > end){
            return -1;
        }

        int mid = start +(end - start)/2;

        if((mid-1 < 0 || nums[mid-1] < nums[mid]) &&
                (mid+1 == nums.length || nums[mid] > nums[mid+1])) return mid;

        //recurse
        int leftPeak = findPeakRec(nums, start, mid-1);

        if(leftPeak !=-1) return leftPeak;

        int rightPeak = findPeakRec(nums, mid+1, end);

        return rightPeak;

    }
}