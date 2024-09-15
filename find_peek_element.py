# As taught in the class, I used modified approach with binary search where I chekc elements to both left and right of mid to return the peak
#Time complexity: O(log(n))
#Space Complexity: O(n)
def findPeek(arr):
    low = 0
    high = len(arr) - 1
    if (arr is None or len(arr) == 0):
        return -1
    while (low <= high):
        mid = int((low + high)/2)
        if ((mid == 0 or arr[mid]>arr[mid-1]) and ( mid== len(arr)-1 or arr[mid]> arr[mid + 1])):
            return mid
        elif (mid>0 and arr[mid]<arr[mid-1]):
            high = mid - 1
        else:
            low = mid  + 1 
    return -1

arr = [1,2,1,3,5,6,4]
arr = findPeek(arr)
print(arr)