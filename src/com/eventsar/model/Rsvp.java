package com.eventsar.model;

import java.util.Set;

public class Rsvp extends AbstractGuidPersistentObject
{
    private Event _event;
    private User _user;
    private Set _timePrefs;

    public Event getEvent () { return _event; }
    public void setEvent (Event event) { _event = event; }

    public User getUser () { return _user; }
    public void setUser (User user) { _user = user; }

    public Set getTimePrefs () { return _timePrefs; }
    public void setTimePrefs (Set timePrefs) { _timePrefs = timePrefs; }
}

