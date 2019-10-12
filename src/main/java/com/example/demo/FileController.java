package com.example.demo;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * ${name} class
 *
 * @author lyliu
 * @date 2018/08/02 下午 5:22
 */
@Controller
public class FileController {
    String path = "F:/test" ;
    /*
     * 获取file.html页面
     */
    @RequestMapping("file")
    public String file(){
        return "/file";
    }
    @RequestMapping(value = "/upload",method =RequestMethod.POST)
    public String upload(MultipartFile file) throws IOException {
      String fileName=  file.getOriginalFilename();
        File dest = new File(path + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        file.transferTo(dest);
     return  "index";
    }
    @GetMapping("/download/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
        try (InputStream inputStream = new FileInputStream(new File(path, id + ".bmp"));
             OutputStream outputStream = response.getOutputStream();) {
            response.setContentType("application/x-download");
            id=URLEncoder.encode(id,"utf-8");
            response.addHeader("Content-Disposition", "attachment;filename=" + id + ".jpg");
            IOUtils.copy(inputStream, outputStream);
             byte [] bytes=new byte[1024];
             int len;
             while ((len=inputStream.read(bytes))!=-1){
                 outputStream.write(bytes,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
