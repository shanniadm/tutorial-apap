package apap.tutorial.traveloke.controller;

import java.util.List;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.KamarService;
import apap.tutorial.traveloke.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HotelController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

    //Routing URL yang diinginkan
    @RequestMapping("/hotel/add")
    public String addHotelFormPage(Model model){
        model.addAttribute("hotel", new HotelModel());
        model.addAttribute("halaman", "Add Hotel");
        return "form-add-hotel";
    }

    @PostMapping("/hotel/add")
    public String addHotelSubmit(
        @ModelAttribute HotelModel hotel,
        Model model
    ){
        hotelService.addHotel(hotel);
        model.addAttribute("idHotel", hotel.getId());
        return "add-hotel";
    }

    @GetMapping("/hotel/change/{idHotel}")
    public String changeHotelFormPage(
        @PathVariable Long idHotel, 
        Model model
    ){
        try {
            HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
            model.addAttribute("hotel", hotel);
            model.addAttribute("idHotel", hotel.getId());
            model.addAttribute("halaman", "Update Hotel");
            return "form-update-hotel";
        } catch (Exception e){
            model.addAttribute("idProcess", idHotel);
            return "cant-process";
        }
        
    }

    @PostMapping("/hotel/change")
    public String changeHotelFormSubmit(
        @ModelAttribute HotelModel hotel,
        Model model
    ){
        HotelModel hotelUpdated = hotelService.updateHotel(hotel);
        model.addAttribute("hotel", hotel);
        return "update-hotel";
    }

    @GetMapping("/hotel/view")
    public String viewDetailHotel(
        @RequestParam(value="idHotel") Long idHotel,
        Model model
    ){
        try {
            HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
            List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(idHotel);
            model.addAttribute("halaman", "View Hotel");
            model.addAttribute("hotel", hotel);
            model.addAttribute("listKamar", listKamar);
            return "view-hotel";
        } catch (Exception e) {
            model.addAttribute("idProcess", idHotel);
            return "cant-process";
        }
    }

    @RequestMapping("/hotel/viewall")
    public String listHotel(Model model){
        //Mendapatkan semua HotelModel 
        List<HotelModel> listHotel = hotelService.getHotelListSorted();
        model.addAttribute("halaman", "View All Hotel");
        //Add variabel semua HotelModel ke "listHotel" untuk dirender pada thymeleaf.
        model.addAttribute("listHotel", listHotel);

        //Return view template yang diinginkan
        return "viewall-hotel";
    }

    @GetMapping("/hotel/delete/{idHotel}")
    public String deleteHotel(
        @PathVariable Long idHotel, 
        Model model
    ){
        try{
            List<KamarModel> kamar = kamarService.findAllKamarByIdHotel(idHotel);
            model.addAttribute("idHotel", idHotel);
            if(kamar.size()==0){
                hotelService.deleteHotel(idHotel);
                return "delete-hotel";
            } else {
                return "cant-delete";
        }
        } catch(Exception e){
            model.addAttribute("idProcess", idHotel);
            return "cant-process";
        }
    }
}
