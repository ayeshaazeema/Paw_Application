package com.bisha.paw

import android.view.Surface
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun AnimalCategoryChip(
    category: String,
    onExecuteSearch: (String) -> Unit,
) {
    Surface(
        modifier = androidx.compose.ui.Modifier.padding(end = 8.dp),
        elevation = 8.dp,
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colors.primary
    ) {
        Row(
            modifier = androidx.compose.ui.Modifier
                .clickable(onClick = { onExecuteSearch(category) })
        ) {
            Text(
                text = category,
                style = MaterialTheme.typography.body2,
                color = androidx.compose.ui.graphics.Color.White,
                modifier = androidx.compose.ui.Modifier.padding(8.dp)
            )
        }
    }

}