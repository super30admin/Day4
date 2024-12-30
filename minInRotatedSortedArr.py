#Time complexity: O(logn)
#Space complexity: O(1)
#Leetcode: Yes

class Solution:
    def findMin(self, nums: List[int]) -> int:
        def findPivot(nums,low,high):
            while low<high:
                mid=(low+high)//2
                if nums[mid]>nums[high]:
                    low=mid+1
                else:
                    high=mid
            return low
        
        low = 0
        high = len(nums)-1

        result = findPivot(nums,low,high)
        return nums[result]