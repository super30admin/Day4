def search(a,ele,l,r): #normal binary search implementaion
    #left = 0
    #right = len(a)-1
    while l<=r:
        if l== r:
            print("left=right")
        mid =  (l + r)//2
        print(mid,'mid')
        if ele == a[mid]:
            return mid
        elif ele <= a[mid-1]:
            r = mid-1
            print(l,r,"r")
            return search(a,ele,l,r)
        elif ele >= a[mid+1]:
            l=mid+1
            print(l,r, "l")
            return search(a, ele, l, r)
        else:
            return -1
#a=[10,20,30,40,60,70,80]
#print(search(a,30,0,len(a)-1))

def bin_search_infinite_array(a,k): #
    arr=a
    l=0
    h=1
    while l<=h:
        #case 1
        if a[l] == k:
            return l
        elif a[h]==k:
            return k
        elif a[h]>k:
            j=search(a,k,l,h)
            if j == -1:
                return None
            else:
                return j
                #a[h]<k:
        else:
            h= 2*h
            #break


print(bin_search_infinite_array([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26],14))
