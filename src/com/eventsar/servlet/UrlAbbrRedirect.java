package com.eventsar.servlet;

import java.io.*;
import java.util.*;
import javax.servlet.http.*;

import org.apache.log4j.*;

import org.apache.velocity.*;
import org.apache.velocity.app.*;
import org.apache.velocity.servlet.*;
import org.apache.velocity.context.*;

import org.hibernate.*;

import com.eventsar.model.*;
import com.eventsar.util.*;

public class UrlAbbrRedirect extends HttpServlet
{
    protected final static long serialVersionUID = 1;

    public void doGet( HttpServletRequest req, HttpServletResponse res )
    {
        final Logger log = Logger.getLogger( getClass() );
        final Session ss = HibernateUtil.getSession ();

        try
        {
            ss.beginTransaction ();

            final String abbr = req.getParameter("abbr");
            final UrlAbbr ua = ( abbr == null ? null :
                    (UrlAbbr) ss.load( UrlAbbr.class, abbr ));

            if( ua == null )
            {
                res.setStatus( HttpServletResponse.SC_NOT_FOUND );
            }

            else
            {
                res.sendRedirect( ua.getUri() );
            }
        }

        catch (Exception e)
        {
            log.error( Utils.getAsString(e) );
            res.setStatus( HttpServletResponse.SC_INTERNAL_SERVER_ERROR );
        }
    }

}

