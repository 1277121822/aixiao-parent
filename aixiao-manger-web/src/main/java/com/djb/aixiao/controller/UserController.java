package com.djb.aixiao.controller;

import com.djb.aixiao.common.pojo.EasyUIDataGridResult;
import com.djb.aixiao.common.utils.JsonUtils;
import com.djb.aixiao.common.utils.TaotaoResult;
import com.djb.aixiao.manager.service.UserService;
import com.djb.aixiao.pojo.TbUser;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** 用户的管理
 * @author djb
 * @create 2019-05-24 14:32
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    //url:/item/list
    //method:get
    //参数：page,rows
    //返回值:json
    @RequestMapping(value="/user/query/list",method= RequestMethod.GET)
    @ResponseBody
    public EasyUIDataGridResult getItemList(Long categoryId,Integer page, Integer rows){
        //1.引入服务
        //2.注入服务
        //3.调用服务的方法
        return userService.getUserList(categoryId,page,rows);
    }

    /**
     * url:/user/save
     * @param user
     * @return
     */
    @RequestMapping(value = "/user/save",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult saveUser(TbUser user){
        //1.引入服务
        //2.注入服务
        //3.调用
        return  userService.saveUser(user);
    }

    /**
     * url:/user/save
     * @param ids
     * @return
     */
    @RequestMapping(value = "/user/delete",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult deleteUser(String ids){
        //1.引入服务
        //2.注入服务
        //3.调用
        return  userService.deleteUser(ids);
    }

    @RequestMapping(value = "/file/imput",method = RequestMethod.POST,produces = MediaType.TEXT_PLAIN_VALUE+";charset=UTF-8")
    @ResponseBody
    public String imputUsers(Long categoryId, MultipartFile uploadFile){
        List<TbUser> userList = new ArrayList<TbUser>();
        try {
            //包装一个excel对象
            HSSFWorkbook workbook = new HSSFWorkbook(uploadFile.getInputStream());
            //读取文件中的第一个Sheet标签页
            HSSFSheet hssfSheet = workbook.getSheetAt(0);
            for (Row row : hssfSheet) {
//            row.setRowStyle(CellType.STRING);
                int rowNum = row.getRowNum();
                if (rowNum == 0)continue;
                //设置读取到的表格格式
                row.getCell(0).setCellType(CellType.STRING);
                row.getCell(1).setCellType(CellType.STRING);
                row.getCell(2).setCellType(CellType.STRING);
                String snoStr = row.getCell(0).getStringCellValue();

                if (StringUtils.isEmpty(snoStr))continue;
                Long sno = Long.parseLong(snoStr);
                String username = row.getCell(1).getStringCellValue();
                String sexStr = row.getCell(2).getStringCellValue();
                String  sex = null;
                if (sexStr.equals("男性")){
                    sex = "1";
                }else if (sexStr.equals("女性")){
                    sex = "2";
                }
                String md5password = DigestUtils.md5DigestAsHex(snoStr.getBytes());
                Date created = new Date();

                TbUser user = new TbUser(null,username, md5password, null, null, sex, null, null,sno, null, categoryId,created ,created);
                //3.插入内容表中
                userList.add(user);

            }
            TaotaoResult result = userService.imputUsers(categoryId, userList);
            return JsonUtils.objectToJson(result);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonUtils.objectToJson(TaotaoResult.build(400,"导入失败请重试！"));
        }
    }

    /**
     * 更改角色
     * @param ids
     * @return
     */
    @RequestMapping(value = "/user/reload",method = RequestMethod.POST)
    @ResponseBody
    public TaotaoResult reloadRole(String ids) {
        //1.引入服务
        //2.注入服务
        //3.调用
        return  userService.reloadRole(ids);
    }


}
