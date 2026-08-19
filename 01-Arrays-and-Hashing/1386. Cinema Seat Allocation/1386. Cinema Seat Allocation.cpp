1class Solution {
2
3    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
4        int left = 0b11110000;
5        int middle = 0b11000011;
6        int right = 0b00001111;
7
8        Map<Integer, Integer> occupied = new HashMap<Integer, Integer>();
9        for (int[] seat : reservedSeats) {
10            if (seat[1] >= 2 && seat[1] <= 9) {
11                int origin = occupied.containsKey(seat[0])
12                    ? occupied.get(seat[0])
13                    : 0;
14                int value = origin | (1 << (seat[1] - 2));
15                occupied.put(seat[0], value);
16            }
17        }
18
19        int ans = (n - occupied.size()) * 2;
20        for (Map.Entry<Integer, Integer> entry : occupied.entrySet()) {
21            int row = entry.getKey(),
22                bitmask = entry.getValue();
23            if (
24                (bitmask | left) == left ||
25                (bitmask | middle) == middle ||
26                (bitmask | right) == right
27            ) {
28                ++ans;
29            }
30        }
31        return ans;
32    }
33}