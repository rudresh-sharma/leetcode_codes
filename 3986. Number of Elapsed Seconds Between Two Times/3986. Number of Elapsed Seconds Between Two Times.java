1import java.util.regex.Pattern;
2import java.util.regex.Matcher;
3
4class Solution {
5
6  
7    
8    
9    public int secondsBetweenTimes(String startTime, String endTime) {
10        String[] t1 = startTime.split(:);
11        String[] t2 = endTime.split(:);
12
13        int h1 = Integer.parseInt(t1[0]);
14         int m1 = Integer.parseInt(t1[1]);
15         int s1 = Integer.parseInt(t1[2]);
16
17         int h2 = Integer.parseInt(t2[0]);
18         int m2 = Integer.parseInt(t2[1]);
19         int s2 = Integer.parseInt(t2[2]);
20
21
22         int startSec = (h1*60*60) + (m1*60) + s1;
23         int endSec = (h2*60*60) + (m2*60) + s2;
24        return endSec-startSec;
25    }
26}