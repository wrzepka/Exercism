static class AssemblyLine
{
    public static double SuccessRate(int speed)
    {
        if (speed == 0) return 0;

        if (speed < 5){
            return 1.00;
        }
        else if (speed < 9){
            return 0.90;
        }
        else{
            return speed == 9 ? 0.80 : 0.77;
        }
    }
    
    public static double ProductionRatePerHour(int speed) => 221 * SuccessRate(speed) * speed;

    public static int WorkingItemsPerMinute(int speed) => (int)(ProductionRatePerHour(speed) / 60.0);
}
