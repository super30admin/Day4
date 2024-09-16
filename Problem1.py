#
# Time Complexity = O(log(n))
# Space Complexity = O(1)
# Works on Leetcode https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
#
def firstPos(arr, target):
    l = 0
    u = len(arr)-1
    res = -1
    while l <= u:
        mid = l+(u-l)//2
        if arr[mid] < target:
            l = mid+1
        else:
            res = mid
            u = mid-1
    return res


class Solution:
    def searchRange(self, arr: List[int], target: int) -> List[int]:
        res = [-1, -1]
        if len(arr) < 1:
            return res
        res[0] = firstPos(arr, target)
        if arr[res[0]] != target:
            return [-1, -1]
        res[1] = firstPos(arr, target+1)-1
        if res[1] < 0:
            res[1] = len(arr)-1
        return res
