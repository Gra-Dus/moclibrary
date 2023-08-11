package gmail

import di.gd

class gs private constructor(
    private val t: String,
    private val tx: String,
    private val e: List<String>
) {
    suspend fun sm(): Boolean {
        return gd.ggs().sm(t, tx, e)
    }

    class gsb {
        private var t: String = ""
        private var tx: String = ""
        private var et: List<String> = emptyList()
        fun st(t: String) = apply { this.t = t }
        fun stx(tx: String) = apply { this.tx = tx }
        fun set(et: List<String>) = apply { this.et = et }
        fun build() = gs(t, tx, et)
    }
}