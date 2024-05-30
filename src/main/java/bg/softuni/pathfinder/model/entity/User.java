package bg.softuni.pathfinder.model.entity;

import bg.softuni.pathfinder.model.enums.Level;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="users")
public class User extends BaseEntity{
    private String username;
    private String password;
    @Column(name = "full_name")
    private String fullName;
    private Integer age;
    private String email;
    @ManyToOne
    @JoinColumn(name = "roles_id", referencedColumnName = "id")
    private UserRole userRole;
    @Enumerated(EnumType.STRING)
    private Level level;

    @OneToMany(targetEntity = Comments.class, mappedBy = "author")
    private Set<Comments> comments;

    @OneToMany(targetEntity = Route.class, mappedBy = "author")
    private Set<Route> routes;

    @OneToMany(targetEntity = Pictures.class, mappedBy = "author")
    private Set<Pictures> pictures;
    @OneToMany(targetEntity = Message.class, mappedBy = "author")
    private Set<Message>messages;

    @OneToMany(targetEntity = Message.class, mappedBy = "recipient")
    private Set<Message> messageSet;

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Set<Comments> getComments() {
        return comments;
    }

    public void setComments(Set<Comments> comments) {
        this.comments = comments;
    }

    public Set<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(Set<Route> routes) {
        this.routes = routes;
    }

    public Set<Pictures> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Pictures> pictures) {
        this.pictures = pictures;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public Set<Message> getMessageSet() {
        return messageSet;
    }

    public void setMessageSet(Set<Message> messageSet) {
        this.messageSet = messageSet;
    }
}
