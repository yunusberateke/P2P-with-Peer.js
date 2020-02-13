create database onlineschooldb;
create user onlineschooldb_user WITH ENCRYPTED PASSWORD 'onlineschooldb_user_passwd';

\c onlineschooldb

create table teachers(
    teacher_id serial unique not null,
    teacher_name text not null,
    teacher_surename text not null,
    teacher_access_key text unique,
    teacher_passwd text not null,
    teacher_email text unique not null,
    teacher_phone text unique not null,
    teacher_image text,
    teacher_birthday timestamp with time zone not null,
    teacher_registration_date timestamp with time zone default now(),

    primary key(teacher_id)
);

create table categories(
    category_id serial unique not null,
    category_name text unique not null,
    category_description text,
    
    primary key(category_id)
);

create table courses(
    course_id serial unique not null,
    course_name text unique not null,
    course_description text,
    course_teacher_id int4 not null references teachers(teacher_id) on delete restrict on update cascade,
    course_category_id int4 not null references categories(category_id) on delete restrict on update cascade,
    course_registration_date timestamp with time zone default now(),

    primary key(course_id)
);

create table lessons(
    lesson_id serial unique not null,
    lesson_course_id int4 not null references courses(course_id) on delete restrict on update cascade,
    lesson_start_date timestamp with time zone default now(),

    primary key(lesson_id)
);


insert into teachers values (1, 'Berat', 'EKE', '', 'passwd', 'yunusberateke@gmail.com', '5344532621', '', '2014-07-02 06:14:00.742000000');
insert into categories values (1, 'Kategori1','');
insert into courses values (1, 'Matematik', '', 1, 1);
insert into lessons values (1, 1);
grant all privileges on all tables in schema public to onlineschooldb_user;
grant usage, select on all sequences in schema public to onlineschooldb_user;