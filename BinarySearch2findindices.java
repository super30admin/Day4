//Time complexity: O(log n) 
//Space Complexity: O(1)
//The aim in this program is to find the left and the right most occurance of the target value 
class Solution {
    public int[] searchRange(int[],nums,int target)
    {
        //initialize result
        int [] res = new int[2];
        //left most index
        res[0] = binaryleft(nums,target);
        //right most index
        res[1] = binaryright(nums,target);
        return res;
    }

    // Function to find the left most index of the element
    private int binaryleft(int [] nums,int target)
    {
        //initialize left index to first index
        int l = 0;
        //initialize length of array as the last index
        h = nums.length -1;
        while(l<=h)
        {
            // find mid value
            int mid = l +(h-l)/2;
            //Check if mid is our target value and also checking if that is the left most element indeed
            if((mid == 0)|| nums[mid-1] < target) && nums[mid] == target)
            {
                // return mid as first element is found
                return mid;
            }
            else
                //Check if the value at mid is lesser than target
                if(nums[mid] < target)
                {
                    // Move the left index to place right of this mid value as target is present in the right
                    l = mid + 1;
                }
            else 
            {
                // Else if the value is greater that the mid value then move right most index to one place left of the value at mid as the target lies in the left of the mid 
                h = mid - 1;
            }
            
        }
        // If not found return -1
        return -1;
    }

    // Function to find the right most index of the element
    private int binaryright(int [] nums,int target)
    {
        //initialize left index to first index
        int l = 0;
        //initialize length of array as the last index
        h = nums.length -1;
        while(l<=h)
        {
            // find mid value
            int mid = l +(h-l)/2;
            //Check if mid is our target value and also checking if that is the right most element indeed
            if((mid == nums.length-1)|| nums[mid+1] > target) && nums[mid] == target)
            {
                // return mid as last element is found
                return mid;
            }
            else
                //Check if the value at mid is greater than target
                if(nums[mid] > target)
                {
                    // Move the right index to one place left of this mid value as target is present in the left
                    h = mid - 1;
                }
            else 
            {
                // Else if the value is lesser that the mid value then move left most index to one place right of the value at mid as the target lies in the right of the mid 
                l = mid + 1;
            }
            
        }
        // If not found return -1
        return -1;
    }
}