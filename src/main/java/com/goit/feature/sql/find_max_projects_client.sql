SELECT name,COUNT(project.id) AS project_count
FROM client
LEFT JOIN project ON client.id = project.client_id
GROUP BY client.id
HAVING project_count IN (
  SELECT count(id)
  FROM project
  GROUP BY client_id
  ORDER BY count(id) DESC
  LIMIT 1
);
