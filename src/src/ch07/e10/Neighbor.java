package ch07.e10;

public class Neighbor {
    private String cityName;
    private int distance;

    public Neighbor(String cityName, int distance) {
        if (cityName == null || cityName.isEmpty())
            throw new IllegalArgumentException("The cityName can't be null or empty.");
        if (distance < 0)
            throw new IllegalArgumentException("The distance must be positive.");

        this.cityName = cityName;
        this.distance = distance;
    }

    public String getCityName() {
        return cityName;
    }

    public int getDistance() {
        return distance;
    }
}
