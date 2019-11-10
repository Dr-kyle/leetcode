package com.kyle.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 解题思路: 滑动窗口
 */
public class Three {
    public static void main(String[] args) {
        Three three = new Three();
        System.out.println(three.lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        if ( null == s || "".equals(s)) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>(s.length());
        int length = s.length();
        // 记录最大值
        int max = 0;
        // 记录当前子串的第一个字符的位置
        int cur = 0;
        // i 当前遍历的index值
        int temp;
        for (int i = 0; i < length; i++) {
            if (map.containsKey(s.charAt(i))) {
                temp = map.get(s.charAt(i));
                // 获取的值 在 cur 之后
                if (temp >= cur) {
                    cur = temp + 1;
                }
            }
            temp = i - cur + 1;
            if (temp > max) {
                max = temp;
            }
            map.put(s.charAt(i), i);
        }
        return max;
    }
}
