package pl.javastart.demoapp.choinka;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Controller
public class ChoinkaController {

    private ChoinkaRepository choinkaRepository;

    public ChoinkaController(ChoinkaRepository choinkaRepository) {
        this.choinkaRepository = choinkaRepository;
    }

    @GetMapping("/")
    public String lista(Model model) {
        List<Choinka> all = choinkaRepository.findAll();
        model.addAttribute("all", all);
        return "lista";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id) {
        choinkaRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/nowa")
    public String nowa(Model model) {
        model.addAttribute("choinka", new ChoinkaDto());
        model.addAttribute("typy", TypChoinki.values());
        return "nowa";
    }

    @PostMapping("/nowa")
    public String add(ChoinkaDto dto) throws IOException {

        Choinka choinka = new Choinka();
        choinka.setDataSciecia(dto.getDataSciecia());
        choinka.setTypChoinki(dto.getTypChoinki());
        choinka.setWysokosc(dto.getWysokosc());

        MultipartFile image = dto.getImage();

        InputStream inputStream = image.getInputStream();

        File file = new File(".", image.getName());

        try {
            FileCopyUtils.copy(inputStream, new FileOutputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }


        // 1. zapisz plik
        // 2. pobierz nazwe

        choinka.setImageName("");

        choinkaRepository.save(choinka);

        return "redirect:/";
    }

    @GetMapping("/edit")
    public String showForm(Model model, @RequestParam Long id) {
        Optional<Choinka> optional = choinkaRepository.findById(id);
        if(optional.isPresent()) {
            Choinka choinka = optional.get();
            model.addAttribute("choinka", choinka);
            model.addAttribute("typy", TypChoinki.values());
            return "edit";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/edit")
    public String edit(Choinka choinka) {
        choinkaRepository.save(choinka);
        return "redirect:/";
    }

}
