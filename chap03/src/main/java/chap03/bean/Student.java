package chap03.bean;

import java.util.ArrayList;
import java.util.Comparator;

public class Student {
	
	private final static ArrayList<Student> ALL_STUDENTS = new ArrayList<Student>();
	
	//�ʵ��� ���������ڸ� private���� ����
	private String id;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private double avg;
	private int rank;
	
	// �⺻ �����ڰ� �ݵ�� �����ؾ� ��
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
			}                           //����� �����ϴٸ� �̸� ������!
		});
		rank = ALL_STUDENTS.indexOf(this) + 1;
	}
	
	// �ʵ忡 ������ ���� getter/setter�� �̿��ؾ���
	
	/*
	 * # Getter and Setter
	 * 
	 * - ��Ŭ�� - > Source -> Generate Getters and Setters
	 * - Getter : �ش� Ŭ������ �ʵ� ���� ��ȯ���ִ� �޼���
	 * - Setter : �ش� Ŭ������ �ʵ忡 ���� �����ϴ� �޼���
	 * - �޼������ �ݵ�� get/set + �ʵ��(ù���� �빮��)�� ������Ѵ�.
	 * - �޼������ ��Ģ�� ���� ������ JSP�� ������ ����� �̿��� �� ����
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
		update(); //�����ϳ��� ���ϸ� ��յ� ���ϴϱ� setter�� ���� ����
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