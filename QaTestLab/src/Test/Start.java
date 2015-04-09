/*
Необходимо описать задачу с применением принципов ООП.
Условие тестовой задачи:
Дано объекты-фигуры следующих видов: квадрат, треугольник, круг, трапеция. Каждую фигуру можно нарисовать, получить ее площадь и цвет. 
Также фигуры имеют уникальные методы, например: вернуть радиус, длину гипотенузы, длину стороны и т. д.
Нам необходимо сгенерировать случайный набор фигур, количество объектов в наборе также заранее неизвестно.
После генерации массива нужно вывести весь список объектов, которые у нас имеются, например:
Фигура: квадрат, площадь: 25 кв. ед., длина стороны: 5 ед., цвет: синий
Фигура: треугольник, площадь: 12,5 кв.ед., гипотенуза: 7.1 ед., цвет: желтый 
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
