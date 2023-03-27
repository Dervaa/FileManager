package com.example.demo.repos;
import com.example.demo.Entity.File;
import org.springframework.stereotype.Repository;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

@Repository
public class YAMLRepos implements IYAMLRepos {
        private final String yamlFilePath;

        public YAMLRepos() {
            this.yamlFilePath = "C:\\Users\\petia\\Рабочий стол\\FileManager\\demo\\src\\main\\resources\\Database.yaml";
        }

//    public class YamlFileReader {
//        public static List<File> readFiles(String filePath) {
//            List<File> files = new ArrayList<>();
//            try (InputStream inputStream = YamlFileReader.class.getClassLoader().getResourceAsStream(filePath)) {
//                if (inputStream != null) {
//                    Yaml yaml = new Yaml(new Constructor(File.class));
//                    Iterable<Object> objects = yaml.loadAll(inputStream);
//                    for (Object object : objects) {
//                        files.add((File) object);
//                    }
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return files;
//        }
//    }
//    public class YamlFileStorage {
//        public static void saveFileEntities(List<File> files, String filePath) {
//            DumperOptions options = new DumperOptions();
//            options.setPrettyFlow(true);
//            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
//
//            try (FileWriter writer = new FileWriter(filePath)) {
//                Yaml yaml = new Yaml(options);
//                yaml.dump(files, writer);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }


        public List<File> findAll() {
            return YamlFileReader.readFiles(yamlFilePath);
        }

        public Optional<File> findById(Long id) {
            return findAll().stream()
                    .filter(file -> file.getId().equals(id))
        }

        public File save(File file) {
            List<File> files = YamlFileReader.readFiles(yamlFilePath);
            files.add(file);
            YamlFileStorage.saveFileEntities(files, yamlFilePath);
            return file;
        }

        public void delete(Long id) {
            List<File> files = YamlFileReader.readFiles(yamlFilePath);
            files.removeIf(file -> file.getId().equals(id));
            YamlFileStorage.saveFileEntities(files, yamlFilePath);
        }

        public void update(File updatedFile) {
            List<File> files = YamlFileReader.readFiles(yamlFilePath);
            files = files.stream()
                    .map(file -> file.getId().equals(updatedFile.getId()) ? updatedFile : file)
                    .collect(Collectors.toList());
            YamlFileStorage.saveFileEntities(files, yamlFilePath);
        }
    }
