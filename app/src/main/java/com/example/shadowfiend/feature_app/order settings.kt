@Composable
fun CoffeeConstructorScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()) // Добавляем прокрутку
    ) {
        // Шапка
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = null)
            Text("Конструктор кофемана", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = Color(0xFF1A237E))
            Icon(Icons.Default.ShoppingCart, contentDescription = null)
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Выберите бариста
        ConstructorRow(label = "Выберите бариста", showArrow = true)
        
        HorizontalDivider(color = Color(0xFFF5F5F5))

        // Вид кофе (Слайдер)
        Column(modifier = Modifier.padding(vertical = 16.dp)) {
            Text("Вид кофе", style = MaterialTheme.typography.bodyLarge)
            Slider(
                value = 0.6f, 
                onValueChange = {},
                colors = SliderDefaults.colors(thumbColor = Color.White, activeTrackColor = Color(0xFF2196F3))
            )
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Арабика", color = Color.LightGray, style = MaterialTheme.typography.bodySmall)
                Text("Робуста", color = Color.LightGray, style = MaterialTheme.typography.bodySmall)
            }
        }

        HorizontalDivider(color = Color(0xFFF5F5F5))

        // Сорт кофе
        ConstructorRow(label = "Сорт кофе", showArrow = true)

        // Обжарка (Кастомные иконки)
        ConstructorRow(label = "Обжарка") {
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Icon(Icons.Default.LocalFireDepartment, contentDescription = null, tint = Color.LightGray)
                Icon(Icons.Default.LocalFireDepartment, contentDescription = null, tint = Color.LightGray)
                Icon(Icons.Default.LocalFireDepartment, contentDescription = null, tint = Color.Black) // Заменить на группу огоньков
            }
        }

        // Помол
        ConstructorRow(label = "Помол") {
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                Icon(painterResource(id = R.drawable.ic_bean_filled), contentDescription = null)
                Icon(painterResource(id = R.drawable.ic_bean_outline), contentDescription = null, tint = Color.LightGray)
            }
        }

        // Молоко и Сироп
        ConstructorRow(label = "Молоко", actionText = "Выбрать")
        ConstructorRow(label = "Сироп", actionText = "Выбрать")
        ConstructorRow(label = "Добавки", showArrow = true)

        // Лед
        ConstructorRow(label = "Лед") {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                // Иконки кубиков льда
                Icon(Icons.Default.Block, contentDescription = null, tint = Color.LightGray)
                Icon(Icons.Default.CropSquare, contentDescription = null, tint = Color.LightGray)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Энциклопедия (Зеленый текст)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Энциклопедия кофемана", color = Color(0xFF4CAF50), fontWeight = FontWeight.Medium)
            Icon(Icons.Default.KeyboardArrowUp, contentDescription = null, tint = Color(0xFF4CAF50))
        }

        Spacer(modifier = Modifier.weight(1f))

        // Итог и кнопка
        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Итоговая сумма", fontWeight = FontWeight.Bold)
            Text("250₽", fontWeight = FontWeight.Bold)
        }

        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth().height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF37474F)),
            shape = RoundedCornerShape(28.dp)
        ) {
            Text("Далее")
        }
    }
}

@Composable
fun ConstructorRow(
    label: String,
    showArrow: Boolean = false,
    actionText: String? = null,
    content: @Composable (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label, style = MaterialTheme.typography.bodyLarge)
        
        if (content != null) {
            content()
        } else if (actionText != null) {
            Text(actionText, color = Color(0xFF1A237E), style = MaterialTheme.typography.bodyMedium)
        } else if (showArrow) {
            Icon(Icons.Default.ChevronRight, contentDescription = null, tint = Color.LightGray)
        }
    }
    HorizontalDivider(color = Color(0xFFF5F5F5))
}
