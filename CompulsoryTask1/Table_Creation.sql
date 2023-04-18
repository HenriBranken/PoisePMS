-- File Location:  "C:\Users\HP Omen\Dropbox\HB21120005908\3. DB Skills Program\L3T08\CompulsoryTask1\Table_Creation.sql"

/*
Before Creating Tables:
[1] Type 'services.msc' > MySQL > Right-Click > Start.
[2] cd "C:\Program Files\MySQL\MySQL Server 8.0\bin"
[3] mysql -u otheruser -p
[4] Type in the password: swordfish
[5] Type in the Command Prompt:
    source C:\Users\HP Omen\Dropbox\HB21120005908\3. DB Skills Program\L3T08\CompulsoryTask1\Table_Creation.sql
*/

CREATE DATABASE IF NOT EXISTS PoisePMS;

USE PoisePMS;

DROP TABLE IF EXISTS projects;

CREATE TABLE projects (prj_no INT NOT NULL AUTO_INCREMENT,
                       prj_name VARCHAR(50),
                       prj_due_dte DATE NOT NULL,
                       pm_name VARCHAR(100) NOT NULL,
                       archt_name VARCHAR(100) NOT NULL,
                       contr_name VARCHAR(100) NOT NULL,
                       cust_fname VARCHAR(50) NOT NULL,
                       cust_lname VARCHAR(50) NOT NULL,
                       struct_eng_name VARCHAR(100) NOT NULL,
                       bldg_type VARCHAR(50) NOT NULL,
                       phys_addr VARCHAR(200),
                       erf_no INT,
                       total_fee DECIMAL(15,2),
                       total_ptd DECIMAL(15,2),
                       status VARCHAR(20) DEFAULT 'ongoing',
                       complt_dte DATE DEFAULT NULL,
                       PRIMARY KEY (prj_no),
                       UNIQUE (erf_no)
                       );

delimiter //
CREATE TRIGGER project_name
BEFORE INSERT ON projects
FOR EACH ROW
BEGIN
  IF (NEW.prj_name IS NULL) THEN
  SET NEW.prj_name = CONCAT(NEW.bldg_type, ' ', NEW.cust_lname);
  END IF;
END;//
delimiter ;

-- +---------------------------------------------------------------------------+

DROP TABLE IF EXISTS architects;

CREATE TABLE architects (name VARCHAR(100) NOT NULL,
                         tel_no VARCHAR(20),
                         email VARCHAR(200),
                         phys_addr VARCHAR(200),
                         PRIMARY KEY (name)
                         );

-- +---------------------------------------------------------------------------+

DROP TABLE IF EXISTS customers;

CREATE TABLE customers (fname VARCHAR(50) NOT NULL,
                        lname VARCHAR(50) NOT NULL,
                        tel_no VARCHAR(20),
                        email VARCHAR(200),
                        phys_addr VARCHAR(200),
                        PRIMARY KEY (fname, lname)
                        );

-- +---------------------------------------------------------------------------+

DROP TABLE IF EXISTS contractors;

CREATE TABLE contractors (name VARCHAR(100) NOT NULL,
                          tel_no VARCHAR(20),
                          email VARCHAR(200),
                          phys_addr VARCHAR(200),
                          PRIMARY KEY (name)
                          );

-- +---------------------------------------------------------------------------+
