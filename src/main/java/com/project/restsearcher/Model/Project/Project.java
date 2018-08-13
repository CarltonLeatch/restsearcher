package com.project.restsearcher.Model.Project;

import com.project.restsearcher.Model.UserProject.UserProject;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "user")
    public Set<UserProject> userProjects;
}
