/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.islam.client.service;

import com.islam.client.Repository.ClientRepository;
import com.islam.client.formBean.Client;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import model.Users;

/**
 *
 * @author bilt
 */
@ManagedBean(name = "userService")
@SessionScoped
public class ClientService {

    @ManagedProperty(value = "#{clientRepository}")
    ClientRepository clientRepository;

  

    public boolean addClient(Users users) {

        boolean status = clientRepository.addClient(users);
        return status;

    }

    public void edit(Users id) {
        clientRepository.edit(id);
    }

    public void update(Users u) {
        clientRepository.update(u);

    }

    public void delete(Users id1) {
        clientRepository.delete(id1);

    }

//    public List<REgistrationForm> getEmployees() {
//        List<REgistrationForm> clientList = clientRepository.getEmployees();
//        return empList;
//    }
    public ClientRepository getClientRepository() {
        return clientRepository;
    }

    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Users> getUserList() {
        return clientRepository.usersList();
    }

}
