public class Lasagna {
    private static int TOTAL_TIME_IN_OVEN = 40;
    private static int LAYER_PREPARATION_TIME = 2;
    
    public int expectedMinutesInOven(){
        return TOTAL_TIME_IN_OVEN;
    }
    public int remainingMinutesInOven(int actualTimeInOven){
        return expectedMinutesInOven() - actualTimeInOven;
    }
    public int preparationTimeInMinutes(int layers){
        return LAYER_PREPARATION_TIME * layers;
    }
    public int totalTimeInMinutes(int layers, int actualTimeInOven){
        return preparationTimeInMinutes(layers) + actualTimeInOven;
    }
}
