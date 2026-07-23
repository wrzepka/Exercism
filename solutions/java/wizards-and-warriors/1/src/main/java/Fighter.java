class Fighter {

    boolean isVulnerable() {
        return true;
    }

    int getDamagePoints(Fighter fighter) {
        return 1;
    }
}

class Warrior extends Fighter{
    @Override
    boolean isVulnerable(){
        return false;
    }
    
    @Override
    int getDamagePoints(Fighter fighter) {
        if (fighter.isVulnerable()){
            return 10;
        }
        return 6;
    }

    @Override
    public String toString(){
        return "Fighter is a Warrior";
    }
}
// TODO: define the Wizard class
class Wizard extends Fighter{
    boolean spellPrepared;

    public Wizard(){
        this.spellPrepared = false;
    }
    
    @Override
    boolean isVulnerable(){
        if (this.spellPrepared){
            return false;
        }
        return true;
    }
    
    @Override
    int getDamagePoints(Fighter fighter) {
        if (this.spellPrepared){
            return 12;
        }
        return 3;
    }

    void prepareSpell(){
        this.spellPrepared = true;
    }
    
    @Override
    public String toString(){
        return "Fighter is a Wizard";
    }
}