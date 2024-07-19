class Solution {
    public int calculate(String str) {
        Stack<Integer> s = new Stack<>();
        char x = '+';
        int sum =0;

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            if(Character.isDigit(ch)){
                sum = sum * 10 +(ch - '0');
            }

            if((!Character.isDigit(ch) && ch != ' ') || i == str.length()-1)
            {
                if(x == '+')
                {
                    s.push(sum);
                }else if(x == '-')
                {
                    s.push(-sum);
                }else if(x == '*')
                {
                    s.push(s.pop()*sum);
                }else if(x == '/')
                {
                    s.push(s.pop()/sum);
                }

                x = ch;
                sum =0;
            }
        }

        int res = 0;
        while(!s.isEmpty())
        {
            res += s.pop();
        }

        return res;
    }
}