class Solution:

    def _binary_search_left(self, nums: list, target: int) -> [int]:
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (low + high) // 2
            # base case and edge case
            # when it hits this condition there are only two possibilities:
            # 1) The next is element is equal to the target
            # 2) The next element is lesser than the target or it is the first element
            if nums[mid] == target:
                # if it is the left most element and
                # the previous element is lesser than the target
                # then this is the first occurence of the element
                if mid == 0 or nums[mid - 1] < target:
                    return mid

                # else the previous element is equal to target for sure
                # since it is sorted it cannot be greater than target
                # keep moving left
                else:
                    high = mid - 1
            # if the current element is greater than the target
            # since it is a sorted array if the element exists
            # it should be on the left hand side for sure
            elif nums[mid] > target:
                high = mid - 1
            # else the current element is lesser than or target
            # it cannot be equal to the target since we are checking for it
            # in the previous condition
            # we are sure than the element if it exists it is going to lie
            # on the right side since it is a sorted array
            else:
                low = mid + 1
        # if the element does not exist
        return -1

    def _binary_search_right(self, nums: list, target: int) -> [int]:
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (low + high) // 2
            # base case and edge case
            # When we hit this condition there are only two possibilities:
            # 1) The next element is greater than the target or it is the last element
            # 2) The next is equal to the target
            if nums[mid] == target:
                # Condition 1
                if mid == len(nums) - 1 or nums[mid + 1] > target:
                    return mid
                # Condition 2
                # keep moving towards right
                # next element is for sure equal to target
                # since it is sorted next element cannot be lesser than target
                else:
                    low = mid + 1
            # Our target for sure if exists should lie only on the right
            elif nums[mid] < target:
                low = mid + 1
            # if our target exists should lie for sure on the left
            else:
                high = mid - 1
        # Techically this condition won't happen because of the check in the
        # first left search itself
        return -1

    def searchRange(self, nums: list, target: int) -> [int]:
        """
            Updated as per discussion in class
            // Time Complexity :
                                O(logn) 'n' is the number of elements in the list
            // Space Complexity :
                                O(1) Constant
            // Did this code successfully run on Leetcode :
                                Yes
        """
        if not nums:
            return [-1, -1]
        left = self._binary_search_left(nums, target)
        # if the element does not exist at all no need to search for
        # the right most element
        if left == -1:
            return [-1, -1]
        right = self._binary_search_right(nums, target)
        return [left, right]


if __name__ == '__main__':
    h = Solution()
    print(h.searchRange([1, 2, 3, 3, 3, 3, 4, 5, 9], 3))
