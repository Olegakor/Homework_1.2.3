fun main() {
    // Ввод суммы покупки
    println("Введите сумму покупки (в рублях):")
    val purchaseAmount = readLine()?.toDoubleOrNull() ?: 0.0

    // Ввод статуса покупателя
    println("Являетесь ли вы постоянным покупателем? (да/нет):")
    val isRegularCustomer = readLine()?.trim()?.equals("да", ignoreCase = true) ?: false

    // Вычисление итоговой стоимости
    val finalPrice = calculateFinalPrice(purchaseAmount, isRegularCustomer)

    // Вывод результата
    println("Итоговая стоимость покупки: ${finalPrice.toInt()} рублей")
}

fun calculateFinalPrice(amount: Double, isRegularCustomer: Boolean): Double {
    var discount = 0.0

    // Определение скидки в зависимости от суммы покупки
    when {
        amount in 0.0..1000.0 -> discount = 0.0
        amount in 1001.0..10000.0 -> discount = 100.0
        amount > 10000.0 -> discount = amount * 0.05
    }

    // Применение стандартной скидки
    var discountedPrice = amount - discount

    // Если постоянный покупатель, применяем дополнительную скидку 1%
    if (isRegularCustomer) {
        discountedPrice *= 0.99 // Уменьшаем на 1%
    }

    return discountedPrice
}