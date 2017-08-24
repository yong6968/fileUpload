/*
 * Copyright (C) 2015 ShenZhen HeShiDai Co.,Ltd All Rights Reserved.
 * 未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 * 版权所有深圳合时代金融服务有限公司 www.heshidai.com.
 */
package com.deyond.fileUpload.common.utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

/**
 * 功能：fastdfs操作工具类
 *
 * @version 2017年1月5日下午4:28:38
 * @author baocheng.ren
 */
public class FastdfsUtil {
    
    private static final int NUMBER_4 = 4;
    private static final int NUMBER_3 = 3;
    
    private static final String CONFIG_FILE_NAME = "config-fdfs.properties";
    
    private static final String STORAGE_SERVER_IP = "storage.server.ip";
    
    private static final String STORAGE_SERVER_PORT = "storage.server.port";
    
    public static final String  IMAGE_VISIT_URL = "server.visit.url";
    
    /**
     * 功能：上传文件
     *
     * @version 2017年1月5日下午4:25:47
     * @author baocheng.ren
     * @param filePath filePath
     * @return String[]
     * @throws Exception Exception
     */
    @SuppressWarnings("unused")
    private static String[] uploadFile(String filePath) throws Exception {
        return uploadFile(new File(filePath));
    }
    
    /**
     * 功能：上传文件
     *
     * @version 2017年1月5日下午4:25:00
     * @author baocheng.ren
     * @param file file
     * @return String[]
     * @throws Exception Exception
     */
    public static String[] uploadFile(File file) throws Exception {
        // 加载配置
        ClientGlobal.init(FastdfsUtil.class.getClassLoader().getResource(CONFIG_FILE_NAME).getPath());
        // 获取文件信息
        String fileExtName = "";
        if (file.getName().contains(".")) {
            fileExtName = file.getName().substring(file.getName().indexOf(".") + 1);
        }
        else {
            throw new Exception("上传文件失败，文件名格式不合法");
        }
        
        // 设置文件信息
        NameValuePair[] nameValuePair = new NameValuePair[NUMBER_4];
        nameValuePair[0] = new NameValuePair("fileName", file.getName().split("\\.")[0]);
        nameValuePair[1] = new NameValuePair("fileExtName", fileExtName);
        nameValuePair[2] = new NameValuePair("fileLength", String.valueOf(file.length()));
        
        // 如果是图片则获取图片尺寸
        if (file.getName().matches(".*(\\.(gif|jpg|png))$")) {
            Image image = ImageIO.read(file);
            int wideth = image.getWidth(null);
            int height = image.getHeight(null);
            nameValuePair[NUMBER_3] = new NameValuePair("fileDimension", wideth + "x" + height);
        }
        else {
            nameValuePair[NUMBER_3] = new NameValuePair("fileDimension", "");
        }
        
        // 建立连接
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        
        StorageServer storageServer = new StorageServer(getConfValue(STORAGE_SERVER_IP), 
                Integer.valueOf(getConfValue(STORAGE_SERVER_PORT)), 0);
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        
        // 上传文件
        String[] fileIds = storageClient.upload_file(file.getAbsolutePath(), fileExtName, nameValuePair);
        return fileIds;
    }
    
    /**
     * 功能：获取配置文件信息
     *
     * @version 2017年2月14日下午2:42:08
     * @author baocheng.ren
     * @param key 键
     * @return String 值
     * @throws IOException IOException
     */
    public static String getConfValue(String key) throws IOException {
        InputStream in = FastdfsUtil.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME);
        Properties prop = new Properties();
        prop.load(in);
        return prop.getProperty(key);
    }
    
    /**
     * 功能：获取文件信息
     *
     * @version 2017年1月5日下午4:26:55
     * @author baocheng.ren
     * @param groupName groupName
     * @param fileName fileName
     * @return NameValuePair[]
     * @throws Exception Exception
     */
    public static NameValuePair[] getFileMetadata(String groupName, String fileName) throws Exception {
        // 加载配置
        ClientGlobal.init(FastdfsUtil.class.getClassLoader().getResource(CONFIG_FILE_NAME).getPath());
        // 建立连接
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageServer storageServer = null;
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        return storageClient.get_metadata(groupName, fileName);
    }
    
}
