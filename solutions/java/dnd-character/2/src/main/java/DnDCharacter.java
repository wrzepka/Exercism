import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Comparator;

class DnDCharacter {
    private final int STR = ability(rollDice());
    private final int DEX = ability(rollDice());
    private final int CON = ability(rollDice());
    private final int INT = ability(rollDice());
    private final int WIS = ability(rollDice());
    private final int CHA = ability(rollDice());

    
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
        return this.STR;
    }

    int getDexterity() {
        return this.DEX;
    }

    int getConstitution() {
        return this.CON;
    }

    int getIntelligence() {
        return this.INT;
    }

    int getWisdom() {
        return this.WIS;
    }

    int getCharisma() {
        return this.CHA;
    }

    int getHitpoints() {
        return (10 + modifier(getConstitution()));
    }
}
