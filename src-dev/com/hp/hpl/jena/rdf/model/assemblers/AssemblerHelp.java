/*
 (c) Copyright 2005, 2006 Hewlett-Packard Development Company, LP
 All rights reserved - see end of file.
 $Id: AssemblerHelp.java,v 1.2 2005-12-26 19:19:54 andy_seaborne Exp $
 */

package com.hp.hpl.jena.rdf.model.assemblers;

import java.lang.reflect.*;
import java.util.*;

import com.hp.hpl.jena.graph.Graph;
import com.hp.hpl.jena.graph.compose.MultiUnion;
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.rdf.model.impl.ModelSpecFactory;
import com.hp.hpl.jena.shared.JenaException;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.vocabulary.*;

public class AssemblerHelp
    {
    public static Resource withFullModel( Resource root )
        { return (Resource) root.inModel( fullModel( root.getModel() ) ); }
    
    public static Model fullModel( Model m )
        {
        if (m.contains( JA.This, RDF.type, JA.Expanded )) 
            return m;
        else
            {
            return 
                // withImports( ModelSpecFactory.withSchema( m, JA.getSchema() ) )
                ModelSpecFactory.withSchema( withImports( m ), JA.getSchema() )
                .add( JA.This, RDF.type, JA.Expanded );
            }
        }

    public static Model withImports( Model model )
        { return withImports( FileManager.get(), model ); }
    
    public static Model withImports( FileManager fm, Model model )
        {
        StmtIterator it = model.listStatements( null, OWL.imports, (RDFNode) null );
        if (it.hasNext())
            {
            MultiUnion g = new MultiUnion( new Graph[] { model.getGraph() } );
            Model result = ModelFactory.createModelForGraph( g );
            while (it.hasNext()) g.addGraph( graphFor( fm, it.nextStatement() ) );
            return result;
            }
        else
            return model;
        }

    private static Map cache = new HashMap();
    
    private static Graph graphFor( FileManager fm, Statement s )
        {
        Resource url = s.getResource();
        Graph already = (Graph) cache.get( url );
        if (already == null)
            {
            Graph result = withImports( fm, fm.loadModel( url.getURI() ) ).getGraph();
            cache.put( url, result );
            return result;
            }
        else
            return already;
        }

    public static void loadClasses( AssemblerGroup group, Model m )
        {
        Property ANY = null;
        StmtIterator it = m.listStatements( null, JA.assembler, ANY );
        while (it.hasNext()) loadClass( group, it.nextStatement() );
        }

    private static void loadClass( AssemblerGroup group, Statement statement )
        {
        try
            {
            Resource type = statement.getSubject();
            Class c = Class.forName( statement.getString() );
            Constructor con = getResourcedConstructor( c );
            if (con == null)
                establish( group, type, c.newInstance() );
            else
                establish( group, type, con.newInstance( new Object[] { statement.getSubject() } ) );
            }
        catch (Exception e)
            { throw new JenaException( e ); }
        }

    private static void establish( AssemblerGroup group, Resource type, Object x )
        {
        if (x instanceof Assembler)
            group.implementWith( type, (Assembler) x );
        else
            throw new JenaException( "constructed entity is not an Assembler: " + x );
        }

    private static Constructor getResourcedConstructor( Class c )
        {
        try { return c.getConstructor( new Class[] { Resource.class } ); }
        catch (SecurityException e) { return null; }
        catch (NoSuchMethodException e) { return null; }
        }
    }

/*
 * (c) Copyright 2005, 2006 Hewlett-Packard Development Company, LP All rights
 * reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer. 2. Redistributions in
 * binary form must reproduce the above copyright notice, this list of
 * conditions and the following disclaimer in the documentation and/or other
 * materials provided with the distribution. 3. The name of the author may not
 * be used to endorse or promote products derived from this software without
 * specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO
 * EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */