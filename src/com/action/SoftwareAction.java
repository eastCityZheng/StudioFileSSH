package com.action;

import com.entity.SoftwareEntity;
import com.entity.SoftwareListEntity;
import com.entity.UserEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.SoftwareService;
import com.service.UserService;
import org.apache.struts2.ServletActionContext;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SoftwareAction extends ActionSupport implements ModelDriven<SoftwareEntity> {

    SoftwareEntity softwareEntity=new SoftwareEntity();

    public SoftwareEntity getSoftwareEntity() {
        return softwareEntity;
    }

    public void setSoftwareEntity(SoftwareEntity softwareEntity) {
        this.softwareEntity = softwareEntity;
    }

    private SoftwareService softwareService;

    public void setSoftwareService(SoftwareService softwareService) {
        this.softwareService = softwareService;
    }

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public SoftwareEntity getModel() {
        return softwareEntity;
    }

    private File software;
    private String softwareFileName;

    public void setSoftware(File software) {
        this.software = software;
    }

    public void setSoftwareFileName(String softwareFileName) {
        this.softwareFileName = softwareFileName;
    }

    //上传文件
    public void upload(File file, String filename){
        //基于myFile创建一个文件输入流
        InputStream is;
        File toFile;
        OutputStream os;
        try {
            String uploadPath = ServletActionContext.getServletContext()
                    .getRealPath("/upload");
            System.out.println(uploadPath);
            is = new FileInputStream(file);
            // 设置上传文件目录


            //如果没有文件夹 就新建文件夹
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            // 设置目标文件
            toFile = new File(uploadPath, filename);

            // 创建一个输出流
            os = new FileOutputStream(toFile);

            //设置缓存
            byte[] buffer = new byte[1024];

            int length = 0;

            //读取myFile文件输出到toFile文件中
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            System.out.println("上传文件名"+filename);

            //关闭输入流
            is.close();
            //关闭输出流
            os.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public  String add(){
        if (softwareFileName!=null) {
            upload(software,softwareFileName);
            softwareEntity.setsSoftware(softwareFileName);
        }
        softwareService.add(softwareEntity);
        ServletActionContext.getRequest().setAttribute("result","true'");
        return "add";
    }

    public String list(){
        UserEntity us=(UserEntity) ActionContext.getContext().getSession().get("user");
        int w_id=us.getwId();

        List<SoftwareEntity> swList=softwareService.findAll(w_id);
        List<SoftwareListEntity> swlList=new ArrayList<>();
        for (SoftwareEntity sw:swList){
            SoftwareListEntity swl=new SoftwareListEntity();
            swl.setUsername(userService.findOneName(sw.getuId()));
            swl.setSoftwareEntity(sw);
            swlList.add(swl);
        }
        ServletActionContext.getRequest().setAttribute("swList",swlList);
        return "list";
    }

    public  String del(){
        SoftwareEntity sw=softwareService.findOne(softwareEntity);
        softwareService.del(sw);
        list();
        ServletActionContext.getRequest().setAttribute("result","true");
        return "del";
    }

    public String edit(){
        SoftwareEntity sw=softwareService.findOne(softwareEntity);
        ServletActionContext.getRequest().setAttribute("sw",sw);
        return "edit";
    }
    public String update(){
        if (softwareFileName!=null) {
            upload(software,softwareFileName);
            softwareEntity.setsSoftware(softwareFileName);
        }
        softwareService.update(softwareEntity);
        ServletActionContext.getRequest().setAttribute("result","true");

        return "edit";
    }
}
