package com.example.demo.Service;
import com.example.demo.Entity.File;

import java.util.List;

public interface IFileService {
    List<File> getAllFiles();

    void saveFile();

    void saveFile(File file);
}

