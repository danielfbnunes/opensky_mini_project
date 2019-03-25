/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Constants;

import LabProject.Plane;
import LabProject.PlaneRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author rd
 */
public class Constants 
{
    public static String INITIAL= 
            "{\n"
            + "\"type\": \"FeatureCollection\", \n"
            + "\"crs\": { \"type\": \"name\", \"properties\": { \"name\": \"urn:ogc:def:crs:OGC:1.3:CRS84\" } },\n"
            + "\"features\": \n[\n";
    
    public static String END = "]\n}";
    
    public static String JSONPATH = "src/main/resources/static/";
    
    public static List<Plane> currPlaneList;
}
