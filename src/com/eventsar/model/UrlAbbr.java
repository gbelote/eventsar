package com.eventsar.model;

import com.eventsar.util.RandomAlphanumeric;

public class UrlAbbr
{
    private String _id;
    private String _uri;

    public final static int DEFAULT_LENGTH = 10;

    public UrlAbbr ()
    {
        _id = new RandomAlphanumeric().nextString( DEFAULT_LENGTH );
    }

    public String getId () { return _id; }
    public void setId (String id) { _id = id; }

    public String getUri () { return _uri; }
    public void setUri (String uri) { _uri = uri; }

    public boolean equals (Object o)
    {
        if( o instanceof UrlAbbr )
        {
            final UrlAbbr ua = (UrlAbbr) o;
            return getId().equals(ua.getId());
        }

        return false;
    }

    public int hashCode ()
    {
        return getId().hashCode();
    }
}

