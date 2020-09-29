package com.changgou.file;

//封装用户，上传文件信息
//时间、Author、type、size、附加信息、后缀、文字内容-》文件的字节数组

import java.io.Serializable;

public class FastDFSFile implements Serializable {
    //文件名字
    private String name;
    //文件内容
    private byte[] content;
    //文件扩展名jpg,png,gif
    private String ext;
    //文件MD5摘要值
    private String MD5;
    //文件创作者
    private String author;

    public FastDFSFile(String name, byte[] content, String ext) {
        this.name = name;
        this.content = content;
        this.ext = ext;
    }

    public FastDFSFile(String name, byte[] content, String ext, String MD5, String author) {
        this.name = name;
        this.content = content;
        this.ext = ext;
        this.MD5 = MD5;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getMD5() {
        return MD5;
    }

    public void setMD5(String MD5) {
        this.MD5 = MD5;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
