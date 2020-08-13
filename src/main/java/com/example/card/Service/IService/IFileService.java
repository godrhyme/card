package com.example.card.Service.IService;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IFileService {
    public List<String> upload(MultipartFile[] files) ;
}
