# 153. Find Minimum in Rotated Sorted Array
# Time Complexity: O(log(n))
# Space Complexity: O(1)
# Approach: first find pivot, if pivot exist then return max(nums[pivot],nums[0]) or simply
# return nums[0]

class Solution:
    def findPivot(self,nums,left,right):
        pivot_position = -1
        while left < right:
            mid = (left + right) // 2
            if nums[mid] > nums[mid+1]:
                pivot_position = mid
                break
            elif nums[mid] < nums[mid-1]:
                pivot_position = mid-1
                break
            elif nums[mid] < nums[left]:
                right = mid - 1
            else:
                left = mid + 1
        return pivot_position
    
    def findMin(self, nums: List[int]) -> int:
        pivot_position = self.findPivot(nums,0,len(nums)-1)
        if pivot_position == -1:
            return nums[0]
        else:
            return min(nums[pivot_position+1],nums[0])
        
        