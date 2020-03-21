package com.sdjzu.knowledgequiz.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface AdminService {
    List<List<Object>> getListByExcel(MultipartFile file);
}
