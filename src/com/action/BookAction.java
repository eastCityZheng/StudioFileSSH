package com.action;

import com.entity.BookEntity;
import com.entity.BookListEntity;
import com.entity.UserEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.BookService;
import com.service.UserService;
import org.apache.struts2.ServletActionContext;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceConfigurationError;

public class BookAction extends ActionSupport implements ModelDriven<BookEntity> {

    BookEntity bookEntity=new BookEntity();

    public BookEntity getBookEntity() {
        return bookEntity;
    }

    public void setBookEntity(BookEntity bookEntity) {
        this.bookEntity = bookEntity;
    }

    @Override
    public BookEntity getModel() {
        return bookEntity;
    }

    private BookService bookService;

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String add(){
        UserEntity bk=(UserEntity)ActionContext.getContext().getSession().get("user");
        bookEntity.setwId(bk.getwId());
        bookService.add(bookEntity);
        ServletActionContext.getRequest().setAttribute("result","true");
        return "add";
    }
    public  String list(){
        listm();
        return "list";
    }
    public  String listm(){
        UserEntity us=(UserEntity) ActionContext.getContext().getSession().get("user");
        int w_id=us.getwId();
        List<BookEntity> bkList=bookService.list(w_id);
        List<BookListEntity> bklList=new ArrayList<>();
        for (BookEntity bk:bkList){
            BookListEntity bkl=new BookListEntity();
            bkl.setBookEntity(bk);
            bkl.setUsername(userService.findOneName(bk.getuId()));
            bklList.add(bkl);
        }
        ServletActionContext.getRequest().setAttribute("bkList",bklList);
        return "listm";
    }
    public  String edit(){
        BookEntity bk=bookService.findOne(bookEntity.getbId());
        ServletActionContext.getRequest().setAttribute("bk",bk);
        return "edit";
    }
    public  String update(){
        BookEntity bk=bookService.findOne(bookEntity.getbId());
        bookEntity.setwId(bk.getwId());
        bookEntity.setuId(bk.getuId());
        bookService.update(bookEntity);
        ServletActionContext.getRequest().setAttribute("result","true");
        return "edit";
    }
    public  String status(){
        BookEntity bk=bookService.findOne(bookEntity.getbId());
        bk.setbStatus(bookEntity.getbStatus());
        bookService.status(bk);
        listm();
        ServletActionContext.getRequest().setAttribute("result","true");
        return "list";
    }

    public String del(){
        BookEntity bk=bookService.findOne(bookEntity.getbId());
        bookService.del(bk);
        listm();
        ServletActionContext.getRequest().setAttribute("result","true");
        return  "listm";
    }
}
