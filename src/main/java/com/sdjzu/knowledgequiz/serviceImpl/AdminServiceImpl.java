package com.sdjzu.knowledgequiz.serviceImpl;

import com.sdjzu.knowledgequiz.service.AdminService;
import com.sdjzu.knowledgequiz.util.ExcelUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@Component
public class AdminServiceImpl implements AdminService {
    @Override
    public List<List<Object>> getListByExcel(MultipartFile file) {
        try {
            InputStream inputStream = null;
            inputStream = file.getInputStream();
            List<List<Object>> list = ExcelUtils.getCourseListByExcel(inputStream, file.getOriginalFilename());
            inputStream.close();
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
