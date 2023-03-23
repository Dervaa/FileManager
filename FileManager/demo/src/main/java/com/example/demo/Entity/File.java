package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class File {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
@Id
private Long id;
    private String type;
    private String name;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
    private Long size;
    public File() {}
    public File (String type, String name, LocalDateTime creationDate, LocalDateTime modificationDate, Long size) {
        this.type = type;
        this.name = name;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}