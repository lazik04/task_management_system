package uz.pdp.task_management_system.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserDao {
    private final JdbcTemplate jdbcTemplate;
}