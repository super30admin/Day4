//Time Complexity O(logn)
//Space Complexity O(1)


class Solution {

    public int binarysearchfirst(int[] nums, int target){
        int low=0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+ (high-low)/2;
            if(nums[mid] == target){
                if(mid ==0 || nums[mid] != nums[mid-1])
                    return mid;
                else {
                    high = mid-1;
                }
            }
            else if(nums[mid]>target){
               high = mid-1;
            }
            else
            low =mid+1;
        }
        return -1;
    }

    public int binarysearchlast(int[] nums, int target){
        int low=0;
        int high = nums.length-1;
        while(low<=high){
            int mid= low+(high-low)/2;
            if(nums[mid] == target){
                if( mid ==0 ||nums[mid]!= nums[mid+1])
                    return mid;
                else
                    low =mid+1;
            }
            else if(nums[mid]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }




    public int[] searchrange(int[] nums, int target){
        if(nums.length ==0 || nums == null) return new int[] {-1,-1};
        if(nums[0]> target || nums[nums.length-1]< target) return new int[]{-1,-1};

        int first = binarysearchfirst(nums,target);
        if(first == -1) return new int[]{-1,-1};
        int last = binarysearchlast(nums,target);
        if(last==-1) return new int[]{-1,-1};
        return new int[]{first,last};
    }
    
}
