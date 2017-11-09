package com.nlp.test.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import com.nlp.test.entity.CountPOSTag;
import com.nlp.persistence.HibernateUtil;

public class CountPOSTagDAO {

    public CountPOSTagDAO(){

    }
    public static CountPOSTag getCountPOSTag(int id){
        CountPOSTag countPOSTag = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            countPOSTag = (CountPOSTag) session.load(CountPOSTag.class, id);
            session.flush();
            Hibernate.initialize(countPOSTag);
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return countPOSTag;
    }
    public static void addCountPOSTag(CountPOSTag countPOSTag){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(countPOSTag);
            session.flush();
            session.getTransaction().commit();

            System.out.println("countPOSTag"+countPOSTag.getId()+" agregado.");
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
