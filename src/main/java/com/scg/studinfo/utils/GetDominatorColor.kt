package com.scg.studinfo.utils

import android.graphics.Bitmap
import android.graphics.Color
import androidx.palette.graphics.Palette
import java.util.*
import kotlin.collections.ArrayList

class GetDominatorColor() {
    fun getDominantColor(bitmap: Bitmap): Int {
        val swatchesTemp: List<Palette.Swatch> =
            Palette.from(bitmap).generate().getSwatches()
        val swatches: List<Palette.Swatch> =
            ArrayList<Palette.Swatch>(
                swatchesTemp
            )
        Collections.sort(swatches) { swatch1, swatch2 -> swatch2.population - swatch1.population }
        // если по какой-то причине не удалось извлечь цвета из изображения, выбираем просто случайный цвет
        return if (swatches.size > 0) swatches[0].getRgb() else getRandomColor()
    }

    fun getRandomColor(): Int {
        val rnd = Random()
        return Color.argb(
            255,
            rnd.nextInt(256),
            rnd.nextInt(256),
            rnd.nextInt(256)
        )
    }
}