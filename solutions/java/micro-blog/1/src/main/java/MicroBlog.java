class MicroBlog {
    private static final int TRUNCATED_STRING_MAX_LEN = 5;
    
    public String truncate(String input) {
        int codePointsCount = input.codePointCount(0, input.length());
        if (codePointsCount <= 5) return input;

        int cutIndex = input.offsetByCodePoints(0, TRUNCATED_STRING_MAX_LEN);
        return input.substring(0, cutIndex);
    }
}
