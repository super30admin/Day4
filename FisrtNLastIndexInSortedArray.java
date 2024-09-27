
// Time Complexity: O(log(n))
// Space Complexity: O(1)
class FisrtNLastIndexInSortedArray {
    public int[] searchRange(int[] nums, int target) {

        if(nums==null || nums.length==0)
            return new int[]{-1,-1};
        if(target < nums[0] || target > nums[nums.length-1])
            return new int[]{-1,-1};
        int leftIndex=-1, rightIndex=-1;
        int l=0,r=nums.length-1, mid=0;
        boolean foundl=false;

        while(l<=r)
        {
            mid = l+(r-l)/2;
            if(nums[mid]==target)
            {
                //if leftIndex is not found yet
                if(!foundl)
                {
                    leftIndex=mid;
                    rightIndex=mid;
                    //left pointer 'l' has target elemnt
                    if(nums[l]==target)
                    {
                        foundl=true;
                        leftIndex=l;
                        l=leftIndex;
                        r=nums.length-1;
                    }
                    //nums[mid] is the left most target element
                    else if(mid==0 || nums[mid-1]< target)
                    {
                        foundl=true;
                        leftIndex=mid;
                        l=mid+1;
                        r=nums.length-1;
                    }
                    else
                    {
                        r=mid-1;
                    }

                }
                else //if leftIndex was found and looking for rtindex
                {
                    rightIndex=mid;

                    //right pointer 'r' has target elemnt
                    if(nums[r]==target)
                    {
                        rightIndex=r;
                        break;

                    }
                    //nums[mid] is the right most target element
                    else if(mid== nums.length-1 || nums[mid+1]> target )
                    {
                        rightIndex=mid;
                        break;
                    }
                    else
                    {
                        l=mid+1;
                    }

                }



            }
            else if( nums[mid]> target)
            {
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }

        return new int[]{leftIndex,rightIndex};

    }
}
