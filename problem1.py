'''
Time Complexity : O(logN)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Finding the second occurence was difficult and I had repeated the code twice -
one to find the left index and one to find right index, took some time to come up with a combined logic

Explanation: We call binarySearch twice for finding least and most - least needs to move left using the position index = 1
most - needs to move right using the position index = 0

Check if the middle element > target or (are we supposed to move to left? and the middle element is target)
this means that the first time we see the target is in the middle and we should move to the left if and only if either
we found the element at the center and we are supposed to move left to find the smaller index or the target is actually
greater than the current index and we need to move to the right array.

To find the greater index we need to check if the element == middle element and we are checking right, if this is true
it would probably be the element we already found and would be false or we find that the target value is greater than the
middle element and move to the right side. This way we can avoid getting the same target value. We will get the position
of the greater index +1 hence we subtract 1 at the end.

Note: I had created a left and right binary search to implement this earlier and then used the position boolean to optimise
the code.

'''
class Solution:
    def binarySearch(self, arr, x, position) :

        l = 0
        r = len(arr)
        while l < r:
            mid = int(l + (r - l) / 2)
            if arr[mid] > x or (position and x == arr[mid]):
                r = mid
            else:
                l = mid + 1

        return l

    def searchRange(self, nums, target):
        leftI = self.binarySearch(nums, target, 1)
        if leftI == len(nums) or nums[leftI] != target:
            return [-1, -1]

        rightI = self.binarySearch(nums, target, 0) - 1

        return [leftI, rightI]

nums = [5,7,7,8,8,8,10]
target = 8
obj = Solution()
print(obj.searchRange(nums,target))