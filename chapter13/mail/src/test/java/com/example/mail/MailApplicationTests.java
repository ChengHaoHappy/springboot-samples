package com.example.mail;

import com.example.mail.service.MailService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import java.io.File;

@SpringBootTest
@RunWith(SpringRunner.class)
class MailApplicationTests {
    @Resource
    MailService mailService;

    @Test
    void sendSimpleMail(){
        mailService.sendSimpleMail("cheng_haoo@qq.com","cheng_haoo@126.com","2967771621@qq.com",
                "测试邮件主题","测试邮件内容");
    }

    @Test
    void sendAttachFileMail(){
        mailService.sendAttachFileMail("cheng_haoo@qq.com","cheng_haoo@126.com",
                "测试邮件主题","测试邮件内容",new File("E:\\邮件附件.txt"));
    }

    @Test
    public void sendMailWithImg() {
        mailService.sendMailWithImg("cheng_haoo@qq.com",
                "cheng_haoo@126.com",
                "测试邮件主题(图片)",
                "<div>hello,这是一封带图片资源的邮件：" +
                        "这是图片1：<div><img src='cid:p01'/></div>" +
                        "这是图片2：<div><img src='cid:p02'/></div>" +
                        "</div>",
                new String[]{"F:\\Image\\p1.png",
                        "F:\\Image\\p2.png"},
                new String[]{"p01", "p02"});
    }

    @Autowired
    TemplateEngine templateEngine;
    @Test
    public void sendHtmlMailThymeleaf() {
        Context ctx = new Context();
        ctx.setVariable("username", "sang");
        ctx.setVariable("gender", "男");
        String mail = templateEngine.process("mailtemplate.html", ctx);
        mailService.sendHtmlMail("cheng_haoo@qq.com",
                "cheng_haoo@126.com",
                "测试邮件主题",
                mail);
    }


}
