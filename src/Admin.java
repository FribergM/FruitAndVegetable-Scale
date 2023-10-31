/**
 * Name: Måns Friberg
 * Email: mans.friberg@iths.se
 * GitHub: https://github.com/FribergM/Labb1
 */

public class Admin {
    private String name;
    private String username;
    private String password;

    public Admin(String name,String username, String password){
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }

    @Override
    public String toString() {
        return name+','+username+','+password;
    }
}