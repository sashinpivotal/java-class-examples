## The security features supported

- Add multiple users to the system with roles - we are going to store them in the InMemory database
- Encode the password using Bcrypt
- Provide login page (you can customize it)
- Provide logout button in the index.html
- Provide access control in the following matter
    - A user with USER privilege can read Employee data 
    - A user with ADMIN privilege can read/update/create Employee 
    - A user with SUPERADMIN privilege can read/update/create/delete Employee 
    - If a user with insufficient privilege tries to perform an action, “error.html” will be displayed
    
## Steps to add Spring security

1. Add Spring Boot security starter to pom.xml and refresh the IDE

```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
```

2. Create "WebSecurityConfig" class under "security" package

```
package com.example.myfirstfullstack.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.authorizeRequests()
                .mvcMatchers("/login").permitAll()
                .mvcMatchers("/deleteEmployee/**").hasAnyRole("SUPERADMIN")
                .mvcMatchers("/showFormForUpdate/**").hasAnyRole("ADMIN", "SUPERADMIN")
                .mvcMatchers("/showEmployeeForm/**").hasAnyRole("ADMIN", "SUPERADMIN")
                .mvcMatchers("/saveEmployee/**").hasAnyRole("ADMIN", "SUPERADMIN")
                .mvcMatchers("/**").hasAnyRole("USER", "ADMIN", "SUPERADMIN")
                .anyRequest().authenticated()
                .and()
             .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
             .logout()
                .permitAll();
        // @formatter:on
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder.encode("user")).roles("USER").and()
                .withUser("admin").password(passwordEncoder.encode("admin")).roles("USER", "ADMIN").and()
                .withUser("superadmin").password(passwordEncoder.encode("superadmin")).roles("USER", "ADMIN", "SUPERADMIN");

    }
}
```

3. Add "login.html" under "resources/templates" directory

```
<body>
<div th:if="${param.error}">
    Invalid username and password.
</div>
<div th:if="${param.logout}">
    You have been logged out.
</div>
<form th:action="@{/login}" method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="Sign In"/></div>
</form>
</body>
</html>
```

4. Add "error.html" under "resources/templates" directory

```
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="https://www.thymeleaf.org"
      xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Error page</title>
</head>
<body>

<h1>Access denied</h1>

<a th:href="@{/}" class="btn btn-primary btn-sm mb-3">Go to homepage </a>

</body>
</html>
```

5. Add "logout" button to the "index.html"

```
<div class="container my-2">
    <a th:href="@{/logout}" class="btn btn-primary btn-sm mb-3"> Log out </a>
</div>
```