package com.example.btvn9.repository.impl;

import com.example.btvn9.entity.TaiKhoan;
import com.example.btvn9.repository.IUserRepository;
import com.example.btvn9.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserRepository implements IUserRepository {
    @Override
    public TaiKhoan checkTonTai(String userName, String password) {
        try(Session sess= HibernateUtil.getFACTORY().openSession()){
            Transaction tran=sess.beginTransaction();
            String hql="FROM TaiKhoan u WHERE u.username = :username AND u.password = :password";
            Query query=sess.createQuery(hql);
            query.setParameter("username",userName);
            query.setParameter("password",password);
            TaiKhoan tk=(TaiKhoan) query.getSingleResult();
            tran.commit();
            return tk;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new UserRepository().checkTonTai("hoant210303","12345"));
    }
}
