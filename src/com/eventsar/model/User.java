package com.eventsar.model;

import java.util.*;

public class User extends AbstractPersistentObject
{
    private String _email;

    public String getEmail () { return _email; }
    public void setEmail (String email)
    {
        // TODO filter valid email addresses
        _email = email;
    }
}

