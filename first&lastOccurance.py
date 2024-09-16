class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if len(nums) == 0:
            return [-1, -1]
        # solving using two binary search
        left, right = 0, len(nums) - 1
        left = self.binarysearchleft(nums, left, right, target)
        if left == -1:
            return [-1, -1]
        right = self.binarysearchright(nums, left, right, target)

        return [left, right]

    def binarysearchleft(self, nums, left1, right, target):

        while (left1 <= right):
            mid = left1 + (right - left1) // 2

            if nums[mid] == target:
                if mid == 0 or nums[mid - 1] != nums[mid]:
                    return mid
                else:
                    right = mid - 1

            if nums[mid] >= target:
                right = mid - 1
            else:
                left1 = mid + 1
        return -1

    def binarysearchright(self, nums, left, right, target):

        while (left <= right):
            mid = left + (right - left) // 2

            if nums[mid] == target:
                if mid == (len(nums) - 1) or nums[mid] != nums[mid + 1]:
                    return mid
                else:
                    right = mid + 1

            if nums[mid] <= target:
                left = mid + 1
            else:
                right = mid - 1
        return -1


if __name__ == '__main__':
    nums = [5, 7, 7, 8, 8, 10]
    target = 8
    obj =Solution()
    print(obj.searchRange(nums,target))
