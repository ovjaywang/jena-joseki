/*
 	(c) Copyright 2005, 2006 Hewlett-Packard Development Company, LP
 	All rights reserved - see end of file.
 	$Id: AssemblerGroup.java,v 1.2 2005-12-26 19:19:54 andy_seaborne Exp $
*/

package com.hp.hpl.jena.rdf.model.assemblers;

import java.util.*;

import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.rdf.model.impl.*;

public abstract class AssemblerGroup extends AssemblerBase implements Assembler
    {    
    public abstract AssemblerGroup implementWith( Resource type, Assembler a );

    public abstract Assembler assemblerFor( Resource type );

    public Model createModel( Resource resource )
        { return (Model) create( resource ); }
    
    public static AssemblerGroup create()
        { return new ExpandingAssemblerGroup(); }
    
    static class ExpandingAssemblerGroup extends AssemblerGroup
        {
        PlainAssemblerGroup internal = new PlainAssemblerGroup();
        
        public Object create( Assembler a, Resource suppliedRoot )
            {
            Resource root = AssemblerHelp.withFullModel( suppliedRoot );
            AssemblerHelp.loadClasses( this, root.getModel() );
            return internal.create( a, root );
            }

        public AssemblerGroup implementWith( Resource type, Assembler a )
            {
            internal.implementWith( type, a );
            return this;
            }

        public Assembler assemblerFor( Resource type )
            { return internal.assemblerFor( type ); }
        }
    
    static class PlainAssemblerGroup extends AssemblerGroup
        {
        Map mappings = new HashMap();
        
        public Object create( Assembler a, Resource root )
            {
            Resource type = ModelSpecFactory.findSpecificType( root, JA.Object );
            Assembler toUse = assemblerFor( type );
            if (toUse == null)
                {
//                System.err.println( ">> root: " + root );
//                System.err.println( ">> specific type: " + type );
                throw new NoImplementationException( root );
                }
            else
                return toUse.create( a, root );
            }

        public AssemblerGroup implementWith( Resource type, Assembler a )
            {
            mappings.put( type, a );
            return this;
            }

        public Assembler assemblerFor( Resource type )
            { return (Assembler) mappings.get( type ); }
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