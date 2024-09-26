//Time Complexity: O(log n)
//Space Complexity: O(1)
//Find First and Last Position of Element in Sorted Array

class Solution {

    public int first(int[] a, int target){
        int low = 0;
        int high = a.length - 1;

        while(low<=high){
            int mid = low + (high - low)/2;

            if(a[mid] == target)
                if(a[mid - 1] < a[mid])
                    return mid;
                else
                    high = mid - 1;
            else if(a[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public int last(int[] a, int target){
        int low = 0;
        int high = a.length - 1;

        while(low<=high){
            int mid = low + (high - low)/2;

            if(a[mid] == target)
                if(a[mid + 1] > a[mid])
                    return mid;
                else
                    low = mid + 1;
            else if(a[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public int[] searchRange(int[] a, int target) {
        int f = first(a, target);
        int l = last(a, target);

        return new int[]{f, l};

    }
}