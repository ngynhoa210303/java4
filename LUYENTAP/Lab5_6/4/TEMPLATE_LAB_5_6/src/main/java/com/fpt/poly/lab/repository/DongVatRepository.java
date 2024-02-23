package com.fpt.poly.lab.repository;

import com.fpt.poly.lab.entity.DongVat;
import com.fpt.poly.lab.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class DongVatRepository {
    public List<DongVat> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query qr = session.createQuery("FROM DongVat", DongVat.class);
            return qr.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public DongVat getOne(UUID id) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query qr = session.createQuery("SELECT dv FROM DongVat dv where dv.ma=:ma", DongVat.class);
            qr.setParameter("ma", id);
            return (DongVat) qr.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean add(DongVat dv) {
        Transaction tran = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.persist(dv);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(DongVat mt) {
        Transaction tran = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.merge(mt);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(DongVat mt) {
        Transaction tran = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            tran = session.beginTransaction();
            session.delete(mt);
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

//    public static void main(String[] args) {
//        System.out.println(new DongVatRepository().searchGiamTheoGiaHoacHangBangCBB("Bộ nhớ"));
//    }
}
