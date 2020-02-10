/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.islam.client.controller;

import com.islam.client.service.ClientService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import model.Users;

/**
 *
 * @author gmsif
 */
@ManagedBean(name = "world")
@RequestScoped
public class ClientControlar {

    @ManagedProperty(value = "#{userService}")
    ClientService clientService;
    Users model = new Users();
    String massege;
    List<Users> userList;
    public List<Users> getUserList() {
        return userList;
    }

    public void setUserList(List<Users> userList) {
        this.userList = userList;
    }

    

    public boolean addClient(Users users) {
        boolean status = clientService.addClient(users);
//        if (status) {
//            massege = "Data is Saved..";
//            return "index.xhtml?faces-redirect=true";
//        } else {
//            massege = "Something is rong. Data isn't Saved..";
//            return "create.xhtml?faces-redirect=true";
//        }
return status;
    }

   
    

    @PostConstruct
    public void init() {
        userList = clientService.getUserList();

    }

//    public List<Client> getUserList() {
//        return clientService.getUserList();
//    }    
    public String save() {

       boolean status =  addClient(model);
       if (status) {
            massege = "Data is Saved..";
            return "index.xhtml?faces-redirect=true";
        } else {
            massege = "Something is rong. Data isn't Saved..";
            return "create.xhtml?faces-redirect=true";
        }
    }

    public String edit(Users u) {
        clientService.edit(u);
        return "/edit.xhtml?faces-redirect=true";
    }

    public String getGenderName(char gender) {
        if (gender == 'M') {
            return "Male";
        } else {
            return "Female";
        }
    }

    public String delete(Users id) {

        clientService.delete(id);
return "/index.xhtml?faces-redirect=true";
    }

    public String update(Users u) {
        clientService.update(u);
        return "/index.xhtml?faces-redirect=true";

    }

    public String getMassege() {
        return massege;
    }

    public void setMassege(String massege) {
        this.massege = massege;
    }

    public ClientService getClientService() {
        return clientService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public Users getModel() {
        return model;
    }

    public void setModel(Users model) {
        this.model = model;
    }

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    

}
