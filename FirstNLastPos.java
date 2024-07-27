//TC: O(Log (n*k))
//SC: O(1)
//Approach: find the first index using binary search and then travese from first index to find the last index using binary search again

class Solution {

    private int bsFirst(int[] n, int l, int h, int target){
        while(l<=h){
            int mid = l + (h-l)/2;
            if(n[mid]==target){
                //for first index compare with prev element not equal
                if(mid ==0 || n[mid] != n[mid-1]) return mid;
                h= mid-1;
            }
            else if(n[mid] > target) h= mid -1;
            else l = mid+1;
        }
        return -1;
    }

    private int bsLast(int[] n, int l, int h, int target){
        while(l<=h){
            int mid = l + (h-l)/2;
            if(n[mid]==target){
                //for last index compare with next element not equal
                if(mid == n.length -1 || n[mid] != n[mid+1]) return mid;
                l = mid +1;
            } 
            else if(n[mid] > target) h= mid -1;
            else l = mid+1;
        }
        return -1;
    }

    public int[] searchRange(int[] n, int target) {
        int l =0; int h = n.length-1;

        // empty array
        if(n == null || n.length == 0) return new int[] {-1,-1};

        // target cannot be in the array
        if(n[l] > target || n[h] < target) return new int[] {-1,-1};

        int first = bsFirst(n,l,h,target);

        // target not found in the array
        if(first ==-1) return new int[] {-1,-1};

        int second = bsLast(n,first,h,target);

        return new int[]{first,second};
    }
}