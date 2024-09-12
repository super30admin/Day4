package Day4;

public class FirstLastPos {
    public int[] searchRange(int[] nums, int target) {

        int l = 0;
        int h = nums.length - 1;
        int res = -1;

        while(l <= h){
            int mid = l + (h-l) / 2;
            System.out.println(mid);
            if(target == nums[mid]){
                res = mid;
                break;
            }

            else if(target < nums[mid]) {h = mid -1;}

            else{l = mid + 1;}
        }

        int temp = res + 1;
        if(target == nums[temp]){
            return new int[]{res,temp};
        }
        else{
            return new int[]{-1,-1};
        }

    }

    public static void main(String args[]){
        int nums[] = new int[]{5,7,7,8,8,10};

        int target = 8;

        int res[] = new int[2];

        res = new FirstLastPos().searchRange(nums,target);

        for(int i=0; i<res.length; i++){
            System.out.println(res[i]);
        }
    }
}