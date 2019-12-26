package com.wangsong.springboot.chapter04.Controller;

import com.wangsong.springboot.chapter04.Bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @description:
 * @author: chenghao
 * @date: 2019/8/18
 */
@RestController
public class Chap04 {

    @Autowired
    Book book;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");

    @GetMapping("hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("books")
    public Book book() {
        book.setAuthor("罗贯中");
        book.setName("三国演义");
        book.setPrice((float) 30);
        book.setPublicationDate(new Date());

        return book;
    }

    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest req) {
        String realPath = req.getSession().getServletContext().getRealPath("/uploadFile/");//上传文件保存路径
        System.out.println(realPath);
        String format = sdf.format(new Date());
        File folder = new File(realPath + format);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }
        //文件重命名
        String oldName = uploadFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."), oldName.length());
        //保存文件
        try {
            uploadFile.transferTo(new File(folder, newName));
            String filePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/uploadFile/" + format + "/" + newName;
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }
}
