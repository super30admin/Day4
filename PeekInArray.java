class Solution {
    public int findPeakElement(int[] a) {
         int s=0;
         int e=a.length-1;
         while(s<e){
             int mid=s+(e-s)/2;
             if(a[mid]>a[mid+1])
                 e=mid;
             if(a[mid]<a[mid+1])
                 s=mid+1;
         }
         return s;
    }
}