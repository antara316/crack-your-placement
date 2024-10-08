class Solution {
    public boolean isValid(String str) {
        Stack <Character> s = new Stack<>();
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            //opening
            if(ch=='(' || ch=='{' || ch=='[')
            {
                s.push(ch);
            }
            else
            {
                //closing
                if(s.isEmpty())
                {
                    return false;
                }else
                {
                    if((s.peek()=='(' && ch==')')
                    || (s.peek()=='{' && ch=='}')
                    || (s.peek()=='[' && ch==']'))
                    {
                        s.pop();
                    }else
                    {
                        return false;
                    }
                }
            }
        }

        if(s.isEmpty())
        {
            return true;
        }
        return false;

    }
}