def find_first_and_last_position(nums, target):
    def binary_search_left(nums, target):
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return left

    def binary_search_right(nums, target):
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] <= target:
                left = mid + 1
            else:
                right = mid - 1
        return right

    left_index = binary_search_left(nums, target)
    right_index = binary_search_right(nums, target)

    if left_index <= right_index:
        return [left_index, right_index]
    else:
        return [-1, -1]

#Example usage:
nums = [5, 7, 8, 9, 10]
target = 100
print(find_first_and_last_position(nums, target))  # Output: [3, 4]

target = 6
print(find_first_and_last_position(nums, target))  # Output: [-1, -1]