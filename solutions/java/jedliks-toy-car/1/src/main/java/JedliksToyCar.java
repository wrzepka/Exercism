public class JedliksToyCar {
    private int distanceDriven = 0;
    private int battery = 100;
    
    public static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    public String distanceDisplay() {
        return ("Driven " + Integer.toString(this.distanceDriven) + " meters");
    }

    public String batteryDisplay() {
        if (this.battery == 0){
            return "Battery empty";
        }
        return ("Battery at " + Integer.toString(this.battery) + "%");
    }

    public void drive() {
        if (this.battery == 0){
            return;
        }

        this.distanceDriven += 20;
        this.battery -= 1;
    }
}
