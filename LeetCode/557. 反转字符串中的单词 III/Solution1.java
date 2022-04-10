class Solution {
    public String reverseWords(String s) {
        String[] wordArray = s.split(" ");
        StringBuilder sb = new StringBuilder();
        Arrays.stream(wordArray)
                .forEach(word -> {
                    sb.append(new StringBuilder(word).reverse());
                    sb.append(" ");
                });
        return sb.toString().trim();
    }
}