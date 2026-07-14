public class CarsAssemble {
    private final int LOWEST_AMOUNT_OF_CARS_PRODUCED_HOURLY = 221;
    private final int MINUTES_IN_HOUR_KEKW = 60;
    public double productionRatePerHour(int speed) {
        if (speed == 0){
            return 0;
        }
        
        if (speed >= 1 && speed < 5){
            return speed * LOWEST_AMOUNT_OF_CARS_PRODUCED_HOURLY;
        }else if (speed < 9){
            return speed * LOWEST_AMOUNT_OF_CARS_PRODUCED_HOURLY * 0.90;
        }else if (speed == 9){
            return speed * LOWEST_AMOUNT_OF_CARS_PRODUCED_HOURLY * 0.80;
        }
        return speed * LOWEST_AMOUNT_OF_CARS_PRODUCED_HOURLY * 0.77;
    }

    public int workingItemsPerMinute(int speed) {
        return (int)productionRatePerHour(speed) / MINUTES_IN_HOUR_KEKW;
    }
}
