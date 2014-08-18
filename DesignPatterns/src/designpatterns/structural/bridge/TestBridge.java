package designpatterns.structural.bridge;
import java.util.*;

//abstraction
interface Question{
    public void nextQuestion();
    public void priorQuestion();
    public void newQuestion(String q);
    public void deleteQuestion(String q);
    public void displayQuestion();
    public void displayAllQuestions();
}

class QuestionManager{
 protected Question questDB;
 public String catalog;
 
 public QuestionManager(String catalog){
     this.catalog = catalog;
 }
 
 public void next(){
     questDB.nextQuestion();
 }
 
 public void prior(){
     questDB.priorQuestion();
 }
 
 public void newOne(String quest){
     questDB.newQuestion(quest);
 }
 
 public void delete(String quest){
     questDB.deleteQuestion(quest);
 }
 
 public void display(){
     questDB.displayQuestion();
 }
 
 public void displayAll(){
     System.out.println("Question Catalog: "+catalog);
     questDB.displayAllQuestions();
 }
}

//further implementation

class QuestionFormat extends QuestionManager{
    public QuestionFormat(String catalog){
      super(catalog);  
    }
    
    public void displayAll(){
        System.out.println("\n~~~~~~");
        super.displayAll();
        System.out.println("~~~~~~");
    }
}

//decoupled implementation

//implementation

class JavaQuestions implements Question{
private List<String> questions = new ArrayList<String>();
private int current = 0;

    public JavaQuestions(){
        questions.add("hat is Java?");
        questions.add("What is an interface?");
        questions.add("What is cross-platform?");
        questions.add("What is UTF-8?");
        questions.add("What is abstract?");
        questions.add("What is Thread?");
        questions.add("What is multi-threading?");
    }
    
    @Override
    public void nextQuestion() {
        if(current <= questions.size() -1)
            current++;
    }

    @Override
    public void priorQuestion() {
        if(current>0)
            current--;
    }

    @Override
    public void newQuestion(String q) {
        questions.add(q);
    }

    @Override
    public void deleteQuestion(String q) {
        questions.remove(q);
    }

    @Override
    public void displayQuestion() {
        System.out.println(questions.get(current));
    }

    @Override
    public void displayAllQuestions() {
        for(String quest:questions){
            System.out.println(quest);
        }
    }    
}

//implementation

public class TestBridge {
public static void main(String[] args){
    QuestionFormat questions = new QuestionFormat("Java Language");
    questions.questDB = new JavaQuestions();
    //can be hooked up with other question class
    questions.displayAll();
    questions.next();
    questions.newOne("What is object?");
    questions.newOne("What is reference type?");
    questions.display();
}    
}