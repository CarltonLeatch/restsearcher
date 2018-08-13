package com.project.restsearcher.Model.UserProject;

import com.project.restsearcher.Model.Project.Project;
import com.project.restsearcher.Model.User.User;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserProject implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    private Type type = Type.USER;

    private Date creationTime;


    public enum Type {
        ADMIN,USER,VIEW,GENERAL
    }
}
