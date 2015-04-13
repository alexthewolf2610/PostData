package addTestPostData;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class TestResult {
	
	public static Connection initialiseDB() {

		Connection c = null;

		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/Q+AWebAppDB", "postgres","password");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

		return c;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("InitialiseDB");
		Connection c = initialiseDB();
		System.out.println("Make sure that the images exist");
		System.out.println("Make sure that the date of all students created is correct");
		System.out.println("Are you happy to create the test data? (y/n)");
		Scanner scanner = new Scanner(System.in);
		String answer1 = scanner.nextLine();
		if(answer1.equalsIgnoreCase("y")){
			createTests(c);
		}
		System.out.println("Would you like to create testresults for all tests? (y/n)");
		String answer2 = scanner.nextLine();
		if(answer2.equalsIgnoreCase("y")){
			createTestResult(c);
		}
		
        
    }
	
	
	public static void createTests(Connection c){
		
		Statement stmt = null;
		try {
			stmt = c.createStatement();
			
			/////// TEST 1 /////////////////
			
			String countriesTest = "insert into test(id,_class_id,name,available_to_students,time_limit,strict_test,date_added,total_mark) VALUES (nextval('test_seq'),(select id from class where name ILIKE '%Geography%' limit 1),'Countries Test',false,15,false,'2015-02-12 00:00:00',0);"
					+ "insert into question(id,test_id,question_type_id,value,position,mark) VALUES (nextval('question_seq'),(select id from test where name = 'Countries Test'),(select id from question_type where name = 'Radio'),'What is the capital of Qatar?',1,5);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'What is the capital of Qatar?'),'Abu Dhabi',false);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'What is the capital of Qatar?'),'Accra',false);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'What is the capital of Qatar?'),'Manama',false);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'What is the capital of Qatar?'),'Doha',true);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'What is the capital of Qatar?'),'Dukhan',false);"
					+ "insert into question(id,test_id,question_type_id,value,position,mark) VALUES (nextval('question_seq'),(select id from test where name = 'Countries Test'),(select id from question_type where name = 'Checkbox'),'Which of the places below are in the country of Spain?',2,10);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'Which of the places below are in the country of Spain?'),'Albacete',true);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'Which of the places below are in the country of Spain?'),'Beja',false);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'Which of the places below are in the country of Spain?'),'Coimbra',false);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'Which of the places below are in the country of Spain?'),'Pamplona',true);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'Which of the places below are in the country of Spain?'),'Zamora',true);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'Which of the places below are in the country of Spain?'),'Guarda',false);"
					+ "insert into question(id,test_id,question_type_id,value,position,mark) VALUES (nextval('question_seq'),(select id from test where name = 'Countries Test'),(select id from question_type where name = 'Checkbox'),'What are the 3 official languages of Belgium?',3,20);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'What are the 3 official languages of Belgium?'),'English',false);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'What are the 3 official languages of Belgium?'),'Dutch',true);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'What are the 3 official languages of Belgium?'),'French',true);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'What are the 3 official languages of Belgium?'),'German',true);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'What are the 3 official languages of Belgium?'),'Italian',false);"
					+ "insert into question(id,test_id,question_type_id,value,position,mark) VALUES (nextval('question_seq'),(select id from test where name = 'Countries Test'),(select id from question_type where name = 'Radio'),'What is the capital of Botswana?',4,5);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'What is the capital of Botswana?'),'Nairobi',false);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'What is the capital of Botswana?'),'Gaborone',true);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'What is the capital of Botswana?'),'Luanda',false);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'What is the capital of Botswana?'),'Abuja',false);"
					+ "insert into question(id,test_id,question_type_id,value,position,mark) VALUES (nextval('question_seq'),(select id from test where name = 'Countries Test'),(select id from question_type where name = 'Checkbox'),'What are the 3 official capital cities of South Africa?',5,20);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'What are the 3 official capital cities of South Africa?'),'Pretoria',true);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'What are the 3 official capital cities of South Africa?'),'Durban',false);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'What are the 3 official capital cities of South Africa?'),'Port Elizabeth',false);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'What are the 3 official capital cities of South Africa?'),'Cape Town',true);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'What are the 3 official capital cities of South Africa?'),'Kimberley',false);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'What are the 3 official capital cities of South Africa?'),'Pietermaritzburg',false);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'What are the 3 official capital cities of South Africa?'),'Bloemfontein',true);"
					+ "insert into question(id,test_id,question_type_id,value,position,mark) VALUES (nextval('question_seq'),(select id from test where name = 'Countries Test'),(select id from question_type where name = 'Drag & Drop'),'Match the image to the country where it was taken',6,25);"
					+ "update test set total_mark = (select sum(mark) from question where test_id = (select id from test where name = 'Countries Test')) where name = 'Countries Test'";
			stmt.executeUpdate(countriesTest);
			
			String insertDragQuestions1 = "insert into question(id,test_id,master_question,question_type_id,value,position,mark) VALUES (nextval('question_seq'),"
					+ "(select id from test where name = 'Countries Test'),"
					+ "(select id from question where value = 'Match the image to the country where it was taken'),"
					+ "(select id from question_type where name = 'Drag & Drop'),"
					+ "'/Users/alexfox/Pictures/Q+AWebApp/20150412103837554_89140_20150319143151652_17780_2014-09-1315.57.52.jpg',"
					+ "1,"
					+ "(select mark from question where value = 'Match the image to the country where it was taken'));";
			
			stmt.executeUpdate(insertDragQuestions1,Statement.RETURN_GENERATED_KEYS);
			
			ResultSet rsDrag1 = stmt.getGeneratedKeys();
			Long dragQ1 = null;
			if (rsDrag1.next()) {
				dragQ1 = rsDrag1.getLong(1);
			}
			rsDrag1.close();
			
			String dragAnsInsert = "insert into answer VALUES (nextval('answer_seq'),"+dragQ1+",'Spain',true);";
			stmt.executeUpdate(dragAnsInsert);		
					
					
			String insertDragQuestions2 = "insert into question(id,test_id,master_question,question_type_id,value,position,mark) VALUES (nextval('question_seq'),"
					+ "(select id from test where name = 'Countries Test'),"
					+ "(select id from question where value = 'Match the image to the country where it was taken'),"
					+ "(select id from question_type where name = 'Drag & Drop'),"
					+ "'/Users/alexfox/Pictures/Q+AWebApp/20150412103837574_57370_20150405174030397_37600_20150313171128072_13410_dscf8088.jpg',"
					+ "2,"
					+ "(select mark from question where value = 'Match the image to the country where it was taken'));";
			stmt.executeUpdate(insertDragQuestions2,Statement.RETURN_GENERATED_KEYS);
			
			ResultSet rsDrag2 = stmt.getGeneratedKeys();
			Long dragQ2 = null;
			if (rsDrag2.next()) {
				dragQ2 = rsDrag2.getLong(1);
			}
			rsDrag2.close();
			
			String dragAnsInsert2 = "insert into answer VALUES (nextval('answer_seq'),"+dragQ2+",'Turkey',true);";
			stmt.executeUpdate(dragAnsInsert2);	
			
			String insertDragQuestions3 = "insert into question(id,test_id,master_question,question_type_id,value,position,mark) VALUES (nextval('question_seq'),"
					+ "(select id from test where name = 'Countries Test'),"
					+ "(select id from question where value = 'Match the image to the country where it was taken'),"
					+ "(select id from question_type where name = 'Drag & Drop'),"
					+ "'/Users/alexfox/Pictures/Q+AWebApp/20150412103836955_7265_20150305164423798_58430_dscf8463.jpg',"
					+ "3,"
					+ "(select mark from question where value = 'Match the image to the country where it was taken'));";
			stmt.executeUpdate(insertDragQuestions3,Statement.RETURN_GENERATED_KEYS);
			
			ResultSet rsDrag3 = stmt.getGeneratedKeys();
			Long dragQ3 = null;
			if (rsDrag3.next()) {
				dragQ3 = rsDrag3.getLong(1);
			}
			rsDrag3.close();
			
			String dragAnsInsert3 = "insert into answer VALUES (nextval('answer_seq'),"+dragQ3+",'Romania',true);";
			stmt.executeUpdate(dragAnsInsert3);	
			
			String insertDragQuestions4 = "insert into question(id,test_id,master_question,question_type_id,value,position,mark) VALUES (nextval('question_seq'),"
					+ "(select id from test where name = 'Countries Test'),"
					+ "(select id from question where value = 'Match the image to the country where it was taken'),"
					+ "(select id from question_type where name = 'Drag & Drop'),"
					+ "'/Users/alexfox/Pictures/Q+AWebApp/20150412103837588_89820_20150313153152553_8775_dsc00066.jpg',"
					+ "4,"
					+ "(select mark from question where value = 'Match the image to the country where it was taken'));";
			stmt.executeUpdate(insertDragQuestions4,Statement.RETURN_GENERATED_KEYS);
			
			ResultSet rsDrag4 = stmt.getGeneratedKeys();
			Long dragQ4 = null;
			if (rsDrag4.next()) {
				dragQ4 = rsDrag4.getLong(1);
			}
			rsDrag4.close();
			
			String dragAnsInsert4 = "insert into answer VALUES (nextval('answer_seq'),"+dragQ4+",'Thailand',true);";
			stmt.executeUpdate(dragAnsInsert4);
			
		/////// END OF TEST 1 /////////////////
			
		/////// TEST 2 /////////////////
		
		String co1003 = "insert into test(id,_class_id,name,available_to_students,time_limit,strict_test,date_added,total_mark) VALUES (nextval('test_seq'),(select id from class where name ILIKE '%CO1003%' limit 1),'Program Design Test',false,15,false,'2015-02-12 00:00:00',0);"
					
					+ "insert into question(id,test_id,question_type_id,value,position,mark) VALUES (nextval('question_seq'),(select id from test where name = 'Program Design Test'),(select id from question_type where name = 'Radio'),'An attribute which is declared to be private cannot be accessed by an outside class.',1,2);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'An attribute which is declared to be private cannot be accessed by an outside class.'),'false',false);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'An attribute which is declared to be private cannot be accessed by an outside class.'),'true',true);"
					
					+ "insert into question(id,test_id,question_type_id,value,position,mark) VALUES (nextval('question_seq'),(select id from test where name = 'Program Design Test'),(select id from question_type where name = 'Radio'),'Javadoc is a documentation generator for Java classes.',2,2);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'Javadoc is a documentation generator for Java classes.'),'false',false);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'Javadoc is a documentation generator for Java classes.'),'true',true);"
					
					+ "insert into question(id,test_id,question_type_id,value,position,mark) VALUES (nextval('question_seq'),(select id from test where name = 'Program Design Test'),(select id from question_type where name = 'Radio'),'Integer is a primitive data type while String is an object.',3,2);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'Integer is a primitive data type while String is an object.'),'false',true);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'Integer is a primitive data type while String is an object.'),'true',false);"
					
					+ "insert into question(id,test_id,question_type_id,value,position,mark) VALUES (nextval('question_seq'),(select id from test where name = 'Program Design Test'),(select id from question_type where name = 'Radio'),'++i and i++ are identical semantically in Java.',4,2);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = '++i and i++ are identical semantically in Java.'),'false',true);"
					+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = '++i and i++ are identical semantically in Java.'),'true',false);"
					
					+ "update test set total_mark = (select sum(mark) from question where test_id = (select id from test where name = 'Program Design Test')) where name = 'Program Design Test'";
		
		stmt.executeUpdate(co1003);
			
		/////// END OF TEST 2 /////////////////
		
		/////// TEST 3 /////////////////
		
		String CO2006 = "insert into test(id,_class_id,name,available_to_students,time_limit,strict_test,date_added,total_mark) VALUES (nextval('test_seq'),(select id from class where name ILIKE '%CO1003%' limit 1),'Software Engineering Test',false,20,false,'2015-02-12 00:00:00',0);"
				+ "insert into question(id,test_id,question_type_id,value,position,mark) VALUES (nextval('question_seq'),(select id from test where name = 'Software Engineering Test'),(select id from question_type where name = 'Checkbox'),'Check the attributes which would fit into the design model',1,10);"
				+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'Check the attributes which would fit into the design model'),'Dynamic (much focus on sequence)',true);"
				+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'Check the attributes which would fit into the design model'),'Few layers',false);"
				+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'Check the attributes which would fit into the design model'),'Should be maintained throughout the complete software lifecycle',true);"
				+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'Check the attributes which would fit into the design model'),'Physical model',true);"
				+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'Check the attributes which would fit into the design model'),'Cheap to develop',false);"
				+ "insert into question(id,test_id,question_type_id,value,position,mark) VALUES (nextval('question_seq'),(select id from test where name = 'Software Engineering Test'),(select id from question_type where name = 'Radio'),'Emergent behaviour in a complex system can be captured with a class diagram',2,4);"
				+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'Emergent behaviour in a complex system can be captured with a class diagram'),'true',false);"
				+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'Emergent behaviour in a complex system can be captured with a class diagram'),'false',true);"
				+ "insert into question(id,test_id,question_type_id,value,position,mark) VALUES (nextval('question_seq'),(select id from test where name = 'Software Engineering Test'),(select id from question_type where name = 'Radio'),'An object interaction in a sequence diagram is depicted by means of a message exchanged between two objects',3,4);"
				+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'An object interaction in a sequence diagram is depicted by means of a message exchanged between two objects'),'true',true);"
				+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'An object interaction in a sequence diagram is depicted by means of a message exchanged between two objects'),'false',false);"
				+ "insert into question(id,test_id,question_type_id,value,position,mark) VALUES (nextval('question_seq'),(select id from test where name = 'Software Engineering Test'),(select id from question_type where name = 'Radio'),'An object interaction in a sequence diagram is depicted showing messages along links between objects that correspond to associations between the corresponding classes',4,4);"
				+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'An object interaction in a sequence diagram is depicted showing messages along links between objects that correspond to associations between the corresponding classes'),'true',false);"
				+ "insert into answer VALUES (nextval('answer_seq'),(select id from question where value = 'An object interaction in a sequence diagram is depicted showing messages along links between objects that correspond to associations between the corresponding classes'),'false',true);"
				+ "update test set total_mark = (select sum(mark) from question where test_id = (select id from test where name = 'Software Engineering Test')) where name = 'Software Engineering Test';";
		
		
		stmt.executeUpdate(CO2006);
			
		/////// END OF TEST 3 /////////////////
			
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
	}
	
	public static void createTestResult(Connection c) throws Exception{
		ArrayList<Test> tests = new ArrayList<Test>();
		
		Statement stmt = c.createStatement();
		String sql = "select id,_class_id,time_limit,total_mark from test where strict_test = false;";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			Test test = new Test(rs.getLong(1), rs.getLong(2), rs.getDouble(3), rs.getDouble(4));
			tests.add(test);
			
		}
		rs.close();
		
		for(int i=0;i<tests.size();i++){
			Test t = tests.get(i);
			ArrayList<User> studentsOnTest = new ArrayList<User>();
			String sql2 = "select u.id,u.role_id,u.email from test t "
					+ "JOIN class c on c.id = t._class_id "
					+ "JOIN users_class uc on uc.class_id = c.id "
					+ "JOIN users u on u.id = uc.users_id "
					+ "where role_id = (select id from role where name ILIKE '%student%') "
					+ "and u.date_added = '2015-04-13 00:00:00' and t.id = "+t.getId();
			
			ResultSet rs2 = stmt.executeQuery(sql2);
			while (rs2.next()) {
				User user = new User(rs2.getLong(1), rs2.getLong(2), rs2.getString(3));
				studentsOnTest.add(user);
			}
			rs2.close();
			
			ArrayList<Question> questions = new ArrayList<Question>();
			String sql3 = "select id,master_question,question_type_id,mark from question q where test_id = "+t.getId();
			ResultSet rs3 = stmt.executeQuery(sql3);
			while (rs3.next()) {
				Question ques = new Question(rs3.getLong(1), rs3.getLong(2), rs3.getLong(3), rs3.getDouble(4));
				questions.add(ques);
			}
			rs3.close();
			
			for(int d=0;d<questions.size();d++){
				Question qbie = questions.get(d);
				ArrayList<Answer> answersForQbie = new ArrayList<Answer>();
				String sql4 = "select id,correct_answer from answer where question_id = "+qbie.getId();
				ResultSet rs4 = stmt.executeQuery(sql4);
				while (rs4.next()) {
					Answer an = new Answer(rs4.getLong(1), rs4.getBoolean(2));
					answersForQbie.add(an);
				}
				rs4.close();
				qbie.setAnswers(answersForQbie);
			}
			
			for(int b=0;b<studentsOnTest.size();b++){
				
				//////////////////////////////////////////
				User u = studentsOnTest.get(b);
				
				Random rand = new Random();
				int randomMinutes = rand.nextInt(((int)t.getTimeLimit() - 1) + 1) + 1;
				long miliseconds = TimeUnit.MINUTES.toMillis(randomMinutes);
				long randomTimeTaken = (new Date()).getTime() - miliseconds;
		        CloseableHttpClient httpclient = HttpClients.createDefault();
		        
		        
		        
		        
		        try {

		            HttpPost httpPost = new HttpPost("http://localhost:9000/authenticateLogin");
		            List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		            nvps.add(new BasicNameValuePair("email", u.getEmail()));
		            nvps.add(new BasicNameValuePair("password", "pass"));
		            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		            CloseableHttpResponse response2 = httpclient.execute(httpPost);
		            

		            try {
		                System.out.println(response2.getStatusLine());
		                HttpEntity entity2 = response2.getEntity();
		                EntityUtils.consume(entity2);
		            } finally {
		                response2.close();
		            }
		            
		            HttpPost addTestResult = new HttpPost("http://localhost:9000/getTestResults");
		            List <NameValuePair> addTestResultValues = new ArrayList <NameValuePair>();
		            addTestResultValues.add(new BasicNameValuePair("testID", t.getId().toString()));
		            addTestResultValues.add(new BasicNameValuePair("startTime", Long.toString(randomTimeTaken)));

		            for(int y=0;y<questions.size();y++){
		            	
		            	Question qMan = questions.get(y);
		            	
		            	if(qMan.getMasterQuestion()==0){
		            	
		            	
		            	List<Answer> answerForQMan = questions.get(y).getAnswers();
		            	
		            	if(qMan.getQuestionTypeID()==1){
		            		Answer answerChosen = answerForQMan.get(new Random().nextInt(answerForQMan.size()));
		            		addTestResultValues.add(new BasicNameValuePair(qMan.getId().toString(), answerChosen.getId().toString()));	
		            	}
		            	if(qMan.getQuestionTypeID()==2){
		            		int howMany = new Random().nextInt(answerForQMan.size());
		            		ArrayList<Integer> previous = new ArrayList<Integer>();
		            		for(int haz=0;haz<howMany;haz++){
		            			int randoNumber = (new Random().nextInt(answerForQMan.size()));
		            			if(!previous.contains(randoNumber)){
		            			Answer answerChosen = answerForQMan.get(randoNumber);
		            			addTestResultValues.add(new BasicNameValuePair(qMan.getId().toString(), answerChosen.getId().toString()));
		            			previous.add(randoNumber);
		            			}
		            		}
		            	}
		            	if(qMan.getQuestionTypeID()==3){
		            		
		            		ArrayList<Question> childQuestions = new ArrayList<Question>();
		            		
		            		for(int childQuestionsLoop=0;childQuestionsLoop<questions.size();childQuestionsLoop++){
		            			Question childQuestion = questions.get(childQuestionsLoop);
		            			if(childQuestion.getMasterQuestion()==qMan.getId()){
		            				childQuestions.add(childQuestion);
		            			}
		            		}
		            		
		            		
		            		
		        			ArrayList<Answer> masterAnswers = new ArrayList<Answer>();
		        			String sql10 = "select a.id,a.correct_answer from question q "
		        					+ "JOIN answer a on a.question_id = q.id "
		        					+ "where q.master_question = "+qMan.getId()+";";
		        			ResultSet rs10 = stmt.executeQuery(sql10);
		        			while (rs10.next()) {
		        				Answer ale = new Answer(rs10.getLong(1), rs10.getBoolean(2));
		        				masterAnswers.add(ale);
		        			}
		        			rs10.close();

		        			ArrayList<Answer> selected = new ArrayList<Answer>();
		        			
		        			
		        			for(int blah=0;blah<childQuestions.size();blah++){
		        				Question chil = childQuestions.get(blah);
			        			boolean addIt = true;
			        			Answer answerChosen = masterAnswers.get(new Random().nextInt(masterAnswers.size()));
					            
		        				for(Answer s : selected){
		        					if(s.equals(answerChosen)){
		        						addIt = false;
		        					}
		        				}
		        				
		        				if(addIt){
		        					addTestResultValues.add(new BasicNameValuePair(chil.getId().toString(), "a"+answerChosen.getId().toString()));
		        					selected.add(answerChosen);
		        				}
			        			
		        				
		        			}
		        			
		            	}
		            	
		            }
		            	
		            }
		            
		            addTestResult.setEntity(new UrlEncodedFormEntity(addTestResultValues));
		            CloseableHttpResponse addTestResultResponse = httpclient.execute(addTestResult);
		            
		            try {
		                System.out.println(addTestResultResponse.getStatusLine());
		                HttpEntity addTREntity = addTestResultResponse.getEntity();
		                EntityUtils.consume(addTREntity);
		            } finally {
		            	addTestResultResponse.close();
		            }
		            
		        } finally {
		            httpclient.close();
		        }
				
				
				
				//////////////////////////////////////////
				
				
				
			}
			
		}

        
        stmt.close();
        c.close();
	}

}
