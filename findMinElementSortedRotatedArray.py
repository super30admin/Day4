'''
Time Complexity: O(log n) because of binary search
Space Complexity: O(1) Constant space as no extra space is being allocated.
Leetcode: Success!
Problems: Silly mistake at the line 25. Also, got a little confused with comparison of spaces on either side of mid.
'''
class Solution:
    def findMin(self, nums) -> int:
        # Sanity checks to check if the array id not null or empty
        if nums == None or len(nums) == 0:
            return -1

        low = 0
        high = len(nums)-1
        # mid = low + (high + low)//2

        # [mid - 1 > mid < mid + 1]
        # first check if the array is sorted low<high
        # check the sections if sorted: mid<high or low<mid
        # then keep checking the condition [mid - 1 > mid < mid + 1]
        while low <= high:
            mid = low + (high - low) // 2
            # to check if the mid is the minimum element.
            if ((mid == 0 or nums[mid-1] > nums[mid]) and (mid == len(nums)-1 or nums[mid]<nums[mid+1])):
                return mid
            # to check if the right space is sorted
            elif nums[mid]>nums[high]:
                low = mid + 1
            else:
                high = mid - 1
        return -1


nums = [4,5,6,7,0,1,2]
# nums = [3,4,5,1,2]
# nums = [11,13,15,17]
s = Solution()

minVal = s.findMin(nums)
print("Minimum Value is ", nums[minVal]," at index ",minVal)
