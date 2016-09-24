
package githubwateway;

class GitHubUser {
    private final long id;
    private final String login;

    GitHubUser(long id, String login) {
        this.id = id;
        this.login = login;
        
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    
    
}
