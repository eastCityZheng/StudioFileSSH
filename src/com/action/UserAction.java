package com.action;

import com.entity.UserEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.UserService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.Servlet;
import java.util.List;

/**
 * 用户管理的Action类
 */
public class UserAction extends ActionSupport implements  ModelDriven<UserEntity>{
    //模型驱动使用的对象
    private UserEntity user=new UserEntity();

    @Override
    public UserEntity getModel() {
        return user;
    }

    //注入业务层的类
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    public String login(){
        System.out.println("login使用了!");
        UserEntity  us= userService.login(user);
        if(user.getuAccount().equals("admin")&&user.getuPassword().equals("123")){
            return "admin";
        }else {
            if(us ==null){
                //登录失败
                ServletActionContext.getRequest().setAttribute("result","false");
            }else
            {
                ServletActionContext.getRequest().setAttribute("result","true");
                ActionContext.getContext().getSession().put("user",us);
            }
        }
        return SUCCESS;
    }
    //添加用户
    public String add(){
        List<UserEntity> us=userService.findOne(user.getuAccount());
        System.out.println(us.size());
        if(us.size()==0){
            userService.add(user);
            ServletActionContext.getRequest().setAttribute("result","true");
        }
        else{
            ServletActionContext.getRequest().setAttribute("result","again");
        }
        return "add";
    }

    public String list(){
        UserEntity us=(UserEntity) ActionContext.getContext().getSession().get("user");
        int w_id=us.getwId();

        List<UserEntity> usList=this.userService.findAll(w_id);
        ServletActionContext.getRequest().setAttribute("usList",usList);
        return "list";
    }

    public  String del(){
        UserEntity us=userService.findOneById(user.getuId());
        userService.del(us);
        list();
        ServletActionContext.getRequest().setAttribute("result","true");
        return "del";
    }
    public  String edit(){
        UserEntity us=userService.findOneById(user.getuId());
        ServletActionContext.getRequest().setAttribute("us",us);
        return "edit";
    }

    public  String update(){
        UserEntity us=userService.findOneById(user.getuId());
        user.setuPassword(us.getuPassword());
        user.setwId(us.getwId());
        user.setuType(us.getuType());

        userService.update(user);
        ServletActionContext.getRequest().setAttribute("result","true");
        return "edit";
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

}
