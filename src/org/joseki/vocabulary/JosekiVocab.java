/*
 * (c) Copyright 2003, 2004, 2005 Hewlett-Packard Development Company, LP
 * [See end of file]
 */

package org.joseki.vocabulary;

//import com.hp.hpl.jena.rdf.model.* ;

/** Vocabulary Class initially generated by Jena vocabulary generator
 *  This class adds the non-schema-generated defintions.
 * 
 * @author      Andy Seaborne
 * @version     $Id: JosekiVocab.java,v 1.3 2005-01-03 20:26:36 andy_seaborne Exp $
 */

public class JosekiVocab extends JosekiSchema
{
    
    // Not mechanically generated.
    // Resource versions omitted : we probably want the resource inth model (with properties).
    
    public static String opQuery          = getURI()+"OpQuery" ;
    //public static Resource r_opQuery      = ResourceFactory.createResource(opQuery) ;
    public static String opQueryPOST       = getURI()+"OpQueryPOST" ;
    //public static Resource opQueryPOST    = ResourceFactory.createResource(opQueryPOST) ; 
    public static String opOptions        = getURI()+"OpOptions" ;
    //public static Resource r_opOptions    = ResourceFactory.createResource(opOptions) ;
    public static String opPing           = getURI()+"OpPing" ;
    //public static Resource r_opPing       = ResourceFactory.createResource(opPing) ;

    public static String opAdd            = getURI()+"OpAdd" ;
    //public static Resource r_opAdd        = ResourceFactory.createResource(opAdd) ;
    public static String opRemove         = getURI()+"OpRemove" ;
    //public static Resource r_opRemove     = ResourceFactory.createResource(opRemove) ;
    public static String opUpdate         = getURI()+"OpUpdate" ;
    //public static Resource r_opUpdate     = ResourceFactory.createResource(opUpdate) ;
    
    public static String opLock           = getURI()+"OpLock" ;
    //public static Resource r_opLock       = ResourceFactory.createResource(opLock) ; 
    public static String opUnlock         = getURI()+"OpUnlock" ;
    //public static Resource r_opUnlock     = ResourceFactory.createResource(opUnlock) ;
    
    public static String queryOperationSPARQL = getURI()+"QueryOperationSPARQL" ;
    
    public static String queryOperationRDQL   = getURI()+"QueryOperationRDQL" ;
    //public static Resource r_queryRDQL        = ResourceFactory.createResource(queryOperationRDQL) ;
    public static String queryOperationGET    = getURI()+"QueryOperationGET" ;
    //public static Resource r_queryGET         = ResourceFactory.createResource(queryOperationGET) ;
    public static String queryOperationFetch  = getURI()+"QueryOperationFetch" ;
    //public static Resource r_queryFetch       = ResourceFactory.createResource(queryOperationFetch) ;
    public static String queryOperationSPO    = getURI()+"QueryOperationSPO" ;
    //public static Resource r_querySPO         = ResourceFactory.createResource(queryOperationSPO) ;
    
    // Fetch modules
    public static String fetchClosure     = getURI()+"FetchClosure" ;
    //public static Resource r_fetchClosure = ResourceFactory.createResource(fetchClosure) ;

    // SourceController interface and built-in defintions

    public static String sourceControllerFile   = getURI()+"SourceControllerFile" ;
    //public static Resource r_sourceControllerFile = ResourceFactory.createResource(sourceControllerFile) ;
    public static String sourceControllerRDB   = getURI()+"SourceControllerRDB" ;
    //public static Resource r_sourceControllerRDB = ResourceFactory.createResource(sourceControllerRDB) ;
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
