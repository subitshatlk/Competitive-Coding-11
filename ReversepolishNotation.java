//TC - O(n)
//SC - O(n)
//use a stack to keep track of the last two operands to perform the operation with. Always push integers into stack and when an operator is detected, opo the elements and perform the operation. 
//the result is again pushed into the stack
class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;
        }
        Stack<Integer> st = new Stack<>();
        HashSet<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");

        for(String token : tokens){
            //Integer detected
            if(!set.contains(token)){
                st.push(Integer.valueOf(token));
                continue;
            }
            int op1 = st.pop();
            int op2 = st.pop();
            int total = 0;
            switch(token){
                case "+" : total = op1 + op2;
                break;
                case "-" : total = op2 - op1;
                break;
                case "*" : total = op1 * op2;
                break;
                case "/" : total = op2 / op1;
                break;
            }
            st.push(total);

        }
        return st.peek();
    }
}