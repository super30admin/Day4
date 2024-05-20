public class FirstAndLast {
        public int[] searchRange(int[] nums, int target)
        {
            if(nums.length==0 || nums==null)
            {
                return new int[]{-1,-1};
            }
            int first= binarysearchfirst(nums, target);
            if(first == -1)
            {
                return new int[]{-1,-1};
            }
            int second= binarysearchsec(nums,target);
            return new int[]{first,second};
        }
        private int binarysearchfirst(int[]nums, int target)
        {
            int low=0;
            int high=nums.length-1;
            while(low<=high)
            {
                int mid=low+(high-low)/2;
                if(nums[mid]==target)
                {
                    if(mid==0 || nums[mid-1]!=target)
                    {
                        return mid;
                    }
                    high=mid-1;
                }
                else if(target>nums[mid])
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
            return -1;
        }

        private int binarysearchsec(int[]nums, int target)
        {
            int low=0;
            int high=nums.length-1;
            while(low<=high)
            {
                int mid=low+(high-low)/2;
                if(nums[mid]==target)
                {
                    if(mid==nums.length-1 || nums[mid+1]!=target)
                    {
                        return mid;
                    }
                    low=mid+1;
                }
                else if(target>nums[mid])
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
            return -1;
        }
        public static void main(String[] args)
        {
            FirstAndLast obj = new FirstAndLast();
            int[] nums= new int[]{5,7,7,8,8,10};
            int target=9;
            int[] ans= new int[2];
            ans= obj.searchRange(nums,target);
            System.out.println(ans[0]+" "+ans[1]);
        }
    }

