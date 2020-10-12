package apap.tutorial.traveloke.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="kamar")
public class KamarModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noKamar;

    @NotNull
    @Size(max=30)
    @Column(name="namaKamar", nullable=false)
    private String namaKamar;

    @NotNull
    @Column(name="tipe", nullable=false)
    private Integer tipe;

    @NotNull
    @Column(name="kapasitasKamar", nullable= false)
    private Integer kapasitasKamar;

    @ManyToOne(fetch= FetchType.EAGER, optional=false)
    @JoinColumn(name="hotelId", referencedColumnName="id", nullable=false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    private HotelModel hotel;

    @OneToMany(mappedBy="kamar", fetch= FetchType.LAZY, cascade= CascadeType.ALL)
    private List<ReviewModel> listReview;

    public Long getNoKamar(){
        return this.noKamar;
    }

    public String getNamaKamar(){
        return this.namaKamar;
    }

    public Integer getTipe(){
        return this.tipe;
    }

    public Integer getKapasitasKamar(){
        return this.kapasitasKamar;
    }

    public HotelModel getHotel(){
        return this.hotel;
    }

    public void setNoKamar(Long noKamar){
        this.noKamar = noKamar;
    }

    public void setNamaKamar(String namaKamar){
        this.namaKamar = namaKamar; 
    }

    public void setTipe(Integer tipe){
        this.tipe = tipe;
    }

    public void setKapasitasKamar(Integer kapasitasKamar){
        this.kapasitasKamar = kapasitasKamar;
    }

    public void setHotel(HotelModel hotel){
        this.hotel = hotel;
    }
}
