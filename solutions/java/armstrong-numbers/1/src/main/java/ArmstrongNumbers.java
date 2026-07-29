class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        int sumOfDigits = 0;
        int power = Integer.toString(numberToCheck).length();
        int numberCopy = numberToCheck;

        while (numberCopy != 0){
            sumOfDigits += Math.pow(numberCopy % 10, power);
            numberCopy /= 10;
        }
        
        return (numberToCheck == sumOfDigits);
    }

}
