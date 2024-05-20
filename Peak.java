public class Peak {
        public int findPeakElement(int[] nums)
        {
            int start=0;
            int n= nums.length;
            int end=n-1;
            int mid;

            if (n==1)
                return 0;

            while(start <= end)
            {
                mid= (start+end)/2;

                if((mid==0 || nums[mid]> nums[mid-1]) && (mid==n-1 || nums[mid]> nums[mid+1]) )
                    return mid;

                else if(nums[mid]< nums[mid+1])
                {
                    start=mid+1;
                }
                else if(nums[mid]< nums[mid-1])
                {
                    end=mid-1;
                }
            }
            return -1;
        }
        public static void main(String[] args)
        {
            Peak peak= new Peak();
            int[] nums= {1,2,3,1};
            int p= peak.findPeakElement(nums);
            System.out.println(p);
        }
    }

