# // Time Complexity :O(logn)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :yes


# // Your code here along with comments explaining your approach



class Solution:
    def BinarySearchFirst(self,nums,target):
        low=0
        high=len(nums)-1
        while(low<=high):
            mid=(low+high)//2
            if(nums[mid]==target):
                    
                    if(nums[mid]>nums[mid-1]):
                        return mid
                    else:
                        high=mid-1
                    
                    
                        
            elif(nums[mid]<target):
                
                low=mid+1
            else:
                
                high=mid-1
    def BinarySearchLast(self,nums,target):
            low=0
            high=len(nums)-1
            while(low<=high):
                mid=(low+high)//2
                if(nums[mid]==target):

                        if(nums[mid]<nums[mid+1]):
                            return mid
                        else:
                            low=mid+1



                elif(nums[mid]<target):

                    low=mid+1
                else:

                    high=mid-1
                
        
        
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if(len(nums)==0):return [-1,-1]
        if(target<nums[0] and target>nums[len(nums)-1]):
            return [-1,-1]
        first=self.BinarySearchFirst(nums,target)
        last=self.BinarySearchLast(nums,target)
        return [first,last]