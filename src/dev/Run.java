/*
 * (c) Copyright 2004, 2005 Hewlett-Packard Development Company, LP
 * All rights reserved.
 * [See end of file]
 */


package dev;
import java.net.* ;

import org.joseki.server.http.HttpContentType;

public class Run
{

    public static void main(String[] args)
    {
        if ( args == null || args.length == 0 )
            args = new String[]{"joseki-dev.n3"} ;
        RunJoseki.main(args) ;
        System.exit(0) ;
        
        return ;
        
        //String a[] = {} ;
        //rdfserver.main(a) ;

//        ct("  RDF/XML; charset=UTF-8" ) ;
//        ct("  RDF/XML" ) ;
//        ct("  RDF/XML;p=57;charset =UTF-8" ) ;
        
        
        //dwim() ;
    }
    
    public static void ct(String s)
    {
        HttpContentType ct = new HttpContentType(s) ;
        System.out.println() ;
        System.out.println("Input: "+s) ;
        System.out.println("Media type = "+ct.getMediaType()) ;
        System.out.println("Charset    = "+ct.getCharset());
        System.out.println("::"+ct.toString()+"::") ;
    }
    
    public static void dwim()
    {
        try {
        String s1 = "SELECT%20?x%20WHERE%20(?x,%20%3Chttp://www.w3.org/2001/vcard-rdf/3.0#FN%3E,%20%22John%20Smith%22)" ;
        System.out.println(s1) ;
        String t = URLDecoder.decode(s1, "UTF-8") ;
        String s2 = URLEncoder.encode(t, "UTF-8") ;
        System.out.println(t) ;
        System.out.println(s2) ;
        } catch(Exception e)
        {
            System.err.println(e) ;
        }
    }
}

/*
 * (c) Copyright 2004, 2005 Hewlett-Packard Development Company, LP
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