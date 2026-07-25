class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        Stack<Character> st = new Stack<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(!st.isEmpty() && map.get(c).equals(st.peek())){
                    st.pop();
                } else {
                    return false;
                }
            } else {
                st.push(c);
            }
        }
        return st.isEmpty();
    }
}

