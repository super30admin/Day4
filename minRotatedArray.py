
# Time Com : O(lgn) Space Com : O(1)
# Ran successfully on leetcode

class Solutions:
    def searchMin(self,nums):
            low = 0
            high = len(nums) -1
            min = -1
            while low <= high:
                mid = (low+high)//2
                #when its  a simple sortd array
                if nums[low] < nums[high]:
                    return nums[low]
                if (mid == high or nums[mid] < nums[mid+1]) and (mid == low or nums[mid] < nums[mid-1]):
                    return nums[mid]
                #left array sorted so min will be on the right side
                elif nums[low] <= nums[mid]:
                    low = mid+1
                else:
                    high = mid-1
            return -1
obj = Solutions()
print(obj.searchMin([3,4,5,0,1,2]))
print(obj.searchMin([4,5,6,7,0,1,2]))
print(obj.searchMin([8,1,2,3,4,5,6]))
