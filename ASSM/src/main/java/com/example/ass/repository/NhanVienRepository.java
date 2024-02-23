package com.example.ass.repository;

import com.example.ass.entity.NhanVien;
import com.example.ass.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class NhanVienRepository {
    public List<NhanVien> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query qr = session.createQuery("SELECT nv from  NhanVien nv", NhanVien.class);
            return qr.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public NhanVien getOne(UUID id) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query qr = session.createQuery("SELECT nv from  NhanVien nv where nv.id=:id", NhanVien.class);
            qr.setParameter("id", id);
            return (NhanVien) qr.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean add(NhanVien nv) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(nv);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(NhanVien nv) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(nv);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(NhanVien nv) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nv);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
