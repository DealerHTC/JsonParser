package githubwateway;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

class ConnectionFabric {
    
    public URLConnection createConnection(String StingUrl) throws IOException{
        
        URL url = new URL(StingUrl);
        return  url.openConnection();
        
    }
}
