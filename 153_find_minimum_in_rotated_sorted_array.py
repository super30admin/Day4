# Refer 33. Search in Rotated Sorted Array
# Done on May 23 2020

# Check both methods for clarity

class Solution:
    def findMin(self, nums: List[int]) -> int:

        # Time : O(log n)
        # Space : O(1)

        # no duplicate elements == so no need to worry for nums[mid] = l , nums[mid] = r
        # we have to move towards unsorted part
        # One part is always sorted

        # Method 2:
        # Check on right side 1st

        start = 0
        end = len(nums) - 1
        '''
        while start<=end:

            mid = (start + end)//2
            if start==end: #same thing is done by the above code, the moment start=end, we return
                print (nums[mid])
                return nums[mid]


            if nums[mid]>nums[end]: #right side of array unsorted [ 4 5 6 7 0 1 2] mid = 7, end = 2
                start = mid+1
            else: #left side unsorted, nums[start]>nums[mid] [ 7 8 1 2 3 ] start = 7, mid = 1
                end = mid
            print(nums[start:end+1])    
            print(nums[mid])


        '''

        # remember when start< end ( NOT start<=end)
        # possibly end = mid ( NOT mid - 1)
        # there should be something to make up for that '='
        # eg. [ 4 5 0 1 2]

        while start < end:

            mid = (start + end) // 2

            # check right 1st*****
            if nums[mid] > nums[end]:  # right side of array unsorted [ 4 5 6 7 0 1 2] mid = 7, end = 2
                start = mid + 1
            else:  # left side unsorted, nums[start]>nums[mid] [ 7 8 1 2 3 ] start = 7, mid = 1
                end = mid
            print(nums[start:end + 1])
            print(nums[mid])

        # basically the loop will break when start == end
        # same thing is done by the above code, the moment start=end, we return
        return nums[start]

        # Method 1:
        # go to unsorted side
        # go to left side 1st****

        '''

        l = 0
        h = len(nums) - 1
        # minimum = 0

        while l < h:
            print('here')
            mid = l + (h - l) // 2

            # Check left 1st****
            # left is unsorted, go to left to find min
            if nums[l] > nums[mid]:
                h = mid

            elif nums[h] < nums[mid]:
                l = mid + 1

            # else:
            #     return nums[l]

        print(l)
        return nums[l]  # for input [1]



        '''

