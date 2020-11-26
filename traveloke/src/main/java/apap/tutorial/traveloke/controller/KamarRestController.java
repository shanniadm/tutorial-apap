package apap.tutorial.traveloke.controller;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.KamarRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class KamarRestController{
    @Autowired
    private KamarRestService KamarRestService;

    @PostMapping(value="/kamar")
    private ResponseEntity<String> addKamar(@Valid @RequestBody KamarModel kamar, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field."
            );
        } else {
            KamarRestService.addKamar(kamar);
            return ResponseEntity.ok("Add kamar success");
        }
    }

    @PutMapping(value="/kamar/{kamarId}")
    private ResponseEntity<String> updateKamar(@RequestBody KamarModel kamar){
        try{
            Long idKamar = kamar.getNoKamar();
            KamarRestService.updateKamar(idKamar, kamar);
            return ResponseEntity.ok("Update kamar success");
        } catch(NoSuchElementException e){
            Long idKamar = kamar.getNoKamar();
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Kamar with ID "+ String.valueOf(idKamar)+" not found!"
            );
        }
    }

    @GetMapping(value="/kamar/{kamarId}")
    private KamarModel getKamar(@PathVariable("kamarId") Long idKamar){
        try{
            return KamarRestService.getKamarByIdKamar(idKamar);
        } catch(NoSuchElementException e){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "ID Kamar "+String.valueOf(idKamar)+" not found!"
            );
        }
    }

    @GetMapping(value="/kamar-all")
    private List<KamarModel> getAllKamar(){
        return KamarRestService.getAllKamar();
    }

    @DeleteMapping(value = "/kamar/{kamarId}")
    private ResponseEntity<String> deleteKamar(@PathVariable("kamarId") Long idKamar){
        try{
            KamarRestService.deleteKamar(idKamar);
            return ResponseEntity.ok("Kamar has been deleted");
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Kamar with ID "+ String.valueOf(idKamar) + " not found!");
        } 
    }
}
