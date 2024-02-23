package com.example.btvn8.repository.impl;

import com.example.btvn8.entity.GiangVien;
import com.example.btvn8.repository.IGiangVienRepository;
import com.example.btvn8.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.ArrayList;
import java.util.List;

public class GiangVienRepository implements IGiangVienRepository {
    @Override
    public List<GiangVien> getAll() {
        List<GiangVien> lists = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query qr = session.createQuery("FROM GiangVien", GiangVien.class);
            lists = qr.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    @Override
    public GiangVien getOne(String id) {
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            GiangVien gv = sess.get(GiangVien.class, id);
            return gv;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public Boolean addGV(GiangVien gv) {
        Transaction tran = null;
        try (Session ses = HibernateUtil.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            ses.persist(gv);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean updateGV(GiangVien gv) {
        Transaction tran = null;
        try (Session ses = HibernateUtil.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            ses.merge(gv);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delGV(GiangVien gv) {
        Transaction tran = null;
        try (Session ses = HibernateUtil.getFACTORY().openSession()) {
            tran = ses.beginTransaction();
            ses.delete(gv);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<GiangVien> listSearch(String ten, Long tuoiMin, Long tuoiMax) {
        List<GiangVien> list = null;
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query qr = sess.createQuery("FROM GiangVien gv WHERE (:ten IS NULL OR LOWER(gv.ten) LIKE CONCAT('%', LOWER(:ten), '%')) AND (:tuoiMin IS NULL OR gv.tuoi >= :tuoiMin) AND (:tuoiMax IS NULL OR gv.tuoi <= :tuoiMax)");
            qr.setParameter("ten", ten);
            qr.setParameter("tuoiMin", tuoiMin);
            qr.setParameter("tuoiMax", tuoiMax);
            list = qr.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
//        System.out.println(new GiangVienRepository().getAll());
//        GiangVien gv=new GiangVienRepository().getOne("HangNT169b");
        System.out.println(new GiangVienRepository().listSearch(null,1L,20L));
    }
}
