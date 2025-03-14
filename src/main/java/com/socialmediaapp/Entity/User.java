package com.socialmediaapp.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private List<Integer> followers = new ArrayList<>();

    private List<Integer> followings = new ArrayList<>();

    private String gender;
    private String bio;


    private String profileImage;
    private String backgroundImage;

    @ManyToMany
    @JsonIgnore // or make dto // error:: infinite loop between user and posts
    private List<Post> savedPost = new ArrayList<>();
}
