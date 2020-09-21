package by.alex.domain;


import java.util.List;
import java.util.Objects;

public class Post {
    private long id;
    private User user;
    private List<Comment> comment;
    private int like;
    private String title;
    private String description;

    public Post(long id, User user, List<Comment> comment, int like, String title, String description) {
        this.id = id;
        this.user = user;
        this.comment = comment;
        this.like = like;
        this.title = title;
        this.description = description;
    }

    public Post(User user, List<Comment> comment, int like, String title, String description) {
        this.user = user;
        this.comment = comment;
        this.like = like;
        this.title = title;
        this.description = description;
    }

    public Post() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(user, post.user) &&
                Objects.equals(title, post.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, title);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", user=" + user +
                ", comment=" + comment +
                ", like=" + like +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
