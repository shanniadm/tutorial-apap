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
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class KamarController {
    HotelTemp hotelTemp = new HotelTemp();

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
            if(hotelTemp.getKamar().size()==1){
                hotelTemp.getKamar().get(0).setHotel(hotelService.getHotelByIdHotel(idHotel));
            };
            model.addAttribute("hotel", hotelTemp);
            model.addAttribute("halaman", "Add Kamar");
            return "form-add-kamar";
        } catch (Exception e){
            model.addAttribute("idProcess", idHotel);
            return "cant-process";
        }
    }

    @PostMapping("/kamar/add")
    private String addKamarSubmit(
        @ModelAttribute HotelTemp hotel, 
        Model model
    ){
        for(KamarModel km : hotel.getKamar()){
            kamarService.addKamar(km);
        }
        return "add-kamar";
    }

    @GetMapping("/kamar/change/{noKamar}")
    public String changeKamarFormPage(
        @PathVariable Long noKamar, 
        Model model
    ){
        try{
            KamarModel kamar = kamarService.getKamarByNoKamar(noKamar);
            model.addAttribute("halaman", "Update Kamar");
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

    @PostMapping(path = "/kamar/delete")
    public String deleteKamarFormSubmit(
        @ModelAttribute HotelModel hotel,
        Model model
    ){
        model.addAttribute("kamarCount", hotel.getListKamar().size());
        
        for(KamarModel kamar : hotel.getListKamar()){
            kamarService.deleteKamar(kamar);
        }
        return "delete-kamar";
    }

    // @GetMapping("/kamar/delete/{noKamar}")
    // public String deleteHotel(
    //     @PathVariable Long noKamar, 
    //     Model model
    // ){
    //     try{
    //         Long idHotel = kamarService.deleteKamar(noKamar);
    //         model.addAttribute("noKamar", noKamar);
    //         model.addAttribute("idHotel", idHotel);
    //         return "delete-kamar";
    //     } catch (Exception e){
    //         model.addAttribute("idProcess", noKamar);
    //         return "cant-process";
    //     }
        
    // }
}

class HotelTemp{
    KamarModel km = new KamarModel();
    private List<KamarModel> kamar = Arrays.asList(km);

    public void addList(KamarModel kamar){
        this.kamar.add(kamar);
    }

    public List<KamarModel> getKamar(){
        return this.kamar;
    }

    public void setList(List<KamarModel> kamar){
        this.kamar = kamar;
    }

}




