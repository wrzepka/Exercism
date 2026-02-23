class Lasagna
{
    // TODO: define the 'ExpectedMinutesInOven()' method
    public int ExpectedMinutesInOven() => 40;
    // TODO: define the 'RemainingMinutesInOven()' method
    public int RemainingMinutesInOven(int timeInOven) => this.ExpectedMinutesInOven() - timeInOven;
    // TODO: define the 'PreparationTimeInMinutes()' method
    public int PreparationTimeInMinutes(int layersAmount) => (2 * layersAmount);
    // TODO: define the 'ElapsedTimeInMinutes()' method
    public int ElapsedTimeInMinutes(int layersAmount, int minutesInOven) => this.PreparationTimeInMinutes(layersAmount) + minutesInOven;
}
