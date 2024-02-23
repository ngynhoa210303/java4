package com.fpt.poly.lab.repository;

import com.fpt.poly.lab.entity.ThucVat;
import com.fpt.poly.lab.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Queue;

public class ThucVatRepository {
    public List<ThucVat> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query qr = session.createQuery("FROM ThucVat tv", ThucVat.class);
            return qr.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ThucVat> listSearch(String ten,Integer tuoiMin,Integer tuoiMax) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query qr = session.createQuery("FROM ThucVat gv WHERE (:ten IS NULL OR LOWER(gv.ten) LIKE CONCAT('%', LOWER(:ten), '%')) AND (:tuoiMin IS NULL OR gv.tuoi >= :tuoiMin) AND (:tuoiMax IS NULL OR gv.tuoi <= :tuoiMax)");
            qr.setParameter("ten",ten);
            qr.setParameter("tuoiMin",tuoiMin);
            qr.setParameter("tuoiMax",tuoiMax);
            List<ThucVat>list=qr.getResultList();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ThucVat getOne(Long id) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query qr = session.createQuery("SELECT  tv FROM ThucVat tv where tv.id=:id", ThucVat.class);
            qr.setParameter("id", id);
            return (ThucVat) qr.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean add(ThucVat tv) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(tv);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(ThucVat tv) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(tv);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(ThucVat tv) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(tv);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ThucVatRepository().listSearch(null,12,45));
    }
}
