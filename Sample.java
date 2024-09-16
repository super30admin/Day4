//Time Complexity
//Problem_1 : O(log n) 

//Problem_2 : O(log n)

//Problem_3 : O(log n)

//Space Complexity
//Problem_1 : O(1) 

//Problem_2 : O(1)

//Problem_3 : O(1)

// Your code here along with comments explaining your approach
/* Problem_2 :
 * In any rotated sorted array, one side always sorted and other side is not.
 * Base case : if mid element is lesser than both of its neighbors return mid element
 * If not, then move the pointer towards the part of array which is not sorted.
 * and repeat the procedure
 * 
 */

/* Problem_1 :
 * Here to find first and last index of target element, binary search is applied twice. once to find left index and second for finding right index.
 * In left binary search : mid element is compared with previous element, if its smaller than mid element then mid element is returned as left index.
 * If not, high pointer moved to mid - 1 and process is repeated 
 * In right binary search : mid element is compared with next element, if its greater than mid element then mid element is returned as left index.
 * If not, low pointer moved to mid + 1 and process is repeated
 */

/* Problem_3 :
 * Peak element is the one where both the neighboring elements are ssmaller than the mid element.
 * To find the peak element, we apply binary search. After calculating mid, if the two neighboring elements of mid are smaller than mid, we return index of it. else we move towards the element which is greater than mid and process is repeated.
 * /