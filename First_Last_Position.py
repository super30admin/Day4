#Time Complexity: O(log(n)), since binary search is used.
# Space Complexity :O(1), as no extra space is used apart from some variables.


class Solution:

    def getStartIndex(self, arr:list,target:int,) -> list:
        
        start, end = arr[0],arr[len(arr)-1] 
        while(start<=end):
            mid = int(start + (end - start)/2) # calculate middle index
            if arr[mid] == target:
                if (mid - 1 >= 0) and arr[mid-1]!= target: # to check if the element of the left of the mid is the target or not
                    return mid
                else:
                    end = mid-1 # move to the left
            elif arr[mid] < target: # check right array
                start = mid + 1
            else: # check left array
                end = mid - 1
        return -1
    def getLastIndex(self, arr:list, target:int,s:int) -> list:
        if s == -1: # if the element is not present
            return -1
        else:
            start ,end = arr[0], arr[len(arr)-1]
            while( start<= end):
                mid = int(start + (end - start)/2) # calculate middle index
                if arr[mid] == target:
                    if mid + 1<= len(arr) and arr[mid+1] != target: # to check if the element of the right of the mid is the target or not
                        return mid
                    else: # move to the right
                        start = mid +1
                elif arr[mid]< target: # check right array
                    start = mid + 1
                else:
                    end = mid - 1 # check left array
        return -1 # the element is not present

    def searchRange(self, arr: list, target: int) -> list: # main function , which returns a list of 2 indices
        if len(arr) == 0: # if the list is empty
            return [-1,-1]
        else:
            start = self.getStartIndex(arr,target) # for start index
            
            end = self.getLastIndex(arr,target,start) # for end index
            return [start,end] 

   

    



s = Solution()
nums = [1,2,3,5]
t = s.searchRange(nums,4)
print(t)
