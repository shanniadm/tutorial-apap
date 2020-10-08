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

    @GetMapping("/")
    private String home(){
        return "home";
    }

    //Routing URL yang diinginkan
    @RequestMapping("/hotel/add")
    public String addHotelFormPage(Model model){
        model.addAttribute("hotel", new HotelModel());
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
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        model.addAttribute("hotel", hotel);
        model.addAttribute("idHotel", hotel.getId());
        return "form-update-hotel";
    }

    @PostMapping("/hotel/change")
    public String changeHotelFormSubmit(
        @ModelAttribute HotelModel hotel,
        Model model
    ){
        System.out.println(hotel.getAlamat());
        HotelModel hotelUpdated = hotelService.updateHotel(hotel);
        model.addAttribute("hotel", hotel);
        return "update-hotel";
    }

    @GetMapping("/hotel/view")
    public String viewDetailHotel(
        @RequestParam(value="idHotel") Long idHotel,
        Model model
    ){
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(idHotel);
        model.addAttribute("hotel", hotel);
        model.addAttribute("listKamar", listKamar);
        return "view-hotel";
    }

    @RequestMapping("/hotel/viewall")
    public String listHotel(Model model){
        //Mendapatkan semua HotelModel 
        List<HotelModel> listHotel = hotelService.getHotelList();

        //Add variabel semua HotelModel ke "listHotel" untuk dirender pada thymeleaf.
        model.addAttribute("listHotel", listHotel);

        //Return view template yang diinginkan
        return "viewall-hotel";
    }

    // @GetMapping(value = "/hotel/view/id-hotel/{idHotel}")
    // public String detailPathHotel(
    //     @PathVariable(value = "idHotel", required = true) String idHotel,
    //     Model model
    // ){
    //         //Mendapatkan HotelModel sesuai dengan idHotel 
    //         HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);

    //         if(hotel!=null){
    //             //Add variabel HotelModel ke "hotel" untuk dirender pada thymeleaf
    //             model.addAttribute("hotel", hotel);

    //             return "view-hotel";
    //         } else {
    //             model.addAttribute("idHotel", idHotel);
    //             return "id-tidak-tersedia";
    //         }
    // }

    // @GetMapping(value = "/hotel/update/id-hotel/{idHotel}/no-telepon/{noTelepon}")
    // public String updateNoTelepon(
    //     @PathVariable(value = "idHotel", required = true) String idHotel,
    //     @PathVariable(value = "noTelepon", required = true) String noTelepon,
    //     Model model
    // ){
    //     //untuk update nomor Telepon
    //     HotelModel hotel = hotelService.updateNoTelepon(idHotel, noTelepon);

    //     //Add variabel ke HotelModel untuk dirender pada thymeleaf
    //     model.addAttribute("idHotel", idHotel);

    //     if(hotel!=null){
    //         return "update-notelp";
    //     } else {
    //         return "id-tidak-tersedia";
    //     }
    // }

    // @GetMapping(value = "/hotel/delete/id-hotel/{idHotel}")
    // public String deleteHotel(
    //     @PathVariable(value = "idHotel", required = true) String idHotel,
    //     Model model
    // ){
    //     HotelModel hotel = hotelService.deleteHotel(idHotel);

    //     model.addAttribute("idHotel", idHotel);

    //     if(hotel!=null){
    //         return "delete-hotel";
    //     } else {
    //         return "id-tidak-tersedia";
    //     }
    // }
}
