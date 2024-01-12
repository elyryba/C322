import java.util.HashMap;

public class Lab1 {

    public class Problem1 {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int[] {map.get(complement), i};
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }
        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] nums = {2, 7, 11, 15};
            int target = 9;
            int[] result = solution.twoSum(nums, target);
            System.out.println("[" + result[0] + ", " + result[1] + "]");
        }

        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        // Expected output: [0, 1]
        int[] nums2 = {1, 2, 3};
        int target2 = 7;
        // Expected output: null or an exception
        int[] nums3 = {3, 3, 4, 4};
        int target3 = 8;
        // Expected output: [2, 3] (or any valid pair)
        int[] nums4 = {6};
        int target4 = 6;
        // Expected output: null or an exception
        int[] nums5 = {-1, -2, -3, -4};
        int target5 = -6;
        // Expected output: [1, 2]
        int[] nums6 = {100000, 50000};
        int target6 = 150000;
// Expected output: [0, 1]

    }



    public class Problem2 {

        public static boolean isPalindrome(int x) {
            if (x < 0) return false;
            int reversed = 0, original = x;
            while (x != 0) {
                reversed = reversed * 10 + x % 10;
                x /= 10;
            }
            return original == reversed;
        }


        public static void main(String[] args) {
            // Test Case 1: Positive Palindrome
            assert Problem2(121) == true; // Expected: true

            // Test Case 2: Negative Number
            assert Problem2(-121) == false; // Expected: false

            // Test Case 3: Non-Palindrome
            assert Problem2(123) == false; // Expected: false

            // Test Case 4: Single Digit
            assert Problem2(7) == true; // Expected: true

            // Test Case 5: Zero
            assert Problem2(0) == true; // Expected: true
        }
    }

    public class Problem3 {


        public static String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) return "";
            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++) {
                while (strs[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                    if (prefix.isEmpty()) return "";
                }
            }
            return prefix;
        }

        public static void main(String[] args) {
            // Test Case 1: Common Prefix
            assert Problem3(new String[]{"flower", "flow", "flight"}).equals("fl"); // Expected: "fl"

            // Test Case 2: No Common Prefix
            assert Problem3(new String[]{"dog", "racecar", "car"}).equals(""); // Expected: ""

            // Test Case 3: Empty Strings
            assert Problem3(new String[]{"", "", ""}).equals(""); // Expected: ""

            // Test Case 4: Single String
            assert Problem3(new String[]{"alone"}).equals("alone"); // Expected: "alone"

            // Test Case 5: All Strings are Identical
            assert Problem3(new String[]{"same", "same", "same"}).equals("same"); // Expected: "same"
        }
    }

    public class Problem4 {


        public static int romanToInt(String s) {
            int[] nums = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) {
                    case 'M': nums[i] = 1000; break;
                    case 'D': nums[i] = 500; break;
                    case 'C': nums[i] = 100; break;
                    case 'L': nums[i] = 50; break;
                    case 'X': nums[i] = 10; break;
                    case 'V': nums[i] = 5; break;
                    case 'I': nums[i] = 1; break;
                }
            }
            int sum = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < nums[i + 1]) sum -= nums[i];
                else sum += nums[i];
            }
            return sum + nums[nums.length - 1];
        }

        public static void main(String[] args) {
            // Test Case 1: Typical Case
            assert romanToInt("III") == 3;

            // Test Case 2: Subtractive Notation
            assert romanToInt("IV") == 4;

            // Test Case 3: Larger Number
            assert romanToInt("MCMXCIV") == 1994;

            // Test Case 4: No Roman Numerals
            assert romanToInt("") == 0;

            // Test Case 5: Single Roman Numeral
            assert romanToInt("V") == 5;
        }
    }

    public class Problem5 {

        public static boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) return false;
                    char top = stack.pop();
                    if ((c == ')' && top != '(') ||
                            (c == '}' && top != '{') ||
                            (c == ']' && top != '[')) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }

        public static void main(String[] args) {
            // Test Case 1: Valid Parentheses
            assert isValid("()[]{}") == true;

            // Test Case 2: Invalid Order
            assert isValid("(]") == false;

            // Test Case 3: Unmatched Parentheses
            assert isValid("([)]") == false;

            // Test Case 4: Single Open Bracket
            assert isValid("(") == false;

            // Test Case 5: Empty String
            assert isValid("") == true;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public class Problem6 {

        public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) return list2;
            if (list2 == null) return list1;

            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }

        public static void main(String[] args) {
            // Test Case 1: Both lists are non-empty
            ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
            ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
            ListNode mergedList = mergeTwoLists(list1, list2);


            // Test Case 2: One list is empty
            ListNode list3 = null;
            ListNode list4 = new ListNode(0);
            ListNode mergedList2 = mergeTwoLists(list3, list4);


            // Test Case 3: Both lists are empty
            ListNode list5 = null;
            ListNode list6 = null;
            ListNode mergedList3 = mergeTwoLists(list5, list6);
        }
    }

    public class Problem7 {

        public static int[] plusOne(int[] digits) {
            int n = digits.length;
            for (int i = n - 1; i >= 0; i--) {
                if (digits[i] < 9) {
                    digits[i]++;
                    return digits;
                }
                digits[i] = 0;
            }

            int[] newNumber = new int[n + 1];
            newNumber[0] = 1;
            return newNumber;
        }

        public static void main(String[] args) {
            // Test Case 1: Increment without carry over
            int[] digits1 = {1, 2, 3};

            // Test Case 2: Increment with carry over
            int[] digits2 = {9, 9, 9};

            // Test Case 3: Increment with leading zeros
            int[] digits3 = {0, 0, 9};

            // Test Case 4: Single digit
            int[] digits4 = {6};

            // Test Case 5: Zero
            int[] digits5 = {0};
        }
    }





}
