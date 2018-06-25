package com.action;

import com.entity.CompetitionEntity;
import com.entity.CompetitionListEntity;
import com.entity.UserEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.CompetitionService;
import com.service.UserService;
import org.apache.struts2.ServletActionContext;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CompetitionAction extends ActionSupport implements ModelDriven<CompetitionEntity> {

    CompetitionEntity competitionEntity =new CompetitionEntity();

    public CompetitionEntity getCompetitionEntity() {
        return competitionEntity;
    }

    public void setCompetitionEntity(CompetitionEntity competitionEntity) {
        this.competitionEntity = competitionEntity;
    }

    @Override
    public CompetitionEntity getModel() {
        return competitionEntity;
    }

    private CompetitionService competitionService;

    public void setCompetitionService(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private File word;
    private String wordFileName;
    private File code;
    private String codeFileName;
    private File video;
    private String videoFileName;
    private File certificate;
    private String certificateFileName;

    public  String add(){
        if (wordFileName!=null) {
            upload(word,wordFileName);
            competitionEntity.setcWord(wordFileName);
        }
        if (codeFileName!=null){
            upload(code,codeFileName);
            competitionEntity.setcCode(codeFileName);
        }
        if(videoFileName!=null){
            upload(video,videoFileName);
            competitionEntity.setcVideo(videoFileName);
        }
        if(certificateFileName!=null){
            upload(certificate,certificateFileName);
            competitionEntity.setcCertificate(certificateFileName);
        }
        competitionService.add(competitionEntity);
        ServletActionContext.getRequest().setAttribute("result","true");
        return  "add";
    }

    public  String list(){
        UserEntity us=(UserEntity) ActionContext.getContext().getSession().get("user");
        int w_id=us.getwId();
        List<CompetitionEntity> ctList=competitionService.list(w_id);

        List<CompetitionListEntity> cpList=new ArrayList<>();
        for(CompetitionEntity ct:ctList){
            CompetitionListEntity cp=new CompetitionListEntity();
            cp.setUsername(userService.findOneName(ct.getuId()));
            cp.setCompetitionEntity(ct);
            cpList.add(cp);
        }
        ServletActionContext.getRequest().setAttribute("cpList",cpList);

        return  "list";
    }

    public  String del(){
        CompetitionEntity ct=competitionService.findOne(competitionEntity.getcId());
        competitionService.del(ct);
        list();
        ServletActionContext.getRequest().setAttribute("result","true");
        return "del";
    }
    public String edit(){
        CompetitionEntity ct=competitionService.findOne(competitionEntity.getcId());
        ServletActionContext.getRequest().setAttribute("cp",ct);
        return  "edit";
    }

    public  String update(){
        if (wordFileName!=null) {
            upload(word,wordFileName);
            competitionEntity.setcWord(wordFileName);
        }
        if (codeFileName!=null){
            upload(code,codeFileName);
            competitionEntity.setcCode(codeFileName);
        }
        if(videoFileName!=null){
            upload(video,videoFileName);
            competitionEntity.setcVideo(videoFileName);
        }
        if(certificateFileName!=null){
            upload(certificate,certificateFileName);
            competitionEntity.setcCertificate(certificateFileName);
        }
        competitionService.update(competitionEntity);
        ServletActionContext.getRequest().setAttribute("result","true");
        return "update";
    }

    public void setWord(File word) {
        this.word = word;
    }

    public void setWordFileName(String wordFileName) {
        this.wordFileName = wordFileName;
    }

    public void setCode(File code) {
        this.code = code;
    }

    public void setCodeFileName(String codeFileName) {
        this.codeFileName = codeFileName;
    }

    public void setVideo(File video) {
        this.video = video;
    }

    public void setVideoFileName(String videoFileName) {
        this.videoFileName = videoFileName;
    }

    public void setCertificate(File certificate) {
        this.certificate = certificate;
    }

    public void setCertificateFileName(String certificateFileName) {
        this.certificateFileName = certificateFileName;
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
}
