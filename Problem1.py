# Time Complexity : O(n) for method 1, O(log n) for method 2
# Space Complexity :O(1)

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # METHOD - 1
        #        Using recursion, find if the target is present in the list
        #         l = 0
        #         h = len(nums) - 1
        #         idx = -1

        #         while l <= h:
        #             mid = (l+h)//2
        #             if nums[mid] == target:
        #                 idx = mid
        #                 break
        #             elif target > nums[mid]:
        #                 l = mid + 1
        #             else:
        #                 h = mid - 1
        #         find start and end index of the taregt from mid by linear search
        #         start= idx
        #         end = idx
        #         if idx != -1:
        #             while start >=0 and nums[start] == target:
        #                 start -= 1
        #             while end <= len(nums)-1 and nums[end] == target:
        #                 end += 1
        #             return [start+1, end-1]

        #         return [-1, -1]

        # METHOD - 2
        l = 0
        h = len(nums) - 1
        idx = -1

        # Using recursion, find if the target is present in the list
        while l <= h:
            mid = (l + h) // 2
            if nums[mid] == target:
                # Find start and end of target from mid using binary search
                start = self.left_index(nums, target, 0, mid)
                end = self.right_index(nums, target, mid, len(nums) - 1)
                return [start, end]
            elif target > nums[mid]:
                l = mid + 1
            else:
                h = mid - 1

        return [-1, -1]

    def left_index(self, nums, target, l, h):
        while l <= h:
            mid = (l + h) // 2

            if mid == 0 and nums[mid] == target:
                return 0
            if nums[mid] == target and nums[mid - 1] < target:
                return mid
            if nums[mid] == target:
                h = mid - 1
            else:
                l = mid + 1

    def right_index(self, nums, target, l, h):
        while l <= h:
            mid = (l + h) // 2

            if mid == len(nums) - 1 and nums[mid] == target:
                return len(nums) - 1
            if nums[mid] == target and nums[mid + 1] > target:
                return mid
            if nums[mid] == target:
                l = mid + 1
            else:
                h = mid - 1
