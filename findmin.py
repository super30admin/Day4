class Solution(object):
    def findMin(self, nums):
        if len(nums) == 1:
            return nums[0]
        
        left, right = 0, len(nums) - 1
        
        while left <= right:
            mid = left + (right - left) // 2
            
            # Base condition 1. if mid + 1 < mid
            # pivot is at mid + 1
            # if nums[mid] > nums[mid + 1]:
            #     return nums[mid + 1]

            # Base condition 2. if mid < mid - 1
            # pivot is at mid
            # print(mid - 1)
            if nums[left] < nums[right]:
                return nums[left]

            if nums[mid] > nums[mid + 1]:
                return nums[mid + 1]

            # compare with right value
            # if this is true, that means min value lies on the right of mid
            elif nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid - 1

nums1 = [4,5,6,-4,-3,-2,-1,0,1,2]
nums2 = [1,2,3,4, 5]
nums3 = [5,6,7,8,0]
nums4 = [4,-1,0,1,2,3]
nums = [nums1, nums2, nums3, nums4]

obj = Solution()
# print(obj.findMin(nums2))
for i, num in enumerate(nums):
    print()
    print(i + 1, num)
    print(obj.findMin(num))
    print(obj.findMin(num) == min(num))