package com.example.ass.util;

import com.example.ass.entity.ChiTietSP;
import com.example.ass.entity.ChucVu;
import com.example.ass.entity.CuaHang;
import com.example.ass.entity.DongSP;
import com.example.ass.entity.KhachHang;
import com.example.ass.entity.MauSac;
import com.example.ass.entity.NhaSanXuat;
import com.example.ass.entity.NhanVien;
import com.example.ass.entity.SanPham;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import java.util.Properties;
public class HibernateUtil {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123456");
        properties.put(Environment.SHOW_SQL, "true");

        conf.setProperties(properties);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(CuaHang.class);
        conf.addAnnotatedClass(DongSP.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(NhaSanXuat.class);
        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(ChiTietSP.class);


        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
    public static void main(String[] args) {
        System.out.println(getFACTORY());
    }
}
