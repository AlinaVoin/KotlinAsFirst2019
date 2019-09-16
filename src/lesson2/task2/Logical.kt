@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.sqr
import kotlin.math.abs

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
    sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean =
    (number / 1000 + (number / 100) % 10) == (number % 10 + (number / 10) % 10)


/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean = when {
    ((x1 == 1) || (x1 == 8) || (y1 == 1) || (y1 == 8)) && ((x2 == 1) || (x2 == 8) || (y2 == 1) || (y2 == 8)) -> false
    (x1 == x2) && (y1 != y2) -> true
    (x1 != x2) && (y1 == y2) -> true
    (abs(x1 - x2)) == (abs(y1 - y2)) -> true
    else -> false
}


/**
 * Простая
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int = when {
    (month == 1 or 3 or 5 or 7 or 8 or 10 or 12) -> 31
    (month == 4 or 6 or 9 or 11) -> 30
    (month == 2) and (year % 4 == 0) -> 29
    else -> 28
}

/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(
    x1: Double, y1: Double, r1: Double,
    x2: Double, y2: Double, r2: Double
): Boolean = when {
    sqr(x2 - x1) + sqr(y2 - y1) < sqr(r2 - r1) -> true
    else -> false
}

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean = when {
    ((a <= r) and (b <= s)) or ((b <= r) and (a <= s)) or ((a <= r) and (c <= s)) or ((c <= r) and (a <= s)) or ((b <= r) and (c <= s)) or ((c <= r) and (b <= s)) -> true
    else -> false
}