class NeedForSpeed {
    private int speed;
    private int batteryDrain;
    private int battery;
    private int distanceDriven;
    
    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
        this.battery = 100;
        this.distanceDriven = 0;
    }

    public boolean batteryDrained() {
        return (this.battery < this.batteryDrain);
    }

    public int distanceDriven() {
        return this.distanceDriven;
    }

    public void drive() {
        if (this.battery < this.batteryDrain) return;
        this.distanceDriven += this.speed;
        this.battery -= this.batteryDrain;
    }

    public int getSpeed(){
        return this.speed;
    }

    public int getBattery(){
        return this.battery;
    }

    public int getBatteryDrain(){
        return this.batteryDrain;
    }
    
    public static NeedForSpeed nitro() {
        return (new NeedForSpeed(50, 4));
    }
}

class RaceTrack {
    private int distance;
    
    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        return (this.distance <= (car.getBattery()/car.getBatteryDrain())*car.getSpeed());
    }
}
