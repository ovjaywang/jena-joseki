/*
 * (c) Copyright 2003, 2004, 2005 Hewlett-Packard Development Company, LP
 * [See end of file]
 */

package org.joseki.server.processors.ops;

import org.apache.commons.logging.* ;
import org.joseki.server.*;
import org.joseki.server.processors.ProcessorModelCom;

import com.hp.hpl.jena.rdf.model.*;

/** General template for any operation that takes no models
 *  (in the request body) as arguments - they can have parameters.
 * 
 * @author      Andy Seaborne
 * @version     $Id: ArgZeroProcessor.java,v 1.3 2005-01-03 20:26:35 andy_seaborne Exp $
 */
public abstract class ArgZeroProcessor extends ProcessorModelCom
{
    static final Log logger = LogFactory.getLog(ArgZeroProcessor.class.getName()) ; 
 
    public ArgZeroProcessor(String n, int lockType)
    {
        super(n, lockType) ;
    }

    public int argsNeeded() { return ARGS_ZERO ; }
    
    /**
     * @see org.joseki.server.ProcessorModelCom#exec(Request)
     */
    public Model exec(Request request) throws ExecutionException
    {
        if ( request.getDataArgs().size() != 0 )
            throw new ExecutionException(Response.rcArgumentError,
                                         "Wrong number of arguments: wanted 0, got "+request.getDataArgs().size()) ;

        SourceModel src = request.getSourceModel() ;
        try {
            Model r = execZeroArg(src, request) ;
            return r ;
        } catch (RDFException ex)
        {
            logger.trace("RDFException: "+ex.getMessage() ) ;
            throw new ExecutionException(ExecutionError.rcInternalError, null) ;
        }
        catch (Exception ex)
        {
            logger.trace("Exception: "+ex.getMessage() ) ;
            throw new ExecutionException(ExecutionError.rcInternalError, null) ;
        }
        //return emptyModel ;
    }

    public abstract Model execZeroArg(SourceModel target, Request request)
        throws RDFException, ExecutionException ;
}


/*
 *  (c) Copyright 2003, 2004, 2005 Hewlett-Packard Development Company, LP
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
