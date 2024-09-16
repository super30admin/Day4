//tc O(logn)
//sc o(1)


class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] output = {-1,-1};
        
        output[0]=startingPosition(nums, target);
        output[1]=endingPosition(nums,target);
        
        return output;
        
}
    
    
    public int startingPosition(int[] nums, int target){
    int l  = 0;
    int r = nums.length-1;
    int index = -1;
    while(l<=r){
        int mid = l+ (r-l)/2;
        
        
        if(nums[mid]<target){
            l = mid+1;
        }
        else if(nums[mid]>target)
            r = mid -1;
        
        
        if(nums[mid]==target){
            index = mid;
            r = index-1;
        }
        
    }
    return index;
}
public int endingPosition(int[] nums, int target){
    int l  = 0;
    int r = nums.length-1;
    int index = -1;
    while(l<=r){
        int mid = l+ (r-l)/2;
        
        
        if(nums[mid]<target){
            l = mid+1;
        }
        else if(nums[mid]>target)
            r = mid -1;
        
        
        if(nums[mid]==target){
            index = mid;
            l = index+1;
        }
        
    }
    return index;
}
}


