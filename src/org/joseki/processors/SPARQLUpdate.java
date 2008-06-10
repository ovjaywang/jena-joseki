/*
 * (c) Copyright 2008 Hewlett-Packard Development Company, LP
 * All rights reserved.
 * [See end of file]
 */

package org.joseki.processors;

import java.io.Reader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joseki.DatasetDesc;
import org.joseki.ExecutionException;
import org.joseki.Joseki;
import org.joseki.QueryExecutionException;
import org.joseki.Request;
import org.joseki.Response;
import org.joseki.ReturnCodes;
import org.joseki.module.Loadable;

import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.sparql.modify.lang.ParserSPARQLUpdate;
import com.hp.hpl.jena.update.GraphStore;
import com.hp.hpl.jena.update.GraphStoreFactory;
import com.hp.hpl.jena.update.UpdateFactory;
import com.hp.hpl.jena.update.UpdateProcessor;
import com.hp.hpl.jena.update.UpdateRequest;

public class SPARQLUpdate extends ProcessorBase implements Loadable
{
    private static Log log = LogFactory.getLog(SPARQLUpdate.class) ;
    
    public void init(Resource service, Resource implementation)
    {}

    // For now - just a static that is called in the "query" procoessing flow.
    
    public void execOperation(Request request, Response response, DatasetDesc datasetDesc)
    throws QueryExecutionException
    {
        if ( ! request.getParam(Joseki.VERB).equals("POST") )
            // Because nasty things happen otherwise.
            throw new QueryExecutionException(ReturnCodes.rcBadRequest, "Updates must use POST") ;
        log.info("SPARQL/Update Operation") ;

        // Implementation goes here!
        Reader in = request.getStream() ;
        if ( in == null )
            log.warn("Reader is null") ;

        // Parsing with a Reader.  Normally discouraged because of charset issues 
        // Hence no UpdateFactory operations and a need to go direct.
        ParserSPARQLUpdate p = new ParserSPARQLUpdate() ;
        UpdateRequest updateRequest = new UpdateRequest() ;
        p.parse(updateRequest, in) ;
        GraphStore graphStore = GraphStoreFactory.create(datasetDesc.getDataset()) ;
        
        UpdateProcessor uProc = UpdateFactory.create(updateRequest, graphStore) ;
        try { uProc.execute() ; response.setOK() ; }
        catch (Exception ex)
        {
            ExecutionException execEx = new ExecutionException(ReturnCodes.rcUpdateExecutionFailure,"Update failed") ;
            response.sendException(execEx) ;
        }
    }
}

/*
 * (c) Copyright 2008 Hewlett-Packard Development Company, LP
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