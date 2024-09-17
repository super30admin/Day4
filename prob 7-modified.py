class Solution:
    def searchRange(self, nums, target):
        left = 0
        right = len(nums) - 1

        # mid_outer = (left+right)//2
        def first_ele(a, l, r, target):
            if l <= r:
                mid = (l + r) // 2
                # case 1
                if (mid == 0 or a[mid - 1] < target) and a[mid] == target:
                    # a[mid]==0 to check fr the edge case when the first occurance of the                              number is thee target element
                    first = mid
                    return first


                # case 2:
                elif a[mid] < target:
                    l = mid +1
                    return first_ele(a, l, r, target)
                else:
                    r = mid - 1
                    return first_ele(a, l, r, target)
            return -1

        def last_ele(a, l, r, target):
            if l <= r:
                mid = (l + r) // 2
                if (mid == (len(a)-1) or target < a[mid + 1]) and a[mid] == target:
                    return mid
                elif (target < a[mid]):
                    r = mid - 1
                    return last_ele(a, l, r, target)
                else:
                    l = mid + 1
                    return last_ele(a, l, r, target)
            return -1

        first = first_ele(nums, left, right, target)
        last = last_ele(nums, left, right, target)
        return [first, last]

g= Solution()
print(g.searchRange([4,5,6,7,7,8,8,9,9],8))


