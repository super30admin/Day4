class Solution(object):
    def searchRange(self, nums, target):
        start = 0
        end = len(nums) -1
        result = [None] * 2
        result[0] = -1
        result[1] = -1
        if nums == None or len(nums) == 0:
            return result
        
        while (start+1  <= end):
            mid = (start+end) // 2
            if nums[mid] == target:
                end = mid
            elif nums[mid] > target:
                    end = mid
            else:
                start = mid
            if nums[end] == target:
                result[0] = end
            if nums[start] == target:
                result[0] = start
        start =0
        end = len(nums) -1
        while (start+1 <= end):
            mid = (start+end) //2
            if nums[mid] == target:
                start = mid
            elif nums[mid] < target:
                    start = mid
            else:
                end = mid
            if nums[start] == target:
                result[1] = start
            if nums[end] == target:
                result[1] = end
        return result

"""
This is my first solution. The idea is here is to try to find the target value in the second half
of the array first using binary search keep on doing this until we either find a target value in
the end or start indexes. hence at a particular point we will come across the first occurence of 
the target in the second half of the array if not found repeat the same for finding the first 
occurence of target in the first half of the array.
repeat the same process to last occurence of the target in either the first half or the second half
of the array. basically we are applying binary search two times to find first and last occurence.

This solution passes 84/88 test cases. not working if the array len is 2 or less. kindly let me know
the corrections to be made.
"""

