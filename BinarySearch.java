class BinarySearch {
    public int search(int[] nums, int target) {
        if(nums.length>1){
        int mid = (nums.length/2)-1;
        System.out.println(mid);
        int old_mid = mid;
        int rotate=0;
        //Checking for rotation in the array
        if((nums[mid]>=nums[0])&&(nums[mid]<=nums[nums.length-1])){
            System.out.println("There is no rotation");
            rotate=0;
        }
        else if((nums[mid]>=nums[0])&&(nums[mid]>=nums[nums.length-1])){
            System.out.println("There is a rotation in second half");
            rotate=2;
        }
         else if((nums[mid]<=nums[0])&&(nums[mid]<=nums[nums.length-1])){
             System.out.println("There is rotation in first half");
             rotate=1;
         }
        else return mid;
        if(rotate==1){
             System.out.println("Entering the half 1");
            return binarySearch(nums,mid,0,target, old_mid);
        }
        else if(rotate==2){
            System.out.println("Entering the half 2");
            return binarySearch(nums,nums.length-1,mid+1,target, old_mid);
        }
        else if(rotate==0){
            return binarySearch(nums,nums.length-1,0,target, old_mid);
        }
            return -1;
        }
        else if ((nums.length==1)&&(nums[0]==target)) {  return 0;}
        return -1;
    }
    public int binarySearch(int[] nums, int high, int low, int target, int old_mid){
        System.out.println(low);
        System.out.println(high);
        if(nums[old_mid]==target) {System.out.println("equal to old mid"+old_mid); return old_mid;}
        if(high>=low){
        int mid = low + (high-low)/2;
            System.out.println("mid is"+mid);
        if(nums[mid]>target) {//loop=1; 
            System.out.println("dividing half 1");
            high=mid-1; return binarySearch(nums,high,low,target,old_mid);}
        else if(nums[mid]<target) {//loop=2;
            System.out.println("dividing half 2");
            low=mid+1; return binarySearch(nums,high,low,target,old_mid);}
        else if(nums[mid]==target) return mid; 
        else return -1;
        }
        else return -1;
    }
}