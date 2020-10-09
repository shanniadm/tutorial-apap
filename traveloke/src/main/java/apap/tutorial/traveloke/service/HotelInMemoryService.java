package apap.tutorial.traveloke.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;

import apap.tutorial.traveloke.model.HotelModel;

@Service
public class HotelInMemoryService {
    
    private List<HotelModel> listHotel;

    //Constructor 
    public HotelInMemoryService(){
        listHotel = new ArrayList<>();
    }

    //@Override
    public void addHotel(HotelModel hotel){
        // listHotel.add(hotel);
    }

    //@Override
    public List<HotelModel> getHotelList(){
        // return listHotel;
        return null;
    }

    //@Override
    public HotelModel getHotelByIdHotel(Long idHotel){
        // for(HotelModel hotel : listHotel){
        //     if(hotel.getId().equals(idHotel)){
        //         return hotel;
        //     }
        // }
        // return null;
        return null;
    }

    //@Override
    public HotelModel updateHotel(HotelModel hotel){
        // for(HotelModel hotel : listHotel){
        //     if(hotel.getId().equals(id)){
        //         hotel.setNomorTelepon(nomorTelepon);
        //         return hotel;
        //     }
        // }
        // return null;
        return null;
    }

    //@Override
    public List<HotelModel> getHotelListSorted(){
        return null;
    }
}
