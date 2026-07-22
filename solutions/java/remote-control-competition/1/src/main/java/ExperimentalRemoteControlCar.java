public class ExperimentalRemoteControlCar implements RemoteControlCar{
    private int distanceDriven;

    public ExperimentalRemoteControlCar(){
        this.distanceDriven = 0;
    }
    
    public void drive() {
        this.distanceDriven += 20;
    }

    public int getDistanceTravelled() {
        return this.distanceDriven;
    }
}
