class FirstLastPosition {
    //Time complexity - o(logn)
    //Space Complexity - o(1)
    
     public static int firstOccurance(int[] a,int target, int start, int end) {
			while (start <= end) {
				int mid = start+(end-start)/2;
				
				if( (mid == 0 || a[mid-1] < target) && a[mid]== target) {
					return mid;
				}
				if(target<=a[mid]) {
					return firstOccurance(a,target,start,mid-1);
				} else {
					return firstOccurance(a,target,mid+1,end);
				}
			}
			return -1;
		}
		
		public static int SecondOccurance(int[] a,int target, int start, int end) {
			while (start <= end) {
				int mid = start+(end-start)/2;
				
				if((mid==a.length-1 || a[mid+1] > target) && a[mid]== target) {
					return mid;
				}
				if(target>=a[mid]) {
					return SecondOccurance(a,target,mid+1,end);
				} else {
					return SecondOccurance(a,target,start,mid-1);
				}
			}
			return -1;
		}
    public int[] searchRange(int[] nums, int target) {
        int num[] = new int[2];
        num[0] = firstOccurance(nums,target,0,nums.length-1);
        num[1] = SecondOccurance(nums,target,0,nums.length-1);
        return num;
    }
}