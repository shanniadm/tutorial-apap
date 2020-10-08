package apap.tutorial.traveloke.service;
import apap.tutorial.traveloke.model.HotelModel;
import java.util.List;

public interface HotelService {
    //Method untuk menambah Hotel
    void addHotel(HotelModel hotel);

    //Method untuk mendapatkan daftar Hotel yang telah tersimpan
    List<HotelModel> getHotelList();

    //Method untuk mendapatkan data sebuah hotel berdasarkan idHotel 
    HotelModel getHotelByIdHotel(String idHotel);

    HotelModel updateNoTelepon(String idHotel, String noTelepon);

    HotelModel deleteHotel(String idHotel);
}
