class Solution:
    def findPeakElement(self, nums):

        low = 0
        high = len(nums) - 1
        '''
        find value of mid and check if it is less than both of the two previous and consecutive values
        decrement high to mid if value of mid is less than mid -1 which means that peak will be around mid -1
        increment low if nums[mid] is greater than nums[mid-1] because then mid might be the peak 
        '''
        while low <= high:
            mid = (low + high) // 2
            if ((mid == low or nums[mid] > nums[mid - 1]) and (mid == high or nums[mid] > nums[mid + 1])):
                return mid
            elif (mid > low and nums[mid] < nums[mid - 1]):
                high = mid - 1
            else:
                low = mid + 1

        return -1

peak_element = Solution()
print(peak_element.findPeakElement([1,2,3,1]))
print(peak_element.findPeakElement([1,2,1,3,5,6,4]))

'''
time complexity = O(log(n)) - n element in an array
space complexity = O(1)
'''