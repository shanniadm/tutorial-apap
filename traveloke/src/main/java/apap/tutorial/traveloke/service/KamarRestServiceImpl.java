package apap.tutorial.traveloke.service;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.repository.KamarDb;
import apap.tutorial.traveloke.rest.Setting;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class KamarRestServiceImpl implements KamarRestService{

    // void addKamar(KamarModel kamar);

    // KamarModel updateKamar(Long idKamar, KamarModel kamar);

    // KamarModel getKamarByIdKamar(Long idKamar);

    // List<KamarModel> getAllKamar();

    // void deleteKamar(Long idKamar);

    @Autowired
    private KamarDb kamarDb;

    @Override 
    public void addKamar(KamarModel kamar){
        kamarDb.save(kamar);
    }

    @Override
    public KamarModel updateKamar(Long idKamar, KamarModel kamarUpdate){
        KamarModel kamar = getKamarByIdKamar(idKamar);
        kamar.setHotel(kamarUpdate.getHotel());
        kamar.setKapasitasKamar(kamarUpdate.getKapasitasKamar());
        kamar.setNamaKamar(kamarUpdate.getNamaKamar());
        kamar.setTipe(kamarUpdate.getTipe());
        return kamarDb.save(kamar);
    }

    @Override
    public KamarModel getKamarByIdKamar(Long idKamar){
        Optional<KamarModel> kamar = kamarDb.findById(idKamar);
        if(kamar.isPresent()){
            return kamar.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public List<KamarModel> getAllKamar(){
        return kamarDb.findAll();
    }

    @Override 
    public void deleteKamar(Long idKamar){
        kamarDb.deleteById(idKamar);
    }
}
