/*
 * (c) Copyright 2004, 2005 Hewlett-Packard Development Company, LP
 * All rights reserved.
 * [See end of file]
 */

package org.joseki.http;

import org.joseki.util.StringUtils ;

/** A class to handle HTTP Accept types
 * 
 * @author Andy Seaborne
 * @version $Id: AcceptItem.java,v 1.2 2005-10-26 16:14:28 andy_seaborne Exp $
 */

public class AcceptItem
{
    // Names are all wrong.
    // "MediaItem"?
    // Use with Accept: and Content-Type:
    
    private String acceptType  = null;
    
    private String type = null ;
    private String subType = null ;
    
    
    protected AcceptItem() { }
    
    public AcceptItem(String s)
    {
        acceptType = s ;
        parseAndSet(s) ;
    }
    
    public AcceptItem(String type, String subType)
    {
        this.type = type ;
        this.subType = subType ;
        acceptType = type ;
        if ( subType != null )
            acceptType = type+"/"+subType ;
    }
    
    protected void parseAndSet(String s)
    {
        acceptType = s ;
        String[] t = StringUtils.split(s, "/") ;
        type = t[0] ;
        if ( t.length > 1 )
            subType = t[1] ;
    }
    
    public boolean accepts(AcceptItem item)
    {
        if ( ! accept(this.type, item.type) )
            return false ;
        
        return accept(this.subType, item.subType) ;
    }
    
    private boolean accept(String a, String b)
    {
        // Null implies *
        if ( a == null || b == null )
            return true ;
        
        if ( a.equals("*") || b.equals("*") )
            return true ;
        
        return a.equals(b) ;
    }

    // Strictly more grounded than
    public boolean moreGroundedThan(AcceptItem item)
    {
        if ( isStar(item.type) && ! isStar(this.type) )
            return true ;
        
        // they are the same
        
        if ( isStar(item.subType) && ! isStar(this.subType) )
            return true ;
        
        return false ;
    }
    
    private boolean isStar(String x)
    {
        return x == null || x.equals("*") ;
    }
    
    // Rename as toHeaderString
    public String toHeaderString()
    {
        return acceptType ;
    }
    
    public String toString()
    {
        return acceptType ;
    }
    /**
     * @return Returns the acceptType.
     */
    public String getAcceptType()
    {
        return acceptType;
    }
    /**
     * @param acceptType The acceptType to set.
     */
    public void setAcceptType(String acceptType)
    {
        this.acceptType = acceptType;
    }
    /**
     * @return Returns the subType.
     */
    public String getSubType()
    {
        return subType;
    }
    /**
     * @param subType The subType to set.
     */
    public void setSubType(String subType)
    {
        this.subType = subType;
    }
    /**
     * @return Returns the type.
     */
    public String getType()
    {
        return type;
    }
    /**
     * @param type The type to set.
     */
    public void setType(String type)
    {
        this.type = type;
    }
}

/*
 * (c) Copyright 2004, 2005 Hewlett-Packard Development Company, LP
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. The name of the author may not be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
