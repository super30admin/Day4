"""" I struggled a lot with the solution, my first approach did have some errors later had to refer discussion section, many concepts got cleared but there is a lot of room for imprivement"""

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        while nums[low]>nums[high]:
            
            if len(nums)==2:
                return nums[1]
            
            mid = low + (high - low )//2
            minimum = nums[mid]
            
            if (nums[mid]<nums[mid - 1] and nums[mid]<nums[mid+1]):
                return nums[mid]
            
            if nums[mid] < nums[high]:
                high = mid                
            else:
                low = mid + 1  
                
        return nums[low]
       