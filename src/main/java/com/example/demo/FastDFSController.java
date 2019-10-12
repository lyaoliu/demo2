package com.example.demo;

import com.example.demo.util.FastDFSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * FastDFSController class
 *
 * @author lyliu
 * @date 2019/04/09 15:22
 */
@Controller
@RequestMapping("/fastdfs")
public class FastDFSController {
    @Autowired
    private FastDFSClient client;
    @RequestMapping("/index.do")
    public String execute(){
        return "/fastdfs";
    }

    /**
     * 上传文件
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping("/upload")
    @ResponseBody
    public Map<String ,Object> upload(MultipartFile file) throws IOException {
        String url=client.uploadFile(file);
        Map<String,Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", "上传成功");
        result.put("url", url);
        return result;
    }

    /**
     * 下载文件
     * @param url
     * @param response
     * @throws IOException
     */
    @RequestMapping("/download")
    public void download(String url,HttpServletResponse response) throws IOException {
        client.download(url,response);
    }

    /**
     * 删除文件
     * @param url
     * @return
     */
    public Map<String ,Object>delete(String url){
        client.deleteFile(url);
        Map<String,Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("msg", "删除文件成功");
        return result;
    }
}
