package CoordsParser;


import Constants.Constants;
import LabProject.ScheduledTask;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rd
 */
public class CoordsParser 
{
    private static final Logger log = LoggerFactory.getLogger(CoordsParser.class);
    
    private List<Double[]> coords =  new ArrayList<>();
    private String filename;
    private Constants constants = new Constants();
    private int lineCounter=1;
    
    public CoordsParser(List<Double[]> coords, String filename)
    {
        this.coords=coords;
        this.filename=filename;
    }
    
    public void createFile(List<Double[]> coords, String na) 
            throws FileNotFoundException, UnsupportedEncodingException
    {
        if(coords==null)
            coords=this.coords;
        
        PrintWriter writer = new PrintWriter(Constants.JSONPATH + filename, "UTF-8");
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.INITIAL);
        
        for (int i=0 ; i<coords.size() ; i++)
        {    
            log.info(Arrays.toString(coords.get(i)));
            if(i==0)
                sb.append(createLine(coords.get(i)[0], coords.get(i)[1], "Initial") + ",\n"); 
            else if (i== coords.size()-1)
                sb.append(createLine(coords.get(i)[0], coords.get(i)[1], "Actual")+ "\n");
            else
                sb.append(createLine(coords.get(i)[0], coords.get(i)[1], "Along route")+ ",\n");
        }
        sb.append(Constants.END);
        
        writer.print(sb.toString());
        writer.close();
    }
    
    
    public String createLine(double latitude, double longitude, String name)
    {
        return "{ \"type\": \"Feature\", \"properties\": { \"latitude\":" + latitude +
                ", \"longitude\":" + longitude + ", \"time\":" + lineCounter++ +
                ", \"id\": \"route1\", \"name\": \""+ name +"\" }, \"geometry\": { "
                + "\"type\": \"Point\", \"coordinates\": ["+longitude +", " +latitude+" ] } }";
    }
}
