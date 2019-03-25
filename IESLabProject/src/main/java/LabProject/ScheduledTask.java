package LabProject;

import Constants.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ScheduledTask {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);

    PlaneController pc = new PlaneController();
    
    @Autowired
    private PlaneRepository repository = pc.getRepo();
   
    @Scheduled(fixedRate = 5 * 1000)
    public void reportCurrentTime() {
        RestTemplate restTemplate = new RestTemplate();
        Results results = restTemplate.getForObject("https://opensky-network.org/api/states/all?lamin=35.8389&lomin=-9.7962&lamax=54.8229&lomax=25.5226", Results.class);
        Constants.currPlaneList = results.getPlanesList();
        
        for(Plane p : Constants.currPlaneList)
        {
            PlaneEntity pe = new PlaneEntity(p);
            repository.save(pe);
        }
    }
}