# Time Complexity : O(log(n)) where m is the no of rows and n is the no of columns
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

#Your code here along with comments explaining your approach
class Solution:
    def findFirst(self,nums,low,high,target):
        while(low<=high):
            mid = low + (high-low)//2 
            if(target==nums[mid]):
                if(mid==0 or nums[mid-1]<nums[mid]):
                    return mid
                else:
                    high = mid-1
        
            if (target>nums[mid]):
                low =mid+1
            else:
                high = mid-1
        return -1
        
    def findSecond(self,nums,low,high,target):
        while(low<=high):
            mid = low + (high-low)//2 
            if(target==nums[mid]):
                if(mid==len(nums)-1 or nums[mid+1]>nums[mid]):
                    return mid
                else:
                    low = mid+1     
            elif (target>nums[mid]):
                low =mid+1
            else:
                high = mid-1
        return -1
            
            
            
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        first  = self.findFirst(nums,0,len(nums)-1,target)
        second  = self.findSecond(nums,0,len(nums)-1,target)
        return [first,second]
        
            
            
            
        
        
    
            