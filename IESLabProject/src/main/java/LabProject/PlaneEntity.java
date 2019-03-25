
package LabProject;

import LabProject.Plane;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "rddn_planes")
public class PlaneEntity {

    static long counter=0;
    
    @Id
    @Column(name="id")
    private Long id;
    
    @Column(name="icao24")
    private String icao24;
     
    @Column(name="name")
    private String name;
    
    @Column(name="originCountry")
    private String originCountry;
    
    @Column(name="latitude")
    private Double latitude;
    
    @Column(name="longitude")
    private Double longitude;
    
    @Column(name="velocity")
    private Double velocity;
    
    @Column(name="verticalRate")
    private Double verticalRate;

    /**
     * Needed for the JPA. 
     * JPA needs this to create and entity
     */
    public PlaneEntity(){}
    
    public PlaneEntity(Plane p) {
        super();
        this.id=++counter;
        this.icao24=p.getID();
        this.name=p.getName();
        this.originCountry=p.getOriginCountry();
        this.latitude=p.getLatitude();
        this.longitude=p.getLongitude();
        this.velocity=p.getVelocity();
        this.verticalRate=p.getVelocity();
    }
    
    public String getIcao24() {
        return icao24;
    }

    public void setIcao24(String icao24) {
        this.icao24 = icao24;
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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getVelocity() {
        return velocity;
    }

    public void setVelocity(Double velocity) {
        this.velocity = velocity;
    }

    public Double getVerticalRate() {
        return verticalRate;
    }

    public void setVerticalRate(Double verticalRate) {
        this.verticalRate = verticalRate;
    }

    @Override
    public String toString() {
        return "PlaneEntity{" + "x=" + id + ", ID=" + icao24 + ", name=" + name + ", originCountry=" + originCountry + ", latitude=" + latitude + ", longitude=" + longitude + ", velocity=" + velocity + ", verticalRate=" + verticalRate + '}';
    }
    
    
    
}
