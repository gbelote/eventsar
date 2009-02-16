package com.eventsar.model;

import java.util.*;

public class ActionKey
{
    private String _key;
    private Event _event;
    private User _user;

    public String getKey () { return _key; }
    public void setKey (String key) { _key = key; }

    public Event getEvent () { return _event; }
    public void setEvent (Event event) { _event = event; }

    public User getUser () { return _user; }
    public void setUser (User user) { _user = user; }
}

