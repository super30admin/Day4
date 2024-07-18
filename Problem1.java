//Runtime Complexity: O(logn)
//Space Complexity: O(n)

class Solution {
    public int[] search(int[] nums, int target) {
        //We use 2 Binary searches for the first and last element in the array.
        int first = binarySearchStart(nums,0,nums.length-1,target);
        if(first == -1)
            return new int[] {-1,-1};
        int last = binarySearchLast(nums,first,nums.length-1,target);

        return new int[] {first,last};
    }

    public int binarySearchStart(int[] nums,int start,int end,int target){
        while(start<=end){
            int mid = start + (end-start)/2;

            if(nums[mid]==target){
                if(mid == 0 || nums[mid-1] < target)
                    return mid;
                else
                    end = mid-1;
             }
            else if(nums[mid]<target)
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }

    public int binarySearchEnd(int[] nums,int start,int end,int target){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target){
                if(mid == nums.length-1 || nums[mid+1] > target)
                    return mid;
                else
                    start = mid+1;
             }
           else if(nums[mid]<target)
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }
}