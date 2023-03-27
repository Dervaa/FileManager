package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        File directory = new File(UPLOAD_DIRECTORY);
        List<File> files = Arrays.asList(directory.listFiles());
        List<File> folders = Arrays.stream(directory.listFiles())
                .filter(file -> file.isDirectory())
                .collect(Collectors.toList());
        model.addAttribute("files", files);
        model.addAttribute("folders", folders);
        return "home";
    }
/* в репоз */
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_DIRECTORY + "/" + file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

    private static final String UPLOAD_DIRECTORY = "C:\\Users\\petia\\Рабочий стол\\FileManager\\demo\\src\\main\\resources\\static";
}
