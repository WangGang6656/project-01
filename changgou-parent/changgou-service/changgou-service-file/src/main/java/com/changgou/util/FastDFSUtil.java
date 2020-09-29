package com.changgou.util;

//实现FastDFS工具类
//文件上传、文件删除、文件下载、文件信息获取、Storage信息获取、Tracker信息获取

import com.changgou.file.FastDFSFile;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.omg.CORBA.NameValuePair;
import org.springframework.core.io.ClassPathResource;

public class FastDFSUtil {

    //1、加载Tracker链接信息
    static{
        try{
            //查找classpath下的文件路径
            String filename = new ClassPathResource("fdfs_client.conf").getPath();
            //加载Tracker链接信息
            ClientGlobal.init(filename);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //2、先在FastDFSFile进行文件封装，然后调用upload上传方法
    public  void upload(FastDFSFile fastDFSFile) throws Exception{
        //附加参数
        NameValuePair[] meta_list = new NameValuePair[1];
        meta_list[0] = new NameValuePair("author",fastDFSFile.getAuthor());

        //创建一个Tracker访问的客户端对象TrackerClient
        TrackerClient trackerClient = new TrackerClient();

        //通过TrackerClient访问TrackerServer服务,获取链接信息系
        TrackerServer trackerSer = trackerClient.getConnection();

        //通过TrackerServer的链接信息，获取Storage的链接信息，创建StorageClient对象存储Storage链接信息
        StorageClient storageClient = new StorageClient(trackerSer, null);

        //通过StoageClient访问Storage,实现文件上传，并且获取文件上传后的存储信息
        String[] strings = storageClient.upload_appender_file(fastDFSFile.getContent(), fastDFSFile.getExt(), meta_list);

    }
}
