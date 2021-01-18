package concurrent;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

class Student /*implements Comparable<Student> */{
	String name;
	
	Integer rank;

	
	public Student(String name, Integer rank) {
		this.name = name;
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	
	@Override
	public String toString() {
		return "Student [name=" + name + ", rank=" + rank + "]";
	}

//	@Override
//	public int compareTo(Student o) {
//		return this.rank-o.rank;
//	}
	
	
}


class StudentComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getRank()-o2.getRank();
	}
	
}

public class PriorityQueueExample {

	public static void main(String[] args) {

		PriorityBlockingQueue<Integer> blockingQueue=new PriorityBlockingQueue<Integer>();
		blockingQueue.add(3);
		blockingQueue.add(2);
		blockingQueue.add(4);
		System.out.println(blockingQueue.poll());
		System.out.println(blockingQueue.poll());
		System.out.println(blockingQueue.poll());

		
//		PriorityBlockingQueue<Student> studentQueue=new PriorityBlockingQueue<Student>();
//		studentQueue.add(new Student("a", 4));
//		studentQueue.add(new Student("b", 3));
//		studentQueue.add(new Student("c", 2));
//		System.out.println(studentQueue.poll());
//		System.out.println(studentQueue.poll());
//		System.out.println(studentQueue.poll());

		PriorityBlockingQueue<Student> studentQueue=new PriorityBlockingQueue<Student>(5,new StudentComparator());
		studentQueue.add(new Student("a", 4));
		studentQueue.add(new Student("b", 3));
		studentQueue.add(new Student("c", 2));
		System.out.println(studentQueue.poll());
		System.out.println(studentQueue.poll());
		System.out.println(studentQueue.poll());
	}

}
