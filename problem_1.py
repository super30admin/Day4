# complexity O(logN)
# solved on leetcode all test cases pass

class solution:
    def __init__(self, array, target):
        self.array = array
        self.target = target
    
    def binary_search(self):
        if len(self.array) == 0:
            return [-1, -1]
        
        left = 0
        right = len(self.array) - 1
        flag = 0
        
        # here first performed Binary search to find the element
        while left <= right:
            mid = (left + right)//2
            if self.array[mid] == self.target:
                flag = 1
                break
            if self.target < self.array[mid] : 
                right = mid - 1
            if self.target > self.array[mid]:
                left = mid + 1

        #if flag is zero that means that the loop couldn't find the element.
        if not flag:
            return [-1, -1]

        first = left
        second = mid
        lfb = 0

        # Now we perform binary search to find the left most element
        while first <= second:
            mid = (first + second) // 2
            if mid == 0 and self.array[mid] == self.target:
                lfb = 0
                break
            if self.array[mid-1] < self.array[mid] and \
                self.array[mid] == self.target:
                lfb = mid
                break
            
            # if mid element is equal to the target, then we have to move
            # more to the left
            elif self.array[mid] < self.target:
                first = mid + 1
            
            # if the mid element is less than the target, that means we have to 
            # move towards the right
            elif self.array[mid] == self.target:
                second = mid - 1

        first = mid
        second = right
        rbb = 0

        #similarly we perform binary search to calculate the right upper bound
        while first <= second:
            mid = (first+second)//2
            if mid == len(self.array)-1 and self.array[mid] == self.target:
                rbb = len(self.array)-1
                break
            if self.array[mid] < self.array[mid + 1] \
                and self.array[mid] == self.target:
                rbb = mid
                break
            
            # if the target is less than the current mid, then
            # we move on to the left part 
            elif self.target < self.array[mid]:
                second = mid - 1
            
            # if target is equal to the middle element, that means
            # that we should move further to the right. 
            elif self.target == self.array[mid]:
                first = mid + 1

        return [lfb, rbb]

array = [5,7,7,8,8,10]
target = 8

new = solution(array, target)

print(new.binary_search())