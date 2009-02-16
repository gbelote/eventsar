package com.eventsar.util;

import org.hibernate.*;
import org.hibernate.cfg.*;

public final class HibernateUtil
{
    private static SessionFactory _sessionFactory = null;

    public static synchronized SessionFactory getSessionFactory ()
    {
        if( _sessionFactory == null )
        {
            try
            {
                _sessionFactory = new Configuration().configure().buildSessionFactory();
            }

            catch (Throwable e)
            {
                System.err.println("Initial SessionFactory creation failed." + e);
                throw new ExceptionInInitializerError(e);
            }
        }

        return _sessionFactory;
    }

    public static synchronized Session getSession ()
    {
        return getSessionFactory().getCurrentSession();
    }
}

