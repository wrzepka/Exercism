class RemoteControlCar
{
    private int _battery;
    private int _speed;
    private int _batteryDrain;
    private int _metersDriven;
    
    public RemoteControlCar(int speed, int batteryDrain)
    {
        _battery = 100;
        _metersDriven = 0;
        _speed = speed;
        _batteryDrain = batteryDrain;
    }

    public bool BatteryDrained() => _battery - _batteryDrain < 0 ? true : false;

    public int DistanceDriven() => _metersDriven;

    public void Drive()
    {
        if (_battery - _batteryDrain >= 0)
        {
            _metersDriven += _speed;
            _battery -= _batteryDrain;
        }
    }

    public static RemoteControlCar Nitro() => new RemoteControlCar(50, 4);
}

class RaceTrack
{
    private int _distance;

    public RaceTrack(int distance)
    {
        _distance = distance;
    }

    public bool TryFinishTrack(RemoteControlCar car)
    {
        while (!car.BatteryDrained())
        {
            car.Drive();
        }

        if (car.DistanceDriven() >= _distance) return true;
        return false;
    }
}
