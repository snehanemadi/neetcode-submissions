class Solution {

    public String encode(List<String> strs) {
        StringBuilder encode = new StringBuilder();
        for(String str : strs) {
            encode.append(str.length()).append("#").append(str);
        }
        return encode.toString();
    }

    public List<String> decode(String str) {
        List<String> decode = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j=i;
            while(str.charAt(j) != '#') j++;

            int length = Integer.valueOf(str.substring(i,j));
            i = j + 1 + length;
            decode.add(str.substring(j+1,i));
        }
        return decode;
    }
}
