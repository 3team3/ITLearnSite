package lecture.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sun.javafx.fxml.BeanAdapter;

public class LectureDAOImpl implements LectureDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DataSource ds = null;
	String sql = "";
	Statement stmt = null;

	private Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		Context envContext = (Context) ctx.lookup("java:/comp/env");
		ds = (DataSource) envContext.lookup("jdbc/oracle");
		return ds.getConnection();
	}

	private void closeConnection() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
			if (stmt != null)
				stmt.close();

		} catch (SQLException e) {
			System.out.println("closeConnection()메소드에서 오류  : " + e);
		}
	}

	// 자료실 목록
	@Override
	public List selectAllLectures(Map pagingMap) {
		List lecturesList = new ArrayList();

		// 전달 받은 section 값과 pageNum 값을 가져옴
		int section = (Integer) pagingMap.get("section");
		int pageNum = (Integer) pagingMap.get("pageNum");
/*		
		System.out.println("section : " + section);
		System.out.println("pageNum : " + pageNum);
*/
		try {

			con = getConnection();
			sql = "select * from ( " + "select ROWNUM as recNum, lvl, "
					+ "lec_no, lec_parentno, lec_title, lec_price, lec_imgfile, lec_spofile "
					+ "from (select level as lvl, "
					+ "lec_no, lec_parentno, lec_title, lec_price, lec_imgfile, lec_spofile " + "from lecture_table "
					+ "start with lec_parentno=0 " + "connect by prior lec_no = lec_parentno "
					+ "order siblings by lec_no desc))" + " where recNum between(?-1)*30+(?-1)*3+1 "
					+ "and (?-1)*30+?*3";

			// section과 pageNum 값으로 레코드 번호의 범위를 조건으로 정한
			// (이들 값이 각각 1로 전송 시, between 1 and 10이 됨)

			System.out.println(sql);

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, section);
			pstmt.setInt(2, pageNum);
			pstmt.setInt(3, section);
			pstmt.setInt(4, pageNum);
			ResultSet rs = pstmt.executeQuery();
			/*
			 * System.out.println(rs.next());
			 */
			while (rs.next()) {
				/*System.out.println("rs :" + rs);*/

				int level = rs.getInt("lvl");
				int lec_no = rs.getInt("lec_no");
				int lec_parentno = rs.getInt("lec_parentno");
				String lec_title = rs.getString("lec_title");
				int lec_price = rs.getInt("lec_price");
				String lec_imgfile = rs.getString("lec_imgfile");
				String lec_spofile = rs.getString("lec_spofile");
				
				/*
				 * System.out.println("level : " + level); System.out.println(
				 * "lec_no : " + lec_no); System.out.println("lec_parentno : " +
				 * lec_parentno); System.out.println("lec_title : " +
				 * lec_title); System.out.println("lec_price : " + lec_price);
				 * System.out.println("lec_imgfile : " + lec_imgfile);
				 * System.out.println("lec_spofile : " + lec_spofile);
				 */
				LectureBean bean = new LectureBean();

				bean.setLevel(level);
				bean.setLec_no(lec_no);
				bean.setLec_parentno(lec_parentno);
				bean.setLec_title(lec_title);
				bean.setLec_price(lec_price);
				bean.setLec_imgfile(lec_imgfile);
				bean.setLec_spofile(lec_spofile);

				lecturesList.add(bean);
				/*System.out.println("bean : " + bean);*/
			}
			/*
			 * System.out.println("lecturesList : " + lecturesList);
			 */
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return lecturesList;
	}

	// 전체 글 개수
	@Override
	public int selectTotLectures() {
		try {
			con = getConnection();

			// 전체 글 수 조회
			String query = "select count(lec_no) from lecture_table";
			/*System.out.println(query);*/
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				/* System.out.println(rs.getInt(1)); */
				return (rs.getInt(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return 0;
	}

	@Override
	public void lectureRegister(LectureBean lBean) {

		try {
			con = getConnection();
			// 파일 이름 테이블에 데이터를 넣기 위한 변수
			ArrayList<String> saveFiles = lBean.getSaveFiles();
			ArrayList<String> originFiles = lBean.getOriginFiles();
			ArrayList<String> list_title = lBean.getList_title();
			 
			sql = "select count(*) from lecture_table";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int lec_no = rs.getInt(1) + 1;

			String sql = "insert into lecture_table(lec_no, lec_title, lec_price, lec_content, lec_imgfile, lec_spofile) "
					+ "values(?,?,?,?,?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, lec_no);
			pstmt.setString(2, lBean.getLec_title());
			pstmt.setInt(3, lBean.getLec_price());
			pstmt.setString(4, lBean.getLec_content());
			pstmt.setString(5, saveFiles.get(0));
			pstmt.setString(6, saveFiles.get(1));
			pstmt.executeUpdate();

			
			sql = "insert into lecture_list(lec_no, list_no, list_title, list_savefile, list_originalfile) values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			for (int i = 1; i < saveFiles.size(); i++) {
				/*
				System.out.println(lec_no);
				System.out.println(i);
				System.out.println(list_title.get(i-1));
				System.out.println(saveFiles.get(i));
				System.out.println(originFiles.get(i));
				*/
				pstmt.setInt(1, lec_no);
				pstmt.setInt(2, i);
				pstmt.setString(3, list_title.get(i-1));
				pstmt.setString(4, saveFiles.get(i));
				pstmt.setString(5, originFiles.get(i));
				pstmt.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}
	
	/* 강의 정보 */
	@Override
	public LectureBean lectureDetail(int lec_no) {
		
		LectureBean bean = new LectureBean();
		
		try {
			con = getConnection();

			// 전체 글 수 조회
			String query = "select * from lecture_table  where lec_no = ?";
			/*System.out.println(query);*/
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, lec_no);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setLec_no(rs.getInt("lec_no"));
				bean.setLec_title(rs.getString("lec_title"));
				bean.setLec_price(rs.getInt("lec_price"));
				bean.setLec_content(rs.getString("lec_content"));
				bean.setLec_imgfile(rs.getString("lec_imgfile"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		
		return bean;
	}

	/* 강의 상세 리스트(파일 저장 테이블)*/
	@Override
	public List lectureList(int lec_no) {
		
		List<LectureBean> lectureList = new ArrayList<LectureBean>();
		
		try {
			con = getConnection();

			// 전체 글 수 조회
			String query = "select * from lecture_list where lec_no = ? order by list_no";
			/*System.out.println(query);*/
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, lec_no);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				
				int list_no = rs.getInt("list_no");
				String list_titleStr = rs.getString("list_title");
				String list_savefile = rs.getString("list_savefile");
				String list_originalfile = rs.getString("list_originalfile");
				/*
				System.out.println("dao : list" +list_no);
				System.out.println("dao : list" +list_titleStr);
				System.out.println("dao : list" +list_savefile);
				System.out.println("dao : list" + list_originalfile);
				*/
				
				LectureBean bean = new LectureBean();
				
				bean.setList_no(list_no);
				bean.setList_titleStr(list_titleStr);
				bean.setList_savefile(list_savefile);
				bean.setList_originalfile(list_originalfile);
				
				
				
				lectureList.add(bean);
				
			}
			/*
			System.out.println("dao : list" +lectureList);
*/
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return lectureList;
	}
	
	/*
	 * // 새 글번호 검색 private int getNewNo() { try { con = getConnection(); String
	 * query = "SELECT  max(res_no) from resource_table ";
	 * System.out.println(query); pstmt = con.prepareStatement(query); ResultSet
	 * rs = pstmt.executeQuery(query); if (rs.next()) return (rs.getInt(1) + 1);
	 * } catch (Exception e) { e.printStackTrace(); } finally {
	 * closeConnection(); } return 0; }
	 * 
	 * // 자료실 글쓰기
	 * 
	 * @Override public int insertLecture(ResourceBean rBean) { int res_no =
	 * getNewNo(); try { con = getConnection(); int res_parentno =
	 * rBean.getRes_parentno(); String res_title = rBean.getRes_title(); String
	 * res_email = rBean.getRes_email(); String res_content =
	 * rBean.getRes_content(); String res_filename = rBean.getRes_filename();
	 * 
	 * String query =
	 * "INSERT INTO resource_table (RES_NO, RES_PARENTNO, RES_TITLE, RES_EMAIL, RES_CONTENT, RES_FILENAME)"
	 * + " VALUES (?, ? ,?, ?, ?, ?)"; System.out.println(query); pstmt =
	 * con.prepareStatement(query); pstmt.setInt(1, res_no); pstmt.setInt(2,
	 * res_parentno); pstmt.setString(3, res_title); pstmt.setString(4,
	 * res_email); pstmt.setString(5, res_content); pstmt.setString(6,
	 * res_filename); pstmt.executeUpdate(); } catch (Exception e) {
	 * System.out.println("insertResource메소드에서 오류 :" + e); } finally {
	 * closeConnection(); } return res_no; }
	 * 
	 * // 자료실 글수정
	 * 
	 * @Override public void updateLecture(ResourceBean rBean) {
	 * 
	 * int res_no = rBean.getRes_no(); String res_title = rBean.getRes_title();
	 * String res_content = rBean.getRes_content(); String res_filename =
	 * rBean.getRes_filename();
	 * 
	 * try { con = getConnection(); String query =
	 * "update resource_table set res_title=?,res_content=?"; if (res_filename
	 * != null && res_filename.length() != 0) { query += ",res_filename=?"; }
	 * query += ",res_writedate=sysdate where res_no=?";
	 * 
	 * System.out.println(query); pstmt = con.prepareStatement(query);
	 * pstmt.setString(1, res_title); pstmt.setString(2, res_content); if
	 * (res_filename != null && res_filename.length() != 0) { pstmt.setString(3,
	 * res_filename); pstmt.setInt(4, res_no); } else { pstmt.setInt(3, res_no);
	 * } pstmt.executeUpdate();
	 * 
	 * } catch (Exception e) { System.out.println("updateResource메소드에서 오류 :" +
	 * e); } finally { closeConnection(); } }
	 * 
	 * // 자료실 내용
	 * 
	 * @Override public ResourceBean lectureView(int res_no) { ResourceBean
	 * rBean = new ResourceBean(); try { con = getConnection(); String sql =
	 * "select * from resource_table where res_no=?"; pstmt =
	 * con.prepareStatement(sql); pstmt.setInt(1, res_no); rs =
	 * pstmt.executeQuery(); if (rs.next()) { rBean.setRes_no(res_no);
	 * rBean.setRes_title(rs.getString("res_title"));
	 * rBean.setRes_email(rs.getString("res_email"));
	 * rBean.setRes_content(rs.getString("res_content"));
	 * rBean.setRes_filename(rs.getString("res_filename"));
	 * rBean.setRes_writedate(rs.getDate("res_writedate")); }
	 * 
	 * } catch (Exception e) { System.out.println("resourceView()메소드에서 오류 :" +
	 * e); } finally { closeConnection(); } return rBean; }
	 * 
	 * // 자료실 내용 삭제
	 * 
	 * @Override public void lectureDelete(int res_no) { try { // 커넥션풀로부터 커넥션 얻기
	 * con = getConnection(); String query =
	 * "Delete From resource_table where res_no = ?"; pstmt =
	 * con.prepareStatement(query); pstmt.setInt(1, res_no);
	 * pstmt.executeUpdate(); } catch (Exception e) { System.out.println(
	 * "resourceDelete메소드에서 오류 :" + e); } finally { closeConnection(); }
	 * 
	 * }
	 */

	/*
	 * // 자료실 검색
	 * 
	 * @Override public ArrayList<ResourceBean> lectureSelect(HashMap<String,
	 * Object> listOpt) {
	 * 
	 * ArrayList<ResourceBean> ResourceList = new ArrayList<ResourceBean>();
	 * String opt = (String) listOpt.get("opt"); // 검색옵션 String condition =
	 * (String) listOpt.get("condition"); // 검색내용
	 * 
	 * int start = (Integer)listOpt.get("start"); //페이지번호
	 * 
	 * 
	 * try { con = getConnection();
	 * 
	 * // 0: 제목 //1:내용// 2:글쓴이 if (opt.equals("0")) { sql =
	 * "select * from resource_table where res_title LIKE '%' || ? || '%'";
	 * pstmt = con.prepareStatement(sql); pstmt.setString(1, condition); rs =
	 * pstmt.executeQuery(); } else if (opt.equals("1")) { sql =
	 * "select * from resource_table where res_content LIKE '%' || ? || '%'";
	 * pstmt = con.prepareStatement(sql); pstmt.setString(1, condition); rs =
	 * pstmt.executeQuery(); } else if (opt.equals("2")) { sql =
	 * "select * from resource_table where res_email LIKE '%' || ? || '%'";
	 * pstmt = con.prepareStatement(sql); pstmt.setString(1, condition); rs =
	 * pstmt.executeQuery(); }
	 * 
	 * while (rs.next()) { ResourceBean rBean = new ResourceBean();
	 * rBean.setRes_no(rs.getInt("res_no"));
	 * rBean.setRes_title(rs.getString("res_title"));
	 * rBean.setRes_email(rs.getString("res_email"));
	 * rBean.setRes_writedate(rs.getDate("res_writedate"));
	 * ResourceList.add(rBean); }
	 * 
	 * } catch (Exception e) { System.out.println("resourceSelect()에서 오류 : " +
	 * e); } finally { closeConnection(); } return ResourceList; }
	 */
}
