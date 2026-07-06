1class Solution {
2    public int[] twoSum(int[] nums, int target) {
3        Map<Integer, Integer> map = new HashMap<>();
4
5        int n = nums.length;
6
7        for(int i=0; i<n; i++){
8         for(int j=i+1; j<n; j++){
9            if(nums[i] + nums[j] == target){
10                return new int[]{i,j};
11            }
12         }
13        }
14
15        return new int[]{};
16    }
17}