/*
 * (c) Copyright 2003, 2004, 2005 Hewlett-Packard Development Company, LP
 * [See end of file]
 */
 
package org.joseki.server.processors.ops;

import org.joseki.server.*;
import org.joseki.server.processors.LockType;
import org.joseki.vocabulary.JosekiVocab;

import com.hp.hpl.jena.rdf.model.*;

/** Ping operation processor.  Returns an empty model.
 * @author      Andy Seaborne
 * @version     $Id: PingProcessor.java,v 1.3 2005-01-03 20:26:35 andy_seaborne Exp $
 */

public class PingProcessor extends ArgZeroProcessor
{
    public PingProcessor()
    {
        super("ping", LockType.ReadOperation) ;
    }
    
    public String getInterfaceURI() { return JosekiVocab.opPing ; }

    public Model execZeroArg(SourceModel src, Request request) throws RDFException, ExecutionException
    {
        return emptyModel ;
    }
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
