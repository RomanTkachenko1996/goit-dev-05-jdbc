SELECT
  CASE
    WHEN birthday = (SELECT MIN(birthday) FROM worker) THEN 'YOUNGEST'
    WHEN birthday = (SELECT MAX(birthday) FROM worker) THEN 'OLDEST'
    ELSE ''
  END AS type,
  name,
  birthday
FROM worker
WHERE birthday = (SELECT MIN(birthday) FROM worker) OR birthday = (SELECT MAX(birthday) FROM worker)
ORDER BY birthday ASC;
