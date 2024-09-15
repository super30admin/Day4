# Time Complexity : O(log n) because twith every iteration the length of array in which we search reduces to half
# Space Complexity : O(1) constant space is required 
# Did this code successfully run on Leetcode :  Yes 
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach : - With every iteration we check the mid with mid+1 or mid -1 and if true then at that point we return the value


class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        if len(nums)==1:
            return nums[0]
        first= 0 
        last = len(nums)-1
        
        if nums[first] < nums[last]:
            return nums[0]
        while first<= last:
            mid = (first+last)//2
            if nums[mid] > nums[mid+1]:
                return nums[mid+1]
            elif nums[mid] < nums[mid-1]:
                return nums[mid]
            
            if nums[mid] > nums[0]:
                first = mid+1
            else:
                last = mid - 1
        
        
                