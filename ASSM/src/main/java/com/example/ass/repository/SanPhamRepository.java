package com.example.ass.repository;

import com.example.ass.entity.SanPham;
import com.example.ass.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;
import java.util.UUID;

public class SanPhamRepository {
    public List<SanPham> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query qr = session.createQuery("SELECT ch from  SanPham ch", SanPham.class);
            return qr.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public SanPham getOne(UUID id) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query qr = session.createQuery("SELECT ch from  SanPham ch where ch.id=:id", SanPham.class);
            qr.setParameter("id", id);
            return (SanPham) qr.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean add(SanPham ch) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(ch);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(SanPham ch) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(ch);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(SanPham ch) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(ch);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    //    public int genMaKhachHang() {
//        String maStr = "";
//        try(Session session = HibernateUtil.getFACTORY().openSession()) {
//            String nativeQuery = "SELECT MAX(CONVERT(INT, SUBSTRING(ma,3,10))) from KhachHang";
//            NativeQuery query = session.createNativeQuery(nativeQuery);
//            if (query.getSingleResult() != null) {
//                maStr = query.getSingleResult().toString();
//            } else {
//                maStr = null;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (maStr == null) {
//            maStr = "0";
//            int ma = Integer.parseInt(maStr);
//            return ++ma;
//        }
//        int ma = Integer.parseInt(maStr);
//        return ++ma;
//    }
}
