/*
 * (c) Copyright 2005, 2006 Hewlett-Packard Development Company, LP
 * All rights reserved.
 * [See end of file]
 */

package org.joseki.soap;

import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;

import org.joseki.*;
import org.w3.www._2005._09.sparql_protocol_types.* ;
import org.w3.www._2005.sparql_results.Sparql;


public class ResponseSOAP extends Response
{
    QueryResult result = new QueryResult() ;
    private MalformedQuery malformedQuery = null ;
    private QueryRequestRefused queryRequestRefused = null ;
    
    public ResponseSOAP(Request request)
    {
        super(request) ;
    }
    
    public void execException() throws MalformedQuery, QueryRequestRefused
    {
        if ( malformedQuery != null )
            throw malformedQuery ;
        if ( queryRequestRefused != null )
            throw queryRequestRefused ;
    }
    public QueryResult get() { return result ; }
    
    protected void doResponseModel(Model model) throws QueryExecutionException
    {
        result.setRDF(model) ;
    }

    protected void doResponseResultSet(ResultSet resultSet) throws QueryExecutionException
    {
        Sparql r = AxisUtils.resultSetToProtocol(resultSet) ;
        result.setSparql(r) ;
    }

    protected void doResponseBoolean(Boolean bool) throws QueryExecutionException
    {
        Sparql r = new Sparql() ;
        r.set_boolean(bool) ;
        result.setSparql(r) ;
    }

    protected void doException(ExecutionException execEx)
    {
        
        if ( execEx.returnCode == ReturnCodes.rcQueryParseFailure )
        {
            malformedQuery = new MalformedQuery() ;
            malformedQuery.setFaultDetails1(execEx.shortMessage) ; 
        }
        else
        {
            queryRequestRefused = new QueryRequestRefused() ;
            queryRequestRefused.setFaultDetails1(execEx.shortMessage) ;
        }
    }
}

/*
 * (c) Copyright 2005, 2006 Hewlett-Packard Development Company, LP
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