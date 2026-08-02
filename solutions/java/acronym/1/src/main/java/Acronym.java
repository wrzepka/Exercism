import java.lang.StringBuilder;

class Acronym {
    private String phrase;
    
    Acronym(String phrase) {
        this.phrase = new String(phrase);
    }

    String get() {
        boolean isStartOfAWord = true;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < phrase.length(); i++){
            if (Character.isWhitespace(phrase.charAt(i)) || phrase.charAt(i) == '-' || phrase.charAt(i) == '_'){
                isStartOfAWord = true;
                continue;
            }

            if (isStartOfAWord){
                builder.append(Character.toUpperCase(phrase.charAt(i)));
                isStartOfAWord = false;
            }
        }

        return builder.toString();
    }

}
