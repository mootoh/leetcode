/*
 * @lc app=leetcode id=66 lang=javascript
 *
 * [66] Plus One
 */

// @lc code=start
/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
    var result = [];
    var carry = 1;

    for (var i=digits.length-1; i>=0; i--) {
        if (carry == 1) {
            if (digits[i] == 9) {
                result.unshift(0);
                if (i == 0) {
                    result.unshift(1);
                }
                carry = 1;
            } else {
                result.unshift(digits[i]+1);
                carry = 0;
            }
        } else {
            result.unshift(digits[i]);
        }
    }
    return result;
};
// @lc code=end

