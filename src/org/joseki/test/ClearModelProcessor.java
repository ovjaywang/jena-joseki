/*
 * (c) Copyright 2003, 2004 Hewlett-Packard Development Company, LP
 * [See end of file]
 */
 
package org.joseki.test;

import java.util.* ;
import org.joseki.server.*;
import org.joseki.server.processors.*;
import org.joseki.vocabulary.JosekiVocab;

import com.hp.hpl.jena.rdf.model.*;

/** This processor is only for testing. It is not a good idea to have
 *  on a live system.
 * 
 * @author      Andy Seaborne
 * @version     $Id: ClearModelProcessor.java,v 1.4 2004-11-15 16:22:06 andy_seaborne Exp $
 */

public class ClearModelProcessor extends ArgZeroProcessor
{
    public ClearModelProcessor()
    {
        super("clear", LockType.WriteOperation) ;
    }
    
    public String getInterfaceURI() { return JosekiVocab.getURI()+"OpClear" ; }

    public Model execZeroArg(SourceModel src, Request request)
        throws RDFException, ExecutionException
    {
        Model target = ((SourceModelJena)src).getModel() ;
            
        // target.remove(target) gets a java.util.ConcurrentModificationException (Jena1)
        Set s = new HashSet() ;
        for ( StmtIterator sIter = target.listStatements() ; sIter.hasNext() ; )
            s.add(sIter.next()) ;
        for ( Iterator iter = s.iterator() ; iter.hasNext() ; )
            target.remove((Statement)iter.next()) ;
        return super.emptyModel ;
    }
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
