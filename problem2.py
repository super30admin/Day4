#Time Complexity O(log(N))
#Space Complexity O(log(N))
#Passed Leetcode
#Problems : Had an issue when there were only 2 elements

class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        if len(nums) == 0:
            reutrn -1
        left = 0
        right = len(nums) - 1
        
        while left <= right:
            if left == right:
                return nums[left]
            
            mid = left + (right - left) // 2
            
            if nums[mid] < nums[right]:
                right = mid
            else:
                left = mid + 1
        