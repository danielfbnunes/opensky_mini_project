
package LabProject;

public class Plane
{
    private String ID, name, originCountry;
    private double latitude, longitude, altitude, velocity, verticalRate;

    public Plane(String ID, String name, String originCountry, double latitude, 
            double longitude, double altitude, double velocity, double verticalRate) 
    {
        this.ID = ID;
        this.name = name;
        this.originCountry = originCountry;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.velocity = velocity;
        this.verticalRate = verticalRate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getVerticalRate() {
        return verticalRate;
    }

    public void setVerticalRate(double verticalRate) {
        this.verticalRate = verticalRate;
    }

    @Override
    public String toString() {
        return "\nPlane {" + "\nID=" + ID + "\nname=" + name + "\noriginCountry=" 
                + originCountry + "\nlatitude=" + latitude + "\nlongitude=" + longitude 
                + "\naltitude=" + altitude + "\nvelocity=" + velocity 
                + "\nverticalRate=" + verticalRate + '}';
    }
    
    
}