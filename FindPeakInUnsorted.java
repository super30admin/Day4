/* Time complexity
O(logN)*/

class FindPeakInUnsorted{

        public int findPeakElement(int[] nums) {

            int start = 0;
            int end = nums.length -1;

            while(start<=end)
            {
                int mid = start + (end-start)/2;
                boolean midGtThanLeft = mid ==0 || nums[mid] > nums[mid-1];
                boolean midGtThanRight = mid ==nums.length-1 || nums[mid] > nums[mid+1];


                //if mid is peak
                if (midGtThanLeft && midGtThanRight) return mid;

                // if mid Gt thank left => goo right
                if( midGtThanLeft)
                {
                    start =mid+1;
                }
                else{
                    end = mid -1;
                }
                //else => go left
            }
            return -1;
        }

}