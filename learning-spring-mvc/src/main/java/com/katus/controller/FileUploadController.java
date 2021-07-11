package com.katus.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-30
 */
@Controller
@RequestMapping("/file")
public class FileUploadController implements Serializable {
    // 传统文件上传方式
    @RequestMapping("/upload1")
    public String upload1(HttpServletRequest request) throws Exception {
        System.out.println("Test File Upload 1");
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item : items) {
            if (item.isFormField()) {
                // 普通表单字段
            } else {
                String name = item.getName();
                // 设置文件名唯一
                String uuid = UUID.randomUUID().toString().replace("-", "");
                name = uuid + "_" + name;
                item.write(new File(path, name));
                item.delete();
            }
        }
        return "success";
    }

    // SpringMVC上传文件方式
    @RequestMapping("/upload2")
    public String upload2(HttpServletRequest request, MultipartFile upload) throws IOException {// MultipartFile参数名需要与form表单中的name一致
        System.out.println("Test File Upload 2");
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String name = upload.getOriginalFilename();
        // 设置文件名唯一
        String uuid = UUID.randomUUID().toString().replace("-", "");
        name = uuid + "_" + name;
        upload.transferTo(new File(path, name));
        return "success";
    }

    // 跨服务器上传文件方式
    @RequestMapping("/upload3")
    public String upload3(MultipartFile upload) throws IOException {// MultipartFile参数名需要与form表单中的name一致
        System.out.println("Test File Upload 3");
        // 定义文件服务器地址 需要保证路径存在
        String path = "http://localhost:9090/uploads/";
        String name = upload.getOriginalFilename();
        // 设置文件名唯一
        String uuid = UUID.randomUUID().toString().replace("-", "");
        name = uuid + "_" + name;
        // 创建客户端对象
        Client client = Client.create();
        // 和文件服务器建立联系
        WebResource webResource = client.resource(path + name);
        // 按字节上传文件
        webResource.put(upload.getBytes());
        return "success";
    }
}
