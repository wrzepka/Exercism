class RemoteControlCar
{
    private int _battery = 100;
    private int _metersDriven = 0;
    
    public static RemoteControlCar Buy()
    {
        var newCar = new RemoteControlCar();

        return newCar;
    }

    public string DistanceDisplay() => $"Driven {this._metersDriven} meters";

    public string BatteryDisplay() => (this._battery <= 0) ? "Battery empty" : $"Battery at {this._battery}%";

    public void Drive()
    {
        if (this._battery > 0){
            this._battery -= 1;
            this._metersDriven += 20;
        }
    }
}
