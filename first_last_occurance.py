class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        :space complexity : O(1)
        :time complexity : O(logn)
        """
        
        start = 0
        end = len(nums)-1
        result = []
        
        
        # search in right half
        while start <= end:
            mid = start + (end-start)/2
            if nums[mid] < target:
                start = mid + 1
            else:
                end = mid - 1
        result.append(start)


        start = 0
        end = len(nums)-1
        
        # search in left half
        while start <= end:
            mid = start + (end-start)/2
            if nums[mid]  > target:
                end = mid -1
            else:
                start = mid + 1
        result.append(end)

        if result[0] > result[1]:
            return [-1, -1]
        else:
            return result