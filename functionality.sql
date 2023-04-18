-- See a list of Projects that still need to be completed:
SELECT * FROM projects WHERE statust = 'ongoing';

-- See a list of projects that are past the due date:
SELECT * FROM projects WHERE prj_due_dte < DATE(NOW())
    ORDER BY prj_no, prj_name;

-- Mark the status as finalised, and set the completion date:
UPDATE projects SET status = 'finalised' WHERE prj_no = xyz;
UPDATE PROJECTS SET complt_dte = 'YYYY-MM-DD' WHERE prj_no = xyz;

-- Show all the Project Numbers and Project Names:
SELECT prj_no, prj_name FROM projects
    ORDER BY prj_no, prj_name;

-- +---------------------------------------------------------------------------+
