abstract class Character
{
    protected string characterType;
    
    protected Character(string characterType)
    {
        this.characterType = characterType;
    }

    public abstract int DamagePoints(Character target);

    public virtual bool Vulnerable() => false;

    public override string ToString() => $"Character is a {characterType}";
}

class Warrior : Character
{
    public Warrior() : base("Warrior")
    {
    }

    public override int DamagePoints(Character target)
    {
        if (target.Vulnerable()) return 10;
        return 6;
    }
}

class Wizard : Character
{
    private bool _spellPrepared;
    
    public Wizard() : base("Wizard")
    {
        _spellPrepared = false;
    }

    public override int DamagePoints(Character target)
    {
        if(_spellPrepared){
            _spellPrepared = false;
            return 12;
        }
        return 3;
    }

    public void PrepareSpell()
    {
        _spellPrepared = true;
    }

    public override bool Vulnerable() => _spellPrepared ? false : true;
}
