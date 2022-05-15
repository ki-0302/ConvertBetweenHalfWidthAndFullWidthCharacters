package com.maho_ya.convertbetweenhalfwidthandfullwidthcharacters

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class StringConverterTest {

    private lateinit var stringConverter: StringConverter

    @Before
    fun setup() {
        stringConverter = StringConverter()
    }

    @Test
    fun toHalfWidth() {
    }

    /**
     * 半角カナ（濁音・濁点付き） -> 全角 に変換する
     */
    @Test
    fun toFullWidth_givenHalfWidthKanaWidthDakuonAndDakuten_returnFullWidthKana() {
        val target = "ｶﾞｷﾞｸﾞｹﾞｺﾞｻﾞｼﾞｽﾞｾﾞｿﾞﾀﾞﾁﾞﾂﾞﾃﾞﾄﾞﾊﾞﾋﾞﾌﾞﾍﾞﾎﾞﾊﾟﾋﾟﾌﾟﾍﾟﾎﾟ"
        val expected = "ガギグゲゴザジズゼゾダヂヅデドバビブベボパピプペポ"
        assertThat(stringConverter.toFullWidth(target)).isEqualTo(expected)
    }

    /**
     * 半角カナ -> 全角 に変換する
     */
    @Test
    fun toFullWidth_givenHalfWidthKana_returnFullWidthKana() {
        val target = "ｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜｦﾝｧｨｩｪｫｯｬｭｮｰ｡､｢｣･"
        val expected = "アイウエオカキクケコサシスセソタチツテトナニヌネノハヒフヘホマミムメモヤユヨラリルレロ" +
                "ワヲンァィゥェォッャュョー。、「」・"
        assertThat(stringConverter.toFullWidth(target)).isEqualTo(expected)
    }

    /**
     * 半角英数字 -> 全角 に変換する
     */
    @Test
    fun toFullWidth_givenHalfWidthAlphaNum_returnFullWidthAlphaNum() {
        val target = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        val expected = "ａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚ" +
                "ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺ" +
                "０１２３４５６７８９"
        assertThat(stringConverter.toFullWidth(target)).isEqualTo(expected)
    }

    /**
     * 半角記号 -> 全角 に変換する
     */
    @Test
    fun toFullWidth_givenHalfWidthSymbol_returnFullWidthSymbol() {
        val target = """!"#$%&'()*+,-./:;<=>?[\]^_`{|}~ ¥"""
        val expected = "！”＃＄％＆’（）＊＋，−．／：；＜＝＞？［＼］＾＿｀｛｜｝〜　￥"
        assertThat(stringConverter.toFullWidth(target)).isEqualTo(expected)
    }
}