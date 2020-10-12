package apap.tutorial.traveloke.repository;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.model.ReviewModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDb extends JpaRepository<ReviewModel,Long>{
    
}
