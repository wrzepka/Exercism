class Darts {
    int score(double xOfDart, double yOfDart) {
        double shotRadiusFromCenter = Math.sqrt(Math.pow(xOfDart,2) + Math.pow(yOfDart,2));

        if (shotRadiusFromCenter >= 0 && shotRadiusFromCenter <= 1){
            return 10;
        } else if (shotRadiusFromCenter <= 5){
            return 5;
        } else if (shotRadiusFromCenter <= 10){
            return 1;
        }
        
        return 0;
    }
}
