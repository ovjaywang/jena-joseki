/*
 * (c) Copyright 2004, 2005, 2006, 2007, 2008, 2009 Hewlett-Packard Development Company, LP
 * All rights reserved.
 * [See end of file]
 */


package dev;


import org.openjena.atlas.lib.StrUtils ;

import com.hp.hpl.jena.query.QueryException ;
import com.hp.hpl.jena.query.QueryExecution ;
import com.hp.hpl.jena.query.ResultSetFormatter ;
import com.hp.hpl.jena.sparql.engine.http.QueryEngineHTTP ;

public class RunClient
{
    static String endpointSOAP = "http://localhost:2525/axis/services/sparql-query" ;
    static String endpointHttp = "http://localhost:2020/books" ;
    public static void main(String[] args)
    {
        doHttpSelect() ;
        System.exit(0) ;
    }
    
    public static void doHttpSelect()
    {
        String queryStr = "SELECT ?z {?x ?y ?z }" ;
        
        try {
            QueryExecution qexec = new QueryEngineHTTP(endpointHttp, queryStr) ;
            ResultSetFormatter.out(System.out, qexec.execSelect()) ;
            qexec.close() ;
        } 
        catch (QueryException ex)
        {
            System.err.println("Query error: "+ex.getMessage()) ;
            ex.printStackTrace() ;
        }
    }
    static private String concat(String [] a)
    {
        return StrUtils.strjoin("\n", a) ; 
    }
    
}

/*
 * (c) Copyright 2004, 2005, 2006, 2007, 2008, 2009 Hewlett-Packard Development Company, LP
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
