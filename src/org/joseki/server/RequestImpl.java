
/*
 * (c) Copyright 2003, 2004 Hewlett-Packard Development Company, LP
 * [See end of file]
 */


package org.joseki.server;


import java.util.* ;

/** General pupose implementation of an operation.
 *  provides methods to create the operation as well as meet
 *  the Request interface.
 * @author      Andy Seaborne
 * @version     $Id: RequestImpl.java,v 1.2 2004-11-03 17:37:42 andy_seaborne Exp $
 */
public class RequestImpl implements Request
{
    // Where and how the operation will be performed
    ProcessorModel processor ;
    SourceModel modelSource ;
    Dispatcher dispatcher ;
    
    // How the operation was described.
    String opName = null;
    String modelURI = null ;
    String requestURL = null ;

    final static Object noValue = new Object() ; 
    // Arguments - models
    // Parameters - key/value pairs
    List args = new ArrayList();
    Map params = new HashMap();

    public RequestImpl(String u, String url, String name, Dispatcher d, SourceModel aModel, ProcessorModel proc)
    {
        modelURI = u ;
        requestURL = url ;
        opName = name ;
        dispatcher = d ;
        modelSource = aModel ;
        processor = proc ;
    }

    public boolean  takesArg() { return true ; }
    
    public boolean containsParam(String name) { return params.containsKey(name) ; }
    
    public void setParam(String name, String value)
    {
        if ( value == null )
            params.put(name, noValue) ;
        else
            params.put(name, value) ;
    }
    
    public void addArg(Object m) { args.add(m) ; }

    public String getName() { return opName ; }
    public String getModelURI() { return modelURI ; }
    public String getRequestURL() { return requestURL ; }

    public SourceModel getSourceModel() { return modelSource ;  }
    public ProcessorModel getProcessor() { return processor ;  }
    public void setProcessor(ProcessorModel proc) { processor = proc ;  }
    public Dispatcher getDispatcher() { return dispatcher ; }

    public Map getParams() { return params ; }
    public String getParam(String param) { return (String)params.get(param); }
    
    public List getDataArgs() { return args ; }
}

/*
 *  (c) Copyright 2003, 2004 Hewlett-Packard Development Company, LP
 *  All rights reserved.
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
