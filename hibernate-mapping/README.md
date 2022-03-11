## Student exercise

### One-to-One mapping exercise

- Let's assume Author and PrimaryHome has one-to-one relationship
- Create Author and Primary Home classes
  - Author has authorName field
  - PrimaryHome has country and city fields
- Add proper annotations to the class
- Create hibernate.cfg.xml file
- Create App class to test 
- Verify that proper elements are created in AUTHOR and PRIMARYHOME tables

### One-to-Many and Many-to-One mapping exercises

- Create One-to-many relationship between Company and Employee classes
  - A company has many employees
- Create Company and Employee classes
  - Company has companyName and country fields
  - Employee has employeeName and department fields
- Add proper annotations to the class
- Add proper mapping element to an existing hibernate.cfg.xml file
- Create App class to test
- Verify that proper elements are created in COMPANY and EMPLOYEE tables

- Try both @ManyToOne and @OneToMany relationships
