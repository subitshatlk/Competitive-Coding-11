//TC - O(n)
//Sc - O(n)
//Approach - A monotonic stack has either increasing values /decreasing. 
//For the number to be small, the initial digits must be smaller. Use a stack and compare at each step if the number in the stack is > than current element. If yes, then pop it and add the smaller element. In general, if the numbers are the same as the prev or if they are in increasing order eg: 1234 , we can simply remove from the end ( pop from stack)

class Solution {
    public String removeKdigits(String num, int k) {
        if(num == null || num.length() == 0){
            return null;
        }
        Stack<Character> st = new Stack<>();
        for(char c : num.toCharArray()){
            while(!st.isEmpty() && k > 0 && st.peek() > c){
                st.pop();
                k--;
            }
            st.push(c);
        }
        while(!st.isEmpty() && k > 0){
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        while(sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
    return sb.length() > 0 ? sb.toString() : "0";
    }
    }
