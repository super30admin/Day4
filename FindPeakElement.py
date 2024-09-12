class Solution:
    def findPeakElement(arr):
        low = 0
        high = len(arr) - 1
        if len(arr) == 1:
            return 0
        while low <= high:
            mid = (low + high) // 2
            if arr[mid] > arr[mid - 1] and arr[mid] > arr[mid + 1]:
                return mid
            elif mid == low and arr[low] < arr[high]:
                return high
            elif mid == low and arr[low] > arr[high]:
                return low
            elif arr[mid] > arr[mid - 1] and arr[mid] < arr[mid + 1]:
                low = mid
            else:
                high = mid
        '''
        Better Solution
        
        low = 0 
        high = len(arr) - 1
        while low < high:
            mid = (low + high) // 2
            if arr[mid] < arr[mid+1]:
                low = mid + 1
            else:
                high = mid
        return low
        
        '''
    
if __name__ == "__main__":
    s = Solution
    print(s.findPeakElement([1,2,1,3,5,6,4]))

        
        
        