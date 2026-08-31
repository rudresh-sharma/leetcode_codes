1class Solution {
2
3    public int[] nodesBetweenCriticalPoints(ListNode head) {
4        int[] result = { -1, -1 };
5
6        // Initialize minimum distance to the maximum possible value
7        int minDistance = Integer.MAX_VALUE;
8
9        // Pointers to track the previous node, current node, and indices
10        ListNode previousNode = head;
11        ListNode currentNode = head.next;
12        int currentIndex = 1;
13        int previousCriticalIndex = 0;
14        int firstCriticalIndex = 0;
15
16        while (currentNode.next != null) {
17            // Check if the current node is a local maxima or minima
18            if (
19                (currentNode.val < previousNode.val &&
20                    currentNode.val < currentNode.next.val) ||
21                (currentNode.val > previousNode.val &&
22                    currentNode.val > currentNode.next.val)
23            ) {
24                // If this is the first critical point found
25                if (previousCriticalIndex == 0) {
26                    previousCriticalIndex = currentIndex;
27                    firstCriticalIndex = currentIndex;
28                } else {
29                    // Calculate the minimum distance between critical points
30                    minDistance = Math.min(
31                        minDistance,
32                        currentIndex - previousCriticalIndex
33                    );
34                    previousCriticalIndex = currentIndex;
35                }
36            }
37
38            // Move to the next node and update indices
39            currentIndex++;
40            previousNode = currentNode;
41            currentNode = currentNode.next;
42        }
43
44        // If at least two critical points were found
45        if (minDistance != Integer.MAX_VALUE) {
46            int maxDistance = previousCriticalIndex - firstCriticalIndex;
47            result = new int[] { minDistance, maxDistance };
48        }
49
50        return result;
51    }
52}