class Peak {
     //Time complexity - o(logn)
    //Space Complexity - o(1)
    
    public int findPeakElement(int[] a) {
        
      int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if ((mid==0 || a[mid] > a[mid - 1]) && (mid == a.length-1 || a[mid] > a[mid + 1])) {
				return mid;
			} else if (mid > 0 && a[mid-1] > a[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return 0;

	}
}