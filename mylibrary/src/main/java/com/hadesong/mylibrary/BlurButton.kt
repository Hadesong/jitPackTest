package com.hadesong.mylibrary

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.unit.dp
import com.hadesong.mylibrary.BrushEnum.*

/**
 *                     +--------+-------------------+
 *                     | Date   | 2022-8-10  22:58  |
 *                     +--------+-------------------+
 *                     | Author | Sinng             |
 *                     +--------+-------------------+
 *                     | Stay hungry. Stay foolish. |
 *                     +----------------------------+
 *
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BlurButton(
    bgColors: List<Color> = listOf(Color(0xff00c9a7), Color(0xff845ec2)),
    borderColor: List<Color> = listOf(Color.Transparent, Color.White),
    elevation: Int = 5,
    direction: BrushEnum = LINEAR,
    buttonHeight: Int = 56,
    buttonPadding: Int = 20,
    roundedCornerShape: Int = 10,
    borderWidth: Int = 1,
    content: @Composable () -> Unit,
    onClick: () -> Unit


) {
    var brushBg = Brush.linearGradient(bgColors)
    var brushBorder = Brush.linearGradient(borderColor)
    when (direction) {
        HORIZONTAL -> {
            brushBg = Brush.horizontalGradient(bgColors)
            brushBorder = Brush.horizontalGradient(borderColor)
        }
        VERTICAL -> {
            brushBg = Brush.verticalGradient(bgColors)
            brushBorder = Brush.verticalGradient(borderColor)
        }
        LINEAR -> {
            brushBg = Brush.linearGradient(bgColors)
            brushBorder = Brush.linearGradient(borderColor, Offset.Zero, Offset.Infinite)
        }
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(buttonPadding.dp)
            .height(buttonHeight.dp),
        border = BorderStroke(borderWidth.dp, brushBorder),
        shape = RoundedCornerShape(roundedCornerShape.dp),
        elevation = elevation.dp,
        onClick = onClick
    ) {
        Box(
            modifier = Modifier
                .background(brushBg)
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}

enum class BrushEnum {
    HORIZONTAL,
    VERTICAL,
    LINEAR
}