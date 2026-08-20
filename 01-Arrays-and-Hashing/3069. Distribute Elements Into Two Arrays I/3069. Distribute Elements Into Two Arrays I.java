1class Solution {
2
3    public int[] resultArray(int[] nums) {
4        int n = nums.length;
5        List<Integer> arr1 = new ArrayList<>();
6        List<Integer> arr2 = new ArrayList<>();
7        arr1.add(nums[0]);
8        arr2.add(nums[1]);
9        for (int i = 2; i < n; i++) {
10            if (arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)) {
11                arr1.add(nums[i]);
12            } else {
13                arr2.add(nums[i]);
14            }
15        }
16        int[] res = new int[n];
17        int idx = 0;
18        for (int x : arr1) {
19            res[idx++] = x;
20        }
21        for (int x : arr2) {
22            res[idx++] = x;
23        }
24        return res;
25    }
26}