/*
���������� ������� ������ � ����������� ��������� ���.
������� �������� ������:
���� �������-������ ��������� �����: �������, �����������, ����, ��������. ������ ������ ����� ����������, �������� �� ������� � ����. 
����� ������ ����� ���������� ������, ��������: ������� ������, ����� ����������, ����� ������� � �. �.
��� ���������� ������������� ��������� ����� �����, ���������� �������� � ������ ����� ������� ����������.
����� ��������� ������� ����� ������� ���� ������ ��������, ������� � ��� �������, ��������:
������: �������, �������: 25 ��. ��., ����� �������: 5 ��., ����: �����
������: �����������, �������: 12,5 ��.��., ����������: 7.1 ��., ����: ������ 
*/

package Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JFrame;

public class Start {
	
	static int maxAmountOfShapes = 10;
	public static Random rand = new Random();

	public static void main(String[] args) {
		
		Reader r = new Reader("Test for the QaTestLab");
		r.setVisible(true);
		r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		r.setSize(300, 150);
		r.setResizable(false);
		r.setLocationRelativeTo(null);
		
	}
	
	public static void start() throws InterruptedException {
		
		Shape []array = new Shape[(rand.nextInt(maxAmountOfShapes-1)+1)];
		
		Map<Integer, ShapeBuilder> fig = new LinkedHashMap<Integer, ShapeBuilder>();
		fig.put(1, new CircleBuilder());
		fig.put(2, new SquareBuilder());
		fig.put(3, new TrapezeBuilder());
		fig.put(4, new TriangleBuilder());
		
		for(int i = 0; i < array.length; i++) {
			array[i] = fig.get(rand.nextInt(fig.size()-1)+1).BuildShape();
		}
		
		for(Shape i : array) {
			Thread.sleep(250);
			System.out.println(i);
			i.draw();
		}
	}

}
