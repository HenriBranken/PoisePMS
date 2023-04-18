-- File Location:  "C:\Users\HP Omen\Dropbox\HB21120005908\3. DB Skills Program\L3T08\CompulsoryTask1\Data_Insertion.sql"

/*
If you're not running a MySQL session:
[1] Type 'services.msc' > MySQL > Right-Click > Start.
[2] cd "C:\Program Files\MySQL\MySQL Server 8.0\bin"
[3] mysql -u otheruser -p
[4] Type in the password: swordfish
[5] Type in the Command Prompt:
    source C:\Users\HP Omen\Dropbox\HB21120005908\3. DB Skills Program\L3T08\CompulsoryTask1\Data_Insertion.sql
*/

-- Empty the `projects` table for fresh insertion of new data.
DELETE FROM projects;

INSERT INTO projects (prj_due_dte, pm_name, archt_name, contr_name, cust_fname, cust_lname, struct_eng_name, bldg_type, phys_addr, erf_no, total_fee, total_ptd, status, complt_dte)
VALUES ('2023-04-13', 'Kelly Millard', 'Olive Yew', 'Exotic Services', 'Aida', 'Bugg', 'Teri Dactyl', 'school', '15 Ajax Str', 1250, 5000000.00, 3000000.00, 'ongoing', NULL),
('2023-03-10', 'Peg Legge', 'Allie Grater', 'Sensible Services', 'Liz', 'Erd', 'Alem Mused', 'apartment', '12 Jasmine Ave', 18675, 123000.00, 111000, 'ongoing', NULL),
('2023-06-08', 'Constance Noring', 'Loise Di Nominator', 'Stunning Services', 'Minnie', 'Van Ryder', 'Lynn Oleeum', 'house', '20 Earl Grey Str', 1654, 2000000.00, 150000.00, 'ongoing', NULL),
('2023-02-25', 'Lee Sun', 'Ray Jasmine', 'Respectable Services', 'Isabelle', 'Ringing', 'Eileen Sideways', 'mall', '3 Aalwyn Str', 999852, 150000000.00, 150000000.00, 'finalised', '2023-02-24'),
('2023-01-15', 'Rita Book', 'Paige Turner', 'Golden Services', 'Rhoda', 'Report', 'Augusta Wind', 'museum', '2 Begonia ave', 7777777, 200000000.00, 200000000.00, 'finalised', '2023-01-20'),
('2022-11-25', 'Chris Anthenum', 'Anne Teak', 'Splendid Services', 'Anita', 'Bath', 'Hope Furaletter', 'restaurant', '33 Crescent Rd', 1322, 80000.00, 80000.00, 'finalised', '2022-11-25');

-- Display the `projects` data.
SELECT * FROM projects;

-- +---------------------------------------------------------------------------+

-- Empty the `architects` table for fresh insertion of new data.
DELETE FROM architects;

INSERT INTO architects (name, tel_no, email, phys_addr)
VALUES ('Olive Yew', '057 357 2177', 'olive.yew@gmail.com', '729 Pouros Cres'),
('Allie Grater', '057 357 8324', 'allie.grater@gmail.com', '3613 Annabelle Str'),
('Loise Di Nominator', '057 352 1012', 'loise.dinominator@gmail.com', '194 Jacobs Cres'),
('Ray Jasmine', '057 352 1234', 'ray.jasmine@gmail.com', '375 Pacocha Station'),
('Paige Turner', '057 355 8255', 'paige.turner@gmail.com', '613 Easton Ave'),
('Anne Teak', '057 355 6412', 'anne.teak@gmail.com', '503 Lavina Str');

-- Display the `architects` data.
SELECT * FROM architects;

-- +---------------------------------------------------------------------------+

-- Empty the `customers` table for fresh insertion of new data.
DELETE FROM customers;

INSERT INTO customers (fname, lname, tel_no, email, phys_addr)
VALUES ('Aida', 'Bugg', '063 251 2177', 'aida.bugg@gmail.com', '93 Stanley Str'),
('Liz', 'Erd', '063 251 8324', 'liz.erd@gmail.com', '13 Farelli Str'),
('Minnie', 'Van Ryder', '063 251 1012', 'minnie.vanryder@gmail.com', '204 Purdyferry Str'),
('Isabelle', 'Ringing', '063 251 1234', 'isabelle.ringing@gmail.com', '532 Hermiston Str'),
('Rhoda', 'Report', '063 251 8255', 'rhoda.report@gmail.com', '303 Theron Str'),
('Anita', 'Bath', '063 251 6412', 'anita.bath@gmail.com', '401 Schuster Str');

-- Display the `customers` data.
SELECT * FROM customers;

-- +---------------------------------------------------------------------------+

-- Empty the `contractors` table for fresh insertion of new data.
DELETE FROM contractors;

INSERT INTO contractors (name, tel_no, email, phys_addr)
VALUES ('Exotic Services', '071 144 2177', 'exotic.services@gmail.com', '88 Dagmar Ave'),
('Sensible Services', '071 144 8324', 'sensible.services@gmail.com', '131 Dorothea Ave'),
('Stunning Services', '071 144 1012', 'stunning.services@gmail.com', '76 Alia Ave'),
('Respectable Services', '071 144 1234', 'respectable.services@gmail.com', '28 Cummings Ave'),
('Golden Services', '071 144 8255', 'golden.services@gmail.com', '65 Trantow Ave'),
('Splendid Services', '071 144 6412', 'splendid.services@gmail.com', '22 London Ave');

SELECT * FROM contractors;

-- +---------------------------------------------------------------------------+
