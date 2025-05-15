class Solution {
    int i=0;
    public int calculate(String s) {
        return calculator(s);
    }
    private int calculator(String s)
    {
        int num = 0;
        int ans = 0;
        int sign = 1;
        while(i < s.length())
        {
            char c = s.charAt(i++);
            if(c >= '0' && c <= '9')
            {
                num = num * 10 + (c - '0');
            }
            else if(c == '(')
            {
                num = calculator(s);
            }
            else if(c == ')')
            {
                return (ans = ans + num * sign);
            }
            else if(c == '+' || c == '-')
            {
                ans = ans + num * sign ;
                num = 0;
                sign = (c =='-') ? -1 : 1;
            }
        }
        ans = ans + num * sign;
        return ans;
    }
}