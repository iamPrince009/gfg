class Solution {
    public static String maxSubseq(String s, int k) {
        // code here
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            while(!stack.isEmpty() && k>0 && stack.peek()-'0'<s.charAt(i)-'0')
            {
                stack.pop();
                k--;
            }
            stack.push(s.charAt(i));
        }
        while(k>0)
        {
            stack.pop();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty())
        {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
