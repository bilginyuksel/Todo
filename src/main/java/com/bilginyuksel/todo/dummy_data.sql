
insert into permission (id, permission) values (1,'ALL');
insert into permission (id, permission) values (2,'TODO_DELETE');
insert into permission (id, permission) values (3,'TODO_UPDATE');
insert into permission (id, permission) values (4,'USER_DELETE');
insert into permission (id, permission) values (5,'USER_UPDATE');
insert into permission (id, permission) values (6,'CATEGORY_INSERT');
insert into permission (id, permission) values (7,'CATEGORY_DELETE');
insert into permission (id, permission) values (8,'CATEGORY_UPDATE');
insert into permission (id, permission) values(9,'USER_INSERT');
insert into permission (id,permission) values (10, 'TODO_INSERT');

insert into role (id, title) values (1, 'USER');
insert into role (id, title) values (2, 'ADMIN');


insert into role_permissions (role_id, permissions_id) values (1,10);
insert into role_permissions (role_id, permissions_id) values (1,2);
insert into role_permissions (role_id, permissions_id) values (1,3);
insert into role_permissions (role_id, permissions_id) values (1,5);
insert into role_permissions (role_id, permissions_id) values (1,6);
insert into role_permissions (role_id, permissions_id) values (1,7);
insert into role_permissions (role_id, permissions_id) values (1,8);


insert into role_permissions (role_id, permissions_id) values (2,1);
