package Day4;

public class PeakElement {
    public int findPeakElement(int[] nums) {

        if(nums.length <= 1){
            return 0;
        }

        if(nums.length == 2){
            if(nums[0] >= nums[1]){
                return 0;
            }
            else{
                return 1;
            }
        }

        if(nums.length == 3){
            int max = 0;
            int res = 0;
            if(nums[0] > nums[1]){
                max = nums[0];
                res = 0;
            }
            else{
                max = nums[1];
                res = 1;
            }

            if(nums[2]>max){
                res = 2;
            }

            return res;
        }
        else{

            for(int i=1; i<=nums.length-2;i++){
                int a = i-1;
                int b = i+1;

                if(nums[i]>nums[a] && nums[i]>nums[b]){
                    return i;
                }
            }

            return nums.length-1;

        }
    }

    public static void main(String args[]){
        int nums[] = new int[]{1,2,3,1};
        PeakElement obj = new PeakElement();
        System.out.println("Peak element: "+obj.findPeakElement(nums));

    }
}

