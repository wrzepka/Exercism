import java.math.BigInteger;
import java.math.BigDecimal;
import java.lang.IllegalArgumentException;

class Grains {

    BigInteger grainsOnSquare(final int square) {
        if (square <= 0 || square > 64){
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        
        return BigInteger.TWO.pow(square - 1);
    }

    BigInteger grainsOnBoard() {
        BigInteger result = BigInteger.ZERO;
        for (int i = 1; i <= 64; i++){
            result = result.add(grainsOnSquare(i));
        }

        return result;
    }

}
