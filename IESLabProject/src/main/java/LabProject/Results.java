/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package LabProject;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results
{
    private static final Logger log = LoggerFactory.getLogger(Results.class);

    /**
     * Default constructor
     */
    public Results() {}
    
    /**
     * Will save all the data from the REST API
     */
    @JsonIgnore
    private Map<String, Object> properties = new HashMap<String, Object>();
    
    
    @JsonAnyGetter
    public Object getProperties() {
        return this.properties;
    }
    
    
    @JsonAnySetter
    public void setProperty(String name, Object value) {
        this.properties.put(name, value);
    }
    
    
    /**
     * Casts the results from the REST service to an arraylist containing
     * String arraylists with infos about each plane
     * @return ArrayList<ArrayList<String>> containing infos about each plane
     */
    public ArrayList<ArrayList<Object>> getPlanesRaw()
    {
        return ((ArrayList<ArrayList<Object>>) properties.get("states"));
    }
    
    
    /**
     * Treats the raw data, sent by the initial API and treats it, returning
     * a list of planes
     * @return List of PLane Objects
     */
    public List<Plane> getPlanesList()
    {
        String ID=null, name=null, originCountry=null;
        double latitude=0, longitude=0, altitude=0, velocity=0, verticalRate=0;        
        
        List<Plane> planes = new ArrayList<Plane>();
        ArrayList<ArrayList<Object>> rawData = getPlanesRaw();
        
        for(ArrayList<Object> planeData : rawData)
        {
            //Mandatory properties
            ID =  planeData.get(0).toString();
            originCountry = planeData.get(2).toString();
            //Optional
            if( planeData.get(1) != null)
                name =  planeData.get(1).toString();
            if( planeData.get(5) != null)
                longitude = Double.parseDouble(planeData.get(5).toString());
            if( planeData.get(6) != null)
                latitude = Double.parseDouble(planeData.get(6).toString());
            if( planeData.get(7) != null)
                altitude = Double.parseDouble(planeData.get(7).toString());
            if( planeData.get(9) != null)
                velocity = Double.parseDouble(planeData.get(9).toString());
            if( planeData.get(11) != null)
                verticalRate = Double.parseDouble(planeData.get(11).toString());

            //Plane
            Plane p =  new Plane(ID, name, originCountry, latitude, longitude,
                    altitude, velocity, verticalRate);
            
            planes.add(p);
        }
        return planes;
    }
    
    
    @Override
    public String toString() {
        return "Results{" + "time=" + properties.get("time") + ", properties=" 
                + properties.get("states") + '}';
    }
    
    
    
    
    
    
    
    
    
    
}

