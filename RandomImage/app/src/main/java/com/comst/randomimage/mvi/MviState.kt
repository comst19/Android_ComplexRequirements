package com.comst.randomimage.mvi

import com.comst.randomimage.mvi.model.Image

sealed class MviState{

    // 인자 있으면 dataclass, 없으면 object
    object Idle : MviState()
    object Loading : MviState()
    data class LoadedImage(val image: Image, val count : Int) : MviState()
}
