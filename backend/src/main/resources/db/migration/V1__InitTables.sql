create table employee_category(
    id      bigserial primary key,
    name    varchar(255) not null unique
);

create table employee_category_type(
    id                bigserial primary key,
    name              varchar(255) not null unique,
    employee_category bigint references employee_category(id) on delete cascade on update cascade
);

create table employee_type_attribute(
    id                  bigserial primary key,
    attribute_name      varchar(255) not null,
    employee_type       bigint references employee_category_type(id) on delete cascade on update cascade
);

create table employee(
    id                      bigserial primary key,
    first_name              varchar(255) not null,
    second_name             varchar(255) not null,
    passport                varchar(10) not null,
    employee_type           bigint references employee_category_type(id) on delete set null on update cascade,
    employment_date         date not null,
    dismissal_date          date
);

create table employee_property(
    id             bigserial primary key,
    employee       bigint references employee(id) on delete cascade on update cascade,
    attribute      bigint references employee_type_attribute(id) on delete cascade on update cascade,
    value          varchar(255)
);

create table brigadier(
    id    bigint primary key references employee(id) on delete cascade on update cascade
);

create table department_chief(
    id     bigint primary key references employee(id) on delete cascade on update cascade
);

create table department(
    id                 bigserial primary key,
    department_name    varchar(255) not null unique,
    department_chief   bigint references department_chief(id) on delete set null on update cascade
);


create table department_region_chief(
    id     bigint primary key references employee(id) on delete cascade on update cascade
);

create table department_region (
    id                          bigserial primary key,
    region_name                 varchar(255) not null unique,
    department_id               bigint references department(id) on delete cascade on update cascade,
    department_region_chief     bigint references department_region_chief(id) on delete set null on update cascade
);

create table brigade(
    id                  bigserial primary key,
    brigade_name        varchar(255) not null unique,
    brigadier           bigint references brigadier(id) on delete set null on update cascade,
    department_region   bigint references department_region(id) on delete cascade on update cascade
);

create table worker_brigade(
   id                bigserial primary key,
   worker            bigint references employee(id) on delete cascade on update cascade,
   brigade           bigint references brigade(id) on delete cascade on update cascade,
   department_region bigint references department_region(id) on delete set null on update cascade
);

create table product_category(
    id      bigserial primary key,
    name    varchar(255) not null unique
);

create table product_type_attribute(
    id                  bigserial primary key,
    attribute_name      varchar(255) not null,
    category            bigint references product_category(id) on delete cascade on update cascade
);

create table product_category_type(
    id          bigserial primary key,
    name        varchar(255) not null unique,
    category    bigint references product_category(id) on delete cascade on update cascade
);

create table product(
    id                      bigserial primary key,
    category_type           bigint references product_category_type(id) on delete cascade on update cascade,
    manufacturer_department bigint references department(id) on delete set null on update cascade,
    customer                varchar(255) not null
);

create table product_property(
    id          bigserial primary key,
    product     bigint references product(id) on delete cascade on update cascade,
    attribute   bigint references product_type_attribute(id) on delete cascade on update cascade,
    value       varchar(255)
);

create table product_status(
    id   bigserial primary key,
    name varchar(255) not null unique
);

create table product_process(
    id                  bigserial primary key,
    product             bigint references product(id) on delete cascade on update cascade,
    description_work    text not null,
    collecting_brigade  bigint references brigade(id) on delete cascade on update cascade,
    status              bigint references product_status(id) on delete cascade on update cascade,
    release_date        date
);

create table region_brigade(
    id      bigserial primary key,
    region  bigint references department_region(id) on delete cascade on update cascade,
    brigade bigint references brigade(id) on delete cascade on update cascade
);

create table master(
    id           bigint primary key references employee(id) on delete cascade on update cascade,
    chief        bigint references department_region_chief(id) on delete set null on update cascade
);

create table laboratory(
    id              bigserial primary key,
    laboratory_name varchar(255) not null unique
);

create table laboratory_employee(
    id              bigint primary key references employee(id) on delete cascade on update cascade,
    laboratory      bigint references laboratory(id) on delete set null on update cascade
);

create table equipment(
    id              bigserial primary key,
    serial_number   varchar(10) not null unique
);

create table test(
    id                  bigserial primary key,
    equipment           bigint references equipment(id) on delete cascade on update cascade,
    laboratory_employee bigint references laboratory_employee(id) on delete cascade on update cascade,
    description         text not null
);

create table laboratory_order(
    id              bigserial primary key,
    product         bigint references product(id) on delete cascade on update cascade,
    laboratory      bigint references laboratory(id) on delete cascade on update cascade
);

create table order_test(
    id                  bigserial primary key,
    laboratory_order    bigint references laboratory_order(id) on delete cascade on update cascade,
    test                bigint references test(id) on delete cascade on update cascade,
    testing_date        date not null
);