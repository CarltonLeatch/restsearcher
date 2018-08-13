package com.project.restsearcher.Model.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.project.restsearcher.Model.UserProject.UserProject;
import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(UserView.Public.class)
    private long id;
    @JsonView(UserView.Public.class)
    private String username;
    @JsonView(UserView.Secretly.class)
    private String password;

    @Column(columnDefinition = "varchar(32) default 'USER'")
    @Enumerated(value = EnumType.STRING)
    @JsonIgnore
    @JsonView(UserView.Public.class)
    private Type type = Type.USER;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserProject> userProjects;


    public enum Type {
        ADMIN,USER
    }
}



