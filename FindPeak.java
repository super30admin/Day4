class FindPeak {

  public int findPeakElement(int[] nums) {

    int n = nums.length;

    int low = 0;

    int high = n - 1;

    while (low <= high) {

      int mid = low + (high - low) / 2;

      // base case

      if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == n - 1 || nums[mid + 1] < nums[mid])) {

        return mid;

      } else if (mid > 0 && nums[mid] < nums[mid - 1]) {

        high = mid - 1;

      } else {

        low = mid + 1;

      }

    }

    return -1;

  }

}