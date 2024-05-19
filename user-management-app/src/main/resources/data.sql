-- Create group table
CREATE TABLE IF NOT EXISTS "groups" (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT
);

-- Create user table
CREATE TABLE IF NOT EXISTS "users" (
    id SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

-- Create user_group join table
CREATE TABLE IF NOT EXISTS user_groups (
    user_id BIGINT NOT NULL,
    group_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, group_id),
    CONSTRAINT fk_user
        FOREIGN KEY(user_id)
            REFERENCES "users"(id),
    CONSTRAINT fk_group
        FOREIGN KEY(group_id)
            REFERENCES "groups"(id)
);

-- Insert data into the group table
INSERT INTO "groups" (name, description) VALUES ('Admin', 'Administrators group');
INSERT INTO "groups" (name, description) VALUES ('User', 'Regular users group');

-- Insert data into the user table
INSERT INTO "users" (username, password, email) VALUES ('john_doe', 'password123', 'john_doe@example.com');
INSERT INTO "users" (username, password, email) VALUES ('jane_doe', 'password456', 'jane_doe@example.com');

-- Assuming the IDs are generated sequentially starting from 1
-- Insert data into the user_group join table to establish the many-to-many relationship
-- Assign user 'john_doe' to 'Admin' and 'User' groups
INSERT INTO user_groups (user_id, group_id) VALUES (1, 1);
INSERT INTO user_groups (user_id, group_id) VALUES (1, 2);

-- Assign user 'jane_doe' to 'User' group only
INSERT INTO user_groups (user_id, group_id) VALUES (2, 2);
