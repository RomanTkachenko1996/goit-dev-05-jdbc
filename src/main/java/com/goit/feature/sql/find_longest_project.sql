SELECT id, TIMESTAMPDIFF(MONTH, start_date, finish_date) AS duration_in_months
FROM project
WHERE TIMESTAMPDIFF(MONTH, start_date, finish_date) = (
  SELECT MAX(TIMESTAMPDIFF(MONTH, start_date, finish_date))
  FROM project
);
