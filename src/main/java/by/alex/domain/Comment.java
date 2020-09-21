package by.alex.domain;

import java.util.List;
import java.util.Objects;

public class Comment {
    private long id;
    private String title;
    private User user;
    public List<Like> likes;

    public Comment() {
    }

    public Comment(long id, String title, User user, List<Like> likes) {
        this.id = id;
        this.title = title;
        this.user = user;
        this.likes = likes;
    }

    public Comment(String title, User user, List<Like> likes) {
        this.title = title;
        this.user = user;
        this.likes = likes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(title, comment.title) &&
                Objects.equals(user, comment.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, user);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", user=" + user +
                ", likes=" + likes +
                '}';
    }
}
