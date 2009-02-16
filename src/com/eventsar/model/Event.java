package com.eventsar.model;

import java.util.*;

public class Event extends AbstractGuidPersistentObject
{
    /** Start date of this event. */
    private Date _startInterval;
    /** End date of this event. */
    private Date _endInterval;

    private Status _status;

    private Set _rsvps;
    private Set _details;

    private Map <String, String> _detailMap = null;


    public Date getStartInterval () { return _startInterval; }
    public void setStartInterval (Date startInterval) { _startInterval = startInterval; }

    public Date getEndInterval () { return _endInterval; }
    public void setEndInterval (Date endInterval) { _endInterval = endInterval; }

    public int getStatusEncoding () { return _status.getEncoding(); }
    public void setStatusEncoding (int encoding) { _status = Status.getStatus(encoding); }

    public Status getStatus () { return _status; }
    public void setStatus (Status status) { _status = status; }



    public Set getRsvps () { return _rsvps; }
    public void setRsvps (Set rsvps) { _rsvps = rsvps; }

    public Set getDetails () { return _details; }
    public void setDetails (Set details)
    {
        _details = details;
    }

    public String getDetail (String key)
    {
        for( Object o : _details )
        {
            final EventDetail detail = (EventDetail) o;
            if( detail.getKey().equals(key) )
            {
                return detail.getValue();
            }
        }

        return null;
    }

    public void setDetail (String key, String value)
    {
        for( Object o : _details )
        {
            final EventDetail detail = (EventDetail) o;
            if( detail.getKey().equals(key) )
            {
                detail.setValue(value);
                return;
            }
        }
    }

    public enum Status
    {
        PROPOSED (1),
        PLANNED (2),
        MARKED_FOR_DELETE (3);

        private final int _encoding;
        private final static Map <Integer, Status> _toStatus =
                new HashMap <Integer, Status> ();

        // Evaluated after construction
        static
        {
            for( Status s : values() )
            {
                if( _toStatus.containsKey( s.getEncoding() ) )
                {
                    throw new RuntimeException( "Duplicate encoding: "+s.getEncoding() );
                }

                _toStatus.put( s.getEncoding(), s );
            }
        }

        private Status (int encoding)
        {
            _encoding = encoding;
        }

        public int getEncoding ()
        {
            return _encoding;
        }

        public static Status getStatus (int encoding)
        {
            return _toStatus.get( encoding );
        }
    }
}

