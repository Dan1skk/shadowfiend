@Composable
fun CoffeeOrderScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        // Top Bar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Назад")
            Text("Заказ", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Icon(Icons.Default.ShoppingCart, contentDescription = "Корзина")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Coffee Image Card
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFF8F8F8)),
            contentAlignment = Alignment.Center
        ) {
            // Замени R.drawable.cappuccino на свое изображение
            Image(
                painter = painterResource(id = R.drawable.cappuccino),
                contentDescription = "Капучино",
                modifier = Modifier.size(150.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Название и счетчик
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Капучино", style = MaterialTheme.typography.bodyLarge)
            QuantitySelector()
        }

        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp), color = Color(0xFFF0F0F0))

        // Ристретто (Segmented Control)
        OptionRow(label = "Ристретто") {
            CustomSegmentedControl(options = listOf("Один", "Два"), selectedOption = "Один")
        }

        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp), color = Color(0xFFF0F0F0))

        // На месте / Навынос
        OptionRow(label = "На месте / навынос") {
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Icon(Icons.Default.LocalCafe, contentDescription = null, tint = Color.LightGray)
                Icon(Icons.Default.TakeoutDining, contentDescription = null, tint = Color.Black)
            }
        }

        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp), color = Color(0xFFF0F0F0))

        // Объем
        OptionRow(label = "Объем, мл") {
            VolumeSelector(selectedSize = 350)
        }

        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp), color = Color(0xFFF0F0F0))

        // Время приготовления
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Приготовить к\nопределенному времени\nсегодня?",
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.bodyMedium
            )
            Switch(checked = true, onCheckedChange = {}, colors = SwitchDefaults.colors(checkedThumbColor = Color.White, checkedTrackColor = Color(0xFF4CAF50)))
        }
        
        // Time Picker Placeholder
        Box(
            modifier = Modifier
                .align(Alignment.End)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFFEEEEEE))
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Text("18 : 10", style = MaterialTheme.typography.bodyLarge)
        }

        Spacer(modifier = Modifier.weight(1f))

        // Bottom Button
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth().height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF37474F)),
            shape = RoundedCornerShape(28.dp)
        ) {
            Text("Далее", color = Color.White)
        }
    }
}
