insert into department(department_name) values ('motor'),
                                               ('device');

insert into employee_category(name) values ('worker'),
                                           ('engineering_staff'),
                                           ('laboratory_tester');

insert into employee_category_type(name, employee_category) values ('engineer', 2),
                                                                   ('technologist', 2),
                                                                   ('technician', 2),
                                                                   ('assembler', 1),
                                                                   ('turner', 1),
                                                                   ('welder', 1),
                                                                   ('locksmith', 1),
                                                                   ('tester', 3);

insert into employee_type_attribute(attribute_name, employee_type) values ('education', 1),
                                                                          ('professional_grade', 2),
                                                                          ('specialization', 3),
                                                                          ('detail_type', 4),
                                                                          ('specialization', 5),
                                                                          ('metal_welding_type', 6),
                                                                          ('profile', 7);

insert into employee(first_name, second_name, passport, employee_type, employment_date, dismissal_date) values
                            ('Anastasia', 'Kirekova', '1234202021', 1, '10.01.2022', null),
                            ('Petr', 'Gorlanov', '3428982122', 7, '10.01.2019', null),
                            ('Maksim', 'Bobrov', '0116289821', 6, '11.12.2021', null),
                            ('Kirill', 'Greer', '2328982122', 4, '23.07.2020', '30.09.2022'),
                            ('Ivan', 'Motruhin', '5432092502', 3, '21.02.2021', null),
                            ('Andrei', 'Gurkin', '3454234523', 2, '08.04.2022', null),
                            ('Kirill', 'Flout', '3450004523', 1, '08.04.2022', '08.11.2022'),
                            ('Aleksei', 'Gurkin', '9994234523', 5, '12.12.2022', null),
                            ('Damir', 'Lend', '3454234222', 4, '28.10.2022', null),
                            ('Vladimir', 'Derop', '3454298763', 2, '23.11.2022', null),
                            ('Konstantin', 'Lok', '0951298763', 8, '21.10.2022', null),
                            ('Aleksei', 'Korjov', '0854298763', 8, '23.01.2021', null),
                            ('Ivan', 'Siroc', '0754298763', 8, '27.02.2023', null);


insert into employee_property(employee, attribute, value) values
                                     (2, 7, 'toolmaker'),
                                     (3, 6, 'thermite'),
                                     (4, 4, 'motor'),
                                     (9, 4, 'chassis'),
                                     (1, 1, 'nsu'),
                                     (5, 3, '5'),
                                     (6, 2, 'smth'),
                                     (7, 1, 'msu'),
                                     (8, 5, '3'),
                                     (10, 2, 'grade');


insert into brigadier values (4),
                             (3);


insert into brigade(brigade_name, brigadier) values
                           ('Best', 3),
                           ('Nozzle', 3),
                           ('Import', 4);

insert into worker_brigade(worker, brigade) values
                                  (2, 1),
                                  (2, 2),
                                  (3, 3),
                                  (4, 1),
                                  (9, 3);

insert into department_chief values (1),
                                    (10);

update department set department_chief = 1 where department.id = 1;
update department set department_chief = 10 where department.id = 2;

insert into department_region_chief values (1),
                                           (5);

insert into department_region(region_name, department_id, department_region_chief) values ('First', 1, 1),
                                                                        ('Build', 2, 5);

update brigade set department_region = 1 where id = 1;
update brigade set department_region = 2 where id = 2;
update brigade set department_region = 1 where id = 2;



insert into product_category(name) values
                                    ('motorbike'),
                                    ('truck'),
                                    ('passenger_car'),
                                    ('bus'),
                                    ('agricultural_car'),
                                    ('road_construction_car');

insert into product_type_attribute(attribute_name, category) values
                                          ('engine_capacity', 1),
                                          ('load_capacity', 2),
                                          ('doors_number', 3),
                                          ('capacity', 4),
                                          ('performance', 5),
                                          ('pressure', 6),
                                          ('engine_capacity', 3);

insert into product_category_type values (1, 'Dodge Tomahawk', 1),
                                         (2, 'Suzuki Hayabusa', 1),
                                         (3, 'Yamaha YZF-R1', 1),
                                         (4, 'Ducati – 1098', 1),
                                         (5, 'kamaz-5490', 2),
                                         (6, 'Foton Auman', 2),
                                         (7, 'MAN TGX', 2),
                                         (8, 'Hyundai H350', 4),
                                         (9, 'Volvo 7900', 4),
                                         (10, 'Maz-251', 4),
                                         (11, 'BMW X5', 3),
                                         (12, 'Mercedes GT', 3),
                                         (13, 'Toyota Land Cruiser Prado', 3),
                                         (14, 'claas', 4),
                                         (15, 'New Holland', 4),
                                         (16, 'niva', 4),
                                         (17, 'Volvo Construction Equipment', 5),
                                         (18, 'Liebherr R920', 5),
                                         (19, 'Cat 320D2L', 5);

insert into product values (1, 12, 1, 'David Belov'),
                           (2, 5, 1, 'StroiMash'),
                           (3, 13, 2, 'Eduard Lomov'),
                           (4, 2, 2, 'Bloty');

insert into product_property(product, attribute, value) values
                                    (1, 3, '5'),
                                    (2, 2, '20000'),
                                    (3, 3, '5'),
                                    (3, 7, '300');

insert into product_status(name) values ('waiting'),
                                        ('assembling'),
                                        ('assembled');

insert into product_process(product, description_work, collecting_brigade, status, release_date) values
                                   (1, 'motor manufacturing', 1, 3, '02.12.2021'),
                                   (1, 'packing', 1, 2, null),
                                   (2, 'smth', 2, 3, '02.03.2022'),
                                   (2, 'smth2', 2, 2, null),
                                   (2, 'smth3', 3, 1, null);

insert into region_brigade(region, brigade) values (1, 1),
                                                   (1, 2),
                                                   (1, 3),
                                                   (2, 3),
                                                   (2, 2);

insert into master values (6, 5);

insert into laboratory(laboratory_name) values ('crash'),
                                               ('nondestructive'),
                                               ('metrology');

insert into laboratory_employee values (11, 1),
                                       (12, 2),
                                       (13, 3);

insert into equipment(serial_number) values
                             ('0213213212'),
                             ('3433432121'),
                             ('2344213433'),
                             ('4332123231');

insert into test(equipment, laboratory_employee, description) values (1, 11, 'strength'),
                                                                     (2, 11, 'stability'),
                                                                     (3, 12, 'solidity'),
                                                                     (4, 13, 'permanency'),
                                                                     (2, 12, '3433432121');

insert into laboratory_order(product, laboratory) values (1, 1),
                                                         (1, 2),
                                                         (1, 3);

insert into order_test(laboratory_order, test, testing_date) values
                              (1, 1, '12.12.2021'),
                              (1, 2, '13.12.2021'),
                              (1, 3, '14.12.2021'),
                              (1, 4, '14.12.2021'),
                              (1, 5, '30.12.2021'),
                              (2, 2, '10.10.2022'),
                              (3, 2, '13.02.2022'),
                              (3, 5, '13.02.2022');