import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Comparator;

class DnDCharacter {
    private int strength = 0;
    private int dexterity = 0;
    private int constitution = 0;
    private int inteligence = 0;
    private int wisdom = 0;
    private int charisma = 0;

    
    int ability(List<Integer> scores) {
        int score = 0;
        int lowestRoll = 6;
        
        for (int roll : scores){
            score += roll;
            if (roll < lowestRoll) lowestRoll = roll;
        }
        score -= lowestRoll;
        
        return score;
    }

    List<Integer> rollDice() {
        final int maxDiceValue = 6;
        final int minDiceValue = 1;
        List<Integer> rolls = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 4; i++){
            int roll = random.nextInt(maxDiceValue - minDiceValue + 1) + minDiceValue;
            rolls.add(roll);
        }
        
        return rolls;
    }

    int modifier(int input) {
        return Math.floorDiv((input - 10), 2);
    }

    int getStrength() {
        if (this.strength == 0) this.strength = ability(rollDice());
        
        return this.strength;
    }

    int getDexterity() {
        if (this.dexterity == 0) this.dexterity = ability(rollDice());
        
        return this.dexterity;
    }

    int getConstitution() {
        if (this.constitution == 0) this.constitution = ability(rollDice());
        
        return this.constitution;
    }

    int getIntelligence() {
        if (this.inteligence == 0) this.inteligence = ability(rollDice());
        
        return this.inteligence;
    }

    int getWisdom() {
        if (this.wisdom == 0) this.wisdom = ability(rollDice());
        
        return this.wisdom;
    }

    int getCharisma() {
        if (this.charisma == 0) this.charisma = ability(rollDice());
        
        return this.charisma;
    }

    int getHitpoints() {
        return (10 + modifier(getConstitution()));
    }
}
