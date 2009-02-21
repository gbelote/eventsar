package com.eventsar.util;

import java.util.*;
import java.security.SecureRandom;

public class RandomAlphanumeric
{
    protected Random _generator;
    protected String _charset;

    public final static String DEFAULT_CHARSET =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public RandomAlphanumeric ()
    {
        this( new SecureRandom(), DEFAULT_CHARSET );
    }

    public RandomAlphanumeric (Random generator)
    {
        this( generator, DEFAULT_CHARSET );
    }

    public RandomAlphanumeric (Random generator, String charset)
    {
        _generator = generator;
        _charset = charset;
    }


    private long _nextLong( int bits )
    {
        if( true )
        {
            final int upperInt = _generator.nextInt( 1 << (bits-32) );
            final int lowerInt = _generator.nextInt ();

            long result = (upperInt << 32) | Math.abs( (long) lowerInt );

            System.out.println( result );
            return result;
        }


        long mask = (1 << (bits+1)) - 1;
        System.out.printf( "Mask: %x%x (%d bits)\n", mask & 0xffff, (mask >> 32) & 0xffff, bits );
        return _generator.nextLong() & mask;
    }

    private int _maxBits( int outputLength )
    {
        // result = log_2(_charset.length ^ outputLength)
        //        = outputLength * ln(_charset.length)/ln(2)

        return (int) Math.floor(
                outputLength * Math.log(_charset.length())/Math.log(2) );
    }

    public String nextString (int length)
    {
        final StringBuilder result = new StringBuilder ();
        for( int i = 0; i < length; i++ )
        {
            result.append( _charset.charAt( _generator.nextInt( _charset.length() ) ) );
        }

        return result.toString();
    }

/*
        final int randBits = _maxBits( length );
        if( randBits < 1 || randBits > 63 )
        {
            throw new RuntimeException(
                    "Handling for "+randBits+" bits unimplemented.");
        }

        long rnd = _nextLong( randBits );
        final StringBuilder result = new StringBuilder ();

        for (int i = 0; i < length; i++)
        {
            final byte index = (byte) (rnd % _charset.length());
            //System.out.println( "rnd = "+rnd+" index = "+index );
            result.append( _charset.charAt(index) );
            rnd = rnd / _charset.length();
        }

        return result.toString();
    }
*/

    public static void main (String [] args)
    {
        final RandomAlphanumeric ra = new RandomAlphanumeric ();
        for( int i = 0; i < 20; i++ )
        {
            System.out.println( ra.nextString(10) );
        }
    }
}

