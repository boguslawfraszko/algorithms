package org.example.algorithms;

/**
 * For two strings A and B, we define the similarity of the strings to be the length of the longest prefix common to both strings. For example, the similarity of strings "abc" and "abd" is 2, while the similarity of strings "aaa" and "aaab" is 3.
 *
 * Calculate the sum of similarities of a string S with each of it's suffixes.
 *
 *
 */
public class SumOfSimilarities {

    public static long calculateSumOfSimilarities(String s) {
        int n = s.length();
        int[] z = calculateZFunction(s);
        long sum = n;  // The whole string is a prefix of itself
        for (int i = 1; i < n; i++) {
            sum += z[i];
        }
        return sum;
    }

    private static int[] calculateZFunction(String s) {
        int n = s.length();
        int[] z = new int[n];
        int l = 0, r = 0;

        for (int i = 1; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }

        return z;
    }
}
