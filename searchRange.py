#Time Complexity=O(log n)
#Space Complexity=O(1)

#1. Set low and high index of the array as 0 and length of array -1.
#2. Calcualte mid index.
#3. if the mid value is equal to target, check if the its preceding value is equal to target or not so that we can confine our search space towards left and also check if mid is the 0th element (for the case where target is present at 0th index).
# If yes, then we return the mid, else we check if the target id greater or lesser then target and confine our search space as such by moving our low and high pointers.
# 4 Otherwise, we return -1 , ie if target is not found.
#5. Same procedure is followed for looking for last index.


class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        
        def firstIndex(nums, target):
            start, end = 0, len(nums) - 1
            while start <= end:
                mid = start + (end - start) // 2
                if nums[mid] == target:
                    if mid == 0 or nums[mid-1] != target:
                        return mid
                if nums[mid] < target:
                    start = mid + 1
                else:
                    end = mid - 1
            return -1
        
        def lastIndex(nums, target):
            start, end = 0, len(nums) - 1
            while start <= end:
                mid = start + (end - start)//2
                if nums[mid] == target:
                    if mid == len(nums)-1 or nums[mid + 1] != target:
                        return mid
                if nums[mid] <= target:
                    start = mid + 1
                else:
                    end = mid - 1
            return -1
        
        return [firstIndex(nums, target), lastIndex(nums, target)]
