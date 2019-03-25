/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LabProject;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author dn
 */
@Component
public class UserResource {
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    private static final String TOPIC = "rddnPortugalPlanes";

    private final List<String> planes_portugal = new ArrayList<String>();
    
    @Scheduled(fixedRate = 5 * 1000)
    public void post(){
        RestTemplate restTemplate = new RestTemplate();
        Results results = restTemplate.getForObject("https://opensky-network.org/api/states/all?lamin=36.819839&lomin=-9.660839&lamax=41.86754&lomax=-6.265792", Results.class);
        
        
        for(Plane p : results.getPlanesList())
        {
            PlaneEntity pe = new PlaneEntity(p);
            if (!planes_portugal.contains(pe.getIcao24())){
               kafkaTemplate.send(TOPIC, pe.getName() + "_" + pe.getIcao24());
               System.out.println("AVIAO NOVO: " + pe.getName() + "_" + pe.getIcao24());
               planes_portugal.add(pe.getIcao24());
            }
            
        }
        

    }
    
}