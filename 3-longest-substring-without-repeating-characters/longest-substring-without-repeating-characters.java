class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        // Stores the last seen index of each ASCII character. 
        // Initialized to -1.
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);
        
        int left = 0;
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            
            // If the character was seen and is currently inside the window
            if (lastSeen[c] >= left) {
                // Jump the left boundary past the duplicate
                left = lastSeen[c] + 1;
            }
            
            // Update the maximum valid window size
            maxLen = Math.max(maxLen, right - left + 1);
            
            // Record/update the latest position of the character
            lastSeen[c] = right;
        }
        return maxLen;
    }
}