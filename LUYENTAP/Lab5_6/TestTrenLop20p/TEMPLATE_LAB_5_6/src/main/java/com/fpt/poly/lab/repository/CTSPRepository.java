package com.fpt.poly.lab.repository;

import com.fpt.poly.lab.entity.CTSP;
import com.fpt.poly.lab.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;
import java.util.Queue;

public class CTSPRepository {
    public List<CTSP> getAll(){
        try(Session sess= HibernateUtil.getFACTORY().openSession()){
            Query qr=sess.createQuery("SELECT ctsp From CTSP ctsp ", CTSP.class);
            return qr.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new CTSPRepository().getAll());
    }
}
