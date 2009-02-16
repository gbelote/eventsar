package com.eventsar.util;

import java.io.*;

public final class Utils
{
    public static String getAsString( Throwable t )
    {
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw);

        t.printStackTrace( pw );
        pw.flush ();

        final String result = sw.toString ();

        return result;
    }
}

