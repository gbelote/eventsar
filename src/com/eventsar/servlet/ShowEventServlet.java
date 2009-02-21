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

public class ShowEventServlet extends HttpServlet
{
    protected final static long serialVersionUID = 1;

    public void doGet( HttpServletRequest req, HttpServletResponse res )
    {
        final Logger log = Logger.getLogger( ShowEventServlet.class );
        final Session ss = HibernateUtil.getSession ();
        String sTemplate = "show.vm";

        try
        {
            res.setContentType( "text/html" );
            final PrintWriter out = res.getWriter ();

            final VelocityContext ctx = new VelocityContext();
            ss.beginTransaction();

            final String eventId = req.getParameter("id");
            ctx.put("eventId", eventId);

            final Event event;
            if( eventId == null )
            {
                event = null;
            }
            else
            {
                event = (Event) ss.load(Event.class, eventId);
            }

            ctx.put("event", event);

            final VelocityEngine ve = VelocityUtil.getEngine ();
            ve.mergeTemplate( sTemplate, ctx, out );
            ss.getTransaction().commit();
        }

        catch( Exception e )
        {
            log.error( Utils.getAsString(e) );
        }
    }
}

