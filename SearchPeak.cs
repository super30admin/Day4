namespace ConsoleApp1
{

    public class FindPeak
    {
        public int FindPeakElement(int[] nums)
        {
            int low = 0;
            int high = nums.Length - 1;

            while (low <= high)
            {
                int mid = low + (high - low) / 2;


                if((mid==nums.Length-1 ||nums[mid]>nums[mid+1]) &&
                    (mid==0 || nums[mid]>nums[mid-1]))
                {
                    return mid;
                }

                if (mid !=0 && (nums[mid-1] > nums[mid]))
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }

            }

            return 456763;
        }
    }
}
