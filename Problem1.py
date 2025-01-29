class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        def binSearch(isLeft):
            l, r = 0, len(nums)-1
            i = -1

            while l <= r:
                m = (l + r) // 2
                if target > nums[m]:
                    l = m + 1
                elif target < nums[m]:
                    r = m - 1
                else:
                    i = m             # Update Position
                    if isLeft:
                        r = m - 1 # Move left for first occurrence
                    else:
                        l = m + 1  # Move right for last occurrence

            return i

        left = binSearch(isLeft = True)
        right = binSearch(isLeft = False)

        return [left, right]


# Time Complexity: O(log N + log N) = O(log N)
# Space Complexity: O(1)