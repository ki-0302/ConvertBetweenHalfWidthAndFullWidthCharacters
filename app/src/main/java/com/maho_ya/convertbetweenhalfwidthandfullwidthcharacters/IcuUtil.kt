package com.maho_ya.convertbetweenhalfwidthandfullwidthcharacters

// 手動import
import com.ibm.icu.text.Transliterator

class IcuUtil: IStringConverter {

    companion object {
        private const val ID_FULL_WIDTH_TO_HALF_WIDTH = "Fullwidth-Halfwidth"
        private const val ID_HALF_WIDTH_TO_FULL_WIDTH = "Halfwidth-Fullwidth"
    }

    override fun toHalfWidth(value: String): String {
        return if (!Transliterator.getAvailableIDs().toList().contains(ID_FULL_WIDTH_TO_HALF_WIDTH) ) {
            value
        } else {
            Transliterator.getInstance(ID_FULL_WIDTH_TO_HALF_WIDTH).transliterate(value)
        }
    }

    override fun toFullWidth(value: String): String {
        return if (!Transliterator.getAvailableIDs().toList().contains(ID_HALF_WIDTH_TO_FULL_WIDTH) ) {
            value
        } else {
            Transliterator.getInstance(ID_HALF_WIDTH_TO_FULL_WIDTH).transliterate(value)
        }
    }
}
