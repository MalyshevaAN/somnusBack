package malysheva.AN.contentcalendar.repository;

import malysheva.AN.contentcalendar.model.Content;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class ContentJdbcTemplateRepository {

    private final JdbcTemplate jdbcTemplate;

    public ContentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    private static Content mapRow(ResultSet rs, int rowNum) throws SQLException{
//        return new Content(rs.getInt("id"),
//                rs.getString("title"),
//                rs.getString("desc"),
//                rs.getString("status"),
//                rs.getString("content_type"),
//                rs.getTimestamp("date_created"),
//                rs.getTimestamp("date_updated"),
//                rs.getString("url"));
//    }
//
//    public List<Content> getAllContent(){
//        String sql = "SELECT * FROM Content";
//        List<Content> contents = jdbcTemplate.query(sql, ContentJdbcTemplateRepository::mapRow);
//        return contents;
//    }
//
//    public void createContent(String title, String desc, String status, String contentType, Timestamp date_created, Timestamp date_updated, String url){
//        String sql = "INSERT INTO Content (title, desc, status, content_type, date_created, date_updated, url) VALUES (?,?,?,?,?,?,?)";
//        jdbcTemplate.update(sql, title, desc, status, contentType, date_created, date_updated, url);
//    }

}
