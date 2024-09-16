# Array: [1,2,3,4,6,7,8] —>eg [4,5,6,8,9]
# # Idx:[0,1,2,3,4,5,6]
# Binary search 


arr = [1,2,3,4,5,6,8]

l = 0
r = len(arr)
commDiff = arr[0]-0#4
while l<r:
    mid = l+ (r-l)//2#6
    if arr[mid] -mid == commDiff:#6-2 = 4--> 8-3 == 4
        l = mid + 1
    else:
        r = mid - 1
print('missing index',mid)
print('missing num',arr[0]+mid)