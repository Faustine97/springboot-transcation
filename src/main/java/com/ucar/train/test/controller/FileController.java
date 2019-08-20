package com.ucar.train.test.controller;

//import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import com.ucar.train.test.function.MyLog;
import com.ucar.train.test.vo.UserHead;
import com.ucar.train.test.services.impl.UserHeadService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.UUID;

/**
 * 文件上传
 */
@Controller
public class FileController {
    @Autowired
    private UserHeadService userHeadService;

    @RequestMapping(value = "/file")
    public String file() {
        return "file";
    }

    @RequestMapping("/update_user_head")
    public String updateUserHead(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String url = request.getParameter("head");
        String name = (String) session.getAttribute("user");
        session.setAttribute("user_head", url);
        UserHead userHead = new UserHead(name, url);
        userHeadService.saveUserHead(userHead);
        return "user_edit";
    }

    @RequestMapping("/history_head")
    public String historyHead(HttpSession session) {
        String name = (String) session.getAttribute("user");
        List<UserHead> list = userHeadService.getHistoryHead(name);
        session.setAttribute("history_head", list);
        return "history_head";
    }

    @MyLog(operation = "上传头像", result = "成功")
    @PostMapping(value = "/fileUpload")
    public String fileUpload(@RequestParam(value = "file") MultipartFile file, Model model, HttpServletRequest request) {
        if (file.isEmpty()) {
            System.out.println("文件为空空");
        } else {
            String fileName = file.getOriginalFilename();  // 文件名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
            String filePath = "C://temp-rainy//"; // 上传后的路径
            fileName = UUID.randomUUID() + suffixName; // 新文件名
            File dest = new File(filePath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String filename = "/temp-rainy/" + fileName;
            HttpSession session = request.getSession();
            String userName = (String) session.getAttribute("user");
            UserHead userHead = new UserHead(userName, filename);
            userHeadService.saveHistoryHead(userHead);
            userHeadService.saveUserHead(userHead);
            model.addAttribute("user_head", filename);
        }

        return "user_edit";
    }
}
