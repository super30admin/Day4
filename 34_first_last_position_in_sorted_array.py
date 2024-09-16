# iterative approach
# two approaches
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:


        # Method 2 : log n + log n
        # Time : log n
        # SPace: O(1)

        '''
        - we check target == mid only for left element
        - only binary search approach

        '''
        if not nums: return [-1, -1]

        if len(nums) == 1 and target == nums[0]: return [0, 0]

        left_index = self.find_extremes(nums, target, True)
        print('left extreme', left_index)

        # if we go index out of bound while finding left index itself. target nt present
        if left_index == len(nums) or nums[left_index] != target:
            return [-1, -1]

        # if left index is present, right index wil definitely be present
        right_index = self.find_extremes(nums, target, False)

        # this condition is for rg. [2,1,1,1,1] target = 1
        if right_index == len(nums) - 1 and target == nums[right_index]:
            return [left_index, right_index]
        else:
            return [left_index, right_index - 1]


    def find_extremes(self, nums, target, left):
        l = 0
        h = len(nums) - 1

        while l < h:
            mid = l + (h - l) // 2
            if target < nums[mid] or (
                    left and target == nums[mid]):  # target on left , we check target == mid only for left extreme
                h = mid
            else:
                l = mid + 1

        print(l, h)
        return l

    # Method 1 : Linear + Binary method O(n)
    # Time : log n to find the elem and then linear approach
    # SPace: O(1)

    '''

    l = 0
    h = len(nums) - 1
    op = []

    if not nums:
        return [-1,-1]

    while l<=h :

        mid = l + (h - l) // 2
        print(nums[mid])
        if target == nums[mid]:
            break

        elif target<nums[mid]:
            h = mid - 1
        else:
            l = mid + 1

    print(nums[mid],mid)

    if nums[mid] != target:
        return [-1,-1]

    left = mid
    right = mid


    while left!=-1 and nums[left] == target:
        left-=1

    op.append(left+1)

    while right != len(nums)  and nums[right] == target:
        right+=1

    op.append(right-1)

    print(op)
    return op

    '''