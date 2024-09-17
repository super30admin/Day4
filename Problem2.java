class Solution {
    public int findMin(int[] a) {
        
       if(a== null || a.length==0)
           return -1;
        int low=0;
        int high =a.length-1;
      
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(a[low] <a[high])
                return a[low];
            if((mid==0 || a[mid]<a[mid-1]) && (mid==a.length-1 || a[mid]<a[mid+1]))
              return a[mid];
            else if( a[mid]>= a[low])
                low=mid+1;
            else 
                high=mid-1;
            
        }
        return 789;
    }
        
}

The time Complexity is O(logn)