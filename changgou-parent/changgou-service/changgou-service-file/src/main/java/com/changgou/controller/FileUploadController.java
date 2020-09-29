package com.changgou.controller;

import com.changgou.file.FastDFSFile;
import com.changgou.util.FastDFSUtil;
import entity.Result;
import entity.StatusCode;
import jdk.net.SocketFlow;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.util.StringUtil;

//文件上传控制层
@RestController
@RequestMapping(value="/upload")
@CrossOrigin  //解决跨域问题
public class FileUploadController {

    //文件上传
    @PostMapping
    public Result upload(@RequestParam(value="file")MultipartFile file) throws Exception{
        //封装文件信息
        FastDFSFile fastDFSFile = new FastDFSFile(
                file.getOriginalFilename(), //文件名字1.jpg
                file.getBytes(),            //文件字节数组
                StringUtils.getFilenameExtension(file.getOriginalFilename())
        );

        //调用FastDFSutil工具类，将文件传入到FastDFS中
        FastDFSUtil.upload(fastDFSFile);
        return new Result(true, StatusCode.OK,"上传成功");
    }
}
