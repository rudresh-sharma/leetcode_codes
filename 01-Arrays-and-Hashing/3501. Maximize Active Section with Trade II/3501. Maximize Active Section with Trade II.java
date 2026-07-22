1class Group {
2  public int start;
3  public int length;
4  public Group(int start, int length) {
5    this.start = start;
6    this.length = length;
7  }
8}
9
10class SparseTable {
11  public SparseTable(int[] nums) {
12    n = nums.length;
13    st = new int[bitLength(n) + 1][n + 1];
14    System.arraycopy(nums, 0, st[0], 0, n);
15    for (int i = 1; i <= st.length; ++i)
16      for (int j = 0; j + (1 << i) <= n; ++j)
17        st[i][j] = Math.max(st[i - 1][j], st[i - 1][j + (1 << (i - 1))]);
18  }
19
20  // Returns max(nums[l..r])
21  public int query(int l, int r) {
22    final int i = bitLength(r - l + 1) - 1;
23    return Math.max(st[i][l], st[i][r - (1 << i) + 1]);
24  }
25
26  private final int n;
27  private final int[][] st; // st[i][j] := max(nums[j..j + 2^i - 1])
28
29  private int bitLength(int n) {
30    return Integer.SIZE - Integer.numberOfLeadingZeros(n);
31  }
32}
33
34class Solution {
35  public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
36    final int n = s.length();
37    final int ones = (int) s.chars().filter(c -> c == '1').count();
38    final Pair<List<Group>, int[]> zeroGroupsInfo = getZeroGroups(s);
39    final List<Group> zeroGroups = zeroGroupsInfo.getKey();
40    final int[] zeroGroupIndex = zeroGroupsInfo.getValue();
41
42    if (zeroGroups.isEmpty())
43      return Collections.nCopies(queries.length, ones);
44
45    final SparseTable st = new SparseTable(getZeroMergeLengths(zeroGroups));
46    final List<Integer> ans = new ArrayList<>();
47
48    for (int[] query : queries) {
49      final int l = query[0];
50      final int r = query[1];
51      final int left = zeroGroupIndex[l] == -1 ? -1
52                                               : (zeroGroups.get(zeroGroupIndex[l]).length -
53                                                  (l - zeroGroups.get(zeroGroupIndex[l]).start));
54      final int right =
55          zeroGroupIndex[r] == -1 ? -1 : (r - zeroGroups.get(zeroGroupIndex[r]).start + 1);
56      final Pair<Integer, Integer> adjacentIndices = mapToAdjacentGroupIndices(
57          zeroGroupIndex[l] + 1, s.charAt(r) == '1' ? zeroGroupIndex[r] : zeroGroupIndex[r] - 1);
58      final int startAdjacentGroupIndex = adjacentIndices.getKey();
59      final int endAdjacentGroupIndex = adjacentIndices.getValue();
60
61      int activeSections = ones;
62      if (s.charAt(l) == '0' && s.charAt(r) == '0' && zeroGroupIndex[l] + 1 == zeroGroupIndex[r])
63        activeSections = Math.max(activeSections, ones + left + right);
64      else if (startAdjacentGroupIndex <= endAdjacentGroupIndex)
65        activeSections = Math.max(activeSections,
66                                  ones + st.query(startAdjacentGroupIndex, endAdjacentGroupIndex));
67      if (s.charAt(l) == '0' &&
68          zeroGroupIndex[l] + 1 <= (s.charAt(r) == '1' ? zeroGroupIndex[r] : zeroGroupIndex[r] - 1))
69        activeSections =
70            Math.max(activeSections, ones + left + zeroGroups.get(zeroGroupIndex[l] + 1).length);
71      if (s.charAt(r) == '0' && zeroGroupIndex[l] < zeroGroupIndex[r] - 1)
72        activeSections =
73            Math.max(activeSections, ones + right + zeroGroups.get(zeroGroupIndex[r] - 1).length);
74      ans.add(activeSections);
75    }
76
77    return ans;
78  }
79
80  // Returns the zero groups and the index of the zero group that contains the i-th character
81  private Pair<List<Group>, int[]> getZeroGroups(String s) {
82    final List<Group> zeroGroups = new ArrayList<>();
83    final int[] zeroGroupIndex = new int[s.length()];
84
85    for (int i = 0; i < s.length(); i++) {
86      if (s.charAt(i) == '0') {
87        if (i > 0 && s.charAt(i - 1) == '0')
88          zeroGroups.get(zeroGroups.size() - 1).length++;
89        else
90          zeroGroups.add(new Group(i, 1));
91      }
92      zeroGroupIndex[i] = zeroGroups.size() - 1;
93    }
94
95    return new Pair<>(zeroGroups, zeroGroupIndex);
96  }
97
98  // Returns the sums of the lengths of the adjacent groups
99  private int[] getZeroMergeLengths(List<Group> zeroGroups) {
100    final int[] zeroMergeLengths = new int[zeroGroups.size() - 1];
101    for (int i = 0; i < zeroGroups.size() - 1; ++i)
102      zeroMergeLengths[i] = zeroGroups.get(i).length + zeroGroups.get(i + 1).length;
103    return zeroMergeLengths;
104  }
105
106  // Returns the indices of the adjacent groups that contain l and r completely
107  private Pair<Integer, Integer> mapToAdjacentGroupIndices(int startGroupIndex, int endGroupIndex) {
108    return new Pair<>(startGroupIndex, endGroupIndex - 1);
109  }
110}