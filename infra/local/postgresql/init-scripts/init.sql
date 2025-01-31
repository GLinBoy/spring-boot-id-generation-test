-- Create Databases
CREATE DATABASE longid_db;
CREATE DATABASE hibernateuuid_db;
CREATE DATABASE javauuid_db;
CREATE DATABASE nanoid_db;

-- Create Users and Grant Privileges
CREATE USER longid_user WITH ENCRYPTED PASSWORD 'longid_password';
CREATE USER hibernateuuid_user WITH ENCRYPTED PASSWORD 'hibernateuuid_password';
CREATE USER javauuid_user WITH ENCRYPTED PASSWORD 'javauuid_password';
CREATE USER nanoid_user WITH ENCRYPTED PASSWORD 'nanoid_password';

-- Grant Access to Databases
GRANT ALL PRIVILEGES ON DATABASE longid_db TO longid_user;
GRANT ALL PRIVILEGES ON DATABASE hibernateuuid_db TO hibernateuuid_user;
GRANT ALL PRIVILEGES ON DATABASE javauuid_db TO javauuid_user;
GRANT ALL PRIVILEGES ON DATABASE nanoid_db TO nanoid_user;

-- Optional: Create Separate Schemas and Set Default Schema for Each User
\c longid_db
CREATE SCHEMA longid_schema AUTHORIZATION longid_user;
ALTER ROLE longid_user SET search_path TO longid_schema;

\c hibernateuuid_db
CREATE SCHEMA hibernateuuid_schema AUTHORIZATION hibernateuuid_user;
ALTER ROLE hibernateuuid_user SET search_path TO hibernateuuid_schema;

\c javauuid_db
CREATE SCHEMA javauuid_schema AUTHORIZATION javauuid_user;
ALTER ROLE javauuid_user SET search_path TO javauuid_schema;

\c nanoid_db
CREATE SCHEMA nanoid_schema AUTHORIZATION nanoid_user;
ALTER ROLE nanoid_user SET search_path TO nanoid_schema;

