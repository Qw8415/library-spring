INSERT INTO user_role(role, description) VALUES ("ROLE_USER", "default role for user");

INSERT INTO category(name) VALUE ('test');
INSERT INTO category(name) VALUE ('test2');

INSERT INTO book(title, author, category) VALUE('test', 'test', 'test');
INSERT INTO book(title, author, category) VALUE('test2', 'test3', 'test2');
INSERT INTO book(title, author, category) VALUE('test3', 'test2', 'test');
INSERT INTO book(title, author, category) VALUE('test4', 'test4', 'test2');