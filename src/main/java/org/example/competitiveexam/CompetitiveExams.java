package org.example.competitiveexam;

import lombok.Builder;
import lombok.Data;

import java.util.Comparator;
import java.util.List;

public class CompetitiveExams {

    public static void main(String[] args) {
        //write Lambda expression to sort this list based
        //	* on price in descending order and
        //	* if price is same, then sort on duration form shortest to longest
        List<Exam> exams = ExamRepository.retrieveExamDetails();
//        Comparator<Exam> priceDecThenDurationAscCompairator = (exam1, exam2) -> {
//            if (exam2.getTotal_fees() > exam1.getTotal_fees()) return 1;
//            else if(exam2.getTotal_fees() == exam1.getTotal_fees()){
//                if (exam1.getCourse_duration() > exam2.getCourse_duration()){return 1;}
//                else return -1;
//            } else return -1;
//        };
//        exams.stream().sorted(priceDecThenDurationAscCompairator).forEach(System.out::println);
        Comparator<Exam> priceDesc = Comparator.comparingDouble(Exam::getTotal_fees).reversed();
        Comparator<Exam> durationAsc = Comparator.comparingInt(Exam::getCourse_duration);
        exams.stream().sorted(priceDesc.thenComparing(durationAsc)).forEach(System.out::println);
    }
}

@Data
@Builder
class Exam{
    private long course_id;
    private String course_name;
    private String course_teacher;
    private int course_duration;//duration in months 2 months , 12 months,etc
    private double total_fees;
}

class ExamRepository{
    //Add 15 elements to the list
    public static List<Exam> retrieveExamDetails(){
        return List.of(
                Exam.builder().course_id(1).course_name("Civil Services Examination (UPSC)").course_teacher("Shounak Bhalerao").course_duration(5).total_fees(2000.00).build(),
                Exam.builder().course_id(2).course_name("Indian Economic Service Examination (IES)").course_teacher("Adwait Gite").course_duration(4).total_fees(1500.00).build(),
                Exam.builder().course_id(3).course_name("Staff Selection Commission (SSC)").course_teacher("Yash Pawar").course_duration(7).total_fees(3500.00).build(),
                Exam.builder().course_id(4).course_name("Common Admission Test (CAT)").course_teacher("Saurabh Rudrawar").course_duration(12).total_fees(12500.00).build(),
                Exam.builder().course_id(5).course_name("Common Law Admission Test (CLAT)").course_teacher("Aashish Varma").course_duration(4).total_fees(7500.00).build(),
                Exam.builder().course_id(6).course_name("Combined Defence Services Examination (CDS)").course_teacher("Parth Phansalkar").course_duration(24).total_fees(35500.00).build(),
                Exam.builder().course_id(7).course_name("Law School Admission Test (LSAT)").course_teacher("Parth Bhanushali").course_duration(8).total_fees(1100.00).build(),
                Exam.builder().course_id(8).course_name("National Defence Academy Examination (NDA)").course_teacher("Anshul Jadhav").course_duration(15).total_fees(5000.00).build(),
                Exam.builder().course_id(9).course_name("National Eligibility Entrance Test (NEET)").course_teacher("Shashank Bharuka").course_duration(24).total_fees(20000.00).build(),
                Exam.builder().course_id(10).course_name("Food Corporation of India Examination (FCI)").course_teacher("Sanket Naik").course_duration(14).total_fees(21000.00).build(),
                Exam.builder().course_id(11).course_name("Common Entrance Examination for Design (CEED)").course_teacher("Abhishek Jadhav").course_duration(1).total_fees(1000.00).build(),
                Exam.builder().course_id(12).course_name("IBPS PO Examination").course_teacher("Agrim Maheshwari").course_duration(36).total_fees(100000.00).build(),
                Exam.builder().course_id(13).course_name("State Bank of India - Probationary Officers").course_teacher("Dhiraj Chavan").course_duration(9).total_fees(70000.00).build(),
                Exam.builder().course_id(14).course_name("Joint Entrance Examination- Main and Advance (JEE)").course_teacher("Aadarsh Patel").course_duration(25).total_fees(20000.00).build(),
                Exam.builder().course_id(15).course_name("Graduate Aptitude Test in Engineering (GATE)").course_teacher("Chakradhar Bhanu").course_duration(26).total_fees(22300.00).build()
        );
    }
}