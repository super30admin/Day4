class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        out = []
        l, r = 0, len(nums)-1
        found = False
        mid_index = -1 

        while l <= r:
            mid = (l + r ) // 2
            if nums[mid] == target:
                mid_index = mid 
                found = True
                break
            elif nums[mid] < target:
                l = mid + 1 
            else:
                r = mid - 1

        if not found:
            return [-1, -1]
        ##code below is to find the first and last position
        
        first = mid_index
        while first > 0 and nums[first -1]==target:
            first -=1 
            
        last = mid_index
        while last < len(nums)-1 and nums[last + 1 ] == target:
            last +=1 
            
        return [first,last]
        
**Time Complexity: O(log n + k)**

- log n for the initial binary search to find any occurrence of the target
- k is the number of elements equal to the target (for expanding the range left and right)

**Space Complexity: O(1)**

- Only uses a constant amount of extra space for variables like mid_index, first, last, etc.
