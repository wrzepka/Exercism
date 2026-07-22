class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {
    private int distanceDriven;
    private int numberOfVictories;
    
    public ProductionRemoteControlCar(){
        this.distanceDriven = 0;
        this.numberOfVictories = 0;
    }
    
    public void drive() {
        this.distanceDriven += 10;
    }

    public int getDistanceTravelled() {
        return this.distanceDriven;
    }

    public int getNumberOfVictories() {
        return this.numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar otherCar){
        if (this.getNumberOfVictories() > otherCar.getNumberOfVictories()){
            return 1;
        } else if (this.getNumberOfVictories() < otherCar.getNumberOfVictories()){
            return -1;
        }
        return 0;
    }
}
