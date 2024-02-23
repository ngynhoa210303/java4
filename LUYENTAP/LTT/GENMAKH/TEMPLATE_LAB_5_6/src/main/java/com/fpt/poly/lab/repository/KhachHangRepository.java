package com.fpt.poly.lab.repository;

import com.fpt.poly.lab.entity.KhachHang;
import com.fpt.poly.lab.util.HibernateUtil;
import jakarta.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class KhachHangRepository {
    public List<KhachHang> getAll(){
        List<KhachHang> listkh = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            Query query = session.createQuery("from KhachHang ", KhachHang.class);
            listkh = query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listkh;
    }

    public KhachHang getOne(UUID id){
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            KhachHang kh = session.get(KhachHang.class,id);
            return kh;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Boolean add(KhachHang kh){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(kh);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(KhachHang kh){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.merge(kh);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return  false;
    }

    public Boolean delete(KhachHang kh){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(kh);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public List<KhachHang> search(String ten) {
        List<KhachHang> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT kh FROM KhachHang kh WHERE kh.ten like :ten ";
            Query query = session.createQuery(hql);
            query.setParameter("ten", "%" + ten + "%");
            list = query.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    public int genMaKhachHang() {
        String maStr = "";
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            String nativeQuery = "SELECT MAX(CONVERT(INT, SUBSTRING(ma,3,10))) from KhachHang";
            NativeQuery query = session.createNativeQuery(nativeQuery);
            if (query.getSingleResult() != null) {
                maStr = query.getSingleResult().toString();
            } else {
                maStr = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (maStr == null) {
            maStr = "0";
            int ma = Integer.parseInt(maStr);
            return ++ma;
        }
        int ma = Integer.parseInt(maStr);
        return ++ma;
    }
    public static void main(String[] args) {

    }
}
