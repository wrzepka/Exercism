public class Player
{
    public int RollDie()
    {
        Random dice = new Random();

        return dice.Next(1, 19);
    }

    public double GenerateSpellStrength()
    {
        Random dice = new Random();

        return dice.NextDouble() * 100.0;
    }
}
