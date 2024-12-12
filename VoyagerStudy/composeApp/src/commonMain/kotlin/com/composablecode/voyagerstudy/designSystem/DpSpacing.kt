package com.composablecode.voyagerstudy.designSystem

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


/**
 * @property xxs 4
 * @property xs 6
 * @property sm 8
 * @property md 12
 * @property lg 16
 * @property xl 20
 * @property xxl 24
 * @property xxxl 28
 * @property xxxxl 32
 * @property xxxxxl 36
 * @property xxxxxxl 40
 */
data class DpSpacing(
    val xxs: Dp,
    val xs: Dp,
    val sm: Dp,
    val md: Dp,
    val lg: Dp,
    val xl: Dp,
    val xxl: Dp,
    val xxxl: Dp,
    val xxxxl: Dp,
    val xxxxxl: Dp,
    val xxxxxxl: Dp
)


/**
 * @property xxs 4
 * @property xs 6
 * @property sm 8
 * @property md 12
 * @property lg 16
 * @property xl 20
 * @property xxl 24
 * @property xxxl 28
 * @property xxxxl 32
 * @property xxxxxl 36
 * @property xxxxxxl 40
 */
@Composable
fun MaterialTheme.spacings(): DpSpacing {
    return DpSpacing(
        xxs = LocalSpacing.current.xxs.dp,
        xs = LocalSpacing.current.xs.dp,
        sm = LocalSpacing.current.sm.dp,
        md = LocalSpacing.current.md.dp,
        lg = LocalSpacing.current.lg.dp,
        xl = LocalSpacing.current.xl.dp,
        xxl = LocalSpacing.current.xxl.dp,
        xxxl = LocalSpacing.current.xxxl.dp,
        xxxxl = LocalSpacing.current.xxxxl.dp,
        xxxxxl = LocalSpacing.current.xxxxxl.dp,
        xxxxxxl = LocalSpacing.current.xxxxxxl.dp,
    )
}