package com.action;

import com.entity.ProjectListEntity;
import com.entity.ProjectfileEntity;
import com.entity.UserEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.ProjectService;
import com.service.UserService;
import org.apache.struts2.ServletActionContext;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ProjectAction extends ActionSupport implements ModelDriven<ProjectfileEntity> {

    ProjectfileEntity projectfileEntity =new ProjectfileEntity();

    private File word;
    private String wordFileName;
    private File code;
    private String codeFileName;
    private File video;
    private String videoFileName;

    @Override
    public ProjectfileEntity getModel() {
        return projectfileEntity;
    }

    private ProjectService projectService;

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public ProjectfileEntity getProjectfileEntity() {
        return projectfileEntity;
    }

    public void setProjectfileEntity(ProjectfileEntity projectfileEntity) {
        this.projectfileEntity = projectfileEntity;
    }

    public String add (){


        if(wordFileName!=null){
            upload(word,wordFileName);
            projectfileEntity.setpWord(wordFileName);
        }
        if (codeFileName!=null){
            upload(code,codeFileName);
            projectfileEntity.setpCode(codeFileName);
        }
        if(videoFileName!=null){
            upload(video,videoFileName);
            projectfileEntity.setpVideo(videoFileName);
        }
        projectService.add(projectfileEntity);
        ServletActionContext.getRequest().setAttribute("result","true");
        return "add";
    }

    public  String  list(){
        UserEntity us=(UserEntity) ActionContext.getContext().getSession().get("user");
        int w_id=us.getwId();
        List<ProjectfileEntity> list=projectService.list(w_id);

        List<ProjectListEntity> plList=new ArrayList<>();
        for (ProjectfileEntity  pf:list){
            ProjectListEntity pl=new ProjectListEntity();
            pl.setUsername(userService.findOneName(pf.getuId()));
            pl.setProjectfileEntity(pf);
            plList.add(pl);
        }
        ServletActionContext.getRequest().setAttribute("list",plList);
        return "list";
    }

    public String del(){
        ProjectfileEntity pf=projectService.findOne(projectfileEntity.getpId());
        projectService.del(pf);
        list();
        ServletActionContext.getRequest().setAttribute("result","true");
        return "del";
    }
    public  String edit(){
        ProjectfileEntity pf=projectService.findOne(projectfileEntity.getpId());
        ServletActionContext.getRequest().setAttribute("pf",pf);
        return "edit";
    }

    public  String update(){
        if(wordFileName!=null){
            upload(word,wordFileName);
            projectfileEntity.setpWord(wordFileName);
        }
        if (codeFileName!=null){
            upload(code,codeFileName);
            projectfileEntity.setpCode(codeFileName);
        }
        if(videoFileName!=null){
            upload(video,videoFileName);
            projectfileEntity.setpVideo(videoFileName);
        }
        projectService.update(projectfileEntity);
        ServletActionContext.getRequest().setAttribute("result","true");
        return "edit";
    }


    public File getWordFile() {
        return word;
    }

    public String getWordFileName() {
        return wordFileName;
    }

    public void setWordFileName(String wordFileName) {
        this.wordFileName = wordFileName;
    }

    public String getCodeFileName() {
        return codeFileName;
    }

    public void setCodeFileName(String codeFileName) {
        this.codeFileName = codeFileName;
    }


    public String getVideoFileName() {
        return videoFileName;
    }

    public void setVideoFileName(String videoFileName) {
        this.videoFileName = videoFileName;
    }

    public File getWord() {
        return word;
    }

    public void setWord(File word) {
        this.word = word;
    }

    public File getCode() {
        return code;
    }

    public void setCode(File code) {
        this.code = code;
    }

    public File getVideo() {
        return video;
    }

    public void setVideo(File video) {
        this.video = video;
    }

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
}
