import java.lang.StringBuilder;

class ReverseString {

    String reverse(String inputString) {
        StringBuilder output = new StringBuilder(inputString).reverse();
        return output.toString();
    }
  
}
