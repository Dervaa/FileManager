package com.example.demo.repos;

import com.example.demo.Entity.File;

import java.util.List;
import java.util.Optional;

public interface IYAMLRepos {
    List<File> findAll();
    Optional<File> findById(Long id);
    File save(File file);
    void delete(Long id);
    void update(File file);
}
