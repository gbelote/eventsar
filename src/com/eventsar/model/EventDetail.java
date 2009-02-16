package com.eventsar.model;

import java.io.Serializable;

public class EventDetail implements Serializable
{
    private Event _eventId;
    private String _key;
    private String _value;

    public Event getEvent () { return _eventId; }
    public void setEvent (Event eventId) { _eventId = eventId; }

    public String getKey () { return _key; }
    public void setKey (String key) { _key = key; }

    public String getValue () { return _value; }
    public void setValue (String value) { _value = value; }

    public boolean equals (Object o)
    {
        if( o instanceof EventDetail )
        {
            final EventDetail detail = (EventDetail) o;

            return getEvent().equals(detail.getEvent()) &&
                   getKey().equals(detail.getKey());
        }

        return false;
    }

    public int hashCode ()
    {
        return getEvent().hashCode() * 7 + getKey().hashCode() * 23;
    }
}

