package com.example.ass.repository;

import com.example.ass.entity.ChiTietSP;
import com.example.ass.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class ChiTietSPRepository {
    public List<ChiTietSP> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
//            Query qr = session.createQuery("SELECT new com.example.ass.entity.ChiTietSP(ctsp.id,ctsp.idSP,ctsp.idNSX,ctsp.idMauSac,ctsp.idDongSP,ctsp.namBH,ctsp.moTa,ctsp.soLuongTon,ctsp.giaNhap,ctsp.giaBan)  from  ChiTietSP ctsp", ChiTietSP.class);
            Query qr = session.createQuery("SELECT ctsp from  ChiTietSP ctsp", ChiTietSP.class);
            return qr.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ChiTietSP getOne(UUID id) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query qr = session.createQuery("SELECT ctsp from  ChiTietSP ctsp where ctsp.id=:id", ChiTietSP.class);
            qr.setParameter("id", id);
            return (ChiTietSP) qr.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean add(ChiTietSP ctsp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(ctsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean update(ChiTietSP ctsp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(ctsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(ChiTietSP ctsp) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(ctsp);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
//    public static void main(String[] args) {
//        System.out.println(new ChiTietSPRepository().getAll());
//    }
}
