package com.example;

import java.util.*;

class Solution
{

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.' && !set.contains(board[i][j])) set.add(board[i][j]);
                else if (board[i][j] != '.' && set.contains(board[i][j])) return false;
            }
        }
        for (int i = 0; i < board.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != '.' && !set.contains(board[j][i])) set.add(board[j][i]);
                else if (board[j][i] != '.' && set.contains(board[j][i])) return false;
            }
        }

        int y = 0;

        while (y <= 6) {
            int x = 0;
            while (x <= 6) {
                Set<Character> set = new HashSet<>();
                for (int i = x; i < x + 3; i++) {
                    for (int j = y; j < y + 3; j++) {
                        if (board[i][j] != '.' && !set.contains(board[i][j])) set.add(board[i][j]);
                        else if (board[i][j] != '.' && set.contains(board[i][j])) return false;
                    }
                }
                x += 3;
            }
            y += 3;
        }

        return true;
    }


    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode temp = res;

        while (temp.next != null && temp.next.next != null) {
            ListNode l1 = temp.next;
            ListNode l2 = temp.next.next;
            l1.next = l2.next;
            temp.next = l2;
            temp.next.next = l1;
            temp = temp.next.next;
        }
        return res.next;
    }


    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] b = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                b[i][j] = 1;
            }
        }

        for (int i = 0; i < mines.length; i++) {
            int x = mines[i][0];
            int y = mines[i][1];
            b[x][y] = 0;
        }

        int s = 0;

        boolean firstOne = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (b[i][j] == 0) continue;
                if (firstOne) {
                    firstOne = false;
                    s = 1;
                }
                int u = i, d = i, r = j, l = j;

                while (u - 1 >= 0 && b[u - 1][j] == 1 && d + 1 < N && b[d + 1][j] == 1 && l - 1 >= 0 && b[i][l - 1] == 1 && r + 1 < N &&
                        b[i][r + 1] == 1) {
                    u--;
                    d++;
                    l--;
                    r++;
                }
                if (s < r - j + 1) s = r - j + 1;
            }
        }
        return s;
    }


    public List<Integer> partitionLabels(String S) {
        Map<Character, List<Integer>> map = new LinkedHashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < S.length(); i++) {
            map.putIfAbsent(S.charAt(i), new ArrayList<>());
            map.get(S.charAt(i)).add(i);
        }

        int lo = 0;
        int hi = 0;

        boolean firstTime = true;
        for (char c : map.keySet()) {
            List<Integer> list = map.get(c);

            if (list.get(0) > hi) {
                res.add(hi - lo + 1);
                lo = list.get(0);
                hi = list.get(list.size() - 1);
            }
            if (list.get(0) < lo) lo = list.get(0);
            if (list.get(list.size() - 1) > hi) hi = list.get(list.size() - 1);
        }

        res.add(hi - lo + 1);
        return res;
    }


    public int countPrimeSetBits(int L, int R) {
        int pCount = 0;

        for (int i = L; i <= R; i++) {
            String b = Integer.toBinaryString(i);

            int count = 0;
            for (int j = 0; j < b.length(); j++) {
                if (b.charAt(j) == '1') count++;
            }

            for (int r = 2; r <= count; r++) {
                if (r == count) {
                    pCount++;
                    break;
                }
                if (count % r == 0) break;
            }
        }
        return pCount;
    }


    public int[] anagramMappings(int[] A, int[] B) {
        int[] P = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    P[i] = j;
                    break;
                }
            }
        }
        return P;
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= nums.length - 4; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j <= nums.length - 3; j++) {
                    if (j == i + 1 || nums[j] != nums[j - 1]) {
                        int lo = j + 1;
                        int hi = nums.length - 1;
                        int sum = target - nums[i] - nums[j];

                        while (lo < hi) {
                            if (nums[hi] + nums[lo] == sum) {
                                list.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                                while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                                while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                                lo++;
                                hi--;
                            }
                            else {
                                while (lo < hi && nums[lo] + nums[hi] < sum) lo++;
                                while (lo < hi && nums[lo] + nums[hi] > sum) hi--;
                            }
                        }
                    }
                }
            }
        }
        return list;
    }


    int left = 0;
    int maxLen = 0;

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;

        for (int i = 0; i < s.length(); i++) {
            palHelper(s, i, i);
            palHelper(s, i, i + 1);
        }

        return s.substring(left, left + maxLen);
    }

    private void palHelper(String s, int lo, int hi) {
        while (lo >= 0 && hi <= s.length() - 1 && s.charAt(lo) == s.charAt(hi)) {
            hi++;
            lo--;
        }
        lo++;
        hi--;

        if (maxLen < hi - lo + 1) {
            left = lo;
            maxLen = hi - lo + 1;
        }
    }


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode res = l3;
        int rem = 0;
        while (l1 != null && l2 != null) {
            int q = l1.val + l2.val + rem;
            int dig = q % 10;
            rem = q / 10;
            l3.next = new ListNode(dig);
            l1 = l1.next;
            l2 = l2.next;
            l3 = l3.next;
        }

        if (l1 != null) {
            while (rem > 0) {
                int q = l1.val + rem;
                l3.next = new ListNode(q % 10);
                rem = q / 10;
                l1 = l1.next;
                l3 = l3.next;
            }
            l3.next = l1;
        }

        if (l2 != null) {
            while (rem > 0) {
                int q = l2.val + rem;
                l3.next = new ListNode(q % 10);
                rem = q / 10;
                l2 = l2.next;
                l3 = l3.next;
            }
            l3.next = l2;
        }

        return res.next;
    }

    public int removeDuplicates2(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }


    public int divide(int dividend, int divisor) {
        int sign = 1;
        if (dividend < 0 && divisor > 0 || divisor < 0 && dividend > 0) {
            sign = -1;
        }
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        if (divisor == 0 || ldividend < ldivisor) return 0;

        long q = recFnc(ldividend, ldivisor);

        if (q > Integer.MAX_VALUE && sign == 1) {
            return Integer.MAX_VALUE;
        }

        return (int) q * sign;
    }

    private long recFnc(long dividend, long divisor) {
        if (dividend < divisor) return 0;

        long sum = divisor;
        long mult = 1;

        while ((sum + sum) < dividend) {
            sum += sum;
            mult += mult;
        }

        return mult + recFnc(dividend - sum, divisor);
    }


    public List<String> parenthesesGen(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        recFnc(0, 0, list, n, sb);

        return list;
    }

    private void recFnc(int left, int right, List<String> list, int n, StringBuilder sb) {
        if (left == n && right == n) {
            list.add(sb.toString());
            System.out.println(sb.toString());
            return;
        }
        if (left < n) {
            sb.append("(");
            recFnc(left + 1, right, list, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(")");
            recFnc(left, right + 1, list, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public int strStr(String haystack, String needle) {
        if (!haystack.contains(needle)) return -1;

        int n = needle.length();

        for (int i = 0; i < haystack.length() - n + 1; i++) {
            if (haystack.substring(i, i + n).equals(needle)) {
                System.out.println(i + " " + needle);
                return i;
            }
        }
        return 0;
    }


    public int removeDuplicates(int[] nums) {
        int i = 1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[j - 1]) continue;
            else {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            ListNode temp = l1;
            temp.next = mergeTwoLists(l1.next, l2);
            return temp;
        }
        else {
            ListNode temp = l2;
            temp.next = mergeTwoLists(l1, l2.next);
            return temp;
        }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l1 = new ListNode(0);
        ListNode res = l1;
        l1.next = head;

        for (int i = 0; i < n - 1; i++) head = head.next;

        while (head.next != null) {
            head = head.next;
            l1 = l1.next;
        }

        if (l1.next.next != null) l1.next = l1.next.next;
        else l1.next = null;

        return res.next;
    }


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(' || array[i] == '[' || array[i] == '{') {
                stack.push(array[i]);
            }
            else if (array[i] == ')' && !stack.empty() && stack.peek() == '(') {
                stack.pop();
            }
            else if (array[i] == '}' && !stack.empty() && stack.peek() == '{') {
                stack.pop();
            }
            else if (array[i] == ']' && !stack.empty() && stack.peek() == '[') {
                stack.pop();
            }
            else {
                return false;
            }
        }
        return stack.empty();
    }


    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];

        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1, hi = nums.length - 1;

            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(target - result) > Math.abs(target - sum)) {
                    result = sum;
                }
                if (target > sum) {
                    lo++;
                }
                else {
                    hi--;
                }
            }
        }
        return result;
    }


    private static final String[] LETTERS = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        recFnc(0, list, digits, "");
        return list;
    }

    private void recFnc(int index, List<String> list, String digits, String s) {
        if (index < digits.length() - 1) {
            char[] array = LETTERS[digits.charAt(index) - '0'].toCharArray();

            for (char letter : array) {
                recFnc(index + 1, list, digits, s + letter);
            }
        }
        if (index == digits.length() - 1) {
            char[] array = LETTERS[digits.charAt(index) - '0'].toCharArray();

            for (char letter : array) {
                list.add(s + letter);
            }
        }
    }


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


    public String longestPalindrome2(String s) {
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