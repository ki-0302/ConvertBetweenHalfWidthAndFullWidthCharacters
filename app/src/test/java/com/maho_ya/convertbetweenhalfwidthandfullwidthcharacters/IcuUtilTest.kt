package com.maho_ya.convertbetweenhalfwidthandfullwidthcharacters

import com.google.common.truth.Truth.assertThat
import org.junit.Before

import org.junit.Test

class IcuUtilTest {

    private lateinit var icuUtil: IcuUtil

    @Before
    fun setup() {
        icuUtil = IcuUtil()
    }

    /**
     * 全角 -> 半角に変換する
     */
    @Test
    fun toHalfWidth() {
        assertThat(icuUtil.toHalfWidth("１２３４Ａｚ")).isEqualTo("1234Az")
    }

    /**
     * 半角 -> 全角に変換する
     */
    @Test
    fun toFullWidth() {
        assertThat(icuUtil.toFullWidth("1234Az")).isEqualTo("１２３４Ａｚ")
    }
}
