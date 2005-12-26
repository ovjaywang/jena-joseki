/*
 	(c) Copyright 2005, 2006 Hewlett-Packard Development Company, LP
 	All rights reserved - see end of file.
 	$Id: ConnectionAssembler.java,v 1.2 2005-12-26 19:19:54 andy_seaborne Exp $
*/

package com.hp.hpl.jena.rdf.model.assemblers;

import com.hp.hpl.jena.rdf.model.*;

public class ConnectionAssembler extends AssemblerBase implements Assembler
    {
    public final String defaultURL;
    public final String defaultUser;
    public final String defaultPassword;
    public final String defaultType;
    
    protected static final Resource emptyRoot = ModelFactory.createDefaultModel().createResource();
    
    public ConnectionAssembler( Resource init )
        {
        defaultUser = get( init, "dbUser", null );
        defaultPassword = get( init, "dbPassword", null );
        defaultURL = get( init, "dbURL", null );
        defaultType = get( init, "dbType", null );
        }
    
    public ConnectionAssembler()
        { this( emptyRoot ); }

    public Object create( Assembler a, Resource root )
        {
        String dbUser = getUser( root ), dbPassword = getPassword( root );
        String dbURL = getURL( root ), dbType = getType( root );
        return createConnection( dbURL, dbType, dbUser, dbPassword );
        }

    protected ConnectionDescription createConnection( String dbURL, String dbType, String dbUser, String dbPassword )
        { return ConnectionDescription.create( dbURL, dbUser, dbPassword, dbType ); }
    
    public String getUser( Resource root )
        { return get( root, "dbUser", defaultUser ); }

    public String getPassword( Resource root )
        { return get( root, "dbPassword", defaultPassword ); }

    public String getURL( Resource root )
        { return get( root, "dbURL", defaultURL );  }

    public String getType( Resource root )
        { return get( root, "dbType", defaultType ); }    
    
    protected String get( Resource root, String label, String ifAbsent )
        {
        Property property = JA.property( label );
        RDFNode L = getUnique( root, property );
        return 
            L == null ? ifAbsent 
            : L.isLiteral() ? ((Literal) L).getLexicalForm()
            : ((Resource) L).getURI()
            ;
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