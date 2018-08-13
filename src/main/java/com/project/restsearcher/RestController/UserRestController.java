package com.project.restsearcher.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.restsearcher.Config.WebSecurityConfig;
import com.project.restsearcher.Model.Project.Project;
import com.project.restsearcher.Model.User.User;
import com.project.restsearcher.Model.User.UserView;
import com.project.restsearcher.Model.UserProject.UserProject;
import com.project.restsearcher.Repository.ProjectRepository;
import com.project.restsearcher.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class UserRestController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    WebSecurityConfig bCrypter;

    @RequestMapping("/signup")
    public @ResponseBody
    String signup(@RequestBody User user){
        if(userRepository.findAll().size() == 0){
            User u = new User();
            u.setUsername("admin");
            u.setPassword(bCrypter.passwordEncoder().encode("password"));
            u.setType(User.Type.ADMIN);
            userRepository.save(u);
        }
        if(userRepository.findAccountCredentialsByUsername(user.getUsername()) != null)
            return "User alread exist";
        user.setPassword(bCrypter.passwordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        return user.toString();
    }

    /* Maps to all HTTP actions by default (GET,POST,..)*/
    @RequestMapping("/users")
    @JsonView(UserView.Public.class)
    public @ResponseBody
    List<User> getUsers(){
        User u = new User();
        u.setUsername("Test");
        u.setPassword(bCrypter.passwordEncoder().encode("Test"));
        u.setType(User.Type.ADMIN);

        Project p = new Project();
        p.setName("TEST");
        UserProject userProject = new UserProject();
        userProject.setProject(p);
        userProject.setUser(u);
        userProject.setType(UserProject.Type.ADMIN);
        userProject.setCreationTime(new Date());
        Set<UserProject> set = new HashSet<>();
        u.setUserProjects(set);
        u.getUserProjects().add(userProject);

        projectRepository.save(p);
        userRepository.save(u);


        return userRepository.findAll();

    }
}