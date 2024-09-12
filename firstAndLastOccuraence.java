class FirstAndLastOccurence {
    public int[] searchRange(int[] nums, int target) {
        int firstOccurence = findOccurence(nums, target, true);

        if(firstOccurence == -1)
            return new int[]{-1, -1};

        int lastOccurence = findOccurence(nums, target, false);
        return new int[]{firstOccurence, lastOccurence};
    }


    private int findOccurence(int[] nums, int target, boolean isFirst){
        int n = nums.length;

        int l = 0;
        int h = nums.length -1;
        while(l <= h){
            int mid = l + (h-l)/2;
            if(nums[mid] == target){
                // if we need to find the first occurence
                if(isFirst){
                    //if it is the first occurence then mid should be equal to low and mid -1 should not be equal to target
                    if(mid == l || nums[mid - 1] != target){
                        return mid;
                    }
                    // first occurrence might still exist so move the h to mid -1; to find first occurence
                    h = mid - 1;
                }
                else{
                    //if it is the last occurence then mid should be equal to high and mid + 1 should not be equal to target
                    if(mid == h || nums[mid + 1] != target)
                        return mid;

                    l = mid + 1;
                }
            }
            // find target on left side to mid
            else if(nums[mid] > target){
                h = mid - 1;
            }
            // find target on right side to mid
            else l = mid + 1;
        }
        return -1;
    }
}