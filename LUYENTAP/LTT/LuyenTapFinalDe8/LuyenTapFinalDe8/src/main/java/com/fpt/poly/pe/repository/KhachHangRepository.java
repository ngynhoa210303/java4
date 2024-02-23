package com.fpt.poly.pe.repository;

import com.fpt.poly.pe.entity.KhachHang;
import com.fpt.poly.pe.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class KhachHangRepository {
    public List<KhachHang> getAll(){
        List<KhachHang> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("FROM KhachHang ", KhachHang.class);
            list = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public KhachHang getOne(String ma){
        KhachHang khachHang = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("SELECT KH FROM KhachHang KH WHERE KH.ma =: Ma1", KhachHang.class);
            query.setParameter("Ma1", ma);
            khachHang = (KhachHang) query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return khachHang;
    }

    public Boolean add(KhachHang khachHang){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
          transaction = session.beginTransaction();
          session.persist(khachHang);
          transaction.commit();
          return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(KhachHang khachHang){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.merge(khachHang);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(KhachHang khachHang){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(khachHang);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new KhachHangRepository().delete(new KhachHangRepository().getOne("ivMOV+9")));
    }
}
