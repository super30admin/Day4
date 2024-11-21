class MinimumElement {
    //Time complexity - o(logn)
    //Space Complexity - o(1)
    
    public int findMin(int[] a) {
        int low = 0;
		int high = a.length - 1;
        
		while (low <= high) {
			int mid = low + (high - low) / 2;
	if ((mid == 0 || a[mid]<a[mid-1]) && (mid==a.length-1 || a[mid]<a[mid+1])) {
				return a[mid];
			} else if(a[mid]>a[mid+1] || a[mid]>a[high]) {
				low = mid+1;
			} else {
				high = mid-1;
			}
		}
		return 0;
	}
    
}