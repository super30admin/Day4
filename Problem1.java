//Time Complexity: O(logn)
//Space Complexity: O(1);
//Find First and Last Position of Element in Sorted Array




class Solution {

    public int[] searchRange(int[] arr, int target) {

        int firstPivotIndex = findIndex(arr,target,true);

        if(firstPivotIndex == -1){

            return new int[]{-1,-1};
        }

        int lastPivotIndex = findIndex(arr,target,false);

        return new int[]{firstPivotIndex,lastPivotIndex};

    }

    private int findIndex(int[] arr, int target, boolean isFirstCount){

        int left=0;
        int right=arr.length-1;

        while(left<=right){

            int mid = left+(right-left)/2;

            if(arr[mid] == target){

                if(isFirstCount){

                    if(mid == left || arr[mid-1] != target){

                        return mid;
                    }else{

                        right = mid-1;
                    }

                }else{

                    if(mid == right || arr[mid+1] != target){

                        return mid;
                    }else{

                        left = mid+1;
                    }
                }

            }else if(arr[mid] > target){

                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return -1;
    }
}