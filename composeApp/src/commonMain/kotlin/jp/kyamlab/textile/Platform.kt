package jp.kyamlab.textile

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform