package apap.tutorial.traveloke.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "hotel")
public class HotelModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @NotNull
    @Size(max=30)
    @Column(name="namaHotel", nullable=false)
    private String namaHotel; 

    @NotNull
    @Size(max=30)
    @Column(name="alamat", nullable= false)
    private String alamat; 

    @NotNull
    @Column(name="nomorTelepon", nullable= false)
    private Integer nomorTelepon;

    @OneToMany(mappedBy="hotel", fetch= FetchType.LAZY, cascade= CascadeType.ALL)
    private List<KamarModel> listKamar;
    
    //Getter untuk idHotel, namaHotel, alamat, dan noTelepon.
    public Long getId(){
        return id;
    }

    public String getNamaHotel(){
        return namaHotel;
    }

    public String getAlamat(){
        return alamat;
    }

    public Integer getNomorTelepon(){
        return nomorTelepon;
    }

    //Setter untuk idHotel, namaHotel, alamat, dan noTelepon.
    public void setIdHotel(Long id){
        this.id = id;
    }

    public void setNamaHotel(String namaHotel){
        this.namaHotel = namaHotel;
    }

    public void setAlamat(String alamat){
        this.alamat = alamat;
    }

    public void setNomorTelepon(Integer nomorTelepon){
        this.nomorTelepon = nomorTelepon;
    }    
}
