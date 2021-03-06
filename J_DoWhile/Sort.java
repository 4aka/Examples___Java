package J_DoWhile;

public class Sort {

	/*
	 * Принцип разделения. 
	 * 1. Выбирается опорный элемент 
	 * 2. Массив делится на двое.
	 * 3. Элементы "меньше" опорного помещаются в одну сторону. 
	 * 4. Элементы "больше" или равные опорному помещаются в другую сторону. 
	 * 5. Рекурсивно сортировка выполняется для каждой части, и т.д. 
	 * 						fedacb 
	 * 					fed        acb 
	 *                опорный элемент "d" 
	 *                bca	          def 
	 *                "c"             "e"
	 *                abc             def 
	 *                 Результат "abcdef"
	 */

	static void qsort(char items[]) {
		// вызов метода с рекурсией.
		qs(items, 0, items.length - 1);
	}

	private static void qs(char items[], int left, int right) {
		int i, j;
		char x, y;

		i = left;
		j = right;
		
		// (левый символ + правый символ / 2) - (1 + 15)/2 = 8.
		// Опорный элемент - символ 8 - f.
		x = items[(left + right) / 2];

		do {
			while ((items[i] < x) && (i < right))
				i++; // следующий символ
			while ((x < items[j]) && (j > left))
				j--; // предыдущий символ

			// Если левый элемент меньше или равен правому
			if (i <= j) {
				// переназначение значения переменной.
				y = items[i];
				items[i] = items[j];
				items[j] = y;
				i++;
				j--;
			}
		// Выполнять цикл do пока левый символ меньше или равен правому. 
		} while (i <= j);

		// Выполнение рекурсии если сортировка не закончена.
		if (left < j)
			qs(items, left, j);
		// Выполнение рекурсии если сортировка не закончена.
		if (i < right)
			qs(items, i, right);
	}
}