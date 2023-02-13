/*
 * @lc app=leetcode id=58 lang=javascript
 *
 * [58] Length of Last Word
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
    words = s.split(" ");
    for (var i=words.length-1; i>= 0; i--) {
        if (words[i] != "")
            return words[i].length;
    }
    return words[i].length;
};
// @lc code=end

