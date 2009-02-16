package com.eventsar.model;

import com.eventsar.util.RandomGUID;

public class AbstractGuidPersistentObject
{
    /** Unique GUID of this object. */
    private String _id;

    public String getId () { return _id; }
    public void setId (String id) { _id = id; }

    public AbstractGuidPersistentObject ()
    {
        // default to create a new one
        setId( new RandomGUID().toString() );
    }

    /**
     * @requires this.id is non-null.
     */
    public boolean equals (Object o)
    {
        if( o instanceof AbstractGuidPersistentObject )
        {
            final AbstractGuidPersistentObject apo = (AbstractGuidPersistentObject) o;

            // This works across classes because we can assume the GUID is
            // sufficiently unique
            return getId().equals( apo.getId() );
        }

        return false;
    }

    /**
     * @requires this.id is non-null.
     */
    public int hashCode ()
    {
        return getId().hashCode();
    }
}

