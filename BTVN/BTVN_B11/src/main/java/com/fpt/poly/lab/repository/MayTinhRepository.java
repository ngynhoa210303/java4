package com.fpt.poly.lab.repository;

import com.fpt.poly.lab.entity.MayTinh;
import com.fpt.poly.lab.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MayTinhRepository {
    private final String FROM = "FROM MayTinh ";

    public List<MayTinh> getMayTinhList() {
        List<MayTinh> mayTinhs = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(FROM, MayTinh.class);
            mayTinhs = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mayTinhs;
    }

    public List<MayTinh> getMayTinhListSort(String value) {
        List<MayTinh> mayTinhs = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(FROM + "ORDER BY " + value + " DESC", MayTinh.class);
            mayTinhs = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mayTinhs;
    }

    public MayTinh getMayTinh(UUID ma) {
        MayTinh mayTinh = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(FROM + "WHERE ma = :ma", MayTinh.class);
            query.setParameter("ma", ma);
            mayTinh = (MayTinh) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mayTinh;
    }

    public Boolean saveOrUpdate(MayTinh mayTinh) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(mayTinh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(MayTinh mayTinh) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(mayTinh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
