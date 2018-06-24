package com.action;


import com.entity.WorkroomEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.service.WorkroomService;
import org.apache.struts2.ServletActionContext;

import java.util.List;

public class WorkroomAction extends ActionSupport {

    private WorkroomService workroomService;
    public void setWorkroomService(WorkroomService workroomService) {
        this.workroomService = workroomService;
    }

    public   String  list(){
        List<WorkroomEntity> weList=workroomService.getList();
        ServletActionContext.getRequest().setAttribute("workroom",weList);
        return "list";
    }
}
