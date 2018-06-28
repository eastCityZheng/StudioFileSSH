package com.action;


import com.entity.WorkroomEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.WorkroomService;
import org.apache.struts2.ServletActionContext;

import java.util.List;

public class WorkroomAction extends ActionSupport implements ModelDriven<WorkroomEntity> {

    WorkroomEntity workroomEntity=new WorkroomEntity();

    public WorkroomEntity getWorkroomEntity() {
        return workroomEntity;
    }

    public void setWorkroomEntity(WorkroomEntity workroomEntity) {
        this.workroomEntity = workroomEntity;
    }

    @Override
    public WorkroomEntity getModel() {
        return workroomEntity;
    }

    private WorkroomService workroomService;
    public void setWorkroomService(WorkroomService workroomService) {
        this.workroomService = workroomService;
    }

    public String  add(){

        workroomService.add(workroomEntity);
        ServletActionContext.getRequest().setAttribute("result","true");
        return "add";
    }

    public   String  list(){
        List<WorkroomEntity> weList=workroomService.getList();
        ServletActionContext.getRequest().setAttribute("workroom",weList);
        return "list";
    }
    public  String listm(){
        list();
        return  "listm";
    }

    public  String del(){
        WorkroomEntity wr = workroomService.findOne(workroomEntity.getwId());
        workroomService.del(wr);
        listm();
        ServletActionContext.getRequest().setAttribute("result","true");
        return "listm";
    }
    public String edit(){
        WorkroomEntity wr=workroomService.findOne(workroomEntity.getwId());
        ServletActionContext.getRequest().setAttribute("wr",wr);
        return  "edit";
    }
    public String update(){
        workroomService.update(workroomEntity);
        ServletActionContext.getRequest().setAttribute("result","true");
        return "edit";
    }

    public String teaadd(){
        list();
        return "teaadd";
    }

}
