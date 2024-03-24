package org.example;
public enum Planet {
    MERCURY (1,57000, 2439,88),
    VENUS   (2,110000, 6051,225),
    EARTH   (3,148000, 6371,365),
    MARS    (4,230000, 3389, 687),
    JUPITER (5,780000,   69911, 4333),
    SATURN  (6,1438000, 58232, 10759),
    URANUS  (7,2970000, 25362, 30687),
    NEPTUNE (8,4495000, 24622, 60200),
    PLUTO (9,5906000, 101, 99000);

    private final int rank;
    private final double distance;
    private final int radius;
    private final int rotation;

    Planet(int rank, double distance, int radius, int rotation) {
        this.rank = rank;
        this.distance = distance;
        this.radius = radius;
        this.rotation = rotation;
    }

    public int getRank() {
        return rank;
    }

    public double getDistance() {
        return distance;
    }

    public int getRadius() {
        return radius;
    }

    public int getRotation() {
        return rotation;
    }

    public static void main(String[] args) {
        Planet myPlanet =Planet.EARTH;
        canILiveHere(myPlanet);
        myPlanet =Planet.VENUS;
        canILiveHere(myPlanet);
        myPlanet =Planet.MARS;
        canILiveHere(myPlanet);
        myPlanet =Planet.PLUTO;
        canILiveHere(myPlanet);
        myPlanet =Planet.SATURN;
        canILiveHere(myPlanet);
    }
    static void canILiveHere(Planet myPlanet){
        switch (myPlanet){
            case EARTH -> System.out.println(myPlanet.name() + " is planet # " +myPlanet.getRank() + ". This is our home. You can live here!!!");
            case VENUS -> System.out.println(myPlanet.name() + " is planet # " +myPlanet.getRank() + ". You can't live here, yet!!! But I am sure! Women are from Venus...");
            case MARS -> System.out.println(myPlanet.name() + " is planet # " +myPlanet.getRank() + ". You can't live here, yet!!! But you know! Men are from Mars...");
            case PLUTO -> System.out.println("Is " + myPlanet.name() + " planet # " +myPlanet.getRank() + "? Anyway! You can't live here, yet !!! ");
            default -> System.out.println(myPlanet.name() + " is planet # " +myPlanet.getRank() + ". You can't live here, yet!!! ");
        }
    }
}