1class Solution {
2    public boolean uniformArray(int[] nums1) {
3        int sOdd=1;
4        int sEven=0;
5        int currentOdd;
6        int currentEven;
7
8        boolean isOddFound=false;
9        boolean isEvenFound=false;
10
11        for(int i=0; i<nums1.length; i++){
12            int num = nums1[i];
13
14            if(!isOddFound){
15                if(num%2 !=0) {
16                    sOdd=num;
17                    isOddFound=true;
18                }
19            }
20
21
22            if(!isEvenFound){
23                if(num%2 ==0) {
24                    sEven=num;
25                    isEvenFound=true;
26                }
27            }
28
29            if(num%2 !=0 && isOddFound){
30                currentOdd= num;
31                sOdd = Math.min(currentOdd,sOdd);
32                
33            }
34
35             if(num%2 ==0 && isEvenFound){
36                currentEven= num;
37                sEven = Math.min(currentEven,sEven);
38                
39            }
40
41        }
42
43
44        if(isEvenFound) System.out.println(sEven);
45
46        if(isOddFound) System.out.println(sOdd);
47        // Making Odd Parity & Even Which can be made lets see
48        boolean canMakeOddParity = true;
49        boolean canMakeEvenParity=true;
50        for(int i=0; i<nums1.length; i++){
51            int num = nums1[i];
52            // Making Odd
53            if(isOddFound && canMakeOddParity && num%2 == 0){
54             
55
56                if(!(num-sOdd>=1)) canMakeOddParity = false;
57        }
58
59            if(isEvenFound && canMakeEvenParity && num%2 != 0){
60              
61                if(!(num-sOdd>=1)) canMakeEvenParity=false;
62            }
63
64
65
66    }
67
68        System.out.println(canMakeOddParity);
69        System.out.println(canMakeEvenParity);
70        
71        if(canMakeOddParity || canMakeEvenParity) return true;
72        else return false;
73    }
74}
75