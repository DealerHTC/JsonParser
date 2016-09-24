package githubwateway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class GitHubGateWay {
    private final ConnectionFabric confabric;

    GitHubGateWay(ConnectionFabric confabric) {
        this.confabric = confabric;
    }

    GitHubUsers getUsers() throws ParseException, MalformedURLException, IOException {
      
        URLConnection httpCon = confabric.createConnection(
                "https://api.github.com/users");
        
        //String strurl = "https://api.github.com/users";
        //URL url = new URL(strurl);
        //URLConnection con = (HttpURLConnection)url.openConnection();
        //InputStreamReader rd = new InputStreamReader(con.getInputStream());
       
        JSONParser parser = new JSONParser();
        JSONArray decUsers = (JSONArray) parser.parse(new InputStreamReader(httpCon.getInputStream()));
        GitHubUsers users = new GitHubUsers();
        
        for(Object decUsersElement:decUsers){
            JSONObject decUser = (JSONObject)decUsersElement;
            users.add(new GitHubUser(
                    (long)decUser.get("id"),
                    (String)decUser.get("login")));
        }
        
        return users;
    }
}
