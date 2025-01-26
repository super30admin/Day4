public class ElementPosition {

    private int findFirst(int[] nums, int l, int h, int target){
        while(l <= h){
            int mid = l + (h - l)/2;

            //check if mid is the target element
            if(nums[mid] == target){
                //if yes check if it is it's first occurance by comparing with previous element
                if(mid == 0 || nums[mid-1] != target){
                    return mid;
                }else{
                    h=mid -1;
                }
            }else if(nums[mid] < target){
                l = mid + 1;
            }else{
                h = mid - 1;
            }
        }

        return -1;

    }

    private int findLast(int[] nums, int l, int h, int target){
        while(l <= h){
            int mid = l + (h - l)/2;

            if(nums[mid] == target){
                //check if it is it's last occurance by comparing with next element
                if(mid == nums.length - 1 || nums[mid+1] != target){
                    return mid;
                }else{
                    l=mid + 1;
                }
            }else if(nums[mid] < target){
                l = mid + 1;
            }else{
                h = mid - 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {

        if(nums == null || nums.length ==0) return new int[]{-1,-1};

        int l = 0;
        int h = nums.length -1;

        if(target > nums[h] || target < nums[l]) return new int[]{-1,-1};

        //search first occurance
        int first = findFirst(nums, l, h, target);

        if(first == -1) return new int[]{-1,-1};

        //search last occurance
        int last = findLast(nums, first, h, target);

        return new int[]{first,last};
    }
}

//Time Complexity -> O(log(n))
//Space Complexity -> O(1)
