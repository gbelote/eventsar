package com.eventsar.model;

import java.io.Serializable;

public class EventDetail extends AbstractPersistentObject
{
    private Event _event;
    private String _key;
    private String _value;

    public Event getEvent () { return _event; }
    public void setEvent (Event event) { _event = event; }

    public String getKey () { return _key; }
    public void setKey (String key) { _key = key; }

    public String getValue () { return _value; }
    public void setValue (String value) { _value = value; }
}

