package by.zloy.apps.csv.passconv;

public class LP {
    String url;
    String username;
    String password;
    String extra;
    String name;
    String grouping;
    String fav;

    public LP() {
    }

    public LP(String url, String username, String password, String extra, String name, String grouping, String fav) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.extra = extra;
        this.name = name;
        this.grouping = grouping;
        this.fav = fav;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrouping() {
        return grouping;
    }

    public void setGrouping(String grouping) {
        this.grouping = grouping;
    }

    public String getFav() {
        return fav;
    }

    public void setFav(String fav) {
        this.fav = fav;
    }
}
