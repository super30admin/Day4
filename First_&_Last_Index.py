# TC = O(logn)
# SC = O(1)
# Struggled with idea of using two binary searches, cleared after class
# Idea: Use modifies binary search func in such a way that when found (do not return) store value & continue binary search towards left or right until start <= end. The stored value at the end contains starting/ ending index of the target!
class First_Last_Index:
    def search(self, nums, target):
        res = [self.binarySearch(nums, target, True), self.binarySearch(nums, target, False)]
        return res
    
    # Single binary search to find first and last occurence based on flag
    def binarySearch(self, nums, target, flag):
        start, end = 0, len(nums)-1
        res = -1
        while start <= end:
            mid = start + (end-start)//2
            if nums[mid] > target:  
                end = mid - 1
            elif nums[mid] < target:
                start = mid + 1
            else:
                res = mid
                if flag == True:
                    end = mid - 1
                else:
                    start = mid + 1
        return res


obj = First_Last_Index()
nums = [5,7,7,8,8,10] 
target = 8
print(obj.search(nums, target))
