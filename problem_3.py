class solution:
    def __init__(self, array):
        self.array = array
    
    def func(self):
        left = 0
        right = len(self.array) - 1

        while left <= right:
            mid = (left + right)//2

            prev = float('-inf')
            post = float('-inf')

            if mid > 0:
                prev = self.array[mid - 1]
            
            if mid <  len(self.array) -1:
                post = self.array[mid + 1]
            
            if prev < self.array[mid] and self.array[mid] > post:
                return mid
            
            elif prev < self.array[mid] and self.array[mid] < post:
                left = mid + 1
            
            elif prev > self.array[mid] and self.array[mid] > post:
                right = mid - 1

# array =  [1,2,1,3,5,6,4]
array = [1,2,3,1]

new = solution(array)
print(new.func())