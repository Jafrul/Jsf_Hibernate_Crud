///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.islam.client.controller;
//
//import com.islam.client.formBean.Client;
//import com.islam.client.service.ClientService;
//import java.util.List;
//import javax.annotation.PostConstruct;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.RequestScoped;
//
///**
// *
// * @author gmsif
// */
//@ManagedBean(name = "World")
//@RequestScoped
//public class ClientControlar_tableM {
//
//    String massege;
//    @ManagedProperty(value = "#{userService}")
//    ClientService clientService;
//    Client model = new Client();
//    
//    public String addClient(Client client) {        
//        boolean status = clientService.addClient(client);
//        if (status) {            
//            massege = "Data is Saved..";
//            return "index.xhtml?faces-redirect=true";
//        } else {
//            massege = "Something is rong. Data isn't Saved..";
//            return "create.xhtml?faces-redirect=true";
//        }
//    }
//    
//    
//    List<Client> userList;
//    
//    @PostConstruct
//    public void init(){
//    userList=clientService.getUserList();
//    
//    }
//    
//    
//    
////    public List<Client> getUserList() {
////        return clientService.getUserList();
////    }    
//
//    public void save() {
//        
//        addClient(model);
//    }
//    
//    public void edit() {
//        clientService.edit(model.getId());
//        
//    }
//
//    public String getGenderName(char gender) {
//        if (gender == 'M') {
//            return "Male";
//        } else {
//            return "Female";
//        }
//    }
//
//    public void delete() {
//        
//        clientService.delete(model.getId());
//        
//    }
//
//    public void update(Client u) {
//        clientService.update(u);
//        
//    }
//    
//    public String getMassege() {
//        return massege;
//    }
//    
//    public void setMassege(String massege) {
//        this.massege = massege;
//    }
//    
//    public ClientService getClientService() {
//        return clientService;
//    }
//    
//    public void setClientService(ClientService clientService) {
//        this.clientService = clientService;
//    }
//    
//    public Client getModel() {
//        return model;
//    }
//    
//    public void setModel(Client model) {
//        this.model = model;
//    }
//    
//}
