package apap.tutorial.traveloke.service;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import apap.tutorial.traveloke.model.RoleModel;

public interface RoleService {
    List<RoleModel> findAll();
}
