package br.com.prof.twodatabases.repository;

import java.awt.print.Book;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.prof.twodatabases.entity.Users;

//@Repository
public class JdbcUsersRepository {

//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//
//     @Autowired
//    private UsersRepository repository;
//   
//    @Autowired
//    LobHandler lobHandler;
//
//    public int count() {
//        return jdbcTemplate
//                .queryForObject("select count(*) from users", Integer.class);
//    }
//
//    public int save(Users users) {
//        return jdbcTemplate.update(
//                "insert into users (name, email) values(?,?)",
//               users.getName(), users.getEmail());
//    }
//
//    public int update(Users Users) {
//        return jdbcTemplate.update(
//                "update users set email = ? where id = ?",
//                Users.getEmail(), Users.getId());
//    }
//
//
//    public int deleteById(Long id) {
//        return jdbcTemplate.update(
//                "delete users where id = ?",
//                id);
//    }
//
//    public List<Users> findAll() {
//        return jdbcTemplate.query(
//                "select * from users",
//                (rs, rowNum) ->
//                        new Users(
//                                rs.getLong("id"),
//                                rs.getString("name"),
//                                rs.getString("email")
//                            
//                        )
//        );
//    }
//
//   
//   public Optional<Users> findById(Long id) {
//               return jdbcTemplate.queryForObject(
//                      "select * from users where id = ?",
//                           new Object[]{id},
//                          (rs, rowNum) ->
//                            Optional.of(new Users(
//                                         rs.getLong("id"),
//                                         rs.getString("name"),
//                                         rs.getString("email")
//                                   ))
//                                        );
//    }
//
//    
//                               
//      public void saveImages(Long userId, File image) {
//
//          try (InputStream imageInStream = new FileInputStream(image)) {
//
//        jdbcTemplate.execute(
//       "INSERT INTO users_image (users_id, filename, blob_image) VALUES (?, ?, ?)",
//                                                    new AbstractLobCreatingPreparedStatementCallback(lobHandler) {
//                                                        protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException {
//                                                            ps.setLong(1, 1L);
//                                                            ps.setString(2, image.getName());
//                                                            lobCreator.setBlobAsBinaryStream(ps, 3, imageInStream, (int) image.length());
//                                                        }
//                                                    }
//                                            );
//
//                                        } catch (IOException e) {
//                                            e.printStackTrace();
//                                        }
//
//             }
//
//                        
//      
//     public List<Map<String, InputStream>> findImageByBookId(Long bookId) {
//
//        List<Map<String, InputStream>> result = jdbcTemplate.query(
//        "select id, book_id, filename, blob_image from users_image where book_id = ?",
//              new Object[]{bookId},
//               new RowMapper<Map<String, InputStream>>() {
//               public Map<String, InputStream> mapRow(ResultSet rs, int i) throws SQLException {
//
//               String fileName = rs.getString("filename");
//               InputStream blob_image_stream = lobHandler.getBlobAsBinaryStream(rs, "blob_image");
//
//                                                        // byte array
//                                                        //Map<String, Object> results = new HashMap<>();
//                                                        //byte[] blobBytes = lobHandler.getBlobAsBytes(rs, "blob_image");
//                                                        //results.put("BLOB", blobBytes);
//
//                Map<String, InputStream> results = new HashMap<>();
//                 results.put(fileName, blob_image_stream);
//
//                return results;
//
//             }
//           });
//
//          return result;
//         }
//
//      
//	
//	   
//
//	public List<Users> findByNameAndEmail(String name, String email) {
//		return jdbcTemplate.query("select * from users where name like ? and email like ?",
//				new Object[] { "%" + name + "%", email },
//				(rs, rowNum) -> new Users(rs.getLong("id"), rs.getString("name"), rs.getString("email")));
//	}
//
//	public String findNameById(Long id) {
//		return jdbcTemplate.queryForObject("select name from users where id = ?", new Object[] { id }, String.class);
//	}
//
//	public int[] batchUpdate(List<Users> users) {
//
//		return this.jdbcTemplate.batchUpdate("update users set email = ? where id = ?",
//				new BatchPreparedStatementSetter() {
//
//					public void setValues(PreparedStatement ps, int i) throws SQLException {
//						ps.setString(1, users.get(i).getEmail());
//						ps.setLong(2, users.get(i).getId());
//					}
//
//					public int getBatchSize() {
//						return users.size();
//					}
//
//				});
//
//	}
//
//	public int[][] batchUpdate(List<Users> users, int batchSize) {
//
//		int[][] updateCounts = jdbcTemplate.batchUpdate("update users set email = ? where id = ?", users, batchSize,
//				new ParameterizedPreparedStatementSetter<Users>() {
//					public void setValues(PreparedStatement ps, Users argument) throws SQLException {
//						ps.setString(1, argument.getEmail());
//						ps.setLong(2, argument.getId());
//					}
//				});
//		return updateCounts;
//
//	}
//
//	public int[] batchInsert(List<Users> users) {
//
//		return this.jdbcTemplate.batchUpdate("insert into users (name, price) values(?,?)",
//				new BatchPreparedStatementSetter() {
//
//					public void setValues(PreparedStatement ps, int i) throws SQLException {
//						ps.setString(1, users.get(i).getName());
//						ps.setString(2, users.get(i).getEmail());
//					}
//
//					public int getBatchSize() {
//						return users.size();
//					}
//
//				});
//	}
//
//	@Transactional
//	public int[][] batchInsert(List<Users> users, int batchSize) {
//
//		int[][] updateCounts = jdbcTemplate.batchUpdate("insert into users (name, email) values(?,?)", users, batchSize,
//				new ParameterizedPreparedStatementSetter<Users>() {
//					public void setValues(PreparedStatement ps, Users argument) throws SQLException {
//						ps.setString(1, argument.getName());
//						ps.setString(2, argument.getEmail());
//					}
//				});
//		return updateCounts;
//
//	}
//
//	public void saveImage(Long UsersId, File image) {
//
//		try (InputStream imageInStream = new FileInputStream(image)) {
//
//			jdbcTemplate.execute("INSERT INTO Users_image (Users_id, filename, blob_image) VALUES (?, ?, ?)",
//					new AbstractLobCreatingPreparedStatementCallback(lobHandler) {
//						protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException {
//							ps.setLong(1, 1L);
//							ps.setString(2, image.getName());
//							lobCreator.setBlobAsBinaryStream(ps, 3, imageInStream, (int) image.length());
//						}
//					});
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	public List<Map<String, InputStream>> findImageByUsersId(Long UsersId) {
//
//		List<Map<String, InputStream>> result = jdbcTemplate.query(
//				"select id, users_id, filename, blob_image from Users_image where Users_id = ?",
//				new Object[] { UsersId }, new RowMapper<Map<String, InputStream>>() {
//					public Map<String, InputStream> mapRow(ResultSet rs, int i) throws SQLException {
//
//						String fileName = rs.getString("filename");
//						InputStream blob_image_stream = lobHandler.getBlobAsBinaryStream(rs, "blob_image");
//
//						// byte array
//						// Map<String, Object> results = new HashMap<>();
//						// byte[] blobBytes = lobHandler.getBlobAsBytes(rs, "blob_image");
//						// results.put("BLOB", blobBytes);
//
//						Map<String, InputStream> results = new HashMap<>();
//						results.put(fileName, blob_image_stream);
//
//						return results;
//
//					}
//				});
//
//		return result;
//	}

}
