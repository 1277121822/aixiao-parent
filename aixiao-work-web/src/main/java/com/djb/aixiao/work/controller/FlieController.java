package com.djb.aixiao.work.controller;

import com.djb.aixiao.common.utils.FastDFSClient;
import com.djb.aixiao.common.utils.JsonUtils;
import com.djb.aixiao.manager.service.WorkItemService;
import com.djb.aixiao.pojo.TbWork;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/** 文件管理controller
 * @author djb
 * @create 2019-05-24 23:11
 */
@Controller
public class FlieController {


    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;

    @Autowired
    private WorkItemService workItemService;


    @RequestMapping(value = "/file/upload",produces = MediaType.TEXT_PLAIN_VALUE+";charset=UTF-8",method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(MultipartFile uploadFile){
        try {
            //把图片上传到图片服务器
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/client.conf");
            //取文件扩展名
            String originalFilename = uploadFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            //得到一个图片的地址和文件名
            String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
            String fileName = uploadFile.getName();
            //补充为完整的url
            url = IMAGE_SERVER_URL + url;
            //封装到map中返回
            Map result = new HashMap<>();
            result.put("error",0);
            result.put("url",url);
            result.put("fileName",fileName);
            System.out.println("++++++"+url);

            return JsonUtils.objectToJson(result);
        } catch (Exception e) {
            e.printStackTrace();
            Map result = new HashMap<>();
            result.put("error",1);
            result.put("message","文件上传失败！！");
            return JsonUtils.objectToJson(result);
        }
    }


    @RequestMapping(value = "/file/down",produces = MediaType.TEXT_PLAIN_VALUE+";charset=UTF-8",method = RequestMethod.POST)
    @ResponseBody
    public String downFile(HttpServletRequest request, HttpServletResponse response,String fileUrls, String workName,String filenames,String ids){
        response.setContentType("application/x-msdownload");
        response.setHeader("Content-Disposition", "attachment;filename="+workName+".zip");
        try {
            //把下载文件从服务器
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/client.conf");
            JFileChooser jf = new JFileChooser();
            //       设置 JFileChooser，以允许用户只选择文件、只选择目录，或者可选择文件和目录。
            //
            //mode参数：FILES_AND_DIRECTORIES   指示显示文件和目录。
            //
            //      FILES_ONLY                             指示仅显示文件。
            //
            //     DIRECTORIES_ONLY                指示仅显示目录。
            jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            jf.setSelectedFile(new File("c:\\我的报表.xls"));
            int value = jf.showSaveDialog(null);
            jf.setFileHidingEnabled(false);
            Map result = new HashMap<>();
            result.put("status",200);
            if (value == JFileChooser.APPROVE_OPTION) {
                File getPath = jf.getSelectedFile();
                String path = getPath.toString();

                if(path.substring(path.length()-1).equals("\\")){
                        path = path.substring(0,path.length()-1);
                 }
                String[] id = ids.split(",");
                TbWork work = workItemService.getWorkByWorkItemId(id[0]);


                ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(path+"\\"+work.getWorkName()+".zip"));//response.getOutputStream()
                // TODO
                //将多个文件压缩成一个文件
                //遍历
                String[] split = fileUrls.split(",");
                String[] name = filenames.split(",");

                for (int i = 0; i < split.length; i++) {
                    String s1 = split[i].substring(split[i].indexOf("g"));
//                    String filename = split[i].substring(split[i].lastIndexOf("/") + 1);
                    zos.putNextEntry(new ZipEntry(name[i]));
                    byte[] bytes = fastDFSClient.downloadFile(s1);
                    System.out.println(s1);
                    IOUtils.write(bytes,zos);
                    //FileInputStream fis = new FileInputStream();
                    zos.write(bytes);

                    //遍历将作业状态变为已提交
                    workItemService.downWorkItem(id[i]);

                }
                /*for (String s : split) {
                    String s1 = s.substring(s.indexOf("g"));
                    String filename = s.substring(s.lastIndexOf("/") + 1);
                    zos.putNextEntry(new ZipEntry(filename));
                    byte[] bytes = fastDFSClient.downloadFile(s1);
                    System.out.println(s1);
                    IOUtils.write(bytes,zos);
                    //FileInputStream fis = new FileInputStream();
                    zos.write(bytes);


                }*/
                zos.setComment(work.getWorkDesc());
                zos.close();

                result.put("message","下载完成！");


            } else {
                // TODO
                result.put("status",201);
                result.put("message","已取消下载！");
            }
            return JsonUtils.objectToJson(result);
//            response.getWriter().write("zzz");
        } catch (Exception e) {
            e.printStackTrace();
            Map result = new HashMap<>();
            result.put("status",500);
            result.put("message","下载失败请重试！");
            return JsonUtils.objectToJson(result);
        }



    }


    /**
     * 上传图片专用
     * @param uploadFile
     * @return
     */
    @RequestMapping(value = "/pic/upload",produces = MediaType.TEXT_PLAIN_VALUE+";charset=UTF-8",method = RequestMethod.POST)
    @ResponseBody
    public String uploadPic(MultipartFile uploadFile){
        try {
            //把图片上传到图片服务器
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:conf/client.conf");
            //取文件扩展名
            String originalFilename = uploadFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            //得到一个图片的地址和文件名
            String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
            //补充为完整的url
            url = IMAGE_SERVER_URL + url;
            //封装到map中返回
            Map result = new HashMap<>();
            result.put("error",0);
            result.put("url",url);
            return JsonUtils.objectToJson(result);
        } catch (Exception e) {
            e.printStackTrace();
            Map result = new HashMap<>();
            result.put("error",1);
            result.put("message","图片上传失败！！");
            return JsonUtils.objectToJson(result);
        }
    }




}
