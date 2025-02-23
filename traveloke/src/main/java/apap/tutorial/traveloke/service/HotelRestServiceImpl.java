package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.repository.HotelDb;
import apap.tutorial.traveloke.rest.Setting;
import reactor.core.publisher.Mono;
import apap.tutorial.traveloke.rest.HotelDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import javax.transaction.Transactional;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class HotelRestServiceImpl implements HotelRestService {

    private final WebClient webClient;

    @Autowired
    private HotelDb hotelDb;

    @Override
    public HotelModel createHotel(HotelModel hotel) {
        return hotelDb.save(hotel);
    }

    @Override
    public List<HotelModel> retrieveListHotel() {
        return hotelDb.findAll();
    }

    @Override
    public HotelModel getHotelByIdHotel(Long idHotel) {
        Optional<HotelModel> hotel = hotelDb.findById(idHotel);
        if (hotel.isPresent()) {
            return hotel.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public HotelModel changeHotel(Long idHotel, HotelModel hotelUpdate) {
        HotelModel hotel = getHotelByIdHotel(idHotel);
        hotel.setNamaHotel(hotelUpdate.getNamaHotel());
        hotel.setAlamat(hotelUpdate.getAlamat());
        hotel.setNomorTelepon(hotelUpdate.getNomorTelepon());
        return hotelDb.save(hotel);
    }

    @Override
    public void deleteHotel(Long idHotel) {
        HotelModel hotel = getHotelByIdHotel(idHotel);
        if (hotel.getListKamar().size() == 0) {
            hotelDb.delete(hotel);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public HotelRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.hotelUrl).build();
    }

    @Override
    public Mono<String> getStatus(Long idHotel) {
        return this.webClient.get().uri("/rest/hotel"+idHotel+"/status/").retrieve().bodyToMono(String.class);
    }

    @Override
    public Mono<HotelDetail> postStatus(){
        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
        data.add("alamat", "Jl. X");
        data.add("nomorTelepon", "09111112");
        return this.webClient.post().uri("/rest/hotel/full")
        .syncBody(data).retrieve().bodyToMono(HotelDetail.class);
    }

    @Override
    public Mono<String> getSuggest(String namaKota) {
        String[] name = namaKota.split(" ");
        String query = String.join("%20", name);
        return this.webClient.get().uri(URI.create("https://hotels-com-free.p.rapidapi.com/suggest/v1.7/json?query=" + query + "&locale=en_US"))
                .header("x-rapidapi-key", "e26cadda77mshd9666f5b652ec73p199375jsn316254bfa5bc")
                .header("x-rapidapi-host", "hotels-com-free.p.rapidapi.com").retrieve().bodyToMono(String.class);
    }
}
