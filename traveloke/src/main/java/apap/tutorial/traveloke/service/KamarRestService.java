package apap.tutorial.traveloke.service;
import apap.tutorial.traveloke.model.KamarModel;
import reactor.core.publisher.Mono;
import java.util.List;

public interface KamarRestService {
    void addKamar(KamarModel kamar);

    KamarModel updateKamar(Long idKamar, KamarModel kamar);

    KamarModel getKamarByIdKamar(Long idKamar);

    List<KamarModel> getAllKamar();

    void deleteKamar(Long idKamar);
}
