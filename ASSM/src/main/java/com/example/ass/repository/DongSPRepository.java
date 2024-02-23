package com.example.ass.repository;

import com.example.ass.entity.DongSP;
import com.example.ass.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class DongSPRepository {
    public List<DongSP> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query qr = session.createQuery("SELECT dsp from  DongSP dsp", DongSP.class);
            return qr.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public DongSP getOne(UUID id) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query qr = session.createQuery("SELECT dsp from  DongSP dsp where dsp.id=:id", DongSP.class);
            qr.setParameter("id", id);
            return (DongSP) qr.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean existsByMa(String ma) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query qr = session.createQuery("SELECT dsp FROM DongSP dsp WHERE dsp.ma=:ma");
            qr.setParameter("ma", ma);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean add(DongSP dsp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(dsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(DongSP dsp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(dsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(DongSP dsp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(dsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

//    public static void main(String[] args) {
//        System.out.println(new DongSPRepository().existsByMa("ha"));
////        new DongSPRepository().getAll().forEach(s -> System.out.println(s.toString()));
//    }
}
