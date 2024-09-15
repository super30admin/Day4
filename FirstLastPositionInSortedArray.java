
//Time Complexity: O(logn)
//Space Comlexity: O(1)

public class FirstLastPositionInSortedArray {

    public static void main(String[] args) {

        int nums[] = new int[]{5,7,7,8,8,10};
        int target=8;
        int[] result = searchRange(nums,target);

        for(int i=0;i<result.length;i++){
            System.out.println("Index:"+result[i]);
        }
    }

    public static int[] searchRange(int[] nums, int target){

        int first = findSearchBound(nums,target,true);

        if(first ==-1){
            return new int[]{-1,-1};
        }

        int last = findSearchBound(nums,target,false);

        return new int[]{first,last};

    }

    private static int findSearchBound(int[] nums, int target, boolean isFirst){

        int low=0;
        int high=nums.length-1;

        while(low<=high){

            int mid = low+(high-low)/2; // To handle integer overflow;
            if(nums[mid] == target){

                if(isFirst){
                    if(mid == low || nums[mid-1]!=target){
                        return mid;
                    }else{
                        high=mid-1;
                    }
                }else{
                    if(mid == high || nums[mid+1] != target){
                        return mid;
                    }else{
                        low=mid+1;
                    }
                }

            }else if(nums[mid]>target){
                high = mid-1;

            }else{
                low = mid+1;
            }
        }

        return -1;
    }
}
