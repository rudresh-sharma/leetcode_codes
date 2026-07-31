1class Solution {
2public:
3    int minimumPushes(string word) {
4        // Frequency vector to store count of each letter
5        vector<int> frequency(26, 0);
6
7        // Count occurrences of each letter
8        for (char& c : word) {
9            ++frequency[c - 'a'];
10        }
11
12        // Sort frequencies in descending order
13        sort(frequency.rbegin(), frequency.rend());
14
15        int totalPushes = 0;
16
17        // Calculate total number of presses
18        for (int i = 0; i < 26; ++i) {
19            if (frequency[i] == 0) break;
20            totalPushes += (i / 8 + 1) * frequency[i];
21        }
22
23        return totalPushes;
24    }
25};