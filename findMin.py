# Time Complexity : O(logn) 
# Space Complexity :    O(1)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach

class Solution:
    def findMin(self, nums) -> int:
        left = 0
        right = len(nums)-1
        
        while(left<right):
            mid = left+(right-left)//2
            
            #check if ele at mid index is greater than ele at right index 
            #increment left index 
            if nums[mid]>nums[right]:
                left = mid+1
            else:
                right = mid
        
        return nums[left]
            
        

obj = Solution()
nums = [3,4,5,1,2]
print(obj.findMin(nums))