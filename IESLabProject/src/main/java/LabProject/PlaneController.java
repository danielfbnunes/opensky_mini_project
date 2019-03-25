
package LabProject;

import Constants.Constants;
import CoordsParser.CoordsParser;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author rd
 */
@Controller
public class PlaneController {
    
    //Logger
    private static final Logger log = LoggerFactory.getLogger(PlaneController.class);
    
    //Creation of the Plane Repository
    @Autowired
            PlaneRepository planeRepository;
    
    //Allows the scheduler to use the same repository
    public PlaneRepository getRepo() { return planeRepository;}
    
    
    @GetMapping("/planes")
    public String greeting(
            @RequestParam(value = "country", required=false, defaultValue="none") String country,
            @RequestParam(value = "tracking", required=false, defaultValue="none") String tracking,
            Model model)
            throws FileNotFoundException, UnsupportedEncodingException
    {
                
        List<Plane> planes = new ArrayList<>();
        
        //Evaluates which planes are to show (allows filtering by origin country)
        for (Plane p : Constants.currPlaneList) 
            if(p.getOriginCountry().equals(country) || country.equals("none")) 
                planes.add(p);

        //Allows tracking a plane
        if (!tracking.equals("none"))
        {
            //finds all entries given the ID of the plane
            List<PlaneEntity> planeEntries = this.planeRepository.findByIcao24(tracking);
            List<Double[]> coords = new ArrayList<>();
            
            for (PlaneEntity p : planeEntries) 
                coords.add(new Double[] {p.getLatitude(), p.getLongitude()});
            
            //parse coordinates and produce a geojson
            CoordsParser cp = new CoordsParser(coords, "points.geojson");
            cp.createFile(coords, country);
            
            model.addAttribute("coords", coords.get(0) );
            return "tracking";
        }
        
        model.addAttribute("planes", planes);
        return "index";
        
    }
    
}