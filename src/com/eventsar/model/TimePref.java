package com.eventsar.model;

import java.util.*;

public class TimePref extends AbstractGuidPersistentObject
{
    private Date _startInterval;
    private Date _endInterval;

    // TODO: implement type enum

    public Date getStartInterval () { return _startInterval; }
    public void setStartInterval (Date startInterval) { _startInterval = startInterval; }

    public Date getEndInterval () { return _endInterval; }
    public void setEndInterval (Date endInterval) { _endInterval = endInterval; }

    // TODO: implement type enum
    public int getPrefEncoding () { return -1; }
    public void setPrefEncoding (int prefEncoding) { }
}

