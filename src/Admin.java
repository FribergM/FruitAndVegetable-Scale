//Name: Måns Friberg
//Email: mans.friberg@iths.se

public class Admin {
    private String username;
    private String password;

    public Admin(String username, String password){
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
        return username+','+password;
    }
}
