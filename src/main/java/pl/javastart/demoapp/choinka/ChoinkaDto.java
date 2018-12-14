package pl.javastart.demoapp.choinka;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDateTime;

public class ChoinkaDto {

    private Long id;
    private Double wysokosc;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dataSciecia;
    private TypChoinki typChoinki;
    private MultipartFile image;

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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
