package com.example;

import java.util.*;

class Solution
{
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> list = new LinkedList<>();
        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                int hi = nums.length - 1, lo = i + 1;

                while (lo < hi) {
                    if (nums[i] + nums[lo] + nums[hi] == 0) {
                        list.add(Arrays.asList(nums[i], nums[lo], nums[hi]));

                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    }
                    else if (nums[lo] + nums[hi] < -nums[i]) {
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        lo++;
                    }
                    else {
                        while (nums[hi] == nums[hi - 1]) hi--;
                        hi--;
                    }
                }
            }
        }

        return list;
    }


    public String intToRoman(int num) {
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strings = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder rn = new StringBuilder();


        for (int i = 0; i < nums.length && num > 0; i++) {
            for (int j = 0; j < num / nums[i]; j++) {
                rn.append(strings[i]);
            }
            num %= nums[i];
        }
        return rn.toString();
    }


    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 1) return String.join("", strs);

        Arrays.sort(strs);

        int indSW = 0;
        for (int i = 1; i < strs.length; i++) {
            if (strs[indSW].length() > strs[i].length()) {
                indSW = i;
            }
        }

        String shortestWord = strs[indSW];
        StringBuilder pre = new StringBuilder();

        for (int i = 0; i < shortestWord.length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (j == indSW) continue;
                if (shortestWord.charAt(i) != strs[j].charAt(i)) {
                    return pre.toString();
                }
            }
            pre.append(shortestWord.charAt(i));
        }

        return pre.toString();
    }

    public String intToRoman2(int num) {
        String[] ms = new String[]{"", "M", "MM", "MMM"};
        String[] cs = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] xs = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] is = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return ms[num / 1000] + cs[(num % 1000) / 100] + xs[(num % 100) / 10] + is[num % 10];
    }


    public int romanToInt(String s) {
        int total = 0;

        if (s.contains("CD")) total -= 200;
        if (s.contains("CM")) total -= 200;
        if (s.contains("XL")) total -= 20;
        if (s.contains("XC")) total -= 20;
        if (s.contains("IV")) total -= 2;
        if (s.contains("IX")) total -= 2;

        char[] array = s.toCharArray();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 'M') total += 1000;
            if (array[i] == 'C') total += 100;
            if (array[i] == 'D') total += 500;
            if (array[i] == 'X') total += 10;
            if (array[i] == 'L') total += 50;
            if (array[i] == 'I') total += 1;
            if (array[i] == 'V') total += 5;
        }
        return total;
    }


    public boolean isPalindrome(int x) {
        int y = x;
        int total = 0;
        while (y > 0) {
            total = 10 * total + (y % 10);
            y /= 10;
        }
        return total == x ? true : false;
    }


    int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                set.add(s.charAt(j));
                if (set.size() != j - i + 1) {
                    break;
                }
            }
            max = Math.max(max, set.size());
        }
        return max;
    }


    private int count = 0;
    private List<List<Integer>> subsequences = new ArrayList<>();

    void numberOfArithmeticSlices(int[] A) {
        List<Integer> subsequence = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            subsequence.add(A[i]);
            findArithmeticSubsequences(A, subsequence, i + 1);
            subsequence.remove(subsequence.size() - 1);
        }
    }

    private void findArithmeticSubsequences(int[] array, List<Integer> subsequence, int index) {
        for (int i = index; i < array.length; i++) {
            subsequence.add(array[i]);
            if (isArithmetic(subsequence)) {
                subsequences.add(new ArrayList<>(subsequence));
            }
        }
    }

    private boolean isArithmetic(List<Integer> sequence) {
        return sequence.size() >= 3 && sameDifference(sequence);
    }

    private boolean sameDifference(List<Integer> sequence) {
        int difference = 0;
        boolean firstIteration = true;
        for (int i = 0; i < sequence.size() - 1; i++) {
            if (firstIteration) {
                firstIteration = false;
                difference = sequence.get(i + 1) - sequence.get(i);
            }
            else {
                if (difference != sequence.get(i + 1) - sequence.get(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    void printSubsequences() {
        for (List<Integer> list : subsequences) {
            System.out.println(list);
        }
    }


    public int reverse(int x) {
        int curNum = 0;
        while (x != 0) {
            int r = x % 10;
            if (curNum != curNum * 10 / 10) {
                return 0;
            }
            curNum = curNum * 10 + r;
            x = x / 10;
        }
        return curNum;
    }


    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        char[] word = s.toCharArray();
        for (int r = word.length; r > 0; r--) {
            for (int t = 0; t <= word.length - r; t++) {
                int count = 0;
                for (int i = t, j = t + r - 1; i < t + r / 2; i++, j--) {
                    if (word[i] != word[j]) {
                        break;
                    }
                    else {
                        count++;
                    }
                }
                if (count == r / 2) return s.substring(t, (t + r));
            }
        }
        return null;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode dummyHead = l3;
        int remainder = 0;

        while (l1 != null || l2 != null || remainder != 0) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + remainder;
            remainder = sum / 10;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
            l3.next = new ListNode(sum % 10);
            l3 = l3.next;
        }
        return dummyHead.next;
    }


    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        int x = 2 * (numRows - 1);
        int y = 2 * (numRows - 2);

        if (numRows <= 1 || numRows <= s.length() || s == null) return s;

        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                for (int j = i; j < s.length(); j += x) {
                    sb.append(s.substring(j, j + 1));
                }
            }
            else {
                for (int j = i; j < s.length(); j += x) {
                    sb.append(s.substring(j, j + 1));
                    if (y + j < s.length()) {
                        sb.append(s.substring(y + j, y + j + 1));
                    }
                }
                y -= 2;
            }
        }

        return sb.toString();
    }


    public int myAtoi(String str) {
        int index = 0, sign = 1;
        long total = 0;

        if (str.length() == 0) return 0;

        while (str.charAt(index) == ' ' && index < str.length()) {
            index++;
        }

        if (str.charAt(index) == '-' || str.charAt(index) == '+') {
            if (str.charAt(index) == '-') sign = -1;
            index++;
        }

        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            total = 10 * total + (str.charAt(index) - '0');
            if (Integer.MIN_VALUE > total || Integer.MAX_VALUE < total) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            index++;
        }
        return (int) total * sign;
    }
}
