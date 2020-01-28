package question.service;

import java.util.ArrayList;
import java.util.Map;

import question.db.QuestionBean;
import resource.db.ResourceBean;

public interface QuestionService {

	/*자료실 글쓰기*/
	public int addQuestion(QuestionBean qBean);
	
	/*자료실 글수정*/
	public void modQuestion(QuestionBean qBean);
	
	/*자료실 글보기*/
	public QuestionBean questionView(int ques_no);
	
	/*자료실 글삭제*/
	public void questionDelete(int ques_no);
	
	//페이징 기능에 필요한 글목록과 전체 글 개를 각각 조회할 수 있도록 구성 - 공지글/일반글
	public Map listQuestion1(Map<String, Integer> pagingMap);
	public Map listQuestion2(Map<String, Integer> pagingMap);
	
	/*조회수증가*/
	public void updateReadcount(int ques_no);
	
	/*자료실 검색*/
	public ArrayList<QuestionBean> questionSelect(String opt,String condition);

	/*답글 쓰기*/
	public int addReply(QuestionBean qBean);

	
}
