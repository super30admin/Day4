O(n),O(1)
public int search(int[] nums, int target) {
    int [] result = new int[2];
    result[0] = searchFirst(nums,target);
    result[1] = searchLast(nums,target);
    return result;
}


private int searchFirst(int[] nums, int target) {
    int start =0,end=nums.length-1,index=-1;
    while(start<=end){
      
        int mid =start = (end-start)/2;
        if(target==nums[mid]){
           index=mid;
        }else if(nums[mid] > target){
            end=mid-1;
        }else{
            start=mid+1;
        }
    }
    return index;
    
}

private int searchLast(int[] nums, int target) {
    int start =0,end=nums.length-1,index=-1;
    while(start<=end){
        
        int mid =start = (end-start)/2;
        if(target==nums[mid]){
          index=mid;
        }else if(target < nums[mid]){
            start=mid+1;
        }else{
            end=mid-1;
        }
        
    }
    return index;
}

}
