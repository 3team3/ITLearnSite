package question.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import resource.db.ResourceBean;

public interface QuestionDAO{
	
	/*글 등록*/
	public int insertQuestion(QuestionBean qBean);
	
	/*글 수정*/
	public void updateQuestion(QuestionBean qBean);
	
	/*글 삭제*/
	public void questionDelete(int ques_no);
	
	/*글 목록- 공지글/일반글*/
	//public List selectAllQuestions(Map pagingMap);
	public List selectQuestions(Map pagingMap);
	public List selectNotice();
	
	/*전체 글 개수*/
	public int selectTotQuestions();
	
	/*글 내용*/
	public QuestionBean questionView(int ques_no);
	
	/*조회수 증가*/
	public void updateReadcount(int ques_no);
	
	/*글 검색*/
	public ArrayList<QuestionBean> questionSelect(HashMap<String, Object> listOpt);
	
	/*답글 쓰기*/
	public int addReply(QuestionBean qBean);
	
	
}