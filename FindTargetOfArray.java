class FindTargetOfArray {

    


    public int search(int[] nums, int target) {
        int high = nums.length-1;
        int low = 0;
        int mid = low + (high-low)/2 ;
        while(low<=high){
            if(nums[mid]==target){return mid;}
            //check on left
            if(nums[low]<=nums[mid]) {
                if(nums[low] <= target && target <=nums[mid]){
                    high = mid -1;}
                else {
                        low = mid +1;
                     }
                }
            else {
                    if(nums[mid]<=target && target <=nums[high]){
                        low = mid+1;
                    }
                    else {
                        high = mid -1;
                }
            }

        }
        return -1;

    }

public static void main(String args[]){
    int[] a = { 4, 5, 6, 7, 0, 1, 2 };
    FindTargetOfArray f = new FindTargetOfArray();
        f.search(a, 6);

}
}