package com.fpt.poly.pe.repository;

import com.fpt.poly.pe.entity.NhanVien;
import com.fpt.poly.pe.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
//import org.hibernate.query.Query;
import org.hibernate.Transaction;

import java.util.List;
import java.util.UUID;

public class NhanVienRepository {
    public List<NhanVien> getAll() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query qr = session.createQuery("SELECT nv from NhanVien  nv", NhanVien.class);
            return qr.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public NhanVien getOne(UUID id) {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query qr = session.createQuery("SELECT nv FROM NhanVien  nv where nv.id=:id ", NhanVien.class);
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

    public String genMaNV() {
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            String nativeQuery = "SELECT 'NV' + CAST(COALESCE(MAX(CAST(SUBSTRING(ma, 3) AS int)), 0) + 1 AS VARCHAR(10)) FROM NhanVien";
            return (String) session.createNativeQuery(nativeQuery).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return "Haha";
        }
    }
//    public String genMaKhachHang() {
//        try (Session session = HibernateUtil.getFACTORY().openSession()) {
//            String nativeQuery = "SELECT 'KH' + CAST(coalesce(MAX(CONVERT(INT, SUBSTRING(ma, 3, 10))), 0) + 1 AS VARCHAR(10)) FROM KhachHang";
//            return (String) session.createNativeQuery(nativeQuery).getSingleResult();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    public static void main(String[] args) {
//        NhanVien nv= new NhanVienRepository().getOne(UUID.fromString("95B89BDA-6FE0-4150-BCD7-4CA2F7C927D3"));
        System.out.println(new NhanVienRepository().genMaNV());
    }
}
