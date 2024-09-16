# Reference : https://www.youtube.com/watch?v=CFgUQUL7j_c
# May 23 2020

# Check for recursive binary search, space becomes log n
# duplicate elements present

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:


        # Method 3 : Iterative binary search
        # Time :  O(log n )
        # Space : O(1)
        '''
         - the condition is nums[i] ≠ nums[i+1] *****
        e g. [ 4 5 6 7 0 1 2] two peaks at 7 and 2
        basically the logic is to give last element in a continuous increasing order
        for bin search we must have ascending order
        Case 1 : so if right side is not greater than mid, we [ 4 5 0 1] , 0 is not greater than 5, then search for peak on left
        Case 2 : so if right side is greater than mid, we [ 4 5 6 7 0 1] , 7 is greater than 6, then possible more higher values on right

        try with these cases :
        [1,2,1,3,2,1,0] , ideally two peaks, logic gives ans 2, index 1
        [1,2,1,3,2,1] , ideally two peaks, logic gives ans 3, index 3
        '''

        l = 0
        r = len(nums) - 1

        while l < r:
            mid = l + (r - l) // 2

            # check on immediate right
            if nums[mid] < nums[mid + 1]:  # case 2 we [ 4 5 6 7 0 1] , 7 is greater than 6, then possible more higher values on right
                # we can do mid + 1, because mid+1 exists and mid is already checked and it is not peak from above condition
                l = mid + 1  # move to right
            else:  # case 1 : possible peak on left  [ 1 7 4 3 1]
                # here mid can be possible peak, so we do not do mid - 1
                r = mid  # do not make mistake here, r is NOT mid-1, we lose mid in that  case

            print(nums[l:r + 1])
        # loop will break when r = l and thats the answer
        print(nums[r])  # index of peak
        return r # or return l

        # Method 2: Recursive approach ( Similar to iterative approach )
        # Whenever the nums[i+1]<nums[i] return nums[i]
        # Time : O(n)
        # Space : O(1)

        low = 0
        high = len(nums) - 1
        return self.recursive(low, high, nums)

    def recursive(self, l, h, nums):

        if l == h:
            return l

        mid = l + (h - l) // 2
        # since element on right of mid, is higher than mid, we search on right, so l = mid + 1, similar to iteratove approach
        if nums[mid + 1] > nums[mid]:
            return self.recursive(mid + 1, h, nums)

        else:
            return self.recursive(l, mid, nums)

        # Method 1 : linear search
        '''
        if len(nums)==1: return 0

        for i in range(len(nums)-1):
            if nums[i]>nums[i+1]:
                return i

        '''



