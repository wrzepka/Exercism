public static class DifferenceOfSquares
{
    public static int CalculateSquareOfSum(int max)
    {
        int sum = 0;
        for (int i = 1; i <= max; i++){
            sum += i;
        }

        return sum * sum;
    }

    public static int CalculateSumOfSquares(int max)
    {
        int sumOfSquares = 0;
        
        for (int i = 1; i <= max; i++){
            sumOfSquares += i * i;
        }

        return sumOfSquares;
    }

    public static int CalculateDifferenceOfSquares(int max) => CalculateSquareOfSum(max) - CalculateSumOfSquares(max);
}