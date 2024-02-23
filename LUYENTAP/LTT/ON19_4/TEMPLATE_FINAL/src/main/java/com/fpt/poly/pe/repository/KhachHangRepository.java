package com.fpt.poly.pe.repository;

import com.fpt.poly.pe.entity.KhachHang;
import com.fpt.poly.pe.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class KhachHangRepository {
    public List<KhachHang> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query qr = session.createQuery("select kh from KhachHang kh", KhachHang.class);
            return qr.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public KhachHang getOne(UUID id) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query qr = session.createQuery("select kh from KhachHang kh where kh.id=:id", KhachHang.class);
            qr.setParameter("id", id);
            return (KhachHang) qr.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean addKH(KhachHang kh) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(kh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean deleteKH(KhachHang kh) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(kh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new KhachHangRepository().getAll());
    }
}
