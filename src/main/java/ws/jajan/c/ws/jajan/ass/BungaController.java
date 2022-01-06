/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.jajan.c.ws.jajan.ass;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author asus
 */
public class BungaController {
   @CrossOrigin
     @RequestMapping(value = "/tokobunga/xml", produces = {MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Bunga> getTokoBungaXML () { 
        List<Bunga> tokobunga = new ArrayList<>();
        
        BungaJpaController controller = new BungaJpaController();
        
        try {
            tokobunga = controller.findBungaEntities();
        } catch (Exception e) {}
        return tokobunga;
  
    } 
    
    @CrossOrigin
    @RequestMapping(value = "/tokobunga/json", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    
    public List<Bunga> getTokoBungaJSON() {
    
        
        List <Bunga> tokobunga = new ArrayList<>();
        
        BungaJpaController controller = new BungaJpaController();
        
        try {
            tokobunga = controller.findBungaEntities();
        } catch (Exception e) {}
        
        return tokobunga;
    }
}
