package com.eventsar.model;

import java.io.Serializable;

public class EventDetail extends AbstractGuidPersistentObject
{
    private Event _event;
    private String _name;
    private String _value;

    public Event getEvent () { return _event; }
    public void setEvent (Event event) { _event = event; }

    public String getName () { return _name; }
    public void setName (String name) { _name = name; }

    public String getValue () { return _value; }
    public void setValue (String value) { _value = value; }
}

