package com.example.demo.Service;

import com.example.demo.Entity.File;
import com.example.demo.repos.IYAMLRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService implements IFileService {

    private final IYAMLRepos yamlRepos;

    @Autowired
    public FileService(IYAMLRepos yamlRepos) {
        this.yamlRepos = yamlRepos;
    }

    @Override
    public List<File> getAllFiles() {
        return yamlRepos.findAll();
    }

    @Override
    public void saveFile() {
        saveFile(null);
    }

    @Override
    public void saveFile(File file) {
        yamlRepos.save(file);
    }
}

