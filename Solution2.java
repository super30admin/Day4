class Solution {
    public int findMin(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        if(arr[0] < arr[right])
            return arr[0];
        
        // Find which half to search for the minimum
        while(left < right){
            int mid = left + (right - left) / 2;
            if(mid > 0 && arr[mid] < arr[mid-1])
                return arr[mid];
            
            if(arr[mid]>arr[mid+1])
                return arr[mid+1];
                
            if(arr[0]<arr[mid]){
                left = mid +1;
            }
            
            
            else{
                right = mid;
            }
        }
        
        while(left < right){
            int mid = left + (right - left) / 2;
            if(arr[mid] > arr[mid+1]){
                left = mid +1;
            }
            
            else{
                right = mid;
            }

        }
        
        return arr[left];
        
    }
}

// Complexity : O(logN)
