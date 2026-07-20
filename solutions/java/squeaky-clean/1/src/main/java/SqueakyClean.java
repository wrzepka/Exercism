class SqueakyClean {
    static String clean(String identifier) {
        StringBuilder builder = new StringBuilder(identifier);

        for (int i = 0;  i < builder.length(); i++){
            if (Character.isDigit(builder.charAt(i)) || Character.isAlphabetic(builder.charAt(i))){
                switch(builder.charAt(i)){
                    case '4':
                        builder.setCharAt(i, 'a');
                        break;
                    case '3':
                        builder.setCharAt(i, 'e');
                        break;
                    case '0':
                        builder.setCharAt(i, 'o');
                        break;
                    case '1':
                        builder.setCharAt(i, 'l');
                        break;
                    case '7':
                        builder.setCharAt(i, 't');
                        break;
                    default:
                        break;
            }
            } else {
                if (builder.charAt(i) == ' ') builder.setCharAt(i, '_');
                else if (builder.charAt(i) == '-'){
                    builder.setCharAt(i+1, Character.toUpperCase(builder.charAt(i+1)));
                    builder.deleteCharAt(i);
                    i -= 1;
                }
                else {
                    builder.deleteCharAt(i);
                    i -= 1;
                }
            }

        }

        return builder.toString();
    }
}
