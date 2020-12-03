package apap.tutorial.traveloke.service;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import apap.tutorial.traveloke.repository.RoleDb;
import apap.tutorial.traveloke.service.RoleService;
import apap.tutorial.traveloke.model.RoleModel;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleDb roleDb;

    @Override
    public List<RoleModel> findAll(){
        return roleDb.findAll();
    }
}
