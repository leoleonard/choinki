package pl.javastart.demoapp.choinka;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Entity
public class Choinka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double wysokosc;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dataSciecia;

    @Enumerated(EnumType.STRING)
    private TypChoinki typChoinki;

    private String imageName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(Double wysokosc) {
        this.wysokosc = wysokosc;
    }

    public LocalDateTime getDataSciecia() {
        return dataSciecia;
    }

    public void setDataSciecia(LocalDateTime dataSciecia) {
        this.dataSciecia = dataSciecia;
    }

    public TypChoinki getTypChoinki() {
        return typChoinki;
    }

    public void setTypChoinki(TypChoinki typChoinki) {
        this.typChoinki = typChoinki;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
