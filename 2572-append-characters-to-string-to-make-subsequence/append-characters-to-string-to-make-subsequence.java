class Solution {
    public int appendCharacters(String s, String t) {
        int first = 0, longestPrefix = 0;

        while (first < s.length() && longestPrefix < t.length()) {
            if (s.charAt(first) == t.charAt(longestPrefix)) {
                // Since at the current position both the characters are equal,
                // increment longestPrefix by 1
                longestPrefix++;
            }
            first++;
        }

        // The number of characters appended is given by the difference in
        // length of t and longestPrefix
        return t.length() - longestPrefix;
    }
}

// maximum conseq patternj.
// O(n^2) brute?
// nah

// need all elements of t in s and subseuence he toh we need to take care of the order as well.