// Time Complexity : O(log(n)) - Binary search
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Search in Infinite sorted array:
// https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

/**
 * // This is the ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * function ArrayReader() {
 *
 *     @param {number} index
 *     @return {number}
 *     this.get = function(index) {
 *         ...
 *     };
 * };
 */

/**
 * @param {ArrayReader} reader
 * @param {number} target
 * @return {number}
 */
var search = function (reader, target) {
    let low = 0;
    let high = 1;
    let mid = 0;
    // Find the range in which binary search should be done.
    // If the integer at the highest index is smalled than target, set range to [high, high*2]
    while (reader.get(high) < target) {
        low = high;
        high = high * 2;
    }
    // Binary search
    while (low <= high) {
        let mid = Math.floor(low + ((high - low) / 2));
        if (reader.get(mid) === target) {
            return mid;
        }
        if (reader.get(mid) < target) {
            low = mid + 1
        } else {
            high = mid - 1;
        }
    }
    // Return -1 if not found
    return -1;
};