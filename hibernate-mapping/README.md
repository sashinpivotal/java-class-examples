## Student exercise

### One-to-One mapping exercise

- Let's assume Author and PrimaryHome has one-to-one relationship
- Create Author and Primary Home classes
  - Author has authorName field
  - PrimaryHome has country and city fields
- Add proper annotations to the class(es)
- Create hibernate.cfg.xml file
- Create App class to test 
- Verify that proper elements are created in AUTHOR and PRIMARYHOME tables

### One-to-Many and Many-to-One mapping exercises

- Create One-to-many relationship between Company and Employee classes
  - A company has many employees
- Create Company and Employee classes
  - Company has companyName and country fields
  - Employee has employeeName and department fields
- Add proper annotations to the class(es)
- Add proper mapping element to an existing hibernate.cfg.xml file
- Create App class to test
- Verify that proper elements are created in COMPANY and EMPLOYEE tables

- Try both @ManyToOne and @OneToMany relationships

### Many-to-Many mapping exercises

- Create Many-to-Many relationship between Speaker and Event classes
  - Many speakers speaks in an event
  - An event has many speakers
- Create Speaker and Event classes
  - Speaker has speakerName field
  - Event has eventName and eventCity fields
- Add proper annotations to the class(es)
- Add proper mapping element to an existing hibernate.cfg.xml file
- Create App class to test
- Verify that proper elements are created in SPEAKER, EVENT, and join table
