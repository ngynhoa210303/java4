package com.fpt.poly.pe.repository;

import com.fpt.poly.pe.entity.ChucVu;
import com.fpt.poly.pe.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;
import java.util.UUID;

public class ChucVuRepository {
    public List<ChucVu> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query qr = session.createQuery("SELECT nv FROM ChucVu nv", ChucVu.class);
            return qr.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ChucVu getOne(UUID id) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query qr = session.createQuery("SELECT nv FROM ChucVu nv where nv.id=:id", ChucVu.class);
            qr.setParameter("id", id);
            return (ChucVu) qr.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
