#Time Complexity: O(log n)
#Space Complexity: O(1)
#Problem sucessfully accepted in leetcode: yes
class Solution:
    def findMin(self, nums: List[int]) -> int:
        n=len(nums)
        start = 0
        end = n-1
#If the array is rotated n times or size 1, return value of start index
        if nums[start]<nums[end] or n==1:
            return nums[start]
        while(start<=end):
            mid = start+(end-start)//2
#Index and previous index to avoid negative index or array index out of bounds
            prev = mid-1+n%n
            next_num = mid+1%n
#If we find the maximum value in rotated array, the minimum will be at the next index
            if nums[mid]>nums[prev] and nums[mid]>nums[next_num]:
                return nums[next_num]
#Only the minimum element in the rotated sorted array will be less than the number before
            elif nums[mid]<nums[prev]:
                return nums[mid]
#Move to the unsorted part of the roatated array, as minimum lies in unsorted part
            elif nums[start]<nums[mid]:
                start = mid+1
            else:
                end=mid-1