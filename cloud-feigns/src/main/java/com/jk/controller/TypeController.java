package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.jk.entity.Type;
import com.jk.service.TypeServices;
import org.apache.commons.io.IOUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RefreshScope
@RequestMapping("type")
public class TypeController {

    @Value("server.port")
    private String serverPore;
    @Value("config.info")
    private String ConfigInfo;

    public String ConfigInfo(){
        return "serverPore:"+serverPore+"ConfigInfo:"+ConfigInfo;
    }



    @Autowired
    private TypeServices typeService;
    //rabbitmq
    @Autowired
    private AmqpTemplate amqpTemplate;
    //跳转到show页面
    @RequestMapping("show")
    public String toShow(){
        return "show";
    }

    //跳转到add页面
    @RequestMapping("toTypeAdd")
    public String toAdd(){
        return "add";
    }

    //跳转到回显页面
    @RequestMapping("UpdateId")
    public String toAddUser(Integer spid, ModelMap map){
        map.put("id",spid);
        System.out.println(spid+"会显得之");
        return "UpdateId";
    }


    //分页+条查+查findgoodPage
    @RequestMapping("findtypePage")
    @ResponseBody
    public HashMap<String, Object> findtypePage(Type type) {
        System.out.println("Dsfsdf");
        return typeService.findtypePage(type);
    }

    //批量删除
    @RequestMapping("updatefile")
    @ResponseBody
    public void updatefile(String ids){
        //转换并发送消息
        //第一个参数为当前消息需要发送到哪个队列上
        //第二个参数为当前需要发送的消息
        amqpTemplate.convertAndSend("delorder",ids);
    }

    //删除
    @RequestMapping("del")
    @ResponseBody
    public void del(Integer id){
        System.out.println(id);
        typeService.del(id);
    }

    //新增
    @RequestMapping("addType")
    @ResponseBody
    private void addType(Type type){
        String typeJson = JSON.toJSONString(type);
        amqpTemplate.convertAndSend("addorder",typeJson);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("message","成功");
    }
    //新增
    @RequestMapping("addType2")
    @ResponseBody
    private void addType2(Type type){
        for (int i = 0; i <100 ; i++) {
            new Thread(new Runnable() {//new一个线程类，实现runnble接口
                @Override
                public void run() {//子线程
                    for (int j = 0; j <10000 ; j++) {
                        String typeJson = JSON.toJSONString(type);
                        amqpTemplate.convertAndSend("addorder2", typeJson);
                    }
                }

            }).start();//start()让线程进入就绪状态
            System.out.println(type);
        }
    }

    //回显findTypeById
    @RequestMapping("findTypeById")
    @ResponseBody
    public Type findTypeById(Integer id){
        System.out.println(id);
        return typeService.findTypeById(id);
    }

    //修改updateType
    @RequestMapping("updateType")
    @ResponseBody
    private void updateType(Type type){
        typeService.updateType(type);
    }

    //图片上传
    @RequestMapping("upFileImg")
    @ResponseBody
    public HashMap<String,Object> upFileImg(MultipartFile file, HttpServletRequest request){
        String name = file.getOriginalFilename();
        HashMap<String,Object> map=new HashMap<String,Object>();
        try {
            InputStream inp=file.getInputStream();
            String uuid= UUID.randomUUID().toString();
            String path="D:\\短期课程\\实训1\\idea\\项目\\springcloud\\cloud-feigns\\src\\main\\resources\\static\\js\\";
            uuid=uuid+name.substring(name.lastIndexOf("."));
            File fileOne=new File(path+"\\upload");
            path=path+"upload\\"+uuid;
            map.put("src",uuid);
            if ( !fileOne.exists()){//若此目录不存在，则创建之// 这个东西只能简历一级文件夹，两级是无法建立的。。。。。
                fileOne.mkdir();
            }
            FileOutputStream out=new FileOutputStream(new File(path));
            IOUtils.copy(inp, out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }
}
