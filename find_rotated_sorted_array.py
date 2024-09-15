#The easier way is to solve the problem linearly but the time complexity can reduced by using binary search.
#The approach I used here is first find mid if prev element is less than mid then mid is lowest or if mid+1 is less than mid then mid+1 element is lowest
#But, if 1st element of array is less than mid then search to right but if its greater rearch to left
# Time complexity O(log(n))
# Space Complexity O(n)
def search(arr):
    low = 0
    high = len(arr)-1
    if (len(arr)==0):
        return -1
    if len(arr) == 1:
        return arr[0]

    while (low <= high):
        mid = int((low+high)/2)
        if (arr[mid] > arr[mid+1]):
            return arr[mid+1]
        elif (arr[mid-1] < arr[mid]):
            return arr[mid]
        if arr[mid] > arr[low]:
            low = mid + 1
        else:
            high  = mid - 1

arr = [4,5,6,7,0,1,2]
index = search(arr)
print(index) 
