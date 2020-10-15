package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.KamarService;
import apap.tutorial.traveloke.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class KamarController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

    @GetMapping("/kamar/add/{idHotel}")
    private String addKamarFormPage(
        @PathVariable Long idHotel,
        Model model
    ){
        try{
            KamarModel kamar = new KamarModel();
            HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
            kamar.setHotel(hotel);
            model.addAttribute("kamar",kamar);
            model.addAttribute("idHotel", idHotel);
            return "form-add-kamar";
        } catch (Exception e){
            model.addAttribute("idProcess", idHotel);
            return "cant-process";
        }
    }

    @PostMapping("/kamar/add")
    private String addKamarSubmit(
        @ModelAttribute KamarModel kamar, 
        Model model
    ){
        kamarService.addKamar(kamar);
        model.addAttribute("kamar", kamar);
        return "add-kamar";
    }

    @GetMapping("/kamar/change/{noKamar}")
    public String changeKamarFormPage(
        @PathVariable Long noKamar, 
        Model model
    ){
        try{
            KamarModel kamar = kamarService.getKamarByNoKamar(noKamar);
            model.addAttribute("kamar", kamar);
            model.addAttribute("noKamar", noKamar);
            return "form-update-kamar";   
        } catch(Exception e){
            model.addAttribute("idProcess", noKamar);
            return "cant-process";
        }
        
    }

    @PostMapping("/kamar/change")
    public String changeHotelFormSubmit(
        @ModelAttribute KamarModel kamar,
        Model model
    ){
        KamarModel kamarUpdated = kamarService.updateKamar(kamar);
        model.addAttribute("idHotel", kamarUpdated.getHotel().getId());
        model.addAttribute("kamar", kamarUpdated);
        return "update-kamar";
    }

    @GetMapping("/kamar/delete/{noKamar}")
    public String deleteHotel(
        @PathVariable Long noKamar, 
        Model model
    ){
        try{
            Long idHotel = kamarService.deleteKamar(noKamar);
            model.addAttribute("noKamar", noKamar);
            model.addAttribute("idHotel", idHotel);
            return "delete-kamar";
        } catch (Exception e){
            model.addAttribute("idProcess", noKamar);
            return "cant-process";
        }
        
    }
}
