#complexity O(logN)
#solved on leetcode all test cases pass

class solution:
    def __init__(self, array):
        self.array = array
    
    def min_elem(self):
        if len(self.array)==1:
            return self.array[0]
        left = 0
        right = len(self.array)-1
        
        # we perform binary search to find the smallest element.

        while left <= right:
            mid = (left+right)//2
            # print(left, right)
            if mid == len(self.array)-1 and self.array[mid] <= self.array[mid-1]:
                return self.array[mid]
            if mid == 0 and self.array[mid] <= self.array[mid + 1]:
                return self.array[mid]
            
            if self.array[mid] < self.array[mid + 1] and \
            self.array[mid-1] > self.array[mid]:
                return self.array[mid]
            
            # Here we need to check whether the left most element is greater 
            # than the mid element or not
            # then we check whether the array is sorted in a reverse way
            # or is it still a form of unsorted array
            elif self.array[left] > self.array[mid]:
                if self.array[right] > self.array[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            
            # here we check whether the left most element is less than 
            # the mid element or not
            # then we check whether the current array is sorted in an increasing 
            # manner or not
            # or is it still a form of un sorted array
            elif self.array[left] <=  self.array[mid]:
                if self.array[right] < self.array[mid]:
                    left = mid + 1
                else:
                    right = mid - 1

array = [4,5,6,7,1,2,3]

new = solution(array)
print(new.min_elem())