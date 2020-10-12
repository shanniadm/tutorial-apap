package apap.tutorial.traveloke.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "review")
public class ReviewModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=10)
    @Column(name="nama_reviewer", nullable=false)
    private String namaReviewer;

    @NotNull
    @Size(max=50)
    @Column(name="isi_review", nullable=false)
    private String isiReview;

    @Size(max=50)
    @Column(name="saran", nullable = true)
    private String saran;

    @ManyToOne(fetch= FetchType.EAGER, optional=false)
    @JoinColumn(name="kamarId", referencedColumnName="noKamar", nullable=false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    private KamarModel kamar;

    public Long getId(){
        return id;
    }

    public String getNamaReview(){
        return namaReviewer;
    }

    public String getIsiReviewer(){
        return isiReview;
    }

    public String getSaran(){
        return saran;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setNamaReview(String namaReviewer){
        this.namaReviewer = namaReviewer;
    }

    public void setIsiReviewer(String isiReview){
        this.isiReview=isiReview;
    }

    public void setSaran(String saran){
        this.saran = saran;
    }
}
