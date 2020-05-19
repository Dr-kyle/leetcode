package com.kyle.leetcode.l3;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int left = 0;
        int max = 0;
        int right;
        Map<Character, Integer> map = new HashMap<>();
        for (right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                Integer index = map.get(s.charAt(right));
                //如果字符在left和right之间
                if (index >= left) {
                    left = index + 1;
                }
            }
            max = Math.max(right - left + 1, max);
            map.put(s.charAt(right), right);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

