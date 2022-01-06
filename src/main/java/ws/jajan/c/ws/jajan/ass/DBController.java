/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.jajan.c.ws.jajan.ass;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author asus
 */
@Controller
public class DBController {
    
    @RequestMapping("/tokobunga")
    @ResponseBody
    public List<Bunga> getBunga(){
        
        List<Bunga> bunga = new ArrayList<>();
        
        BungaJpaController controller = new BungaJpaController();
        
        try {
            bunga = controller.findBungaEntities();
        } catch (Exception e){}
        return bunga;      
    }
    
}
