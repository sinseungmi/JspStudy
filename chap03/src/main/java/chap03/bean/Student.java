package chap03.bean;

import java.util.ArrayList;
import java.util.Comparator;

public class Student {
	
	private final static ArrayList<Student> ALL_STUDENTS = new ArrayList<Student>();
	
	//필드의 접근제어자를 private으로 설정
	private String id;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private double avg;
	private int rank;
	
	// 기본 생성자가 반드시 존재해야 함
	public Student() {
		ALL_STUDENTS.add(this);
	}
	
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		ALL_STUDENTS.add(this);
		update();
	}
	
	private void update() {
		avg = (kor + eng + math) / 3.0;
		ALL_STUDENTS.sort(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				int compare1 = Double.compare(o2.avg, o1.avg);
				return compare1 != 0 ? compare1 : o1.name.compareTo(o2.name);
			}                           //평균이 동일하다면 이름 순으로!
		});
		rank = ALL_STUDENTS.indexOf(this) + 1;
	}
	
	// 필드에 접근할 때는 getter/setter를 이용해야함
	
	/*
	 * # Getter and Setter
	 * 
	 * - 우클릭 - > Source -> Generate Getters and Setters
	 * - Getter : 해당 클래스의 필드 값을 반환해주는 메서드
	 * - Setter : 해당 클래스의 필드에 값을 대입하는 메서드
	 * - 메서드명은 반드시 get/set + 필드명(첫글자 대문자)로 지어야한다.
	 * - 메서드명이 규칙에 맞지 않으면 JSP의 편리한 기능을 이용할 수 없다
	 * 
	 * */
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
		update();
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
		update(); //점수하나가 변하면 평균도 변하니까 setter에 들어가는 이유
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
		update();
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public int getRank() {
		return rank;
	}
	
}
