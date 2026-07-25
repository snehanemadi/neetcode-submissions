class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int i = 0;
        List<Integer> list = new ArrayList<>();
        for (int digit : digits) {
            list.add(digit);
        }
        Collections.reverse(list);

        while (carry != 0) {
            if (i < list.size()) {
                if (list.get(i) == 9) {
                    list.set(i, 0);
                } else {
                    list.set(i, list.get(i) + 1);
                    carry = 0;
                }
            } else {
                list.add(carry);
                carry = 0;
            }
            i++;
        }
        Collections.reverse(list);
        int[] result = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            result[j] = list.get(j);
        }
        return result;
    }
}
