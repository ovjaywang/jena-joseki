
package apps;
import joseki.rdfserver;

public class Run_rdfserver
{
    static {
//        setPropertyDefault("org.apache.commons.logging.Log",
//                "org.apache.commons.logging.impl.Jdk14Logger");
        setPropertyDefault("org.apache.commons.logging.Log",
                "org.apache.commons.logging.impl.Log4JLogger");
        
        setPropertyDefault("java.util.logging.config.file", "etc/logging.properties");
        setPropertyDefault("log4j.configuration", "file:log4j.properties") ;
    }
    
    
    public static void main(String[] args)
    {
        String a[] = {"joseki-dev.n3"} ;
        
        rdfserver.main(a) ;
        
        // One one of my machines, the web server seems to have daemon threads
        // and so this exits now.  But why?
        // So the other threads must be daemon threads.  But why?

        for ( ; ; )
            try {
                Runtime.getRuntime().wait(10000) ;
            } catch (Exception ex) {}
    }
    
    static void setPropertyDefault(String name, String value)
    {
        if ( System.getProperty(name) == null )
            System.setProperty(name, value) ;
    }
}
