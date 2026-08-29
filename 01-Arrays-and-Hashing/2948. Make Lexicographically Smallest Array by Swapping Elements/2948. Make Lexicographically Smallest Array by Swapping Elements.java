1class Solution {
2    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
3      
4        int right;
5        int n = nums.length;
6    for(int start=0; start<n; start++){
7        right=start+1;
8        while(right<n){
9            if(Math.abs(nums[right]-nums[start]) <=limit){
10                if( nums[right]<nums[start]){
11                swap(nums,start,right);
12                right=start+1;
13                continue;
14                }
15            }
16            right++;
17        }
18    }
19        return nums;
20    }
21
22
23    private static void swap(int[] arr, int i, int j){
24        int temp = arr[i];
25        arr[i] = arr[j];
26        arr[j] = temp;
27    }
28}