package com.baizhi.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@Controller
@RequestMapping("file")
public class UploadController {
    @RequestMapping("upload")
    public String upload(MultipartFile haha, HttpServletRequest request) throws IOException {
        System.out.println(haha.getOriginalFilename());
        System.out.println(haha.getContentType());
        System.out.println(haha.getSize());
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        haha.transferTo(new File(realPath, haha.getOriginalFilename()));
        return "upload";

    }

    @RequestMapping("download")
    public String download(String name, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String realPath = request.getServletContext().getRealPath("/upload");
        File file = new File(realPath, name);
        FileInputStream di = new FileInputStream(file);
        ServletOutputStream os = response.getOutputStream();
        response.setHeader("content-disposition", "attachment" + ";fileName=" + URLEncoder.encode(name, "utf-8"));
        IOUtils.copy(di, os);
        IOUtils.closeQuietly(di);
        IOUtils.closeQuietly(os);
        return null;
    }
}
