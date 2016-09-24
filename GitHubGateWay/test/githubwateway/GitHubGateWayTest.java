package githubwateway;

import java.io.IOException;
import java.net.HttpURLConnection;
import org.json.simple.parser.ParseException;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class GitHubGateWayTest {
    
    public GitHubGateWayTest() {
    }
    
    @Test
    public void getUsers() throws ParseException, IOException{
        
        HttpURLConnection httpCon = mock(HttpURLConnection.class);
        
        when(httpCon.getInputStream())
                .thenReturn(this.getClass().getResourceAsStream("GetUsers.json"));
        
        ConnectionFabric confabric = mock(ConnectionFabric.class);
        
        when(confabric.createConnection("https://api.github.com/users"))
                .thenReturn(httpCon);
        
        GitHubGateWay gateway = new GitHubGateWay(confabric);
        GitHubUsers users =  gateway.getUsers();
        
        assertEquals(1,users.get(0).getId());
        assertEquals("mojombo",users.get(0).getLogin());
        assertEquals(2,users.get(1).getId());
        assertEquals("defunkt",users.get(1).getLogin());
    }
    
    @Test
    public void getUsersNoMock() throws ParseException, IOException{
        
        GitHubGateWay gateway = new GitHubGateWay(new ConnectionFabric());
        GitHubUsers users =  gateway.getUsers();
        
        assertEquals(1,users.get(0).getId());
        assertEquals("mojombo",users.get(0).getLogin());
        assertEquals(2,users.get(1).getId());
        assertEquals("defunkt",users.get(1).getLogin());
    }
}