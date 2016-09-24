package githubwateway;

import java.util.ArrayList;

class GitHubUsers {
    ArrayList <GitHubUser> users = new ArrayList<>();
    
    public int count() {
        return users.size();
    }

    void add(GitHubUser gitHubUser) {
        users.add(gitHubUser);
    }

    GitHubUser get(int i) {
        return users.get(i);
    }

       
}
