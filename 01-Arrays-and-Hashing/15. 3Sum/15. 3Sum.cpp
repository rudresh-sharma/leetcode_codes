1class Solution {
2public:
3    vector<vector<int>> threeSum(vector<int>& nums) {
4        vector<vector<int>> ans;
5        int n = nums.size();
6
7        sort(nums.begin(), nums.end());
8
9        for (int i = 0; i < n; i++) {
10            // skip duplicate first elements
11            if (i > 0 && nums[i] == nums[i - 1]) continue;
12
13            int k = i + 1;
14            int j = n - 1;
15            int target = -nums[i];
16
17            while (k < j) {
18                int sum = nums[k] + nums[j];
19
20                if (sum == target) {
21                    ans.push_back({nums[i], nums[k], nums[j]});
22
23                    k++;
24                    j--;
25
26                    // skip duplicates
27                    while (k < j && nums[k] == nums[k - 1]) k++;
28                    while (k < j && nums[j] == nums[j + 1]) j--;
29                }
30                else if (sum < target) {
31                    k++;
32                }
33                else {
34                    j--;
35                }
36            }
37        }
38
39        return ans;
40    }
41};
42