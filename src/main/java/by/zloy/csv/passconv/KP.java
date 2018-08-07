package by.zloy.csv.passconv;

public class KP {
    String Group;
    String Title;
    String Username;
    String Password;
    String URL;
    String Notes;


    public KP() {
    }

    public KP(String group, String title, String username, String password, String URL, String notes) {
        Group = group;
        Title = title;
        Username = username;
        Password = password;
        this.URL = URL;
        Notes = notes;
    }

    public String[] getAll() {
        return new String[]{Group, Title, Username, Password, URL, Notes};
    }

    public String getGroup() {
        return Group;
    }

    public void setGroup(String group) {
        Group = group;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }
}
