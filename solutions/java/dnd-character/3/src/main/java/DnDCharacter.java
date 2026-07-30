import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Comparator;

class DnDCharacter {
    private final int strength = ability(rollDice());
    private final int dexterity = ability(rollDice());
    private final int constitution = ability(rollDice());
    private final int intelligence = ability(rollDice());
    private final int wisdom = ability(rollDice());
    private final int charisma = ability(rollDice());
    private static final Random RANDOM = new Random();
    
    int ability(List<Integer> scores) {
        int score = 0;
        int lowestRoll = scores.get(0);
        
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

        for (int i = 0; i < 4; i++){
            int roll = this.RANDOM.nextInt(maxDiceValue - minDiceValue + 1) + minDiceValue;
            rolls.add(roll);
        }
        
        return rolls;
    }

    int modifier(int input) {
        return Math.floorDiv((input - 10), 2);
    }

    int getStrength() {
        return this.strength;
    }

    int getDexterity() {
        return this.dexterity;
    }

    int getConstitution() {
        return this.constitution;
    }

    int getIntelligence() {
        return this.intelligence;
    }

    int getWisdom() {
        return this.wisdom;
    }

    int getCharisma() {
        return this.charisma;
    }

    int getHitpoints() {
        return (10 + modifier(getConstitution()));
    }
}
