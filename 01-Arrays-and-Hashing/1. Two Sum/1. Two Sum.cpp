1class Solution {
2public:
3    vector<int> twoSum(vector<int>& nums, int target) {
4
5        unordered_map<int,int> hash;
6        for(int i=0;i<nums.size();i++){
7            int complement=target-nums[i];
8            if(hash.count(complement))return {hash[complement],i};
9            else hash[nums[i]]=i;
10        }
11        return {0};
12    
13    }
14};