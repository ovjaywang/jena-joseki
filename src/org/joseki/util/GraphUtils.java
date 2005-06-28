/*
 * (c) Copyright 2005 Hewlett-Packard Development Company, LP
 * All rights reserved.
 * [See end of file]
 */

package org.joseki.util;

import org.joseki.graph.GraphErrorHandler;
import org.joseki.graph.LimitingGraph;

import com.hp.hpl.jena.graph.Graph;
import com.hp.hpl.jena.mem.GraphMem;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFReader;

import com.hp.hpl.jena.util.FileUtils;

/** A packaging of code to do a controlled read of a graph or model */

public class GraphUtils
{
    public static Model readModel(String uri, int limit)
    {
        return readModel(uri, limit, FileUtils.guessLang(uri)) ;
    }
    
    public static Model readModel(String uri, int limit, String syntax) 
    {
        Graph g = new GraphMem() ;
        g = new LimitingGraph(g, limit) ;
        Model m = ModelFactory.createModelForGraph(g) ;
        RDFReader r = m.getReader(syntax) ;
        r.setErrorHandler(new GraphErrorHandler()) ;
        r.read(m, uri) ;
        return m ;
    }
    
    public static Graph readGraph(String uri, int limit, String syntax) 
    {
        Graph g = new GraphMem() ;
        g = new LimitingGraph(g, limit) ;
        Model m = ModelFactory.createModelForGraph(g) ;
        RDFReader r = m.getReader(syntax) ;
        r.setErrorHandler(new GraphErrorHandler()) ;
        r.read(m, uri) ;
        return g ;
    }
    
    public static Graph readGraph(String uri, int limit)
    {
        return readGraph(uri, limit, FileUtils.guessLang(uri)) ;
    }

}

/*
 * (c) Copyright 2005 Hewlett-Packard Development Company, LP
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