package org.supamassirichotiyakul.catermate.security;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // Supamas changed
    private Long id;

    @NotNull
//    @Size(min=1, max=50)
    private String name;

    @ManyToMany(mappedBy = "roleSet")                         // Supamas added
    private Set<User> users = new HashSet<>();

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

//    @Override
//    public String toString() {
//        return "com.example.demo.security.Role{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
}

