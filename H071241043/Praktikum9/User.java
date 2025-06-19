import java.util.ArrayList;
import java.util.List;

public class User {
    private String nickname;
    private String fullname;
    private String image;
    private List<Post> posts = new ArrayList<>();

    public User(String nickname, String fullname, String image) {
        this.nickname = nickname;
        this.fullname = fullname;
        this.image = image;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void addPost(Post p) {
        posts.add(p);
    }

    public List<Post> getPosts() {
        return posts;
    }
    
    
    
}
