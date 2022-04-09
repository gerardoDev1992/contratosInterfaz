   create table employee_worked_hours (
       id number(19,0) not null,
        worked_date date not null,
        worked_hours number(10,0) not null,
        employee_id number(19,0),
        primary key (id)
    )
 
    
    create table employees (
       id number(19,0) not null,
        birthdate date not null,
        last_name varchar2(255 char) not null,
        name varchar2(255 char) not null,
        gender_id number(19,0),
        job_id number(19,0),
        primary key (id)
    )

    
    create table genders (
       id number(19,0) not null,
        name varchar2(255 char) not null,
        primary key (id)
    )

    
    create table jobs (
       id number(19,0) not null,
        name varchar2(255 char) not null,
        salary double precision not null,
        primary key (id)
    )

    
    alter table employees 
       add constraint UK_jjs2vs6qvtg3tny2mwi0sry0s unique (last_name)

    
    alter table employees 
       add constraint UK_sd5rcqkto9rwnmx8g16o41af unique (name)

    
    alter table employee_worked_hours 
       add constraint FKhoth0hiwrrgrc31qjy6axownd 
       foreign key (employee_id) 
       references employees

    
    alter table employees 
       add constraint FK2ml2wdxfngkqqur3k4bgo0gdj 
       foreign key (gender_id) 
       references genders

    
    alter table employees 
       add constraint FKnpqyu6u0fdh2rmqtoue23gxb4 
       foreign key (job_id) 
       references jobs