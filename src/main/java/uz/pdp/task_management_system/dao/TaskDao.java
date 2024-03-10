package uz.pdp.task_management_system.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import uz.pdp.task_management_system.domain.Task;
import uz.pdp.task_management_system.dto.TaskDto;

import java.util.Date;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class TaskDao {
    private final JdbcTemplate jdbcTemplate;

    public void save(TaskDto task){
     jdbcTemplate.update("insert into tasks(title , description, deadline, stat) values (?,?,?,?)",
             task.getTitle(),
             task.getDescription(),
             task.getDeadline(),
             task.getStat()
     );
    }

    public List<Task> getAll(){
        return jdbcTemplate.query("select tasks.id,tasks.title, tasks.created ,tasks.deadline ,tasks.stat from tasks",new BeanPropertyRowMapper<>( Task.class));
    }

    public void save(String title, String description, String deadline, String status) {
        jdbcTemplate.update("insert into tasks(title , description, deadline, stat ) values (?,?,?,?)",
               title,description,deadline,status
        );
    }

    public Task getById(Long id) {
        String sql = "SELECT * FROM tasks WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Task task = new Task();
            task.setId(rs.getLong("id"));
            task.setTitle(rs.getString("title"));
            task.setDescription(rs.getString("description"));
            task.setDeadline(rs.getString("deadline"));
            return task;
        });
    }
    public void changeStatus(String status,Long id){
        jdbcTemplate.update("update tasks set stat=? where id=?",status,id);
    }
    public void delete(Long id){
        jdbcTemplate.update("DELETE FROM tasks WHERE id = ?",id);
    }

    }

