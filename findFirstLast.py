"""
Finding first and last occurence of target given.
Time = O(log n)
space = O(1)
Successfully excecuted on leetcode

Approach:
1. Two binary search implementation for finding first and last occurence
Left Boundry ---
2. If mid < target, then the range must begins on the right of mid, so l = mid+1
3. If mid > target, it means the range must begins on the left of mid (r = mid-1)
3. If mid = target, then the range must begins on the left of or at mid (r= mid)
Right Boundry --
4. If mid > target, then the range must begins on the left of mid (r = mid-1)
5. If mid < target, then the range must begins on the right of mid, so l = mid+1 
6. If mid = target, then the range must begins on the right of or at mid (l= mid)


"""

class FindFirstLast:
    
    def findFL(self, nums, target):
        if not nums:
            return [-1,-1]
        n = len(nums)
        left, right = -1, -1
        l, r = 0, n-1
        while l < r:
            mid = (l+r)//2
            if nums[mid] < target:
                l = mid+1
            else: 
                r = mid
        if nums[l] != target: 
            return -1, -1
        left = l
        l, r = left, n-1
        while l < r:
            mid = (l+r)//2+1 #plus 1 to make mid biased towards right
            if nums[mid] == target: 
                l = mid
            else: 
                r = mid-1
        right = l
        return left, right