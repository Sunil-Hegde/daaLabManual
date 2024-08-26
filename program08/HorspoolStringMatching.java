package program08;

public class HorspoolStringMatching {
    static final int NO_OF_CHARS = 256;
    // Utility function to get the maximum of two integers
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }
    // Function to fill the bad character heuristic table
    static void badCharHeuristic(char[] pattern, int size, int[] badChar) {
        // Initialize all occurrences of characters as -1
        for (int i = 0; i < NO_OF_CHARS; i++) {
            badChar[i] = -1;
        }
        // Fill the actual value of last occurrence of a character
        for (int i = 0; i < size; i++) {
            badChar[(int) pattern[i]] = i;
        }
    }
    // Function to perform the Horspool's algorithm for string matching
    static void search(char[] text, char[] pattern) {
        int m = pattern.length;
        int n = text.length;
        int[] badChar = new int[NO_OF_CHARS];
        // Fill the bad character heuristic table
        badCharHeuristic(pattern, m, badChar);
        int s = 0;  // s is the shift of the pattern with respect to text
        while (s <= (n - m)) {
            int j = m - 1;
            // Decrease j while characters of pattern and text are matching
            // at this shift s
            while (j >= 0 && pattern[j] == text[s + j]) {
                j--;
            }
            // If the pattern is present at the current shift, print the index
            if (j < 0) {
                System.out.println("Pattern occurs at shift = " + s);

                // Shift the pattern so that the next character in text aligns
                // with the last occurrence of it in pattern.
                // The condition s+m < n is necessary for the case when the pattern occurs at the end of the text
                s += (s + m < n) ? m - badChar[text[s + m]] : 1;
            } else {
                // Shift the pattern so that the bad character in text
                // aligns with the last occurrence of it in pattern. The
                // max function is used to make sure that we get a positive
                // shift.
                s += max(1, j - badChar[text[s + j]]);
            }
        }
    }
    public static void main(String[] args) {
        char[] text = "ABAAABCD".toCharArray();
        char[] pattern = "ABC".toCharArray();
        search(text, pattern);
    }
}
