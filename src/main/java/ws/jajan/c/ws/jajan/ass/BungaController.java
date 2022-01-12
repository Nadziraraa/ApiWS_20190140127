package ws.jajan.c.ws.jajan.ass;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author asus
 */
@CrossOrigin
@RestController
@RequestMapping("/databarang")
public class BungaController {
@Autowired
private flowerInterface tokobunga;
@GetMapping("/tokobunga")
public List<Bunga> getAllTokoBunga(){
return tokobunga.findAll();
}
@GetMapping ("/tokobunga/{id}")
public Bunga getTokoBungaById(@PathVariable String idproduct){
return tokobunga.findById(idproduct).get();
}
@PostMapping ("/tokobunga")
public Bunga saveTokoBungaDetails(@RequestBody Bunga c){
return tokobunga.save(c);
}
@PutMapping("/tokobunga")
public Bunga updateTokoBunga(@RequestBody Bunga c){
return tokobunga.save(c);
}
@DeleteMapping("/tokobunga/{id}")
public ResponseEntity<HttpStatus> deleteTokoBungaById(@PathVariable String idproduct){
tokobunga.deleteById(idproduct);
return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
}
