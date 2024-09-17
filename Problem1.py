#Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
#Time Complexity-O(log n)
#Space Complexity-O(n)
#Test Cases passed on Leetcode 
#Binary Search Used
#low and high converges to first element in searchLeft function, and to last element in searchRight function.
class Solution:
    def searchLeft(self,nums, target):
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = (low + high) // 2
            if target > nums[mid]: 
                low = mid + 1
            else: 
                high = mid - 1
        return low

    def searchRight(self,nums, target):
        low, high = 0, len(nums) - 1
        while low <= high:
            mid = (low + high) // 2
            if target >= nums[mid]: 
                low = mid + 1
            else: 
                high = mid - 1
        return high

    def searchRange(self, nums, target) :
        left_res = self.searchLeft(nums, target)
        right_res = self.searchRight(nums, target)

        if left_res <= right_res:
            return (left_res, right_res)
        else:
        	#if not found
            return (-1,-1)
#to validate the solution
sol=Solution()
nums=[5,7,7,8,8,10]
target=8
print("Array is :")
print(nums)
print("Target is :")
print(target)
output=sol.searchRange(nums,target)
print("First and Last position of target in array is ")
print(output)