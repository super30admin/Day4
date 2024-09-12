# // Time Complexity :O(logn)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :YES

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # list empty return provided case 
        if len(nums)==0:
            return [-1,-1]
            # first find the left most occurance 
        first_index=self.binarySearchLeft(nums,target,0)
        # left most occurance not found return false case 
        if (first_index== -1):
            return [-1,-1] 
            # start looking for right most staring from left most known location 
        last_index=self.binarySearchRight(nums,target,first_index)
        return [first_index,last_index]

    def binarySearchLeft(self,nums,target,low):
        low=0
        high=len(nums)-1
        while(low<=high):
            mid=low+(high-low)//2
            if(nums[mid]==target): 
                # reutnr of the left element is index out of bond or left element is less than the target element 
                if(mid==0 or nums[mid-1]<nums[mid]):
                    return mid
                else:
                    # move until index above case is true 
                    high=mid-1

            # if target is not found and is less than mid move left
            elif(target<nums[mid]):
                    high=mid-1
            # move right (other case)
            else:
                    low=mid+1
        return -1
    def binarySearchRight(self,nums,target,low):
            low=0
            high=len(nums)-1
            while(low<=high):
                mid=low+(high-low)//2
                if(nums[mid]==target):
                    # right most elemenbt is found
                    if(mid==len(nums)-1 or nums[mid+1]>nums[mid]):
                        return mid
                        # move right until right most elemenbt is found
                    else:
                        low=mid+1
                # if target is greater move right
                elif(target>nums[mid]):
                     low=mid+1
                    #  else move left
                else:
                     high=mid-1
            return -1         
    
                
                
                
        
        
        
        
        
        
        
        
        
        
        
        