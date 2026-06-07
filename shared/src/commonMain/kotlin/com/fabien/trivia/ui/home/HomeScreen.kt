package com.fabien.trivia.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onStartAllCategories: () -> Unit,
    onChooseCategory: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Culture\nGénérale",
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(Modifier.height(16.dp))

        Text(
            text = "Testez vos connaissances !",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(64.dp))

        Button(
            onClick = onStartAllCategories,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text("Toutes catégories confondues", style = MaterialTheme.typography.titleMedium)
        }

        Spacer(Modifier.height(12.dp))

        Button(
            onClick = onChooseCategory,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        ) {
            Text("Choisir une catégorie", style = MaterialTheme.typography.titleMedium)
        }
    }
}
