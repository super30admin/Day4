package Day4;


public class findMinRSArr {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length-1);
    }

    public int findMin(int nums[], int left, int right){

        if(left == right) return nums[left];

        if((right-left) == 1){
            return Math.min(nums[left], nums[right]);
        }

        int mid = left + (right-left) / 2;

        if(nums[left] < nums[right]){
            return nums[left];
        }
        else if(nums[mid] > nums[left]){
            return findMin(nums, mid, right);
        }
        else{
            return findMin(nums, left, mid);
        }
    }

    public static void main(String args[]){
        int nums[] = new int[]{3,4,5,1,2};
        findMinRSArr obj = new findMinRSArr();
        System.out.println("min element: "+obj.findMin(nums));

    }
}