#Time Complexity: O(log n)
#Space Complexity : O(1) as we only use pointers high, low,mid
#did your solution run on leetcode - yes

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1
        
        while (low <= high):
            mid = low + (high - low)//2
            #checking edge cases and also checking if the mid is greater than both of its neighbours if yes mid is peak
            if ((mid == 0 or (nums[mid - 1] < nums[mid])) and (mid == len(nums)-1 or nums[mid]> nums[mid + 1]  )):
                return mid
            
            #check whether next > mid move towards the right half of list
            elif  nums[mid] < nums[mid + 1]:
                low = mid + 1
            
            #check whether prev > mid move towards the left half of list
            elif  nums[mid - 1] > nums[mid]:
                high = mid - 1
        return 0
       
        
