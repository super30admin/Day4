/*
To find the first and last index of the target in a given array.
Here, we have divided the task into two parts.
i.e first to check the first index.
second to cehck the last index.

we are performing binary search, for each case, and once we have found the target, we are checking if we are at desired occurence i.e first and last.
If we find that we are not, we are again going to find the target, with shifted array, that we have not yet explored thoroughly 

*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        
    int low=0;
    int high=nums.length-1;
        
    return new int[]{firstBinarysearch(nums,target,low,high),lastBinarysearch(nums,target,low,high)};
    
        
        
   
        
    }
    
    
    
int   firstBinarysearch(int nums[], int target, int low, int high)
    {
        
        if(high<low)
        {
            return -1;
        }
    
        int mid=low+(high-low)/2;
        
        if(nums[mid]>target)
        {
            high=mid-1;
            return firstBinarysearch(nums,target,low,high);
        }
        
        if(nums[mid]<target)
        {
            low=mid+1;
            return firstBinarysearch(nums,target,low,high);
            
        }
        
        if(nums[mid]==target)
        {
        //    System.out.println((mid-1)+" mid-1 index element "+nums[mid-1]+" "+mid+" "+low+" "+high);
            if(low==mid||nums[mid-1]<nums[mid])
            {
                return mid;
            }
            else
            {
                high=mid-1;
                return firstBinarysearch(nums,target,low,high);
            }
        }
      
      return -1;
      
        
    }
    
 
        
int lastBinarysearch(int nums[], int target, int low, int high)
    {
            if(high<low)
        {
            return -1;
        }
        int mid=low+(high-low)/2;
        
        if(nums[mid]>target)
        {
            high=mid-1;
            return lastBinarysearch(nums,target,low,high);
        }
        
        if(nums[mid]<target)
        {
            low=mid+1;
            return lastBinarysearch(nums,target,low,high);
            
        }
        
        if(nums[mid]==target)
        {
        //    System.out.println((mid-1)+" mid-1 index element "+nums[mid-1]+" "+mid+" "+low+" "+high);
            if(high==mid||nums[mid+1]>nums[mid])
            {
                return mid;
            }
            else  
            {
                low=mid+1;
                return lastBinarysearch(nums,target,low,high);
            }
        }
        return -1;
    }
        

}

public class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }
    
        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
    
    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);
            
            int[] ret = new Solution().searchRange(nums, target);
            
            String out = integerArrayToString(ret);
            
            System.out.print(out);
        }
    }
}
