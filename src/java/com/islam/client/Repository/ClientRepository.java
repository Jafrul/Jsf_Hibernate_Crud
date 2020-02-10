/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.islam.client.Repository;

import com.islam.client.jdbcutill.DBConnection;
import hibernateConfig.NewHibernateUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author gmsif
 */
@ManagedBean(name = "clientRepository")
@ApplicationScoped
public class ClientRepository {

    List<Users> usersList;

    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    Connection connection;

    public boolean addClient(Users users) {

        Transaction tx = null;

        try {
            Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            session.merge(users);
            tx.commit();
            return true;

        } catch (Exception e) {

            e.printStackTrace();
            try {
                tx.rollback();
            } catch (Exception ee) {
            }
        } finally {
        }
        return false;
    }

    public List<Users> usersList() {
        List<Users> list = null;
        Transaction tx = null;

        try {
            Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            Query q = session.createQuery("select b from Users b");
            list = q.list();
            tx.commit();
        } catch (Exception e) {

            e.printStackTrace();
            try {
                
                // tx.rollback();
            } catch (Exception ee) {
            }
        } finally {
        }
        return list;
    }


   public void edit(Users id) {
        sessionMap.put("editUser", id);
    }

    

    public void update(Users u) {
        Transaction tx = null;
        try {
            Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            session.update(u);
            tx.commit();
        } catch (Exception e) {
            System.out.println("#########" + e);
            e.printStackTrace();
            try {
                tx.rollback();
            } catch (Exception ee) {
            }
        } finally {
        }
    }

   public void delete(Users id) {
        Transaction tx = null;
        try {
            Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            session.delete(id);
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                tx.rollback();
            } catch (Exception ex) {
            }
        } finally {
        }

    }
        


    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(ArrayList usersList) {
        this.usersList = usersList;
    }

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
