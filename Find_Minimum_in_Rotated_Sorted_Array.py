# Time Complexity- O(log n)
# Space Complexity - O(n)
# Problem solved before class

class Solution:
    def findMin(self, nums: List[int]) -> int:
        left = 0
        right = len(nums)-1
        if len(nums) == 1 :
            return nums[0]
        if len(nums) == 2 and nums[0] > nums[1]:
            return nums[1]
        if len(nums) == 2 and nums[0] < nums[1]:
            return nums[0]
        if nums[left] < nums[right]:
            return nums[left]

        while(left<= right):

            mid = int(left +(right-left)/2)


            if nums[mid + 1] > nums[mid] and nums[mid] < nums[mid-1]:
                return nums[mid]

            # min in other half
            if nums[mid] > nums[right]:
                left = mid
                if mid == right -1:
                    return nums[right]
            if nums[mid] < nums[left]:
                right = mid
                if mid == left +1:
                    return nums[left]

        return -1