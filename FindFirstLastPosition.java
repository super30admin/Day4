// We will be performing two binary searches to first find the first position of the target element and then use another binary search to find the last position of the repeating element using another binary search. 
// The whole time complexity would be O(log n) and the space complexity would be O(1).
class FindFirstLastPosition {
    
    private int getFirstIndex(int[] nums, int l, int h,int target){
        int m;
        while(l<=h){
            m = l + (h-l)/2;
            if(nums[m] == target){
                if(m == 0 || (nums[m-1] < nums[m])){
                    return m;
                }
                else{
                    h = m-1;
                }
            }
            else if(nums[m] > target){
                h = m-1;
            }
            else{
                l = m+1;
            }
        }
        return -1;
    }
    
    private int getLastIndex(int[] nums, int l, int h,int target){
        int m;
        while(l<=h){
            m = l + (h-l)/2;
            if(nums[m] == target){
                if(m == h || (nums[m+1] > nums[m])){
                    return m;
                }
                else{
                    l = m+1;
                }
            }
            else if(nums[m] > target){
                h = m-1;
            }
            else{
                l = m+1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int l = 0, h = nums.length-1;
        int first = getFirstIndex(nums, l,h,target);
        if(first == -1) return new int[]{-1,-1};
        else{
            int last = getLastIndex(nums,first,h,target);
            return new int[]{first,last};
        }
        
        
    }
}