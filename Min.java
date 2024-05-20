public class Min {
        public int findMin(int[] nums)
        {
            if(nums.length==0 || nums==null)
            {
                return -1;
            }
            int low=0;
            int high=nums.length-1;
            int mid;

            while(low<=high)
            {
                if(nums[low]<=nums[high])
                {
                    return nums[low];
                }

                mid=low+(high-low)/2;
                if((mid==0 || nums[mid-1]> nums[mid] )&& (mid==nums.length-1 ||nums[mid+1]>nums[mid]) )
                {
                    return nums[mid];
                }
                if(nums[low]<=nums[mid])
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
            return 54567;
        }
        public static void main(String[] args) {
            Min min = new Min();
            int[] nums= {3,4,5,1,2};
            System.out.println(min.findMin(nums));

        }
    }

