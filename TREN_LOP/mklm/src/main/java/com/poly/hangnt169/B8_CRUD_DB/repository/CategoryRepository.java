package com.poly.hangnt169.B8_CRUD_DB.repository;

import com.poly.hangnt169.B8_CRUD_DB.entity.Category;
import com.poly.hangnt169.B8_CRUD_DB.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
//    CRUD <=> Creat Read Update Delete
    //GET ALL <=> READ

    public List<Category> getAll() {
        List<Category> lists = new ArrayList<>();
        //CODE
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            Query query = sess.createQuery("FROM Category ", Category.class);
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    public Category getOne(Long id) {
        Category category = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("FROM Category WHERE id=:id1 ", Category.class);
            query.setParameter("id1", id);
            category = (Category) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }

    //add INSERT INTO
    public boolean add(Category cate) {
        Transaction tran = null;
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            //Mo tran
            tran = sess.beginTransaction();
            //Add 1 doi tuong
            sess.persist(cate);
            //Commit
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Category cate) {
        Transaction tran = null;
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            //Mo tran
            tran = sess.beginTransaction();
            //Add 1 doi tuong
            sess.merge(cate);
            //Commit
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(Category cate) {
        Transaction tran = null;
        try (Session sess = HibernateUtil.getFACTORY().openSession()) {
            //Mo tran
            tran = sess.beginTransaction();
            //Add 1 doi tuong
            sess.delete(cate);
            //Commit
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new CategoryRepository().getOne(1L));
    }
}
