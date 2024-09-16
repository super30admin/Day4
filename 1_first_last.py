# time complexity : O(log(n))
# space complexity : O(1)
# working on Leetcode : yes

# binary search for first element
def binarysearch(arr,l,r,target):
    while (l<=r):
        mid = l + (r-l)//2
        if arr[mid] == target :
            return l,mid,r
        if arr[mid] > target:
            r=mid-1
        else:
            l=mid+1
    return l,-1,r

def mainSearch(arr,target):
    # find target first
    l,mid,r=binarysearch(arr,0,len(arr)-1,target)
    if mid == -1:
        return [-1,-1]
    # go to first point towards left
    key1=-1
    key2=-1
    while l<=mid:
        key1= l+(mid-l)//2
        if arr[key1]==target:
            if key1 ==l or arr[key1 - 1] != target:
                break
            mid=key1-1
        else:
            l=key1+1
    # same way go right
    while mid <= r:
        key2 = mid + (r-mid)//2
        if arr[key2] == target:
            if key2 == r or arr[key2 + 1] != target:
                break
            mid = key2 + 1
        else:
            r = key2 - 1

    return [key1,key2]


nums = [1,1,8,8,8,8,8,8]
target = 2

print(mainSearch(nums,target))