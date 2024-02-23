package com.fpt.poly.lab.repository.impl;

import com.fpt.poly.lab.entity.SinhVien;
import com.fpt.poly.lab.repository.SinhVienRepository;
import com.fpt.poly.lab.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SinhVienRepositoryImpl implements SinhVienRepository {

    @Override
    public List<SinhVien> getAll() {
        List<SinhVien> lists = new ArrayList<>();
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query qr = sess.createQuery("FROM SinhVien", SinhVien.class);
            lists = qr.getResultList();
            return lists;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SinhVien getOne(UUID id) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            SinhVien sv = session.get(SinhVien.class, id);
            return sv;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean addSV(SinhVien sv) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(sv);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean removeSV(SinhVien sv) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sv);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean updateSV(SinhVien sv) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(sv);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

//    @Override
//    public List<SinhVien> listSearch(String ten) {
//        List<SinhVien> listSearch;
//        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
//            Query qr = sess.createQuery("FROM SinhVien sv where sv.ten LIKE CONCAT('%',:ten,'%') ");
//            qr.setParameter("ten", ten);
//            listSearch = qr.getResultList();
//            return listSearch;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    @Override
    public List<SinhVien> listSearch2DK(String ten, Boolean gioiTinh) {
        List<SinhVien> listSearch;
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT sv FROM SinhVien sv WHERE (:ten IS NULL OR LOWER(sv.ten) LIKE CONCAT('%',LOWER(:ten), '%')) AND (:gioiTinh IS NULL OR sv.gioiTinh = :gioiTinh)";
            Query qr = sess.createQuery(hql);
            qr.setParameter("ten", ten);
            qr.setParameter("gioiTinh",  gioiTinh);
            listSearch =qr.getResultList() ;
            return listSearch;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
//        System.out.println(new SinhVienRepositoryImpl().getAll());
//        UUID id=UUID.fromString("DA7ADD9D-9370-4CF7-B2A0-0C33A4975FF1");
//        System.out.println(new SinhVienRepositoryImpl().addSV(new SinhVien("hoa", 12L, "dsf", true)));
//        System.out.println(new SinhVienRepositoryImpl().listSearch("H"));
//        SinhVien sv = new SinhVien("ggg", 23L, "ggg", false);
//        System.out.println(new SinhVienRepositoryImpl().updateSV(sv));
        System.out.println(new SinhVienRepositoryImpl().listSearch2DK( null,null));
    }
}
