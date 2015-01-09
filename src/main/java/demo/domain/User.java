package demo.domain;

/**
 * Created with IntelliJ IDEA.
 * User: abderrazak
 * Date: 09/01/15
 * Time: 21:29
 */
public class User {

    private String username;
    private String pwd;

    public User(String abderrazak, String s) {
        this.username = abderrazak;
        this.pwd = s;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
