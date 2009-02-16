package com.eventsar.util;

import org.apache.log4j.*;
import org.apache.velocity.app.*;
import org.apache.velocity.runtime.*;

public final class VelocityUtil
{
    private static VelocityEngine s_engineInstance = null;

    private VelocityUtil () { } // non-instantiable

    public static void init( String sFileRoot )
    {
        final Logger log = Logger.getLogger( VelocityUtil.class );

        s_engineInstance = new VelocityEngine ();

        s_engineInstance.setProperty( RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS,
                "org.apache.s_engineInstancelocity.runtime.log.Log4JLogChute");
        s_engineInstance.setProperty( "runtime.log.logsystem.log4j.logger", "R" );

        final String sVelocityPath = sFileRoot + "velocity";

        log.info("Velocity template path: " + sVelocityPath);
        s_engineInstance.setProperty( "file.resource.loader.path", sVelocityPath );
        s_engineInstance.setProperty( "file.resource.loader.cache", false );

        try
        {
            s_engineInstance.init();
        }

        catch (Exception e)
        {
            log.error( Utils.getAsString(e) );
        }
    }

    // Synchronized to handle race condition during initialization
    public static synchronized VelocityEngine getEngine()
    {
        return s_engineInstance;
    }
}

